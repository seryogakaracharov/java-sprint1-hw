public class StepTracker {
    MonthData[] monthToData;
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

    int printSum(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[0].dayData.length; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month-1].dayData[i] + ", ");
            sum = sum + monthToData[month-1].dayData[i];
        }
        return sum;
    }

    int printMaxStep(int month){
        int maxStep = 0;
        for (int i = 0; i < monthToData[0].dayData.length; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month-1].dayData[i] + ", ");
            if (monthToData[month-1].dayData[i] > maxStep) {
                maxStep = monthToData[month-1].dayData[i];
            }
        }
        return maxStep;
    }

    int searchSeries(int month, int ambitionStep) {
        int max = 0;
        for (int i = 0; i < monthToData[0].dayData.length; i++)
            if (monthToData[month - 1].dayData[i] >= ambitionStep) {
                N = N + 1;
            } else {
                NumDay[i] = N;
                N = 0;
            }
        for (int i: NumDay) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
