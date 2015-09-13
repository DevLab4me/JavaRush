package com.javarush.test.level18.lesson10.home08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class ThreadsAndBytes {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileNames = new ArrayList<>();
        String fileName;
        while (!(fileName=reader.readLine()).equals("exit")){
            fileNames.add(fileName);
        }
        for (String s : fileNames){
            new ReadThread(s).start();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        @Override
        public void run() {
            int max = Integer.MIN_VALUE;
            HashMap<Integer, Integer> fileBytesRepetition = new HashMap<>();
            int res = 0;
            ArrayList<Integer> buff = new ArrayList<>();

            try {
                FileInputStream in = new FileInputStream(this.fileName);
                while (in.available() > 0) {
                    int data = in.read();
                    buff.add(data);
                }
                in.close();
            } catch (IOException e) {
            }
            for (int b : buff) {
                if (fileBytesRepetition.containsKey(b)) {
                    int count = fileBytesRepetition.get(b) + 1;
                    fileBytesRepetition.put(b, count);
                } else {
                    fileBytesRepetition.put(b, 1);
                }
            }
            for (Map.Entry<Integer, Integer> pair : fileBytesRepetition.entrySet()) {
                if (pair.getValue() > max) {
                    max = pair.getValue();
                    res = pair.getKey();
                }
            }
            synchronized (resultMap) {
                resultMap.put(this.fileName, res);
            }
        }
    }
}
