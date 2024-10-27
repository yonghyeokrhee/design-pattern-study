package card_sample;

import card_sample.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    // 전략을 매개변수로 받아서 바로바로 전략을 실행
    public void pay(PaymentStrategy paymentMethod) {
        int amount = 0;
        for (Item item : items) {
            amount += item.price;
        }
        paymentMethod.pay(amount);
    }
}
