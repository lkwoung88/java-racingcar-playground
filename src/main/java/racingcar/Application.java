package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.View;

public class Application {

    public static void main(String[] args) {
        View view = new View();
        RacingGame racingGame = new RacingGame(view);
        racingGame.startGame();
    }
}
