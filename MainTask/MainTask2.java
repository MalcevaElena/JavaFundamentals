package JavaFundamentals.MainTask;

/**Отобразить в окне консоли аргументы командной строки в обратном порядке.**/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainTask2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String reverse = new StringBuilder(str).reverse().toString();
        System.out.println( "Строка в обратном порядке: " + reverse );

    }
}
