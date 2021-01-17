package JavaFundamentals.MainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**Ввести целые числа как аргументы командной строки,
 *  подсчитать их сумму (произведение) и вывести результат на консоль.**/

public class MainTask4 {

    private String s;
    static ArrayList<Integer> arr = new ArrayList<>(  );
    private static int sum;
    private static int multiply =1;


    public static void main(String[] args) {
       System.out.println( "Введите несколько чисел:" );
       new MainTask4 ().go ();
       }

    private void go()  {
        try {
            do {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                s = reader.readLine( );
                if (!(s.length( ) == 0)) {
                    int number = Integer.parseInt(s);
                    arr.add(number);
                } else break;
            }
            while (!(s.length( ) == 0)) ;
            for (Integer i : arr) sum = +i;
            for (Integer t : arr) multiply=multiply * t;

            System.out.println( sum );
            System.out.println( multiply );
        }
        
        catch (NumberFormatException e) {
            System.out.println( "Вы ввели не число! ");
        }
        catch (IOException ex) {
            System.out.println( ex.fillInStackTrace());
        }
    }
}
