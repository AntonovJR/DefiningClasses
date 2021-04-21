import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Trainer {
    private String trainerName;
    private int numOfBadges;
    private List<Pokemon> pokemons;

    public void setNumOfBadges() {
        this.numOfBadges++;
    }
    public int getNumOfBadges() {
        return numOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
    public Trainer(String trainerName, List<Pokemon> pokemons) {
        this.trainerName = trainerName;
        this.pokemons = new ArrayList<>();
    }

    private UnaryOperator<Pokemon> damagePokemon = pokemon ->
            new Pokemon(pokemon.getName(), pokemon.getElement(), pokemon.getHealth() - 10);

    public void missingPokemonPenalty() {
        this.pokemons = this.pokemons
                .stream()
                .map(damagePokemon)
                .filter(pokemon -> pokemon.getHealth() > 0)
                .collect(Collectors.toList());
    }

   }