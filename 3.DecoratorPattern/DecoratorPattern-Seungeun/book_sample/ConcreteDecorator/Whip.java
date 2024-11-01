package book_sample.ConcreteDecorator;

import book_sample.Component.Beverage;
import book_sample.Decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 휘핑";
    }

    public double cost() {
        return beverage.cost() + .10;
    }
}
