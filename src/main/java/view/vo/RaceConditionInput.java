package view.vo;

public class RaceConditionInput {

	private final String carNames;
	private final int tryCount;

	public static RaceConditionInput of(String carNames, int tryCount) {
		validate(carNames, tryCount);
		return new RaceConditionInput(carNames, tryCount);
	}

	private RaceConditionInput(String carNames, int tryCount) {
		this.carNames = carNames;
		this.tryCount = tryCount;
	}

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
