package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.vo.Car;

class CarRaceTest {

	@DisplayName("입력한 자동차 댓수 만큼 Car객체 생성")
	@Test
	void carCountAfterStartTest() {
		CarRace carRace = CarRace.readyForRace(3, CarRaceDifficulty.NORMAL);
		carRace.start(1);

		Stream<Car> cars = carRace.getRaceStatus(1);
		assertEquals(3, cars.toList().size());
	}

}