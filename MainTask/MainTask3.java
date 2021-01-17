package JavaFundamentals.MainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***Вывести заданное количество случайных чисел
 *  с переходом и без перехода на новую строку***/

public class MainTask3 {
    public static void main(String[] args) {
        System.out.println( "введите чило" );
       try {
           BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           int number = Integer.parseInt(reader.readLine( ));
           for (int i = 0; i < number; i++) {
               int random = (int) (Math.random( ) * 120);
               System.out.print(random + " ");
               if (i % 2 == 0) {
                   System.out.println( );
               }
           }
       }
       catch (NumberFormatException | IOException e) {
           System.out.println( "Вы ввели не число!" );
       }
    }
}
