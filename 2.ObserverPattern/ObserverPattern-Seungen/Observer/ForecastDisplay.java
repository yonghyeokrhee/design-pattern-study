package Observer;

import Subject.WeatherData;

public class ForecastDisplay implements Observer{ // 기상예보
    private WeatherData weatherData;
    private float currentPressure = 29.92f;
    private float lastPressure;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update() {
        lastPressure = currentPressure;
        currentPressure = weatherData.getPressure();
        String msg = "";
        if (lastPressure == currentPressure){
            msg = "지금과 비슷할 것 같습니다.";
        } else if (lastPressure < currentPressure){
            msg = "쌀쌀하며 비가 올 것 같습니다.";
        } else {
            msg = "날씨가 좋아지고 있습니다!";
        }
        System.out.printf("기상 예보: %s\n",msg);
    }

}
