package domain;

import domain.vo.Car;
import view.CarRaceResultView;
import view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class CarRace implements Race<Stream<Car>> {

    private List<Car> cars = new ArrayList<>();
    private final CarRaceDifficulty carRaceDifficulty;

    public static CarRace readyForRace(int carCount, CarRaceDifficulty carRaceDifficulty) {
        List<Car> newCars = createNewRacingCar(carCount);
        return new CarRace(newCars, carRaceDifficulty);
    }

    private CarRace(List<Car> cars, CarRaceDifficulty carRaceDifficulty) {
        this.cars = cars;
        this.carRaceDifficulty = carRaceDifficulty;
    }

    private static List<Car> createNewRacingCar(int carCount) {
        List<Car> newCars = new ArrayList<>();
        for (int cnt = 0; cnt < carCount; cnt++) {
            newCars.add(new Car("", 0));
        }
        return newCars;
    }

    @Override
    public void race() {
        cars.forEach(car -> {
            Random random = new Random();
            if (carRaceDifficulty.isMoveOk(random.nextInt(10))) car.move();
        });
    }


    @Override
    public Stream<Car> getRaceResult() {
        return cars.stream();
    }
}
