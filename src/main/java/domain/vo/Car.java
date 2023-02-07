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
}
