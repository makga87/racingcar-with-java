package domain;

import java.util.ArrayList;
import java.util.List;

import domain.strategy.CarMoveStrategy;
import domain.strategy.WinnerStrategy;
import domain.vo.Car;
import domain.vo.Cars;

public class CarRace {

	private Cars cars;
	private final CarRaceDifficulty carRaceDifficulty;

	private CarRace(Cars cars, CarRaceDifficulty carRaceDifficulty) {
		this.cars = cars;
		this.carRaceDifficulty = carRaceDifficulty;
	}

	public static CarRace readyForRace(String carNames, CarRaceDifficulty carRaceDifficulty) {
		return new CarRace(createNewRacingCars(carNames), carRaceDifficulty);
	}

	private static Cars createNewRacingCars(String carNames) {

		List<Car> cars = new ArrayList<>();

		for (String carName : carNames.split(",")) {
			cars.add(Car.of(carName, 0));
		}

		return Cars.from(cars);
	}

	public void race() {
		cars.move(CarMoveStrategy.from(carRaceDifficulty));
	}

	public Cars getCars() {
		return this.cars;
	}

	public String getWinners(WinnerStrategy winnerStrategy) {
		return winnerStrategy.winner();
	}
}
