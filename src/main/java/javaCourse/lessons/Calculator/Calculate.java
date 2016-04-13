package javaCourse.lessons.Calculator;

import javaCourse.lessons.Calculator.CalcCommands.*;
import javaCourse.lessons.Calculator.Interface.ArithmeticOperation;
import javaCourse.lessons.Calculator.Interface.InputManager;
import javaCourse.lessons.Calculator.Interface.OutPutManager;

import java.util.LinkedHashMap;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 18.09.15
 * Time: 19:21
 * To change this template use File | Settings | File Templates.
 */
public class Calculate  {
    private InputManager inputManager;
    private OutPutManager outPutManager;
    private IConsoleValidator consoleValidator;
    private ArithmeticOperation action;    // cылка на Интерфейс  служит для роботы  с коммандами

    public Calculate(InputManager inputManager,OutPutManager outPutManager) {
        this.inputManager = inputManager;
        this.outPutManager = outPutManager;
        consoleValidator = new IConsoleValidator(inputManager);
    }
    /*
   Метод создает Арифметические Комманды
   в качестве параметра принимает ключ и возвращает команду по ключу
    */
    public ArithmeticOperation ArifCommand(String operation){     //input specific key to find Command
        LinkedHashMap<String, ArithmeticOperation> map = new LinkedHashMap();       // create collections with Keys,Command
        map.put("+",new PlusAction());
        map.put("-",new MinusAction());
        map.put("/",new DividaeAction());
        map.put("*",new MultipleAction());

        return map.get(operation);   // return command from key
    } // end of method

    /*
   Метод будет запрашивать у пользователя ввести числа
   и произвести Арифметические операции над ними
    */
    public void action() {
        double  firstNumber = 0;  // будет хранить первое выбранное число
        double  secondNumber = 0;  // будет хранить второе выбранное число
        String  operation = "";   // будет хранить выбранну арифметеческую операцию
        boolean go = true;        // для постоянного цыкла
        String choice = "";  // будет хранить значение для продолжения или завершения программы
        try {
            do {
                System.out.println("Enter first Number");
                firstNumber = consoleValidator.getDouble(inputManager.nextLine());
                System.out.println("Enter second number");
                secondNumber = consoleValidator.getDouble(inputManager.nextLine());
                System.out.println("Enter move : / * + -  ");
                operation = consoleValidator.getOperation(inputManager.nextLine());
                action  = ArifCommand(operation);    // вызывает комманду по ключу
                outPutManager.println(String.valueOf(action.calculate(firstNumber,secondNumber)));
                System.out.println("End the program?  Choice   yes or  no");
                choice =  inputManager.nextLine();
                if (choice.equals("yes")){
                    go = false;
                }

            } while (go);

        }  // end of try
        catch (NumberFormatException n){
            System.out.println("Incorect");

        }finally {
            if (inputManager != null) {
                inputManager.close();  // завершает роботу сканнера
            }
        } // end finally block
    } // end of method
}    // end of class
