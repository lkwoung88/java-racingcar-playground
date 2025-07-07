package racingcar;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String getCarNamesString() {
        return scanner.next();
    }

    public int getTryCount() {
        return scanner.nextInt();
    }
}
