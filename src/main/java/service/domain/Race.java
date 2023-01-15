package service.domain;

public interface Race {

    default void start(int raceTryCount) {
        for (int count = 0; count < raceTryCount; count++) {
            System.out.println("=======" + count + "회차 =======");
            race();
            monitor();
        }
    }

    void race();

    void monitor();
}
