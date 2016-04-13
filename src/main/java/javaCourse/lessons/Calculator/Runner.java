package javaCourse.lessons.Calculator;

 import javaCourse.lessons.Calculator.Interface.InputManager;
 import javaCourse.lessons.Calculator.Interface.OutPutManager;

 import java.util.Scanner;

 /**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 18.09.15
 * Time: 19:23
 * To change this template use File | Settings | File Templates.
 */
public class Runner {


    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
         OutPutManager outPutManager = new OutPutManager(){
             @Override
             public void println(String str) {
                 System.out.println(str);
             }
         };

        InputManager inputManager = new InputManager(){
            @Override
            public String nextLine() {
                return scanner.nextLine();
            }
            @Override
            public void close() {
               scanner.close();
            }
        };

        new Calculate(inputManager,outPutManager).action();

    }


}
