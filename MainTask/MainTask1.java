package JavaFundamentals.MainTask;

/**Приветствовать любого пользователя при вводе его имени через командную строку.**/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTask1 {
    String name;

    public static void main(String[] args) {
        System.out.println( "Введите ваше имя: " );
        new MainTask1().go ();

    }

      public void go () {
          try {
              BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
              name = reader.readLine( );

              System.out.println( "Здраствуйте " + name  + " !" );
          }
          catch (IOException e) {
              e.fillInStackTrace();
          }
      }


}
