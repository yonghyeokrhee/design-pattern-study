package book_sample.Decorator;

import book_sample.Component.Beverage;

public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage; // (?) public 으로 셋팅하는게 맞나...

    public abstract String getDescription();
}
