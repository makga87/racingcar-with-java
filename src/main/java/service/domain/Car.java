package service.domain;

public class Car {

    private String carName;
    private int poisition;

    public Car(String carName, int poisition) {
        this.carName = carName;
        this.poisition = poisition;
    }

    public void move() {
        this.poisition++;
    }

    public int getPoisition() {
        return this.poisition;
    }
}
