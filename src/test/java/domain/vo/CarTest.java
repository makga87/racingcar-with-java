package domain.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import domain.CarRaceDifficulty;

class CarTest {

	@RepeatedTest(10)
	@DisplayName("자동차 이동 시, 포지션 변경을 확인한다")
	void carMoveTest() {

		int expected = 0;

		Car car = Car.of("", 0);
		CarRaceDifficulty carDifficulty = CarRaceDifficulty.NORMAL;
		Random random = new Random();

		int randomValue = random.nextInt(carDifficulty.getRandomRange());
		car.move(carDifficulty, randomValue);

		if (carDifficulty.getMoveCondition() <= randomValue) {
			expected++;
		}

		assertEquals(expected, car.getPoisition());
	}
}