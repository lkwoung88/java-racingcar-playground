package racingcar.controller;

import racingcar.dto.CarDto;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.View;

import java.util.List;

public class RacingGame {

    private final View view;

    public RacingGame(View view) {
        this.view = view;
    }

    public void startGame() {

        String carNames = view.getCarNames();
        Cars cars = Cars.of(carNames);

        int tryCount = view.getTryCount();
        for (int i = 0; i < tryCount; i++) {
            view.printResult(getCarDtosBy(cars.moveAll()));
        }

        view.printWinners(getCarDtosBy(cars.getWinner()));
    }

    private List<CarDto> getCarDtosBy(List<Car> cars) {
        return cars.stream().map(CarDto::of).toList();
    }
}
