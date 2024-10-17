# Observer Pattern
#### Observer Pattern 구성 (Subject:Observer=1:N)
- Subject 
  - Observer들을 등록하고 삭제하는 메소드를 가지고 있는 인터페이스
  - Observer들에게 알림을 보내는 메소드를 가지고 있는 인터페이스
- Subject 구현체
  - Observer list를 들고 있음. --> 인터페이스를 참고해서 추후에 Observer 추가에 영향이 없음
- Observer 
  - Subject로부터 알림을 받는 메소드를 가지고 있는 인터페이스
  - 공통적으로 처리해야 하는 action을 정의 (ex. 기상정보 업데이트, 이상감지 알림발송 등)
- Observer 구현체
  - 여러개의 Observer 구현체가 있을 수 있고, 신규 추가 시 새로운 객체만 생성하면 됨.

➡️주제(Data) 상태를 관리하는 객체, 주제(Data) 상태 변화에 따른 처리를 하는 객체로 분리되어 SRP, OCP를 만족 시킴.

#### Observer Pattern 구현방식
* 전체 observer에게 변경 알림이 가는건 동일하나 처리 방식이 다름
1. push
   - 사용하지 않는 데이터여도 전체 observer가 업데이트 됨
2. pull (* 시스템이 커지고 복잡해질 수록 효율적임)
   - 주제에 필요한 정보만 가져와서 사용

#### Observer Pattern 사용예시
- PropertyChangeSupport 클래스 (> Copolit 정리 내용)
  - Java에서 제공하는 Observer Pattern 구현체
  - PropertyChangeSupport 클래스는 PropertyChangeListener 인터페이스를 구현한 객체들을 등록하고, 등록된 객체들에게 PropertyChangeEvent 객체를 전달함.
  - PropertyChangeEvent 객체는 PropertyChangeListener 인터페이스를 구현한 객체들이 받아서 처리함.
- Java에서는 Observable(==Subject), Observer interface가 존재했지만 Java9까지만 지원
---

#### 추가 확인 필요한 것
1. Subject interface 는 왜 필요한 걸까? 1:N 관계에서 1인 부분을 명확히 표기하기엔 오히려 interface를 명시하지 않는게 좋지 않을까..?
2. 
   