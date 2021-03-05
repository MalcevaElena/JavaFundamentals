package com.learn.javaonline.fundamental.MainTask;

/* Ввести целые числа как аргументы командной строки,
 * подсчитать их сумму (произведение) и вывести результат на консоль.
 */

public class MainTask4 {
    public static void main(String[] args) {
        int n = 4;
        int[] number = new int[n];
        int sum = 0;
        int multiply = 1;


        System.out.println("Введите " + n + " числ(а): ");

        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(args[i]);
            sum += number[i];
            multiply *= number[i];
        }

        System.out.println("Сумма = " + sum);
        System.out.println("Произведение = " + multiply);
    }
}
