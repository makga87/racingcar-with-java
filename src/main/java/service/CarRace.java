package service;

import service.domain.RaceCondition;
import view.MonitorView;
import view.View;

public class CarRace implements Race {

    private RaceCondition raceCondition;

    public CarRace(RaceCondition raceCondition) {
        this.raceCondition = raceCondition;
    }

    @Override
    public void race() {
        raceCondition.getCarList().forEach(car -> {
            if (raceCondition.isAdvanceCondition()) car.move();
        });
    }

    @Override
    public void monitor() {
        raceCondition.getCarList().forEach(car -> {
            View view = new MonitorView();
            String result = view.render(car);
            System.out.println(result);
            System.out.println();
        });
    }
}
