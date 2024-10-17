import Observer.CurrentConditionDisplay;
import Observer.ForecastDisplay;
import Observer.StatisticsDisplay;
import Subject.WeatherData;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        weatherData.registerObserver(()->{
            System.out.printf("현재 상태: 온도 %sF, 습도 %s%%\n",weatherData.getTemperature(),weatherData.getHumidity()); // pull 방식
        }); // 함수형 구현, CurrentConditionDisplay 을 사용해도 괜찮음
        weatherData.registerObserver(new ForecastDisplay(weatherData)); // 01. 코드 자석 문제
        weatherData.registerObserver(new StatisticsDisplay(weatherData));
        weatherData.setMeasurements(80, 65, 30.4f); // 상태 변경
        System.out.println("=====================================");
        weatherData.setMeasurements(82, 72, 28.4f); // 상태 변경
        System.out.println("=====================================");
        weatherData.setMeasurements(78, 90, 28.4f); // 상태 변경
    }
}
