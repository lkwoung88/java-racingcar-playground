package racingcar.domain;

import racingcar.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static final String SEPARATOR = ",";

    private final List<Car> carList = new ArrayList<>();

    private Cars(String carNames) {
        String[] carNamesSplit = carNames.split(SEPARATOR);
        for (String carName : carNamesSplit) {
            carList.add(Car.of(carName));
        }
    }

    private Cars(List<Car> carList) {
        this.carList.addAll(carList);
    }

    public static Cars of(String carNames) {
        return new Cars(carNames);
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public int size() {
        return carList.size();
    }

    public List<Car> moveAll() {
        carList.stream().forEach(car -> car.move(RandomGenerator.getRandomValueZeroToNine()));
        return carList;
    }

    public List<Car> getWinner() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("No cars available to determine a winner."));

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
