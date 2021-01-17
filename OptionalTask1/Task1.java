package JavaFundamentals.OptionalTask1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/** адание. Ввести n чисел с консоли.
        1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

        2.     Вывести числа в порядке возрастания (убывания) значений их длины.

        3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

        4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.

        5.     Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.

        6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.

        7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
**/
public class Task1 {
    static String[] var;

    public static void main(String[] args) {
        System.out.println("Введите число n:");
        new Task1().go();
        task1();
        task2(var);
        task3();
        task4();
        task5();
        task6();
        task7();

    }

    public void go() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int number = Integer.parseInt(reader.readLine());
            var = new String[number];
            System.out.println("Теперь введите " + number + " чисел(a):");
            for (int i = 0; i < number; i++) {
                String numbers = reader.readLine();
                var[i] = numbers;
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число! ");
        } catch (IOException ex) {
            System.out.println(ex.fillInStackTrace());
        }
    }

    public static void task1() {
            int min = var[0].length();
            int max = 0;
            for (String val : var) {
                if (val.length() > max)
                    max = val.length();
                else if (val.length() < min)
                    min = val.length();
            }
            for (int i = 0; i < var.length; i++) {
                if (var[i].length() == max)
                    System.out.println("Самое длинное число: " + var[i] + ", его длина: " + var[i].length());
                else if (var[i].length() == min)
                    System.out.println("Самое короткое число: " + var[i] + ", его длина: " + var[i].length());
            }
        }

    public static void task2(String[] arr) {
            for (int i = arr.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (arr[j].length() > arr[j + 1].length()) {
                        String tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }
            System.out.print("Числа в порядке возрастания длины: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.print("Числа в порядке убывания длины: ");
            for (int i = arr.length-1; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    public static void task3 () {
            int sum=0;
            for (int i = 0; i < var.length; i++) {
                sum=sum+var[i].length();
            }
            int average = sum/2;
            System.out.println("Средняя длина всех чисел: "+ average );
            System.out.print("числа длина которых меньше средней длины всех чисел: " );
            for (int i = 0; i < var.length; i++) {
                if (var[i].length()<average)
                System.out.print(var[i] + " его длина: " + var[i].length() + ", " );
            }
            System.out.println();

            System.out.print("числа длина которых больше средней длины всех чисел: " );
            for (int i = 0; i < var.length; i++) {
                if (var[i].length()>average)
                    System.out.print(var[i] + " его длина: " + var[i].length() + ", " );
            }
            System.out.println();
        }
    public static void task4() {
        int[] countElements = new int[var.length]; //массив с кол-вом совпадений

        for (int i = 0; i < var.length; i++) {
            int count = 0;
            int a = Integer.parseInt(var[i]);
            ArrayList<Integer> valueElements = new ArrayList<>();
            for (int b = a; b > 0; b /= 10) { //разбиваеи число на отдельные числа
                int l = b % 10;
                valueElements.add(l);
            }
            for (int e = 0; e < valueElements.size() - 1; e++) { //проверяем числа на совпадения
                int one = valueElements.get(e);
                if (valueElements.size() > 1) {
                    for (int y = e + 1; y < valueElements.size(); y++) {
                        int two = valueElements.get(y);
                        if (one == two) {
                            count++;
                            break;
                        }
                    }
                }
            }
            countElements[i] = count; //добавление в массив кол-во совпадений
        }
        int minTask4 = countElements[0];
        String minNumber = var[0];
        for (int x = 1; x < countElements.length; x++) {
            if (minTask4 > countElements[x]) {
                minTask4 = countElements[x];
                minNumber = var[x];
            }
        }
        System.out.println("Число, в котором количество различных цифр минимально: " + minNumber);
    }
    public static void task5() {
        int evenNumbers=0; // четные
        int oddNumbers=0; // ечетные
        for (int i = 0; i < var.length; i++) {
            int countEven = 0;
            int countOdd=0;
            int a = Integer.parseInt(var[i]);
            int lastNumber = a%10;

            while (a!=0){
                if (lastNumber%2==1) countOdd++;  // нечетное
                else countEven++; // четное
                a/=10;
                lastNumber= a%10;
            }
            if (countOdd==0)  evenNumbers++;
            else if(countOdd==countEven) oddNumbers++;

        }
        System.out.println("Количество чисел, содержащих только четные цифры: " + evenNumbers);
        System.out.println("Количество чисел c одинаковым количеством четных и нечетных чисел, из оставшихся: " + oddNumbers);
    }
    public static void task6() {
        for (int i = 0; i < var.length; i++) {
            int x = Integer.parseInt(var[i]);
            boolean upNumbers = true;
            int last = x % 10;
            x /= 10;
            while (x != 0 && upNumbers == true) {
                if (last <= x % 10) upNumbers = false;
                last = x % 10;
                x /= 10;
                           }
            if (upNumbers == true) {
                System.out.println("Число, цыфры в котором идут строго в порядке возрастания: " +var[i]);
                break;
            }
        }
    }
    public static void task7 () {
            for (int i = 0; i < var.length; i++) {
            int count = 0;
            int a = Integer.parseInt(var[i]);
            ArrayList<Integer> valueElements = new ArrayList<>();
            for (int b = a; b > 0; b /= 10) { //разбиваеи число на отдельные числа
                int l = a % 10;
                valueElements.add(l);
            }
            for (int e = 0; e < valueElements.size() - 1; e++) { //проверяем числа на совпадения
                int one = valueElements.get(e);
                if (valueElements.size() > 1) {
                    for (int y = e + 1; y < valueElements.size(); y++) {
                        int two = valueElements.get(y);
                        if (one == two) {
                            count++;
                            break;
                        }
                    }
                }
            }
            if (count == 0) {
                System.out.println("Число, состоящее только из различных цифр:" + var[i]);
                break;
            }
        }
    }

}


