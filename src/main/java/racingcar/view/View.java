package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);

    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int getTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public void printResult(List<CarDto> dtos) {
        System.out.println("실행 결과");

        for (CarDto dto : dtos) {
            System.out.println(dto.getName() + " : " + dto.getDistance() );
        }
    }

    public void printWinners(List<CarDto> winners) {
        StringBuilder winnerBuilder = new StringBuilder();
        for (CarDto winner : winners) {
            if (winnerBuilder.length() > 0) {
                winnerBuilder.append(", ");
            }
            winnerBuilder.append(winner.getName());
        }
        System.out.println("최종 우승자: " + winnerBuilder.toString());
    }
}
