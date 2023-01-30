package view;


import domain.vo.Cars;

public class CarRaceResultView {

	public void printResult(int no, Cars cars) {
		StringBuilder view = new StringBuilder();

		view.append("======== ").append(no).append("회차").append(" ========").append(System.lineSeparator());
		cars.stream().forEach(car -> {
			view.append(convertPositionToView(car.getPoisition())).append(System.lineSeparator());
		});
		System.out.println(view);
	}

	private String convertPositionToView(int position) {
		StringBuilder positionView = new StringBuilder();
		for (int n = 0; n < position; n++) {
			positionView.append("-");
		}
		return positionView.toString();
	}
}
