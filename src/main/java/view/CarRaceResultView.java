package view;


import domain.vo.Car;
import domain.vo.Cars;

public class CarRaceResultView {

	public void printRaceStatus(int no, Cars cars) {

		StringBuilder view = new StringBuilder();

		view.append("======== ")
			.append(no).append("회차")
			.append(" ========")
			.append(System.lineSeparator());

		cars.stream()
			.forEach(car -> {
				view.append(createCarRaceView(car));
			});
		System.out.println(view);


	}

	public void printRaceWinner(String winner) {
		System.out.println(winner + "가 최종 우승");
	}

	private String createCarRaceView(Car car) {

		StringBuilder view = new StringBuilder();

		return view.append(car.getCarName())
				   .append(" : ")
				   .append(convertPositionToView(car.getPosition()))
				   .append(System.lineSeparator())
				   .toString();
	}

	private String convertPositionToView(int position) {
		StringBuilder positionView = new StringBuilder();
		for (int n = 0; n < position; n++) {
			positionView.append("-");
		}
		return positionView.toString();
	}
}
