package com.javarush.test.level17.lesson10.home04;

/* Синхронизированные методы
Установить модификатор synchronized только тем методам, которым необходимо
*/

public class Solution {
    private double param = Math.random();

    private void method0() {                                       //не нужно синхронизировать, потому он вызывает в себе method3(), который в свою очередь синхронизированный
        double i = method3();
    }

    protected synchronized void method1(String param1) {           //нужно синхронизировать, потому что он вызывает в себе метод, который не синхронизированный, чтоб не получилось так что double i = method3() будет иметь значение из другого потока, а не из вашего
        Solution solution = new Solution();
        solution.method0();
    }

    public void  method2(int param1) {
        param1++;                                                  //не нужно синхронизировать, потому что он не создает новых объектов и не изменяет общие ресурсы и не вызывает других методов
    }

    synchronized double method3() {                                 //нужно синхронизировать, потому он доступается к общему private double param = Math.random(), который может использовать любой метод внутри класса Solution
        double random = Math.random();
        return random + param;
    }

    private synchronized void method4() {                            //нужно синхронизировать, потому что создается новый объект типа StringBuilder(), который не имеет встроенной синхронизации
        new StringBuilder().append(1).append(1).append(1).append(1);
    }

    protected void method5(String param2) {                           //не нужно синхронизировать, потому что создается новый объект типа StringBuffer(), который в себе имеет встроенную синхронизацию
        new StringBuffer().append(param2).append(param2).append(param2);
    }

    public synchronized String method6(int param2) {                   //нужно синхронизировать, потому что он вызывает в себе метод, который не синхронизированный, и у него есть вывод в консоль
        System.out.println("Thinking....");
        method7(5e-2);
        return "Got it!";
    }

    String method7(double param2) {                                    //не нужно синхронизировать, потому что он не создает новых объектов и не изменяет общие ресурсы и не вызывает других методов
        return "" + param2;
    }

}
