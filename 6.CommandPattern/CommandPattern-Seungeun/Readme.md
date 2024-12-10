### Command Pattern
- 동작을 캡슐화 해서 외부에는 execute() 인터페이스만 오픈하고 내부 로직은 구현
- AOP가 비슷한 역할일까? no,
    - AOP : 행동을 캡슐화 하려하는게 비슷하지만 로깅등 메소드 수행전/후에 항상 수행되어야 하는 것들 정의해두는 것 ex) loggin, transaction management
    - 커맨드 패턴 : 행동의 방식이 너무 다양해서 매번 client 에서 이를 정의하는게 아니라 커맨드 객체에게 그 책임을 위임 ex) queues, requests...
- invoker가 꼭 있어야 하나?
  -  

