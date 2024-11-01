package book_sample.Component;

public abstract class Beverage { // Component :  원본 객체와 장식된 객체 모두를 묶는 역할
    public String description = "default description";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
