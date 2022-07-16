import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        int ambitionStep = 10000;
        System.out.println("Целевое количество шагов: 10000");

        while(true) {
            printMenu();

            int choice = scanner.nextInt();
            if(choice == 1) {
                System.out.println("Введите номер месяца (от 1 до 12)");
                int month = scanner.nextInt();
                System.out.println("Введите номер дня (от 1 до 30)");
                int day = scanner.nextInt();
                System.out.println("Введите количетсво шагов");
                int step = scanner.nextInt();
                if (step > 0) {
                    stepTracker.saveStepInDay(month, day, step);
                } else
                    System.out.println("Количество шагов должно быть неотрицательным");
            } else if(choice == 2) {
                System.out.println("Укажите номер месяца:");
                int month = scanner.nextInt();
                stepTracker.printStatistic(month);
                stepTracker.searchSeries(month, ambitionStep);
            } else if(choice == 3) {
                System.out.println("Укажите новую цель по колиеству шагов в день: ");
                ambitionStep = stepTracker.setAmbitionStep();
            } else if(choice == 4) {
                System.out.println("Выход");
                break;
            } else
                System.out.println("Такой команды нет");
        }
    }

    public static void printMenu() {
        System.out.println("Что Вы хотите сделать:");
        System.out.println("1 - Ввести количество шагов за определенный день;");
        System.out.println("2 - Напечатать статистику за определённый месяц;");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("4 - Выйти из приложения.");
    }


}
