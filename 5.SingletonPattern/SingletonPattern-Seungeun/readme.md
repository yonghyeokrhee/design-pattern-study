### Singleton Pattern
- Singleton Pattern은 객체를 하나만 생성하고 그 객체를 공유하여 사용하는 패턴이다. (1개의 인스턴스만 생성)
- 직접 패턴을 구현할때에는 client 에서 인스턴스를 여러개 생성하지 못하도록 구현하는 것이 매우 중요
  
  - 실제 구현해서 사용하는 경우가 있을까?

    - 한번의 new 생성자로 인스턴스를 사용하기 때문에 메모리 낭비를 방지
    - 설정파일 등 여러개의 인스턴스가 생겨서 안되는 경우 사용
- 단점 : OCP 원칙을 위배 

### Spring Singleton vs Singleton Pattern
- Singleton Pattern : Thread-safe 하기 위해 1. double check synchronized, 2.eager initialization, 3. Bill Pugh 구현법 (JVM은 인스턴스 원자성 보장) 등등.. > class loader에 의해 구현
- Spring Singleton : Bean을 생성할때 scope를 singleton으로 설정하면 Spring Container에 등록된 Bean은 Singleton으로 사용 > Spring Container에 의해 구현

