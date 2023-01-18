package view;


import java.util.stream.Stream;

import domain.vo.Car;

public class CarRaceResultView implements View<String> {

	private Stream<Car> cars;
	private int tryNo;

	public static CarRaceResultView of(Stream<Car> cars, int tryNo) {
		return new CarRaceResultView(cars, tryNo);
	}

	private CarRaceResultView(Stream<Car> cars, int tryNo) {
		this.cars = cars;
		this.tryNo = tryNo;
	}

	@Override
	public String render() {
		StringBuilder view = new StringBuilder();
		view.append("======== ").append(tryNo).append("회차").append(" ========").append(System.lineSeparator());
		cars.forEach(car -> {
			view.append(convertPositionToView(car.getPoisition())).append(System.lineSeparator());
		});
		System.out.println(view);
		return view.toString();
	}

	private String convertPositionToView(int position) {
		StringBuilder positionView = new StringBuilder();
		for (int n = 0; n < position; n++) {
			positionView.append("-");
		}
		return positionView.toString();
	}
}
