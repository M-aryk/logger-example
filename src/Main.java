import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите верхнюю границу для значений: ");
        int m = Integer.parseInt(scanner.nextLine());
        createNumberList(n, m, numbers);

        logger.log("Создаём и наполняем список");
        System.out.println("Вот случайный список: " + printNumberList(numbers));

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");

        int f = Integer.parseInt(scanner.nextLine());
        Filter filter = new Filter(f);
        ArrayList<Integer> result = new ArrayList<>(filter.filterOut(numbers));
        System.out.println("Отфильтрованный список: " + printNumberList(result));
        logger.log("Завершаем программу");
    }

    public static void createNumberList(int n, int m, ArrayList<Integer> numbers) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int number = random.nextInt(m);
            numbers.add(number);
        }
    }

    public static String printNumberList(ArrayList<Integer> numbers) {
        String result = numbers.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");
        return result;
    }
}
