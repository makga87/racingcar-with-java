package view;


import domain.vo.Car;

public class MonitorView implements View<Car> {

    @Override
    public String render(Car car) {

        StringBuilder view = new StringBuilder();
        for (int n = 0; n < car.getPoisition(); n++) {
            view.append("-");
        }
        return view.toString();
    }
}
