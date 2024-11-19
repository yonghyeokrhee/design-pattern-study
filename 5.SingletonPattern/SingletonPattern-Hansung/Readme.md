# Singleton 패턴과 사용 사례

[원문 링크](https://injae-kim.github.io/dev/2020/08/06/singleton-pattern-usage.html)

## Singleton 패턴이란?

Singleton 패턴은 특정 클래스의 인스턴스를 단 하나만 생성하여 이를 전역적으로 공유하는 디자인 패턴입니다. 이 패턴은 다음과 같은 경우 유용합니다:

- 애플리케이션 전역에서 하나의 상태를 공유해야 하는 경우
- 특정 리소스나 설정이 중복으로 생성되면 안 되는 경우

## Singleton 패턴 구현 방법

Singleton 패턴을 구현하기 위해 일반적으로 다음과 같은 방법을 사용합니다:

1. **private 생성자**: 외부에서 인스턴스를 생성하지 못하도록 제한합니다.
2. **static 변수**: 단일 인스턴스를 저장할 정적 변수를 선언합니다.
3. **static 메서드**: 정적 변수에 접근하기 위한 메서드를 제공합니다.

### 1.기본적인 구현 방법

```java
public class Singleton {
    private static Singleton instance;

    // private 생성자
    private Singleton() {}

    // 인스턴스 반환 메서드
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### 2. Synchronized 를 사용하여 Thread-Safe 를 보장하는 싱글톤 패턴

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    // synchronzied 스레드 동기화를 사용하며 멀티 스레드 환경에서의 동시성 문제 해결
    public static synchronzied Singleton getInstance() {
      if(instance  == null) {
         instance  = new Singleton();
      }
      return instance;
    }
}
```

### 3. Double Check를 사용하여 Thread-Safe 를 보장하는 싱글톤 패턴

```java
public class Singleton {

    private Singleton() {}
    
    // private static inner class 인 LazyHolder
    private static class LazyHolder() {
        // LazyHolder 클래스 초기화 과정에서 JVM 이 Thread-Safe 하게 instance 를 생성
        private static final Singleton instance = new Singleton();
    }

    // LazyHolder 의 instance 에 접근하여 반환
    public static Singleton getInstance() {
        return LazyHolder.instance;
    }
    
}
```


