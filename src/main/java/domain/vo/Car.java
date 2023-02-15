package domain.vo;

import domain.strategy.MoveStrategy;

public class Car {

	private String carName;
	private int position;

	private Car(String carName, int position) {
		this.carName = carName;
		this.position = position;
	}

	public static Car of(String carName, int position) {
		validateCarName(carName);
		return new Car(carName, position);
	}

	public void move(MoveStrategy moveStrategy) {
		if (moveStrategy.movable()) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public String getCarName() {
		return this.carName;
	}

	private static void validateCarName(String carName) {
		if (carName.length() > 5) {
			throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
		}
	}
}
