package domain.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import domain.vo.Car;
import domain.vo.Cars;
import domain.vo.FirstPlaceCar;

public class CarRaceWinnerStrategy implements WinnerStrategy {

	private Cars cars;
	private List<Car> winners = new ArrayList<>();

	private CarRaceWinnerStrategy(Cars cars) {
		this.cars = cars;
	}

	public static CarRaceWinnerStrategy from(Cars cars) {
		return new CarRaceWinnerStrategy(cars);
	}

	@Override
	public String winner() {
		Stream<Car> sortedCars = sort(cars);
		decideWinner(sortedCars);
		return winnerToString();
	}


	private String winnerToString() {
		StringBuilder sb = new StringBuilder();
		for (Car winner : winners) {
			sb.append(winner.getCarName()).append(",");
		}

		return sb.deleteCharAt(sb.length() - 1).toString();
	}

	private Stream<Car> sort(Cars cars) {
		return cars.stream()
				   .sorted(Comparator.comparing(Car::getPosition));
	}

	private void decideWinner(Stream<Car> sortedCars) {

		FirstPlaceCar firstPlaceCar = FirstPlaceCar.init();

		sortedCars.takeWhile(car -> car.getPosition() >= firstPlaceCar.getPosition())
				  .forEach(car -> {
					  changeFirstPlace(firstPlaceCar, car);
				  });
	}

	private void changeFirstPlace(FirstPlaceCar firstPlaceCar, Car car) {
		if (firstPlaceCar.isPass(car.getPosition())) {
			winners.clear();
			winners.add(car);
			firstPlaceCar.changeFirstPlace(car);
		}

		if (firstPlaceCar.isOvertake(car.getPosition()) && firstPlaceCar.isDifferentCar(car.getCarName())) {
			winners.add(car);
		}
	}
}
