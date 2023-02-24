import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> basket = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Введите номер необходимой операции или введите exit для выхода из программы");
            System.out.println("1. Добавить товар в корзину");
            System.out.println("2. Показать список покупок");
            System.out.println("3. Удалить товар из списка покупок");
            System.out.println("4. Поиск товара по ключевым словам");

            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }

            switch (Integer.parseInt(input)) {
                case (1):
                    while (true) {
                        System.out.println("Введите название товара, или end для завершения операции");
                        String product = scanner.nextLine();
                        if (product.equals("end")) break;
                        basket.add(product);
                    }
                    break;
                case (2):
                    showShoppingList(basket);
                    break;
                case (3):
                    showShoppingList(basket);
                    System.out.println("Какой товар хотите удалить? Введите номер или название");
                    input = scanner.nextLine();
                    try {
                        if (Integer.parseInt(input) > 0 & Integer.parseInt(input) < basket.size())
                            basket.remove(Integer.parseInt(input) - 1);
                    } catch (NumberFormatException e) {
                        Iterator<String> b = basket.iterator();
                        while (b.hasNext()) {
                            if (input.equals(b.next())) b.remove();
                        }
                    }
                    break;
                case (4):
                    System.out.println("Введите текст для поиска");
                    input = scanner.nextLine().toLowerCase();
                    System.out.println("Найдено:");
                    for (int i = 0; i < basket.size(); i++) {
                        if (basket.get(i).toLowerCase().contains(input))
                            System.out.println((i + 1) + ". " + basket.get(i));
                    }
                    break;
                default:
                    System.out.println("Некорректные данные! Попробуйте еще раз.");
            }
        }
    }

    public static void showShoppingList(List<String> basket) {
        System.out.println("Список покупок:");
        for (int i = 0; i < basket.size(); i++) {
            System.out.println((i + 1) + ". " + basket.get(i));
        }
    }
}