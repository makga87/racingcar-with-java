package domain.vo;

import java.util.Random;

import domain.CarRaceDifficulty;

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

	public void move(CarRaceDifficulty carRaceDifficulty) {
		Random random = new Random();
		move(carRaceDifficulty, random.nextInt(carRaceDifficulty.getRandomRange()));
	}

	public void move(CarRaceDifficulty carRaceDifficulty, int randomValue) {
		if (randomValue < 0) {
			throw new IllegalArgumentException("Bad random value input");
		}
		int moveCondition = carRaceDifficulty.getMoveCondition();
		if (moveCondition <= randomValue) {
			this.position++;
		}
	}

	public int getPosition() {
		return this.position;
	}
}
