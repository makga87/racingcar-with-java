package domain.vo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	@DisplayName("빈 자동차명을 입력하면 예외를 발생시킨다")
	@Test
	void validateEmptyNameTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			Car car = Car.from("");
		});
	}

	@DisplayName("자동차명이 5글자를 초과하면 예외를 발생시킨다")
	@Test
	void validateNameLengthOverTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			Car car = Car.from("abcdef");
		});
	}
}