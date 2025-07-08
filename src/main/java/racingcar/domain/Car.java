package racingcar.domain;

public class Car {

    private CarName carName;
    private CarPosition carPosition;

    private Car(String name) {
        this(name, 0);
    }

    private Car(String name, int position) {
        this.carName = CarName.of(name);
        this.carPosition = CarPosition.of(position);
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public static Car of(String name, int position) {
        return new Car(name, position);
    }

    public int move(int randomValue) {
        return carPosition.move(randomValue).getPosition();
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return carPosition.getPosition();
    }
}
