package java_sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StrategyInJava {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(4);

        // sort 메서드의 매개변수로 익명 클래스로 Comparator 객체를 인스턴스화하여
        // 그 안의 compare 메서드 동작 로직(ConcreteStrategy)를 직접 구현하여 할당하는 것을 볼 수 있다.
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(numbers);
    }
}
