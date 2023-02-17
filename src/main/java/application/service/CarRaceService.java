package application.service;

import domain.CarRace;
import domain.CarRaceDifficulty;
import view.View;
import view.vo.RaceCondition;

public class CarRaceService {

	public static void main(String[] args) {

		View view = View.start();
		RaceCondition raceCondition = RaceCondition.from(view);

		CarRace race = CarRace.readyForRace(raceCondition, CarRaceDifficulty.NORMAL);

		while (race.getNo() <= race.getTryCount()) {
			race.race();
			View.print(race);
			race.countNo();
		}
	}
}
