package domain.vo;

public class FirstPlaceCar {

	private Car car;

	private FirstPlaceCar() {
	}

	public static FirstPlaceCar init() {
		return new FirstPlaceCar();
	}

	public void changeFirstPlace(Car car) {
		this.car = car;
	}

	public String getName() {
		return this.car.getCarName();
	}

	public int getPosition() {
		if (this.car == null) {
			return 0;
		}
		return this.car.getPosition();
	}

	public boolean isPass(int carPosition) {
		if (this.car == null) {
			return true;
		}
		return this.car.getPosition() < carPosition;
	}

	public boolean isOvertake(int carPosition) {
		return this.car.getPosition() == carPosition;
	}

	public boolean isSameCar(String carName) {
		return this.car.getCarName().equals(carName);
	}

	public boolean isDifferentCar(String carName) {
		return !isSameCar(carName);
	}
}
