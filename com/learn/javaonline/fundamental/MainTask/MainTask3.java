package com.learn.javaonline.fundamental.MainTask;

import java.util.Scanner;

/* Вывести заданное количество случайных чисел
 * с переходом и без перехода на новую строку.
 */

public class MainTask3 {
    public static void main(String[] args) {
        int number;
        int random;

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите положительное число:");
            while (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число! Повторите попытку:");
                sc.next();
            }
            number = sc.nextInt();
        }
        while (number < 0);

        for (int i = 0; i < number; i++) {
            random = (int) (Math.random() * 120);
            System.out.print(random + " ");
            if (random % 2 == 0) {
                System.out.println();
            }
        }
    }
}