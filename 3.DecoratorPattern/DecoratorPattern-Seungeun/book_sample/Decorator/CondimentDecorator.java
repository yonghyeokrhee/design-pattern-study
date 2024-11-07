package book_sample.Decorator;

import book_sample.Component.Beverage;

public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage; // (?) public 으로 셋팅하는게 맞나... ==> protected 로 선언해서 별도로 잘 관리하는게 좋음

    public abstract String getDescription();
}
