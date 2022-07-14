public class Converter {
    int sum;

    double contDistance(int sum){
        double distance = (sum * 0.75) / 1000;
        return distance;
    }

    double countCal(int sum){
        double kcal = (sum * 50) / 1000;
        return kcal;
    }
}
