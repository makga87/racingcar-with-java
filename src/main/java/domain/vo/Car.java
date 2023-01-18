package domain.vo;

public class Car {

    private String carName;
    private int poisition;

    public static Car of(String carName, int poisition) {
        return new Car(carName, poisition);
    }

    private Car(String carName, int poisition) {
        this.carName = carName;
        this.poisition = poisition;
    }

    public void move() {
        this.poisition++;
    }

    public int getPoisition() {
        return this.poisition;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Car copy() {
        return new Car(this.carName, this.poisition);
    }
}
