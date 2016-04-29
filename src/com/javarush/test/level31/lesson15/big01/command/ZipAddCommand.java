package com.javarush.test.level31.lesson15.big01.command;

import com.javarush.test.level31.lesson15.big01.ConsoleHelper;
import com.javarush.test.level31.lesson15.big01.ZipFileManager;
import com.javarush.test.level31.lesson15.big01.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Artem on 17.04.2016.
 */

public class ZipAddCommand extends ZipCommand{
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("���������� ������ ����� � �����.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("������� ������ ��� ����� ��� ����������:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.addFile(destinationPath);

            ConsoleHelper.writeMessage("���������� � ����� ���������.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("���� �� ��� ������.");
        }
    }
}
