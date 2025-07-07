package racingcar;

public class RacingCar {

    private String name;
    private int movingCount;

    private RacingCar(String name, int movingCount) {
        this.name = name;
        this.movingCount = movingCount;
    }

    public static RacingCar of(String car) {
        if (car.length() > 5) {
            throw new IllegalArgumentException();
        }
        return new RacingCar(car, 0);
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.movingCount;
    }

    public void move(int randomNumber) {
        if(randomNumber >= 4) {
            this.movingCount++;
        }
    }
}
