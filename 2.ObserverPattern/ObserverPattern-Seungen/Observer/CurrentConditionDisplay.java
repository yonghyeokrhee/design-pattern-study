package Observer;

import Subject.WeatherData;

public class CurrentConditionDisplay implements Observer{
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        System.out.printf("현재 상태: 온도 %sF, 습도 %s%%\n",weatherData.getTemperature(),weatherData.getHumidity()); // pull 방식
    }
}
