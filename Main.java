import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);


        list.add("Сходить в магазин");
        list.add("Приготовить завтрак");


        while (true) {

            System.out.println("Выберите операцию:");
            System.out.println("0. Выход из программы\n" +
                    "1. Добавить дело\n" +
                    "2. Показать дела\n" +
                    "3. Удалить дело по номеру\n" +
                    "4. Удалить дело по названию\n" +
                    "5. Удаление по ключевому слову\n"+
                    "Ваш выбор:");

            String input = scanner.nextLine();

            if (input.equals("0")) {
                break;
            }
            if (input.equals("1")) {

                System.out.print("Введите название задачи:");
                String task = scanner.nextLine();
                list.add(task);
                System.out.println("Добавлено!\n");
                showList(list);
            }

            if (input.equals("2")) {
                showList(list);
            }

            if (input.equals("3")) {
                try {
                    System.out.println("Введите номер для удаления:");

                    int input2 = Integer.parseInt(scanner.nextLine());
                    list.remove(input2);
                    System.out.println("Удалено!\n");
                    showList(list);

                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Задача не найдена. Выберите другую операцию\n");

                }

            }

            if (input.equals("4")) {
                System.out.print("Введите задачу для удаления:");

                String task = scanner.nextLine();
                boolean removed = false;

                Iterator<String> iterator = list.iterator();
                while(iterator.hasNext()){
                    String current = iterator.next();
                    if(current.equals(task)){
                        iterator.remove();
                        removed = true;
                    }
                }

                if (removed) {
                    System.out.println("Удалено!\n");
                }
                else {
                    System.out.println("Задача не найдена\n");
                }

                showList(list);



            }

            if(input.equals("5")){

                    System.out.print("Введите ключевое слово для удаления:");


                    String task = scanner.nextLine();

                    Iterator<String> iterator = list.iterator();
                    boolean removed = false;

                    while(iterator.hasNext()){
                        String current = iterator.next();

                        if(current.contains(task)){
                            iterator.remove();
                            removed = true;
                        }
                    }

                    if (removed) {
                        System.out.println("Удалено!\n");
                    }
                    else {
                        System.out.println("Задача не найдена\n");
                    }

                    showList(list);



            }


        }

    }

    public static void showList(List<String> list) {
        System.out.println("Ваш список дел:");
        if(list.isEmpty()){
            System.out.println("(Пусто)");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
        System.out.println();
    }
}
