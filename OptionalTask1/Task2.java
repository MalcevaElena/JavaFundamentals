package JavaFundamentals.OptionalTask1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/** Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
 1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).

 2.     Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.

 3.     Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки

 4.
**/
 public class Task2 {
    private static int[][] array;
    private static int[][] array1;// для примера 1a
    private static int[][] array2; // для примера 1b
    private static int number;

    public static void main(String[] args) {
        System.out.println("Введите размерность матрицы [n][n]:");
        new Task2().go();
        task1a(array1);
        task1b(array2);
        task2();
        task3();
        task4(array);
    }
    void go() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            number = Integer.parseInt(reader.readLine());
            array = new int[number][number];
            int m = -1000;
            int m2 = 1000;

            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    array[i][j] = (int) (Math.random() * (m2 - m) - m2);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число! ");
        } catch (IOException ex) {
            System.out.println(ex.fillInStackTrace());
        }
        print(array);
        array1 = Task2.developmentArray(array1, array);
        array2 = Task2.developmentArray(array2, array);
    }


    public static int[][] developmentArray (int [][] newArray, int [][] firstArray){ // копируем массив для каждого примера, т.к в каждом нужен первоначальный массив
        newArray = new int[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
               newArray[i][j] = firstArray[i][j];
            }
        }
        return newArray;
    }
    public static void print(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d\t", matrix[i][j]);
            }
            System.out.println();
        }
    }
     private static void task1a(int[][] var) {
        // Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
        for (int j = 0; j < number; j++) {
            for (int x = number - 1; x > 0; x--) {
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
        for (int j = 0; j < number ; j++) {
            for (int x = number-1; x > 0; x--) {
                for (int y = 0; y < x; y++) {
                   if (var2[j][y] > var2[j][y+1]) {
                        int tmp = var2[j][y];
                        var2[j][y] = var2[j][y+1];
                        var2[j][y+1] = tmp;      }
                }
            }
        }
        System.out.println( "Упорядоченная матрица, в порядке возрастания элеиентов строки:");
        print(var2);
        }
    public static void task2 (){
      //  Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
       int count = 0;
       int count2 = 0;
        for (int j = 0; j < number; j++) {
            for (int x = 0; x< number -2; x++) {
                   if (array[j][x] < array[j][x+1] && array [j][x+1] < array [j][x+2]) count++;
                   else if (array[j][x] > array[j][x+1] && array [j][x+1] > array [j][x+2])count2++;
            }
        }
       System.out.println("Число возрастающих элементов матрицы, идущих подряд: " + count);
       System.out.println("Число убывающих элементов матрицы, идущих подряд: " + count2);
    }
    public static void task3 (){
        //Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
        System.out.println("Cуммa элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки:");
        for (int j = 0; j < number; j++) {
            int count =0; // сумма элементов
            int forBreak = 0; // количество положительных чисел
            for (int x = 0; x< number; x++) {
                if (array[j][x] > 0 && forBreak==0 ) { //если число положительное и оно первое
                    forBreak++;
                    for (int y = x; y < number ; y++) {
                        if (y==number-1 && array[j][y]<0) {// если только одно положительное
                            count=0;
                            break; }
                        if (y==number-1 && array[j][y]>0 && forBreak==1) break; //если только последнее положительное
                        if (array[j][y + 1] > 0) break;//если следующее положительное
                        count+= array[j][y + 1];
                    }
                }
            }
           System.out.println("Сумма " + (j+1) +  " строки:" + count );
        }
    }
    public static void task4 (int [][] var3) {
       // Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
        int max = 0;
        int row=0;
        int col = 0;
        int new_row=0;
        int new_col=0;
        int [][]matrix_res = new int[number-1][number-1];

        for (int i = 0; i < number; i++) { // ищим максимальный элемент
             for (int j = 0; j < number-1; j++) {
                if (var3[i][j] > var3[i][j+1]&& max < var3[i][j]) {
                    max = var3 [i][j];
                    row=i;
                    col = j;}
                else if (max < var3[i][j+1]) {
                    max = var3[i][j+1];
                    row=i;
                    col = j+1;}
             }
        }
        System.out.println("Максимальный элемент =" + max + ", строка: " +row +", столбец: "+ col);
        System.out.println("Новая матрица:");

        for (int i = 0; i < number; i++) { // удаляем строку и столбец содержащий максимальный элемент
            if (i!=row) {
            for (int j = 0; j < number; j++) {
                if (j != col) {
                    matrix_res[new_row][new_col] =var3[i][j];
                    new_col++; }
            }
            new_col =0;
            new_row++;
            }
        }
    print( matrix_res);
     }
 }


