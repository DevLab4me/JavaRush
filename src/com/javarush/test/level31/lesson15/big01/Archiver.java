package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

/**
 * Created by Artem on 12.04.2016.
 */

public class Archiver {
    public static void main(String[] args) throws Exception {
        System.out.println("Please, enter a path to the archive");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ZipFileManager zipManager = new ZipFileManager(Paths.get(reader.readLine()));

        System.out.println("Please, enter a path to the source file");
        try {
            zipManager.createZip(Paths.get(reader.readLine()));
        } catch (Exception ignored){}

        new ExitCommand().execute();
    }
}
