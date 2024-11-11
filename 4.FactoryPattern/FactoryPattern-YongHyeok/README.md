# Brain power
How might you take all the parts of your application that instantiate concrete classes and seperate or encapsulate them from the rest of your application
<br>
클래스를 초기화 하는 부분을 분리시킬 수 있는 방법? 이게 Factory Pattern 아닌가.

```java
Pizza orderPizza() {
    Pizza pizza = new Pizza();
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
}
```

```java
Pizza orderPizza(String type){
    Pizza pizza;
    if (type.equals("cheese")){
        pizza = new CheesePizza();
    } else if (type.equals("greek")) {
        pizza = new GreekPizza();
    } else if (type.equals("pepperoni")) {
        pizza = new PepperoniPizza();
    }
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
}

```

# Encapsulating object creation
객체 생성에 대한 것을 캡슐화하자.

```java
public class SimplePizzaFactory {
    public Pizza createPizza(string type){
        Pizza pizza;
        if (type.equals("cheese")){
            pizza = new CheesePizza();
        } else if (type.equals("greek")) {
            pizza = new GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}

public class PizzaStore{
    SimplePizzaFactory factory;
    public PizzaStore(SimplePizzaFactory factory) {
        thie.factory = factory;
    }
    public orderPizza(string type){
        Pizza pizza;
        pizza = facotry.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
```
