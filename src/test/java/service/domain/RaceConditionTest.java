package service.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RaceConditionTest {

    @DisplayName("자동차 전진 여부 메서드 테스트를 진행한다")
    @Test
    void advanceConditionTest(){
        int moveCondition = 4;
        RaceCondition raceCondition = RaceCondition.of(0, moveCondition);
        Random random = new Random();
        int randomValue = random.nextInt(10);

        assertEquals(randomValue >= moveCondition, raceCondition.isAdvanceCondition(randomValue));

    }
}