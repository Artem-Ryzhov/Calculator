package javaCourse.lessons.Calculator.CalcCommands;

import javaCourse.lessons.Calculator.Interface.ArithmeticOperation;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 18.09.15
 * Time: 20:34
 * To change this template use File | Settings | File Templates.
 */
public class PlusAction implements ArithmeticOperation {


    public double calculate(double first, double second) {
        return first + second;
    }
}

