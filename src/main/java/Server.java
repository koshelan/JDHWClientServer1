import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("Сервер начал работу");
        try (ServerSocket serverSocket = new ServerSocket(55555)) { /* выбран Blocking способ т.к. невозможно
        действовать без всех входных данных, и дальнейшая работа не возможна без возврата результата */
            while (true) {
                try (Socket socket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    System.out.println("создалось соединение");
                    int num = Integer.parseInt(in.readLine());
                    System.out.print("Пришло число " + num + " ответ ");
                    out.println(fib(num));
                    if (num == 0) {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Сервер закончил работу");
    }

    private static long fib(int num) {
        if (num <= 1) {
            System.out.println(num);
            return num;
        } else {
            long a = 1;
            long b = 1;
            long r = 1;
            for (int i = 2; i < num; i++) {
                r = a + b;
                a = b;
                b = r;
            }
            System.out.println(r);
            return r;

        }
    }

}
