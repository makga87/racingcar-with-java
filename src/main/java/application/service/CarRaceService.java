package application.service;

import java.util.stream.Stream;

import domain.CarRace;
import domain.CarRaceDifficulty;
import domain.vo.Car;
import view.CarRaceResultView;
import view.CarRaceStartView;
import view.View;
import view.vo.RaceConditionInput;

public class CarRaceService {

	public static void main(String[] args) {

		CarRaceStartView carRaceStartView = new CarRaceStartView();
		RaceConditionInput raceConditionInput = carRaceStartView.render();

		CarRace race = CarRace.readyForRace(raceConditionInput.getCarCount(), CarRaceDifficulty.NORMAL);

		race.start(raceConditionInput.getTryCount());

		for (int tryNo = 1; tryNo <= raceConditionInput.getTryCount(); tryNo++) {
			Stream<Car> cars = race.getRaceStatus(tryNo);
			View carRaceResultView = CarRaceResultView.of(cars, tryNo);
			carRaceResultView.render();
		}
	}
}
