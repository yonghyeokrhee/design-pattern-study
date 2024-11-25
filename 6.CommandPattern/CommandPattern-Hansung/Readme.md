# Command Pattern

## Command Pattern 이란
실행될 기능을 캡슐화함으로써 주어진 여러 기능을 실행할 수 있는 재사용성이 높은 클래스를 설계하는 패턴 <br>
즉, 이벤트가 발생했을 때 실행될 기능이 다양하면서도 변경이 필요한 경우에 이벤트를 발생시키는 클래스를 변경하지 않고 재사용하고자 할 때 유용하다. <br>
- 출처: https://gmlwjd9405.github.io/2018/07/07/command-pattern.html

![image](https://github.com/user-attachments/assets/8c220cf6-312d-4e98-9072-7adf9658d02d)

실행될 기능을 캡슐화함으로써 기능의 실행을 요구하는 호출자(Invoker) 클래스와 실제 기능을 실행하는 수신자(Receiver) 클래스 사이의 의존성을 제거한다. <br>
따라서 실행될 기능의 변경에도 호출자 클래스를 수정 없이 그대로 사용 할 수 있도록 해준다. <br>

### 역할이 수행하는 작업
* Command <br>
  * 실행될 기능에 대한 인터페이스 <br>
  * 실행될 기능을 execute 메서드로 선언함 <br>
* ConcreteCommand
  * 실제로 실행되는 기능을 구현
  * 즉, Command라는 인터페이스를 구현함
* Invoker
  * 기능의 실행을 요청하는 호출자 클래스
* Receiver
  * ConcreteCommand에서 execute 메서드를 구현할 때 필요한 클래스
  * 즉, ConcreteCommand의 기능을 실행하기 위해 사용하는 수신자 클래스

```java
// Command Interface
public interface Command {
    void execute();
}

// Concrete Commands
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOn();
    }
}

public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchOff();
    }
}

// Receiver
public class Light {
    public void switchOn() {
        System.out.println("Light is on");
    }
    public void switchOff() {
        System.out.println("Light is off");
    }
}

// Invoker
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
```
* LightOnCommand 와 LightOffCommand 가 두 가지 Command 인터페이스의 구현을 하고 excute() 메소드를 통해 실제 작업을 수행
* Light 클래스가 실제 작업을 수행하는 Receiver
* RemoteControl 클래스가 Invoker로 Command 인터페이스를 사용하여 요청을 저장하고, pressButton 메서드를 통해 요청을 실행

```java
// 인스턴스 생성
Light light = new Light();
Command onCommand = new LightOnCommand(light);
Command offCommand = new LightOffCommand(light);

// Invoker 생성 및 커맨드 설정
RemoteControl remote = new RemoteControl();
remote.setCommand(onCommand);
remote.pressButton(); // Light is on

remote.setCommand(offCommand);
remote.pressButton(); // Light is off
```

### 람다 표현식 혹은 메서드 참조 적용

```java
// Command Interface
public interface Command {
    void execute();
}

// Receiver
public class Light {
    public void switchOn() {
        System.out.println("Light is on");
    }
    public void switchOff() {
        System.out.println("Light is off");
    }
}

// Invoker
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandDemo{
    public static void main(String[] args) {
        // 사용 예제
        Light light = new Light();

        RemoteControl remote = new RemoteControl();

        // 람다 표현식
        remote.setCommand(() -> light.switchOn());
        remote.pressButton(); // Light is on
        
		remote.setCommand(() -> light.switchOff());
        remote.pressButton(); // Light is off
        // 메서드 참조
        remote.setCommand(light::switchOn);
        remote.pressButton(); // Light is on

        remote.setCommand(light::switchOff);
        remote.pressButton(); // Light is off
    }
}
```
### Command Pattern의 장단점
* 장점
>요청 발신자와 수신자 사이의 결합도를 낮춥니다. 이는 요청이 발신자와 수신자 사이에 직접적인 연결이 없다는 것을 의미합니다.<br>
요청을 쉽게 추가하거나 수정할 수 있습니다. 새로운 요청은 Command 클래스를 상속받아 새로운 클래스를 만드는 것으로 추가할 수 있습니다.<br>
요청을 저장하거나, 로그를 남기는 등의 작업을 쉽게 수행할 수 있습니다.<br>
실행 취소와 재실행 같은 기능을 제공하기가 수월합니다.<br>

* 단점

>각각의 개별 요청에 대해 Command 클래스를 만들어야하기 때문에, 클래스가 많아질 수 있습니다.<br>
고수준의 코드 복잡성이 증가할 수 있습니다.<br>

