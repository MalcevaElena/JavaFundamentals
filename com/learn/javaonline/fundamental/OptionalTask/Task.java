package com.learn.javaonline.fundamental.OptionalTask;

import java.util.ArrayList;
import java.util.Scanner;

/* Задание. Ввести n чисел с консоли.
 * 1.Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
 * 2.Вывести числа в порядке возрастания (убывания) значений их длины.
 * 3.Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
 * 4.Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
 * 5.Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
 * 6.Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
 * 7.Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
 */

public class Task {
    public static int[] array;

    public static void main(String[] args) {
        int n;

        n = enterToConsole("Введите число N:");
        array = new int[n];

        System.out.println("Теперь введите " + n + " чисел(a):");
        for (int i = 0; i < n; i++) {
            int number = enterToConsole("Введите число номер " + (i + 1));
            array[i] = number;
        }

        task1();
        task2(array);
        task3();
        task4();
        task5();
        task6();
        task7();
    }

    public static int enterToConsole(String message) {
        int number;
        @SuppressWarnings("resurce")
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            while (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число. Повторите попытку: ");
                sc.next();
            }
            number = sc.nextInt();
        }
        while (number <= 0);
        return number;
    }


    public static void task1() {
        //Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        int min = String.valueOf(array[0]).length();
        int max = 0;

        for (int x : array) {
            x = String.valueOf(x).length();
            if (x > max)
                max = x;
            else if (x < min)
                min = x;
        }
        for (int j : array) {
            if (String.valueOf(j).length() == max)
                System.out.println("Самое длинное число: " + j +
                        ", его длина: " + String.valueOf(j).length());
            else if (String.valueOf(j).length() == min)
                System.out.println("Самое короткое число: " + j +
                        ", его длина: " + String.valueOf(j).length());
        }
    }

    public static void task2(int[] arr) {
        // Вывести числа в порядке возрастания (убывания) значений их длины.
        int tmp;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (String.valueOf(arr[j]).length() > String.valueOf(arr[j + 1]).length()) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        System.out.print("Числа в порядке возрастания длины: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();

        System.out.print("Числа в порядке убывания длины: ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void task3() {
        // Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
        int sum = 0;

        for (int j : array) {
            sum += String.valueOf(j).length();
        }

        double average = sum / 2.0;
        System.out.println("Средняя длина всех чисел: " + average);

        System.out.print("Числа, длина которых меньше средней длины всех чисел: ");
        for (int j : array) {
            if (String.valueOf(j).length() < average)
                System.out.print(j + " его длина: " + String.valueOf(j).length() + ", ");
        }
        System.out.println();

        System.out.print("Числа, длина которых больше средней длины всех чисел: ");
        for (int j : array) {
            if (String.valueOf(j).length() >= average)
                System.out.print(j + " его длина: " + String.valueOf(j).length() + ", ");
        }
        System.out.println();
    }

    public static void task4() {
        /*Найти число, в котором количество различных цифр минимально.
         Если таких чисел несколько, найти первое из них. */
        int[] countElements = new int[array.length]; //массив с кол-вом совпадений

        for (int i = 0; i < array.length; i++) {
            int count = 0;
            ArrayList<Integer> valueElements = new ArrayList<>();
            for (int b = array[i]; b > 0; b /= 10) { //разбиваеи число на отдельные числа
                int number = b % 10;
                valueElements.add(number);
            }
            for (int e = 0; e < valueElements.size() - 1; e++) { //проверяем числа на совпадения
                int one = valueElements.get(e);
                for (int y = e + 1; y < valueElements.size(); y++) {
                    int two = valueElements.get(y);
                    if (one == two) {
                        count++;
                        break;
                    }
                }
            }
            countElements[i] = count; //добавление в массив кол-во совпадений
        }
        int minTask4 = countElements[0];
        int minNumber = array[0];
        for (int i = 1; i < countElements.length; i++) {
            if (minTask4 > countElements[i]) {
                minTask4 = countElements[i];
                minNumber = array[i];
            }
        }
        System.out.println("Число, в котором количество различных цифр минимально: " + minNumber);
    }

    public static void task5() {
   /*Найти количество чисел, содержащих только четные цифры,
    а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.*/
        int evenNumbers = 0; // четные
        int oddNumbers = 0; // ечетные
        for (int j : array) {
            int countEven = 0;
            int countOdd = 0;
            int number = j;
            int lastNumber = number % 10;

            while (number != 0) {
                if (lastNumber % 2 == 1) {
                    countOdd++;  // нечетное
                } else {
                    countEven++; // четное
                }
                number /= 10;
                lastNumber = number % 10;
            }

            if (countOdd == 0) {
                evenNumbers++;
            } else if (countOdd == countEven) {
                oddNumbers++;
            }

        }
        System.out.println("Количество чисел, содержащих только четные цифры: " + evenNumbers);
        System.out.println("Количество чисел c одинаковым количеством четных и нечетных чисел, " +
                "из оставшихся: " + oddNumbers);
    }

    public static void task6() {
    /*Найти число, цифры в котором идут в строгом порядке возрастания.
    Если таких чисел несколько, найти первое из них.*/
        for (int j : array) {
            boolean upNumbers = true;
            int number = j;
            int last = number % 10;
            number /= 10;

            while (number != 0) {
                if (last < number % 10) {
                    upNumbers = false;
                }
                last = number % 10;
                number /= 10;
            }
            if (upNumbers) {
                System.out.println("Число, цыфры в котором идут строго в порядке возрастания: " + j);
                break;
            }
        }
    }

    public static void task7() {
        //Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
        for (int j : array) {
            int count = 0;
            ArrayList<Integer> valueElements = new ArrayList<>();

            for (int b = j; b > 0; b /= 10) { //разбиваеи число на отдельные числа
                valueElements.add(b % 10);
            }

            for (int e = 0; e < valueElements.size() - 1; e++) { //проверяем числа на совпадения
                int one = valueElements.get(e);
                for (int y = e + 1; y < valueElements.size(); y++) {
                    int two = valueElements.get(y);
                    if (one == two) {
                        count++;
                        break;
                    }
                }
            }
            if (count == 0) {
                System.out.println("Число, состоящее только из различных цифр:" + j);
                break;
            }
        }
    }
}



