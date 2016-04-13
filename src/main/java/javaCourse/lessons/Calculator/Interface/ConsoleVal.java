package javaCourse.lessons.Calculator.Interface;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 08.10.15
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
public abstract class ConsoleVal {
   private InputManager inputManager;
    public double getDouble(String question) {
        double number = 0; // будет хранить выбранное число
        boolean run = true;
        /*
        цыкл проверяет или выбранный символ действительно число
         */
        do {
            if (question.matches("\\-?\\d+(\\.\\d{0,})?")) { // рег.выражение служит для ввода только чисел и больше ничего
                number = Double.parseDouble(question);
                run = false;                  // выходим из цыкла
            }else {
                System.out.println("Number is Incorrect enter another number");
                question = inputManager.nextLine();
            }
        } while (run);
        return number;    // передает выбранное число
    }  // end o


}
