package domain;

import java.util.ArrayList;
import java.util.List;

import domain.vo.Car;
import domain.vo.Cars;

public class CarRace {

	private Cars cars;
	private final CarRaceDifficulty carRaceDifficulty;

	private CarRace(Cars cars, CarRaceDifficulty carRaceDifficulty) {
		this.cars = cars;
		this.carRaceDifficulty = carRaceDifficulty;
	}

	public static CarRace readyForRace(int carCount, CarRaceDifficulty carRaceDifficulty) {
		return new CarRace(createNewRacingCars(carCount), carRaceDifficulty);
	}

	private static Cars createNewRacingCars(int carCount) {
		List<Car> cars = new ArrayList<>();

		for (int cnt = 0; cnt < carCount; cnt++) {
			cars.add(Car.of("", 0));
		}

		return Cars.from(cars);
	}

	public void race() {
		cars.move(carRaceDifficulty);
	}

	public Cars getCars() {
		return this.cars;
	}

}
