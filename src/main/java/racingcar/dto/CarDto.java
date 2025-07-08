package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {
    private String name;
    private int position;
    private String distance;

    private CarDto(Car car) {
        int carPosition = car.getPosition();
        StringBuilder distanceBuilder = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            distanceBuilder.append("-");
        }

        this.name = car.getName();
        this.position = carPosition;
        this.distance = distanceBuilder.toString();
    }

    public static CarDto of(Car car) {
        return new CarDto(car);
    }

    public String getName() {
        return this.name;
    }

    public String getDistance() {
        return this.distance;
    }

    public int getPosition() {
        return this.position;
    }
}
