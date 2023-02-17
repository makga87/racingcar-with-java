package view;


import java.util.Scanner;

import domain.CarRace;
import domain.strategy.CarRaceWinnerStrategy;
import domain.vo.Car;
import domain.vo.Cars;

public class View {

	private String carNames;
	private int tryCount;

	private static Scanner input = new Scanner(System.in);

	private View(String carNames, int tryCount) {
		this.carNames = carNames;
		this.tryCount = tryCount;
	}

	public String getCarNames() {
		return carNames;
	}

	public int getTryCount() {
		return tryCount;
	}

	public static View start() {
		String carNames = inputCarName();
		int tryCount = inputRaceTryCount();
		return new View(carNames, tryCount);
	}

	private static String inputCarName() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return input.nextLine();
	}

	private static int inputRaceTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		return input.nextInt();
	}


	public static void print(CarRace carRace) {
		Cars cars = carRace.getCars();

		printStatus(carRace.getCars());

		if (carRace.isEnd()) {
			printWinner(carRace.getWinners(CarRaceWinnerStrategy.from(cars)));
		}
	}

	private static void printStatus(Cars cars) {
		StringBuilder racingStatusView = new StringBuilder();
		cars.stream()
			.forEach(car -> {
				racingStatusView.append(createCarRaceView(car));
			});

		System.out.println(racingStatusView);
	}

	private static void printWinner(String winner) {
		System.out.println(winner + "가 최종 우승");
	}

	private static String createCarRaceView(Car car) {

		StringBuilder view = new StringBuilder();

		return view.append(car.getCarName())
				   .append(" : ")
				   .append(convertPositionToView(car.getPosition()))
				   .append(System.lineSeparator())
				   .toString();
	}

	private static String convertPositionToView(int position) {
		StringBuilder positionView = new StringBuilder();
		for (int n = 0; n < position; n++) {
			positionView.append("-");
		}
		return positionView.toString();
	}
}
