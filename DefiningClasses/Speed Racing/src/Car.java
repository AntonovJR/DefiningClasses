public class Car {
    private String model;
    private double fuel;
    private double consumption;
    private int distance;

    public Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distance = 0;

    }

    public boolean drive(int kilometers) {
        double needFuel = kilometers*this.consumption;
        if(needFuel<=this.fuel){
            this.distance +=kilometers;
            this.fuel -=needFuel;
            return true;
        }else{
            return false;
        }

    }
    public String toString(){
        return String.format("%s %.2f %d", this.model,this.fuel, this.distance);
    }
}
