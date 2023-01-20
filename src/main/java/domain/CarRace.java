package domain;

import domain.vo.Car;
import domain.vo.Cars;

public class CarRace {

	private Cars cars;
	private final CarRaceDifficulty carRaceDifficulty;

	public static CarRace readyForRace(int carCount, CarRaceDifficulty carRaceDifficulty) {
		return new CarRace(carCount, carRaceDifficulty);
	}

	private CarRace(int carCount, CarRaceDifficulty carRaceDifficulty) {
		this.cars = createNewRacingCars(carCount);
		this.carRaceDifficulty = carRaceDifficulty;
	}

	private static Cars createNewRacingCars(int carCount) {
		Cars cars = Cars.createInstance();
		for (int cnt = 0; cnt < carCount; cnt++) {
			cars.addCar(Car.of("", 0));
		}
		return cars;
	}

	public void race() {
		cars.stream()
			.forEach(car -> {
				car.move(carRaceDifficulty);
			});
	}

	public Cars getCars() {
		return this.cars;
	}

}
