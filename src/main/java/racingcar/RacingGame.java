package racingcar;

import java.util.List;

public class RacingGame {

    public static final String SEPARATOR = ",";

    private final Input input;
    private final View view;

    public RacingGame(Input input, View view) {
        this.input = input;
        this.view = view;
    }

    public void getStart() {
        view.printStartMessage();
        String carNames = input.getCarNamesString();

        RacingCars racingCars = getRacingCarsBy(carNames, SEPARATOR);

        view.printTryCountMessage();
        int tryCount = input.getTryCount();

        view.printResultMessage();

        for (int i = 0; i < tryCount; i++) {
            List<RacingCar> cars = racingCars.moveAll();
            view.printRacingCars(cars);
        }

        List<RacingCar> winners = racingCars.getWinners();
        view.printWinner(winners);
    }

    public RacingCars getRacingCarsBy(String carNames, String separator) {
        String[] carNamesArr = carNames.split(separator);
        return RacingCars.of(carNamesArr);
    }
}
