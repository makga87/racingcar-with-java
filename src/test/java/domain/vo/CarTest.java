package domain.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.CarRaceDifficulty;

class CarTest {

	@DisplayName("자동차 이동 시, 포지션 변경을 확인한다")
	@Test
	void carMoveTest() {
		Car car = Car.of("", 0);
		car.move(CarRaceDifficulty.NORMAL);
		assertEquals(1, car.getPoisition());

		car.move(CarRaceDifficulty.NORMAL);
		assertEquals(2, car.getPoisition());

	}

}