package domain.strategy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.CarRaceDifficulty;

class CarMoveStrategyTest {


	@ParameterizedTest
	@CsvSource({
			"1, false",
			"2, false",
			"3, false",
			"4, true",
			"5, true",
	})
	void movableTest(int randomValue, boolean expectedValue) {
		CarMoveStrategy carMoveStrategy = CarMoveStrategy.from(CarRaceDifficulty.NORMAL);
		boolean actualValue = carMoveStrategy.movable(randomValue);

		Assertions.assertEquals(expectedValue, actualValue);
	}
}