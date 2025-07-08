package racingcar.domain;

public class CarPosition {
    private final int position;

    private CarPosition(int position) {
        this.position = position;
    }

    public static CarPosition of(int position) {
        return new CarPosition(position);
    }

    public CarPosition move(int randomValue) {
        if (randomValue >= 4) {
            return CarPosition.of(position + 1);
        }
        return this;
    }

    public int getPosition() {
        return this.position;
    }
}
