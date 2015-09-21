package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter {

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    private char[] writeBuffer;
    private final int writeBufferSize = 1024;

    public void write(int c) throws IOException
    {
        if (writeBuffer == null){
            writeBuffer = new char[writeBufferSize];
        }
        writeBuffer[0] = (char) c;
        write(writeBuffer, 0, 1);
    }


    public void write(char[] charsBuf) throws IOException
    {
        write(charsBuf, 0, charsBuf.length);
    }


    public void write(char[] charsBuf, int off, int len) throws IOException
    {
        System.out.println(String.copyValueOf(charsBuf).substring(off, off+len));
        super.write(charsBuf, off, len);
    }


    public void write(String str) throws IOException
    {
        write(str, 0, str.length());
    }


    public void write(String str, int off, int len) throws IOException
    {
        char charsBuf[];
        if (len <= writeBufferSize) {
            if (writeBuffer == null) {
                writeBuffer = new char[writeBufferSize];
            }
            charsBuf = writeBuffer;
        } else {
            charsBuf = new char[len];
        }
        str.getChars(off, (off + len), charsBuf, 0);
        write(charsBuf, 0, len);
    }
}
