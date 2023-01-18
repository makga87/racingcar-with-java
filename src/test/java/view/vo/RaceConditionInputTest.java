package view.vo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RaceConditionInputTest {

	@DisplayName("자동차 댓수가 1미만 경우 에러가 발생한다")
	@Test
	void carCountFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			RaceConditionInput.of(0, 1);
		});
	}

	@DisplayName("자동차 댓수가 1이상인 경우 정상 동작한다")
	@Test
	void carCountSuccess() {
		assertDoesNotThrow(() -> {
			RaceConditionInput raceConditionInput = RaceConditionInput.of(1, 1);
		});
	}

	@DisplayName("시도 횟수가 1미만 경우 에러가 발생한다")
	@Test
	void tryCountFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			RaceConditionInput.of(1, 0);
		});
	}

	@DisplayName("시도 횟수가 1이상인 경우 정상 동작한다")
	@Test
	void tryCountSuccess() {
		assertDoesNotThrow(() -> {
			RaceConditionInput raceConditionInput = RaceConditionInput.of(1, 1);
		});
	}
}