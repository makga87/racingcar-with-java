package view;


import java.util.Scanner;

public class CarRaceStartView {

	private static Scanner input = new Scanner(System.in);

	public int inputCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		return input.nextInt();
	}

	public int inputRaceTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");

		return input.nextInt();
	}
}
