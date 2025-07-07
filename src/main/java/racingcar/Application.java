package racingcar;

public class Application {

    public static void main(String[] args) {

        View view = new View();
        Input input = new Input();

        RacingGame racingGame = new RacingGame(input, view);
        racingGame.getStart();
    }
}
