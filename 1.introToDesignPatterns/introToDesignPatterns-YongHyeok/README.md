## intro to Design Patterns
- disadvantages of using inheritance to provide Duck behavior
    - 상속의 단점
    - D, F
- 인터페이스를 분리하면 상속의 위험을 줄일 수 있다.
    - interface Duck { swim(); display(); }
    - interface Quackable { quack }
    - interface Flyable { fly() }
    - 그런데 이런 경우 코드 중복을 피할 수 없다. 모든 클래스에서 Flyable 과 Quackable을 구현해야 하기 때문이다. Flyable의 구현을 바꿔야 한다면 최악이다.
- 변화를 만들어 내는 요소들이 무엇인가
    - 의존하고 있는 요소들의 변경 (만약 외부 API에 의존하고 있다면?)
    - 더 이상 경쟁력이 없는 기능과 모델의 성능
    - 발견하지 못했던 숨어있던 버그의 발견과 그 버그의 치명성
- 디자인 원칙
    - 변경되는 부분을 변경되지 않는 부분으로부터 분리하라
    - 변경되는 부분은 캡슐화하라 —> 유연성의 시작이다.
    - 인터페이스에 대해 프로그래밍 하라. 구현이 아니라.
    - 인터페이스에 대해 프로그래밍 하라는 원칙은 Java인터페이스를 사용하라는 뜻은 아니다. 파이썬에는 Interface 구조체가 없다.즉 이말은 다형성을 활용할 수 있도록 supertype에 대해서 프로그래밍 하라는 뜻이다. 
- 결국 전략 패턴은 합성(HAS-A)이다.
  - The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
