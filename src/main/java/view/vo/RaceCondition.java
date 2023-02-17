package view.vo;

import view.View;

public class RaceCondition {

	private final String carNames;
//	private int carCount;
	private final int tryCount;


//	private RaceCondition(int carCount, int tryCount) {
//		this.carCount = carCount;
//		this.carNames = "";
//		this.tryCount = tryCount;
//	}

	private RaceCondition(String carNames, int tryCount) {
		this.carNames = carNames;
//		this.carCount = carNames.split(",").length;
		this.tryCount = tryCount;
	}

	public static RaceCondition from(View view) {
		validate(view.getCarNames(), view.getTryCount());
		return new RaceCondition(view.getCarNames(), view.getTryCount());
	}

//	public static RaceCondition of(int carCount, int tryCount) {
//		validate(carCount, tryCount);
//		return new RaceCondition(carCount, tryCount);
//	}

	public static RaceCondition of(String carNames, int tryCount) {
		validate(carNames, tryCount);
		return new RaceCondition(carNames, tryCount);
	}

//	private static void validate(int carCount, int tryCount) {
//		if (carCount < 1) {
//			throw new IllegalArgumentException("잘못된 자동차 댓수 입력");
//		}
//		if (tryCount < 1) {
//			throw new IllegalArgumentException("잘못된 시도 횟수 입력");
//		}
//	}

	private static void validate(String carNames, int tryCount) {
		if (carNames.isEmpty()) {
			throw new IllegalArgumentException("잘못된 자동차 이름 입력");
		}
		if (tryCount < 1) {
			throw new IllegalArgumentException("잘못된 시도 횟수 입력");
		}
	}

	public String getCarNames() {
		return carNames;
	}

	public int getTryCount() {
		return tryCount;
	}
}
