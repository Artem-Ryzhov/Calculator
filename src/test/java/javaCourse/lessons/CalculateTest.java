package javaCourse.lessons;

import javaCourse.lessons.Calculator.Calculate;
import javaCourse.lessons.Calculator.Interface.InputManager;
import javaCourse.lessons.Calculator.Interface.OutPutManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 27.09.15
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */
public class CalculateTest {

    @Test(expected = ArithmeticException.class)
    public void testAction() throws  ArithmeticException {
        List<String> answers = new ArrayList<String>();
        answers.add("10");
        answers.add("0");
        answers.add("/");
        answers.add("yes");

        final Iterator<String>iterator = answers.iterator(); // итератор который бежит по коллекции
        /*
        делаем анонимный класс
         */
        InputManager inputManager = new InputManager(){

            @Override
            public String nextLine() {
                return iterator.next();
            }
            @Override
            public void close() {
            }
        };
        /*
        делаем анонимный класс
         */
        OutPutManager outPutManager = new OutPutManager() {
            @Override
            public void println(String str) {
            /*
            Сравниваеться наш выходящий парраметр с значением который мы зададим ( Например 2,0)
             */
                //Assert.assertEquals(str,"5.0");
            }
        };
        Calculate calculate = new Calculate(inputManager,outPutManager);
        calculate.action();

        }// end of method
} // end of class
