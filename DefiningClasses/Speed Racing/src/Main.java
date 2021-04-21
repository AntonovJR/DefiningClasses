import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String,Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int fuel = Integer.parseInt(tokens[1]);
            double fuelCostFor1km = Double.parseDouble(tokens[2]);
            Car car = new Car(model,fuel,fuelCostFor1km);
            cars.put(model, car);

        }
        String input = scanner.nextLine();
        while(!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            if(tokens[0].equals("Drive")){
                String model = tokens[1];
                int kilometers = Integer.parseInt(tokens[2]);
                Car carToDrive = cars.get(model);
                if(!carToDrive.drive(kilometers)){
                    System.out.println("Insufficient fuel for the drive");
                }


            }
            input = scanner.nextLine();
        }

        for (Car car: cars.values()){
            System.out.println(car.toString());

        }
    }
}
