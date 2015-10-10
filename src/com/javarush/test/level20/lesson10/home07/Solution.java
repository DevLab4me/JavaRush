package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* ѕереопределение сериализации в потоке
—ериализаци¤/десериализаци¤ Solution не работает.
»справьте ошибки не мен¤¤ сигнатуры методов и класса.
ћетод main не участвует в тестировании.
*/
public class Solution implements Serializable, AutoCloseable {
    public static void main (String[] args) throws Exception
    {
        Solution solution1 = new Solution("D:\\test.txt");
        solution1.writeObject("Hi1");
        solution1.close();
        //SAVE
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\testFile.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(solution1);
        outputStream.flush();
        outputStream.close();
        //LOAD
        FileInputStream fileInputStream = new FileInputStream("D:\\testFile.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution solution2 = (Solution) inputStream.readObject();
        inputStream.close();
        solution2.writeObject("Hi2");
        solution2.writeObject("Hi3");
        solution2.close();
    }

    private transient FileOutputStream stream;
    private String fileName;
    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws Exception
    {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {
        in.defaultReadObject();
        stream = new FileOutputStream(this.fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}