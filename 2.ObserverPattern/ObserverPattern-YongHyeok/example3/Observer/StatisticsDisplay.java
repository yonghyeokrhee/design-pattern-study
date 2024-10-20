package example3.Observer;

import Subject.WeatherData;

public class StatisticsDisplay implements Observer { // 기상예보
    private WeatherData weatherData;
    private float maxTemp = 0.0f;
    private float minTemp = 200f;
    private float sumTemp = 0.0f;
    private int numReadings = 0;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        numReadings++;
        maxTemp = Math.max(maxTemp, weatherData.getTemperature());
        minTemp = Math.min(minTemp, weatherData.getTemperature());
        sumTemp += weatherData.getTemperature();
        System.out.println("평균/최대/최소 온도: " + (sumTemp / numReadings) + "/" + maxTemp + "/" + minTemp);
    }

}
