import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    MonthData[] monthToData;
    int ambitionStep;
    Converter converter = new Converter();
    int[] NumDay = new int[30];
    int N = 0;


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void saveStepInDay(int month, int day, int step){
        monthToData[month-1].dayData[day-1] = step;
    }

    void printStatistic(int month) {
        int sum = 0;
        int maxStep = 0;

            for (int i = 0; i < monthToData[0].dayData.length; i++) {
                System.out.print((i + 1) + " день: " + monthToData[month-1].dayData[i] + ", ");
                sum = sum + monthToData[month-1].dayData[i];
                if (monthToData[month-1].dayData[i] > maxStep) {
                    maxStep = monthToData[month-1].dayData[i];
                }
            }

        System.out.println("");
        System.out.println("Общее количество шагов за месяц: " + sum);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStep);
        System.out.println("Среднее количетсво шагов: " + (sum/30));
        System.out.println("Пройденная дистанция за месяц " + converter.contDistance(sum) + " км");
        System.out.println("Количество сожженных килокалорий " + converter.countCal(sum));

    }

    int setAmbitionStep() {
        ambitionStep = scanner.nextInt();
        System.out.println("Новое значение схоранено.");
        System.out.println("Целевое количество шагов: " + ambitionStep);
        return ambitionStep;
    }

    void searchSeries(int month, int ambitionStep) {
        int max = 0;
        for (int i = 0; i < monthToData[0].dayData.length; i++)
            if (monthToData[month - 1].dayData[i] >= ambitionStep) {
                N = N + 1;
            } else {
                NumDay[i] = N;
                N = 0;
            }

        for (int i = 0; i < NumDay.length; i++) {
            if (NumDay[i] > max) {
                max = NumDay[i];
            }
        }
        if (max >= 2) {
            System.out.println("Лучшая серия: " + max + " дней");
        }
    }
}
