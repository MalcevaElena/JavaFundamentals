package com.learn.javaonline.fundamental.OptionalTask;

import java.util.Scanner;

/* Задание.
 * Ввести с консоли n - размерность матрицы a [n] [n].
 * Задать значения элементов матрицы в интервале значений от -M до M
 * с помощью генератора случайных чисел (класс Random).
 * 1.Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
 * 2.Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
 * 3.Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
 * 4.Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие.
 */

public class Task2 {
    public static int[][] array;
    public static int[][] array1;// для примера 1a
    public static int[][] array2;// для примера 1b
    public static int number;

    public static void main(String[] args) {
        number = enterToConsole("Введите размерность матрицы [n][n]: ");
        array = new int[number][number];
        int m = -1000;
        int m2 = 1000;

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                array[i][j] = (int) (Math.random() * (m2 - m) - m2);
            }
        }
        System.out.println("Матрица: ");
        print(array);

        array1 = Task2.developmentArray(array);
        array2 = Task2.developmentArray(array);

        task1a(array1);
        task1b(array2);
        task2();
        task3();
        task4(array);
    }

    public static int enterToConsole(String message) {
        int numb;
        @SuppressWarnings("resurce")
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            while (!sc.hasNextInt()) {
                System.out.println("Вы ввели не число. Повторите попытку: ");
                sc.next();
            }
            numb = sc.nextInt();
        }
        while (numb <= 0);
        return numb;
    }

    public static void print(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%4d\t", anInt);
            }
            System.out.println();
        }
    }

    public static int[][] developmentArray(int[][] firstArray) {
        // копируем массив для каждого примера, т.к в каждом нужен первоначальный массив
        int[][] newArray = new int[number][number];
        for (int i = 0; i < firstArray.length; i++) {
        //здесь можно использовать System.arraycopy(firstArray[i], 0, newArray[i], 0, firstArray[i].length);
            for (int j = 0; j < firstArray[i].length; j++) {
                newArray[i][j] = firstArray[i][j];
            }
        }
        return newArray;
    }

    private static void task1a(int[][] var) {
        // Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов kаждого столбца (строки).
        for (int j = 0; j < var.length; j++) {
            for (int x = var[j].length - 1; x > 0; x--) {
                for (int y = 0; y < x; y++) {
                    if (var[y][j] > var[y + 1][j]) {
                        int tmp = var[y][j];
                        var[y][j] = var[y + 1][j];
                        var[y + 1][j] = tmp;
                    }
                }
            }
        }
        System.out.println("Упорядоченная матрица, в порядке возрастания элеиентов столбца:");
        print(var);
    }

    private static void task1b(int[][] var2) {
        for (int j = 0; j < var2.length; j++) {
            for (int x = var2[j].length - 1; x > 0; x--) {
                for (int y = 0; y < x; y++) {
                    if (var2[j][y] > var2[j][y + 1]) {
                        int tmp = var2[j][y];
                        var2[j][y] = var2[j][y + 1];
                        var2[j][y + 1] = tmp;
                    }
                }
            }
        }
        System.out.println("Упорядоченная матрица, в порядке возрастания элеиентов строки:");
        print(var2);
    }

    public static void task2() {
        //  Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
        int count = 0;
        int count2 = 0;
        for (int[] ints : array) {
            for (int x = 0; x < ints.length - 2; x++) {
                if (ints[x] < ints[x + 1] && ints[x + 1] < ints[x + 2]) count++;
                else if (ints[x] > ints[x + 1] && ints[x + 1] > ints[x + 2]) count2++;
            }
        }
        System.out.println("Число возрастающих элементов матрицы, идущих подряд: " + count);
        System.out.println("Число убывающих элементов матрицы, идущих подряд: " + count2);
    }

    public static void task3() {
        //Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
        System.out.println("Cуммa элементов матрицы, расположенных между первым " +
                "и вторым положительными элементами каждой строки:");
        for (int i = 0; i < array.length; i++) {
            int count = 0; // сумма элементов
            int forBreak = 0; // количество положительных чисел
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0 && forBreak == 0) { //если число положительное и оно первое
                    forBreak++;
                    for (int y = j; y < array[i].length; y++) {
                        if (y == array[i].length - 1 && array[i][y] < 0) {// если только одно положительное
                            count = 0;
                            break;
                        }
                        if (y == array[i].length - 1 && array[i][y] > 0 && forBreak == 1) {
                            //если только последнее положительное
                            break;
                        }
                        if (array[i][y + 1] > 0) {
                            //если следующее положительное
                            break;
                        }
                        count += array[i][y + 1];
                    }
                }
            }
            System.out.println("Сумма " + (i + 1) + " строки:" + count);
        }
    }

    public static void task4(int[][] var3) {
        // Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
        int max = 0;
        int row = 0;
        int col = 0;
        int new_row = 0;
        int new_col = 0;
        int[][] matrix_res = new int[number - 1][number - 1];

        for (int i = 0; i < var3.length; i++) { // ищим максимальный элемент
            for (int j = 0; j < var3[i].length - 1; j++) {
                if (var3[i][j] > var3[i][j + 1] && max < var3[i][j]) {
                    max = var3[i][j];
                    row = i;
                    col = j;
                } else if (max < var3[i][j + 1]) {
                    max = var3[i][j + 1];
                    row = i;
                    col = j + 1;
                }
            }
        }
        System.out.println("Максимальный элемент =" + max + ", строка: " + row + ", столбец: " + col);
        System.out.println("Новая матрица:");

        for (int i = 0; i < var3.length; i++) { // удаляем строку и столбец содержащий максимальный элемент
            if (i != row) {
                for (int j = 0; j < var3[i].length; j++) {
                    if (j != col) {
                        matrix_res[new_row][new_col] = var3[i][j];
                        new_col++;
                    }
                }
                new_col = 0;
                new_row++;
            }
        }
        print(matrix_res);
    }
}


