package application.service;

import domain.CarRace;
import domain.CarRaceDifficulty;
import domain.vo.Car;
import view.CarRaceResultView;
import view.CarRaceStartView;
import view.RaceConditionInput;
import view.View;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CarRaceService {

    public static void main(String[] args) {

        CarRaceStartView carRaceStartView = new CarRaceStartView();
        RaceConditionInput raceConditionInput = carRaceStartView.render();

        CarRace race = CarRace.readyForRace(raceConditionInput.getCarCount(), CarRaceDifficulty.NORMAL);

        race.start(raceConditionInput.getTryCount());

        Stream<Car> cars = race.getRaceResult();

        View carRaceResultView = CarRaceResultView.from(cars);
        carRaceResultView.render();
    }
}
