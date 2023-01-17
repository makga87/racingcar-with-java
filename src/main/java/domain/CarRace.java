package domain;

import domain.vo.RaceCondition;
import view.MonitorView;
import view.View;

import java.util.Random;

public class CarRace implements Race {

    private RaceCondition raceCondition;

    public CarRace(RaceCondition raceCondition) {
        this.raceCondition = raceCondition;
    }

    @Override
    public void race() {
        raceCondition.getCarList().forEach(car -> {
            Random random = new Random();
            if (raceCondition.isAdvanceCondition(random.nextInt(10))) car.move();
        });
    }

    @Override
    public void monitor() {
        raceCondition.getCarList().forEach(car -> {
            View view = new MonitorView();
            String result = view.render(car);
            System.out.println(result);
        });
    }
}
