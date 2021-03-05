package com.learn.javaonline.fundamental.MainTask;

//Отобразить в окне консоли аргументы командной строки в обратном порядке.

public class MainTask2 {
    public static void main(String[] args) {
        String [] str = new String[args.length];

        for (int i = 0; i < str.length; i++) {
            str [i] = args[i];
        }

        System.out.println("Аргументы командной строки в обратном порядке: " );

        for (int i = str.length-1; i>=0; i--){
            System.out.print(str[i]);
        }
    }
}
