package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Artem on 06.03.2016.
 */

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while(true) {
                Message message = connection.receive();
                switch (message.getType()) {
                    case NAME_REQUEST:
                        String userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                        break;
                    case NAME_ACCEPTED:
                        this.notifyConnectionStatusChanged(true);
                        return;
                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                switch (message.getType()){
                    case TEXT: processIncomingMessage(message.getData()); break;
                    case USER_ADDED: informAboutAddingNewUser(message.getData()); break;
                    case USER_REMOVED: informAboutDeletingNewUser(message.getData()); break;
                    default:  throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run(){
            try {
                String address = getServerAddress();
                int port = getServerPort();
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        }catch (InterruptedException e){
            ConsoleHelper.writeMessage("Ошибка соединения");
            return;
        }

        if(clientConnected)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        else
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while (clientConnected){
            String message = ConsoleHelper.readString();
            if(message.equals("exit"))
                break;

            if(shouldSentTextFromConsole())
                sendTextMessage(message);
        }
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Пожалуйста, введите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Пожалуйста, введите порт сервера");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Пожалуйста, введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole(){
       return true;
    }

    protected SocketThread getSocketThread(){
       return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }catch (IOException e){
            ConsoleHelper.writeMessage("Ошибка отправки сообщения");
            clientConnected = false;
        }
    }
}
