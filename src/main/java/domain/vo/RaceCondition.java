package domain.vo;

import java.util.ArrayList;

public class RaceCondition {

	private final ArrayList<Car> carList = new ArrayList<>();
	private final int moveCondition;

	public static RaceCondition of(int carCount, int moveCondition) {
		isValidCarCount(carCount);
		return new RaceCondition(carCount, moveCondition);
	}

	public RaceCondition(int carCount, int moveCondition) {
		initCarList(carCount);
		this.moveCondition = moveCondition;
	}

	private static void isValidCarCount(int carCount) {
		if(carCount < 1) throw new IllegalArgumentException("자동차 갯수는 1대 이상이어야 합니다.");
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
