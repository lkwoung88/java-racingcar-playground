package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {

    final List<RacingCar> racingCars = new ArrayList<>();
    Random random = new Random();

    public static RacingCars of(String[] carNamesArr) {
        RacingCars racingCarCollection = new RacingCars();

        List<String> carNameList = List.of(carNamesArr);
        carNameList.stream()
                .forEach(car -> racingCarCollection.addCar(RacingCar.of(car)));

        return racingCarCollection;
    }

    public void addCar(RacingCar car) {
        this.racingCars.add(car);
    }

    public List<RacingCar> moveAll() {
        this.racingCars.forEach(car -> {
                int randomNumber = random.nextInt(10);
                car.move(randomNumber);
        });
        return this.racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<RacingCar> getWinners() {
        return racingCars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .toList();
    }

    private int getMaxPosition() {
        return racingCars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("No cars available"));
    }
}
