package view;


import domain.vo.Car;

import java.util.stream.Stream;

public class CarRaceResultView implements View<String> {

    private Stream<Car> cars;

    public static CarRaceResultView from(Stream<Car> cars) {
        return new CarRaceResultView(cars);
    }

    private CarRaceResultView(Stream<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String render() {
        StringBuilder view = new StringBuilder();
        cars.forEach(car -> {
            view.append(convertPositionToView(car.getPoisition())).append(System.lineSeparator());
        });
        return view.toString();
    }

    private String convertPositionToView(int position) {
        StringBuilder positionView = new StringBuilder();
        for (int n = 0; n < position; n++) {
            positionView.append("-");
        }
        return positionView.toString();
    }
}
