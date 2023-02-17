package domain.vo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.strategy.MoveStrategy;

public class Cars {

	private List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars from(List<Car> cars) {
		return new Cars(cars);
	}

	public static Cars from(String carNames) {

		String[] carNameArray = carNames.split(",");

		return new Cars(Stream.of(carNameArray)
							  .map(Car::from)
							  .collect(Collectors.toList()));
	}

	public Stream<Car> stream() {
		return cars.stream();
	}

	public void move(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}
}
