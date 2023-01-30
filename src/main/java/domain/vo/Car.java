package domain.vo;

import java.util.Random;

import domain.CarRaceDifficulty;

public class Car {

	private String carName;
	private int poisition;

	public static Car of(String carName, int poisition) {
		return new Car(carName, poisition);
	}

	private Car(String carName, int poisition) {
		this.carName = carName;
		this.poisition = poisition;
	}

	public void move(CarRaceDifficulty carRaceDifficulty) {
		Random random = new Random();
		move(carRaceDifficulty, random.nextInt(carRaceDifficulty.getRandomRange()));
	}

	public void move(CarRaceDifficulty carRaceDifficulty, int randomValue) {
		if (randomValue <= 0) {
			throw new IllegalArgumentException("Bad random value input");
		}
		int moveCondition = carRaceDifficulty.getMoveCondition();
		if (moveCondition <= randomValue) {
			this.poisition++;
		}
	}

	public int getPoisition() {
		return this.poisition;
	}
}
