package domain;

public interface Race<R> {


    default void start(int raceTryCount) {
        for (int tryNo = 1; tryNo <= raceTryCount; tryNo++) {
            race(tryNo);
        }
    }

    void race(int tryNo);

    R getRaceStatus(int tryNo);

}
