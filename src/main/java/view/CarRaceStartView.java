package view;


import java.util.Scanner;

public class CarRaceStartView implements View<RaceConditionInput> {

    @Override
    public RaceConditionInput render() {

        Scanner input = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");

        int carCount = input.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");

        int tryCount = input.nextInt();

        return RaceConditionInput.of(carCount, tryCount);
    }
}
