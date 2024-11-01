package book_sample;

import book_sample.Component.Beverage;
import book_sample.ConcreteComponent.Espresso;
import book_sample.ConcreteDecorator.Whip;

public class main {
    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println("기본커피 [" + espresso.getDescription() + "] 가격 : " + espresso.cost());

        Beverage whipedEspresso = new Whip(espresso);
        System.out.println("휘핑 올라간 커피 [" + whipedEspresso.getDescription() + "] 가격 : " + whipedEspresso.cost());

        Beverage doubleWhipedEspresso = new Whip(whipedEspresso); // (?) 어떻게 처리하지? // 재귀적으로 처리 해야 한다고 함
        System.out.println("휘핑 올라간 커피 [" + doubleWhipedEspresso.getDescription() + "] 가격 : " + doubleWhipedEspresso.cost());

    }
}
