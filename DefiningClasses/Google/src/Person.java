import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;
    private Company company;
    private List<Map<String, String>> pokemonsNameType;
    private List<Map<String, String>> parentsNameBirthday;
    private List<Map<String, String>> childrenNameBirthday;
    private Map<String, String> carNameSpeed;

    public Person(String name) {
        this.name = name;
        this.pokemonsNameType = new ArrayList<>();
        this.parentsNameBirthday = new ArrayList<>();
        this.childrenNameBirthday = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Map<String, String>> getPokemonsNameType() {
        return this.pokemonsNameType;
    }

    public List<Map<String, String>> getParentsNameBirthday() {
        return this.parentsNameBirthday;
    }

    public List<Map<String, String>> getChildrenNameBirthday() {
        return this.childrenNameBirthday;
    }

    public void setCarNameSpeed(Map<String, String> carNameSpeed) {
        this.carNameSpeed = carNameSpeed;
    }

    private String getPairs(List<Map<String, String>> pairList) {
        StringBuilder sb = new StringBuilder();
        for (Map<String,String> pair : pairList) {
            pair.forEach((key, value) -> sb.append(key).append(" ").append(value).append(System.lineSeparator()));

        }

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company.toString()).append(System.lineSeparator());
        }

        sb.append("Car:").append(System.lineSeparator());
        if (this.carNameSpeed != null) {
            for (String s : carNameSpeed.keySet()) {
                for (String value : carNameSpeed.values()) {
                    sb.append(s).append(" ").append(value).append(System.lineSeparator());
                }

            }

        }

        sb.append("Pokemon:").append(System.lineSeparator());
        sb.append(getPairs(this.pokemonsNameType));

        sb.append("Parents:").append(System.lineSeparator());
        sb.append(getPairs(this.parentsNameBirthday));

        sb.append("Children:").append(System.lineSeparator());
        sb.append(getPairs(this.childrenNameBirthday));

        return sb.toString();
    }
}