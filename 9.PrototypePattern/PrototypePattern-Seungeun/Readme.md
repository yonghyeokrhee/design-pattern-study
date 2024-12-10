### Prototype Pattern
이미 생성된 객체를 프로토타입을 사용하여 새로운 객체를 생성하는 패턴
Java는 Object 클래스의 clone() 메소드를 사용하여 객체를 복사할 수 있음
모든 객체에 선언되어 있으니 바로 사용할 수 있을 것 같지만 protected 접근제어자로 선언되어 있어서 사용하기 위해서 Clonable 인터페이스를 구현해야 함

<br>

#### shallow copy vs deep copy
1. shallow copy : 주소값 복사
2. deep copy : 값만 가져다 새로운 객체 생성

<br>

#### 실제 사용?
front-end에서 종종 쓰고 있던 거 같음
