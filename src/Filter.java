import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");
        List<Integer> result = new ArrayList<>();
        for (int number : source) {
            if (number < treshold) {
                logger.log(String.format("Элемент \"%d\" не проходит", number));
            } else {
                result.add(number);
                logger.log(String.format("Элемент \"%d\" проходит", number));
            }
        }
        logger.log("Выводим результат на экран");
        return result;
    }
}
