package domain.vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("자동차 이동 시, 포지션 변경을 확인한다")
	@Test
	void carMoveTest() {
		Car car = new Car("", 0);
		car.move();
		assertEquals(1, car.getPoisition());

		car.move();
		assertEquals(2, car.getPoisition());

	}

}