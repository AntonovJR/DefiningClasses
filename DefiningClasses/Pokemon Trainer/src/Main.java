import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"Tournament".equals(input)) {

            String[] tokens = input.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>()));
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.get(trainerName).getPokemons().add(pokemon);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {

            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                if (entry.getValue().getPokemons().size() > 0) {
                    boolean havePokemon = false;
                    for (Pokemon pokemon : entry.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(input)) {
                            havePokemon = true;
                            entry.getValue().setNumOfBadges();
                            break;
                        }
                    }
                    if (!havePokemon) {
                        entry.getValue().missingPokemonPenalty();
                    }
                }
            }
            input = scanner.nextLine();
        }
        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumOfBadges(), b1.getValue().getNumOfBadges()))
                .forEach(t -> {
                    System.out.println(String.format("%s %s %s", t.getKey(),
                            t.getValue().getNumOfBadges(),
                            t.getValue().getPokemons().size()));
                });
    }
}