package application.service;

import domain.CarRace;
import domain.CarRaceDifficulty;
import view.CarRaceResultView;
import view.CarRaceStartView;
import view.vo.RaceConditionInput;

public class CarRaceService {

	public static void main(String[] args) {

		CarRaceStartView carRaceStartView = new CarRaceStartView();
		RaceConditionInput raceConditionInput = RaceConditionInput.of(carRaceStartView.inputCarCount(), carRaceStartView.inputRaceTryCount());

		CarRace race = CarRace.readyForRace(raceConditionInput.getCarCount(), CarRaceDifficulty.NORMAL);

		CarRaceResultView resultView = new CarRaceResultView();

		for (int no = 1; no <= raceConditionInput.getTryCount(); no++) {
			race.race();
			resultView.printResult(no, race.getCars());
		}
	}
}
