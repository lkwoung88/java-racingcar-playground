package racingcar;

import java.util.List;

public class View {

    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printRacingCars(List<RacingCar> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName() + ": ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        });
    }

    public void printWinner(List<RacingCar> winners) {
        System.out.println(winners.stream()
                .map(RacingCar::getName)
                .reduce((first, second) -> first + ", " + second)
                .orElse("") + "가 최종 우승했습니다.");
    }
}
