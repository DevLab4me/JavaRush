package com.javarush.test.level30.lesson15.big01.client;


import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Artem on 08.03.2016.
 */

public class BotClient extends Client {
    private static int botNumber = 0;

    public class BotSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
            String [] line = message.split(": ");
            String name = line[0];
            SimpleDateFormat dateFormat = null;
            if(line.length >= 2) {
                String command = line[1];
                switch (command) {
                    case "дата":
                        dateFormat = new SimpleDateFormat("d.MM.YYYY");
                        break;
                    case "день":
                        dateFormat = new SimpleDateFormat("d");
                        break;
                    case "месяц":
                        dateFormat = new SimpleDateFormat("MMMM");
                        break;
                    case "год":
                        dateFormat = new SimpleDateFormat("YYYY");
                        break;
                    case "время":
                        dateFormat = new SimpleDateFormat("H:mm:ss");
                        break;
                    case "час":
                        dateFormat = new SimpleDateFormat("H");
                        break;
                    case "минуты":
                        dateFormat = new SimpleDateFormat("m");
                        break;
                    case "секунды":
                        dateFormat = new SimpleDateFormat("s");
                        break;
                    default:
                        ConsoleHelper.writeMessage("Wrong request");
                        break;
                }
            }
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            if(dateFormat != null) {
                String text = String.format("Информация для %s: " + dateFormat.format(date), name);
                sendTextMessage(new Message(MessageType.TEXT, text).getData());
            }
        }

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }


    }

    @Override
    protected SocketThread getSocketThread(){
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole(){
        return false;
    }

    @Override
    protected String getUserName(){
        if(botNumber > 100)
            botNumber = 0;
        return String.format("date_bot_%d", botNumber++);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
