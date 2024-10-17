package Subject;

import Observer.Observer;
import java.util.List;
import java.util.ArrayList;

public class WeatherData implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;

    private List<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public WeatherData(float temp, float humi, float press) {
        this.temperature = temp;
        this.humidity = humi;
        this.pressure = press;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void measurementsChanged() { // 변경 상태 받는 함수
        notifyObservers();
    }
    public void setMeasurements(float temp, float humi, float press) {
        this.temperature = temp;
        this.humidity = humi;
        this.pressure = press;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

}
