import service.CarRace;
import service.domain.RaceCondition;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int moveCondition = 4;

        Scanner input = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = input.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = input.nextInt();

        CarRace carRace = new CarRace(RaceCondition.of(carCount, moveCondition));

        carRace.start(tryCount);

    }
}
