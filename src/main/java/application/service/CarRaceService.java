package application.service;

import domain.CarRace;
import domain.CarRaceDifficulty;
import domain.strategy.CarRaceWinnerStrategy;
import view.CarRaceResultView;
import view.CarRaceStartView;
import view.vo.RaceConditionInput;

public class CarRaceService {

	public static void main(String[] args) {

		CarRaceStartView carRaceStartView = new CarRaceStartView();

		RaceConditionInput raceConditionInput = RaceConditionInput.of(carRaceStartView.inputCarName(), carRaceStartView.inputRaceTryCount());

		String carNames = raceConditionInput.getCarNames();
		int tryCount = raceConditionInput.getTryCount();

		CarRace race = CarRace.readyForRace(carNames, CarRaceDifficulty.NORMAL);

		CarRaceResultView resultView = new CarRaceResultView();

		for (int no = 1; no <= tryCount; no++) {
			race.race();
			resultView.printRaceStatus(no, race.getCars());
		}

		resultView.printRaceWinner(race.getWinners(CarRaceWinnerStrategy.from(race.getCars())));

	}
}
