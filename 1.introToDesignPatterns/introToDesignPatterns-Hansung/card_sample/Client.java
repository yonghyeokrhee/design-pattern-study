package card_sample;

import card_sample.strategy.KakaoCardStrategy;
import card_sample.strategy.LunaCardStrategy;

public class Client {
    public static void main(String[] args) {
        // 쇼핑카트 전략 컨텍스트 등록
        ShoppingCart cart = new ShoppingCart();

        // 쇼핑 물품
        Item A = new Item("맥북 프로", 10000);
        Item B = new Item("플레이스테이션", 30000);
        cart.addItem(A);
        cart.addItem(B);

        // LUNACard로 결제 전략 실행
        cart.pay(new LunaCardStrategy("kundol@example.com", "pukubababo")); // 40000원 paid using LUNACard.

        // KAKAOBank로 결제 전략 실행
        cart.pay(new KakaoCardStrategy("Ju hongchul", "123456789", "123", "12/01")); // 40000원 paid using KAKAOCard.
    }
}
