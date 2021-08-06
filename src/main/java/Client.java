import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 55555); /* выбран Blocking способ т.к. невозможно действовать
            без всех входных данных, и дальнейшая работа не возможна без возврата результата */
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {

            String num;
            do {
                System.out.println("Введите целое число не меньше 0");
                num = scanner.nextLine();
            } while (!isNumber(num));
            System.out.println("->" + num);
            out.println(num);
            System.out.println(num + " член последовательности фибоначи равен " + in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNumber(String str) {
        try {
            if (Integer.parseInt(str) >= 0) {
                return true;
            } else {
                System.out.println("Число не меньше 0");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода");
            return false;
        }
    }

}
