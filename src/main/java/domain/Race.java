package domain;

import java.util.HashMap;
import java.util.Map;

public interface Race<R> {


    default void start(int raceTryCount) {
        for (int count = 1; count <= raceTryCount; count++) {
            race();
        }
    }

    void race();

    R getRaceResult();


}
