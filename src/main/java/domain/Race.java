package domain;

public interface Race {

    default void start(int raceTryCount) {

		if(raceTryCount < 1) throw new IllegalArgumentException("시도 횟수는 0이상이어야 합니다.");

		for (int count = 1; count <= raceTryCount; count++) {
            System.out.println("=======" + count + "회차 =======");
            race();
            monitor();
        }
    }

    void race();

    void monitor();
}
