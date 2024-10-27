package robot_example;

import robot_example.move.MoveStrategy;
import robot_example.translate.TranslateStrategy;

public class Robot {
    MoveStrategy moveStrategy;
    TranslateStrategy translateStrategy;

    Robot(MoveStrategy moveStrategy, TranslateStrategy translateStrategy) {
        this.moveStrategy = moveStrategy;
        this.translateStrategy = translateStrategy;
    }

    void move() {
        moveStrategy.move();
    }

    void translate() {
        translateStrategy.translate();
    }

    void setMove(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    void setTranslate(TranslateStrategy translateStrategy) {
        this.translateStrategy = translateStrategy;
    }
}