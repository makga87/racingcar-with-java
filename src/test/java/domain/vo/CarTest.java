package domain.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.CarRaceDifficulty;

class CarTest {

	@DisplayName("자동차 이동에 대한 랜덤 값이 0보다 작은 경우 예외를 발생시킨다")
	@CsvSource({"0", "-1"})
	@ParameterizedTest
	void carMoveErrorTest(int randomValue) {

		Car car = Car.of("", 0);
		CarRaceDifficulty carDifficulty = CarRaceDifficulty.NORMAL;

		String message = assertThrows(IllegalArgumentException.class, ()->{
			car.move(carDifficulty, randomValue);
		}).getMessage();

		assertEquals("Bad random value input", message);
	}

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