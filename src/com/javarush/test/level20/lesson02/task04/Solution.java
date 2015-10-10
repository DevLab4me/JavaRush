package com.javarush.test.level20.lesson02.task04;

import java.io.*;

/* „итаем и пишем в файл статики
–еализуйте логику записи в файл и чтени¤ из файла дл¤ класса ClassWithStatic
ћетод load должен инициализировать объект включа¤ статические пол¤ данными из файла
ћетод main реализован только дл¤ вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        try {

            File fileName = File.createTempFile("d:\\test.txt", null);
            OutputStream outputStream = new FileOutputStream(fileName);
            InputStream inputStream = new FileInputStream(fileName);

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            ClassWithStatic.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            System.out.println(ClassWithStatic.staticString);

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String hasStaticString = (staticString != null) ? "yes" : "no";
            printWriter.println(hasStaticString);
            if ("yes".equals(hasStaticString))
                printWriter.println(staticString);
            printWriter.println(this.i);
            printWriter.println(this.j);
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String hasStaticString = bufferedReader.readLine();
            if ("yes".equals(hasStaticString))
                staticString = bufferedReader.readLine();
            this.i = Integer.parseInt(bufferedReader.readLine());
            this.j = Integer.parseInt(bufferedReader.readLine());
            bufferedReader.close();
        }
    }
}