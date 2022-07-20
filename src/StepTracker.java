public class StepTracker {
    MonthData[] monthToData;
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

    int calcSum(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[0].dayNum; i++) {
            sum = sum + monthToData[month-1].dayData[i];
        }
        return sum;
    }

    void printStepOnDay (int month) {
        for (int i = 0; i < monthToData[0].dayNum; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month - 1].dayData[i] + ", ");
        }
    }

    int calcMaxStep(int month){
        int maxStep = 0;
        for (int i = 0; i < monthToData[0].dayNum; i++) {
            System.out.print((i + 1) + " день: " + monthToData[month-1].dayData[i] + ", ");
            if (monthToData[month-1].dayData[i] > maxStep) {
                maxStep = monthToData[month-1].dayData[i];
            }
        }
        return maxStep;
    }

    int searchBestSeries(int month, int ambitionStep) {
        int Series = 0;
        int bestSeries = 0;
        for (int i = 0; i < monthToData[0].dayNum; i++) {
            if (monthToData[month - 1].dayData[i] >= ambitionStep) {
                N = N + 1;
            } else {
                Series = N;
                N = 0;
            }
            if (Series > bestSeries) {
                bestSeries = Series;
            }
        }
        return bestSeries;
    }
}
