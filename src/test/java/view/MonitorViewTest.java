package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import service.domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class MonitorViewTest {

    @DisplayName("레이싱카의 현재 위치 값을 지정한 값으로 렌더링 하는 것을 확인한다")
    @ParameterizedTest
    @CsvSource({
            "1, -",
            "2, --",
            "3, ---"
    })
    void monitorViewTest(int carPosition, String expected) {

        Car car = new Car("", carPosition);
        MonitorView monitorView = new MonitorView();
        String actual = monitorView.render(car);

        assertEquals(expected, actual.trim());

    }
}