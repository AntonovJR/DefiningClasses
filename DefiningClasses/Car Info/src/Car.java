import java.util.ArrayList;

public class Car {

    private String brand;
    private String model;
    private int horsePower;


    public Car(String brand, String model, int horsePower) {
        this(brand, model);
        this.horsePower = horsePower;

    }

    public Car(String brand, String model) {
        this(brand);
        this.model = model;
    }

    public Car(String brand) {
        this.brand = brand;
    }


    private int verifyHorsePowerNotLessThanOne(int horsePower) {
        return Math.max(horsePower, 0);
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void increaseHP(int horsePower) {
        this.horsePower += verifyHorsePowerNotLessThanOne(horsePower);
    }


    public String printCar(Car car) {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(),
                this.getModel() != null ? this.getModel() : "unknown",
                car.getHorsePower() != 0 ? this.getHorsePower() : -1);
    }

}
