
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");

            String personName = tokens[0];
            if (!people.containsKey(personName)) {
                Person person = new Person(personName);
                people.put(personName, person);
            }

            if ("company".equals(tokens[1])) {
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);

                Company currentCompany = new Company(companyName, department, salary);
                people.get(personName).setCompany(currentCompany);
            } else if ("pokemon".equals(tokens[1])) {
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];

                Map<String, String> currentPokemonNameType = new LinkedHashMap<>();
                currentPokemonNameType.put(pokemonName,pokemonType);
                people.get(personName).getPokemonsNameType().add(currentPokemonNameType);
            } else if ("parents".equals(tokens[1])) {
                String parentName = tokens[2];
                String parentBirthday = tokens[3];
                Map<String, String> currentParent = new LinkedHashMap<>();
                currentParent.put(parentName,parentBirthday);
                people.get(personName).getParentsNameBirthday().add(currentParent);
            } else if ("children".equals(tokens[1])) {
                String childName = tokens[2];
                String childBirthday = tokens[3];

                Map<String, String> currentChild = new LinkedHashMap<>();
                currentChild.put(childName,childBirthday);
                people.get(personName).getChildrenNameBirthday().add(currentChild);
            } else if ("car".equals(tokens[1])) {
                String carModel = tokens[2];
                String carSpeed = tokens[3];

                Map<String, String> carModelSpeed = new LinkedHashMap<>();
                carModelSpeed.put(carModel, carSpeed);
                people.get(personName).setCarNameSpeed(carModelSpeed);
            }
            input = scanner.nextLine();
        }

        String printInfoOnThisPerson = scanner.nextLine();


        System.out.println(people.get(printInfoOnThisPerson));
    }
}