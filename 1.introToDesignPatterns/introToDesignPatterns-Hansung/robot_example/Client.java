package robot_example;

import robot_example.move.Run;
import robot_example.move.Walk;
import robot_example.translate.Japanese;
import robot_example.translate.Korean;

// 클라이언트(전략 교체/전략 실행한 결과를 얻음)
class Client {
    public static void main(String[] args) {
        Robot robot = new Robot(new Walk(), new Korean());
        robot.move(); // 걸어서 배달합니다 삐-빅
        robot.translate(); // 한국어로 번역합니다 삐-비-빅

        // 로봇의 전략(기능)을 run과 Japanese 번역으로 변경
        robot.setMove(new Run());
        robot.setTranslate(new Japanese());

        robot.move(); // 뛰러서 배달합니다 삐-빅
        robot.translate(); // 일본어로 번역합니다 삐-비-빅
    }
}