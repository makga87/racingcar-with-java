package service.domain;

import java.util.ArrayList;
import java.util.Random;

public class RaceCondition {

    private final ArrayList<Car> carList = new ArrayList<>();
    private final int moveCondition;

    public static RaceCondition of(int carCount, int moveCondition) {
        return new RaceCondition(carCount, moveCondition);
    }

    public RaceCondition(int carCount, int moveCondition) {
        initCarList(carCount);
        this.moveCondition = moveCondition;
    }

    private void initCarList(int carCount) {
        for (int count = 0; count < carCount; count++) {
            carList.add(new Car("", 0));
        }
    }

    public ArrayList<Car> getCarList() {
        return this.carList;
    }

    public boolean isAdvanceCondition(int randmonValue) {
        return randmonValue >= moveCondition;
    }
}
