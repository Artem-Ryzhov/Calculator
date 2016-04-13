package javaCourse.lessons.Calculator.CalcCommands;

import javaCourse.lessons.Calculator.Interface.IValidator;
import javaCourse.lessons.Calculator.Interface.InputManager;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 06.10.15
 * Time: 18:14
 * To change this template use File | Settings | File Templates.
 */

public class IConsoleValidator implements IValidator{
    private InputManager inputManager;  // ссылка на интерфейс
    public IConsoleValidator(InputManager inputManager) {
        this.inputManager = inputManager;
    }

    @Override
    public double getDouble(String question) {
        return Double.valueOf(this.validate(question,"\\-?\\d+(\\.\\d{0,})?","Enter the number"));
    }  // end of method

    @Override
    public String getOperation(String ArifOperation) {
        return  (validate(ArifOperation,"[*+/-]","Enter * / + -"));
    } // end of method


    @Override
    public String getAnswer(String answer) {
        return  (validate(answer,"yes"," End the programm??? Enter YES to End the programm"));
    } // end of method

    public String validate(String question,String pattern,String help){
        do{
            if(question.matches(pattern)){
                return question;
            } else {
                System.out.println(help);
                question = inputManager.nextLine();
            }
        }  while (true);
    } // END of validate method


}
