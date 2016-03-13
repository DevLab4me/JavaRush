package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Artem on 28.02.2016.
 */

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> connectionEntry : connectionMap.entrySet()){
            try {
                connectionEntry.getValue().send(message);
            } catch (IOException e){
                ConsoleHelper.writeMessage("Ошибка отправки сообщения");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Enter your username"));
                Message reply = connection.receive();
                if (reply.getType() == MessageType.USER_NAME) {
                    if (reply.getData() != null && !reply.getData().isEmpty()) {
                        if (!connectionMap.containsKey(reply.getData())) {
                            connectionMap.put(reply.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED, "Login Successful"));
                            return reply.getData();
                        }
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> connectionEntry : connectionMap.entrySet()) {
                String name = connectionEntry.getKey();
                if (!name.equals(userName)) {
                    Message message = new Message(MessageType.USER_ADDED, name);
                    connection.send(message);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(!Thread.currentThread().isInterrupted()) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String stringFormat = "%s: %s";
                    Message chatMessage = new Message(MessageType.TEXT, String.format(stringFormat, userName, message.getData()));
                    sendBroadcastMessage(chatMessage);
                } else
                    ConsoleHelper.writeMessage("Not a text message");
            }
        }

        public void run(){
            String userName = null;
            try(Connection connection = new Connection(socket)){
                SocketAddress socketAddress = connection.getRemoteSocketAddress();

                ConsoleHelper.writeMessage("New connection established with " + socketAddress);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage("Error happened while data exchange");
            }
            if(userName != null){
                 connectionMap.remove(userName);
                 sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Connection with server is closed");
        }
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter a server port");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port)){
            ConsoleHelper.writeMessage("Server launched successfully");

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    new Handler(socket).start();
                } catch (IOException e) {
                    ConsoleHelper.writeMessage(e.getMessage());
                    break;
                }
            }
        } catch (IOException e){
            ConsoleHelper.writeMessage("Server not launched. Socket error");
        }
    }
}
