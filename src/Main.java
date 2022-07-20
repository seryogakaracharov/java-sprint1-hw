import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        int ambitionStep = 10000;
        System.out.println("Целевое количество шагов: 10000");

        while(true) {
            printMenu();

            int choice = scanner.nextInt();
            if(choice == 1) {
                System.out.println("Введите номер месяца (от 0 до 11)");
                int month = scanner.nextInt();
                if (month >11 ) {
                    System.out.println("Неверный номер месяца.");
                    break;
                } else if (month < 0) {
                    System.out.println("Неверный номер месяца.");
                    break;
                }
                System.out.println("Введите номер дня (от 0 до 29)");
                int day = scanner.nextInt();
                if (day >29  ) {
                    System.out.println("Неверный номер дня.");
                    break;
                } else if (day < 0) {
                    System.out.println("Неверный номер месяца.");
                    break;
                }
                System.out.println("Введите количетсво шагов");
                int step = scanner.nextInt();
                if (step >= 0) {
                    stepTracker.saveStepInDay(month, day, step);
                } else
                    System.out.println("Количество шагов должно быть неотрицательным");
            } else if(choice == 2) {
                System.out.println("Укажите номер месяца:");
                int month = scanner.nextInt();
                if (month >11 ) {
                    System.out.println("Неверный номер месяца.");
                    break;
                } else if (month < 0) {
                    System.out.println("Неверный номер месяца.");
                    break;
                }
                int sum = stepTracker.calcSum(month);
                int maxStep = stepTracker.calcMaxStep(month);
                stepTracker.printStepOnDay(month);
                System.out.println("Общее количество шагов за месяц: " + sum);
                System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStep);
                System.out.println("Среднее количетсво шагов: " + sum/30);
                System.out.println("Пройденная дистанция за месяц " + converter.contDistance(sum) + " км");
                System.out.println("Количество сожженных килокалорий " + converter.countCal(sum));

                if (stepTracker.searchBestSeries(month, ambitionStep) >= 2) {
                    System.out.println("Лучшая серия: " + stepTracker.searchBestSeries(month, ambitionStep) + " дней");
                }
            } else if(choice == 3) {
                System.out.println("Укажите новую цель по колиеству шагов в день: ");
                ambitionStep = scanner.nextInt();
                System.out.println("Новое значение схоранено.");
                System.out.println("Целевое количество шагов: " + ambitionStep);
            } else if(choice == 4) {
                System.out.println("Выход");
                break;
            } else
                System.out.println("Такой команды нет");
        }
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("Что Вы хотите сделать:");
        System.out.println("1 - Ввести количество шагов за определенный день;");
        System.out.println("2 - Напечатать статистику за определённый месяц;");
        System.out.println("3 - Изменить цель по количеству шагов в день;");
        System.out.println("4 - Выйти из приложения.");
    }
}
