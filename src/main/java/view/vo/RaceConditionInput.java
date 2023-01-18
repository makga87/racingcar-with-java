package view.vo;

public class RaceConditionInput {

    private final int carCount;
    private final int tryCount;

    public static RaceConditionInput of(int carCount, int tryCount) {
        validate(carCount, tryCount);
        return new RaceConditionInput(carCount, tryCount);
    }

    private RaceConditionInput(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    private static void validate(int carCount, int tryCount) {
        if(carCount < 1) throw new IllegalArgumentException("잘못된 자동차 댓수 입력");
        if(tryCount < 1) throw new IllegalArgumentException("잘못된 시도 횟수 입력");
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
