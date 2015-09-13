package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream {
    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fileOutput;

    public AmigoOutputStream(FileOutputStream fileOutput) throws FileNotFoundException
    {
        super(fileName);
        this.fileOutput = fileOutput;
    }

    @Override
    public void write(int b) throws IOException
    {
        fileOutput.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException
    {
        fileOutput.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException
    {
        fileOutput.write(b, off, len);
    }

    @Override
    public void flush() throws IOException
    {
        fileOutput.flush();
    }

    @Override
    public void close() throws IOException
    {
        fileOutput.flush();
        fileOutput.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        fileOutput.close();
    }
}

