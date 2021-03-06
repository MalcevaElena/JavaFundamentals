package com.learn.javaonline.fundamental.MainTask;

import java.util.Scanner;

/* Ввести число от 1 до 12.
 * Вывести на консоль название месяца, соответствующего данному числу.
 * Осуществить проверку корректности ввода чисел.
 */

public class MainTask5 {
    public static void main(String[] args) {
        int number;

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Введите чило от 1 до 12");
            while (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число. Повторите ввод:");
                sc.next();
            }
            number = sc.nextInt();
        }
        while (number < 0);

        switch (number) {
            case 1 -> System.out.println("Январь");
            case 2 -> System.out.println("Февраль");
            case 3 -> System.out.println("Март");
            case 4 -> System.out.println("Апрель");
            case 5 -> System.out.println("Май");
            case 6 -> System.out.println("Июнь");
            case 7 -> System.out.println("Июль");
            case 8 -> System.out.println("Август");
            case 9 -> System.out.println("Сентябрь");
            case 10 -> System.out.println("Октябрь");
            case 11 -> System.out.println("Ноябрь");
            case 12 -> System.out.println("Декабрь");
            default -> System.out.println("Это число не входит в диапазон от 1 до 12");
        }
    }
}