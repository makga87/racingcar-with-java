package domain.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Cars {

	private List<Car> cars;

	public static Cars from(List<Car> cars) {
		return new Cars(cars);
	}

	public static Cars createInstance() {
		return new Cars();
	}

	private Cars() {
		this.cars = new ArrayList<>();
	}

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public Car getCar(int index) {
		return this.cars.get(index);
	}

	public Stream<Car> stream() {
		return cars.stream();
	}

	public void addCar(Car car) {
		this.cars.add(car);
	}

	public void removeCar(int index) {
		this.cars.remove(index);
	}
}
