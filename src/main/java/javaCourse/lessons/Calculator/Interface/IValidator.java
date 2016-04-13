package javaCourse.lessons.Calculator.Interface;

/**
 * Created by IntelliJ IDEA.
 * User: артем
 * Date: 06.10.15
 * Time: 18:13
 * To change this template use File | Settings | File Templates.
 */
public interface IValidator {
     /**
     * Метод запрашивает пользовательский ввести число после  возвращает ето  число
     * @param question  вопрос к пользователю
     *
     * @return
     */
    double getDouble(String question);

    /*
    Метод запрашивает у пользователя ввести арифметическую камманду
    + - * /
    и ета комманда передаеться в качестве парраметра в метод
     */

    String getOperation(String move);
    /*
      Метод запрашивает у пользователя ввести
       yes or no  для продолжения или завершения программы
     */
    String getAnswer(String answer);
}
