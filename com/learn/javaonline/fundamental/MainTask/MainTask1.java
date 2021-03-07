package com.learn.javaonline.fundamental.MainTask;

//Приветствовать любого пользователя при вводе его имени через командную строку.

public class MainTask1 {
    public static void main(String[] args) {
        String name;
        name = args [0];

        System.out.println("Hello " + name + "!");
    }

}
