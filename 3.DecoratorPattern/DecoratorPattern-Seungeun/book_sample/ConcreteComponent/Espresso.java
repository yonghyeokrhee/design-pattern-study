package book_sample.ConcreteComponent;

import book_sample.Component.Beverage;

public class Espresso extends Beverage { // ConcreteComponent : 원본 객체 (데코레이팅 할 객체)
    public Espresso() {
        this.description = "에스프레소";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
