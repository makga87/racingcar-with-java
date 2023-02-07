package domain.vo;

import java.util.List;
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

	public Stream<Car> stream() {
		return cars.stream();
	}

	public void move(MoveStrategy moveStrategy) {
		for (Car car : cars) {
			car.move(moveStrategy);
		}
	}
}
