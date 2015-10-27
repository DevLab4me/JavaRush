package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        int [] check = getNumbers(88593477);
        long after = System.currentTimeMillis();
        double seconds = (after - before) / 1000.0;
        System.out.println("Time: " + seconds);
        System.out.println("Memory: " + (Runtime.getRuntime().totalMemory() -
                Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        for (int a : check)
            System.out.print(a+" ");
    }

    public static int[] getNumbers(int N) {
        final int NUMBERS = 10;
        final int SQRT = 12;
        long [][] powResults = new long[NUMBERS][SQRT];
        for (int n = 0; n < NUMBERS; n++) {
            for (int j = 0; j < SQRT; j++) {
                long temp = n;
                for (int z = 0; z < j - 1; z++) {
                    temp *= n;
                }
                powResults[n][j] = temp;
            }
        }
        ArrayList<Integer> armstrongNums = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (i < 10)
                armstrongNums.add(i);
            else {
                int result = 0;
                int exponent = (int) (Math.log10(i) + 1);
                for (int j = i; j > 0; j /= 10) {
                    result += powResults[j % 10][exponent];
                }
                if (i == result)
                    armstrongNums.add(i);
            }
        }

        int[] result = new int [armstrongNums.size()];
        for (int i = 0; i < armstrongNums.size(); i++) {
            result[i] = armstrongNums.get(i);
        }
        return result;
    }
}
