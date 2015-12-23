package com.epam.junior.pokemonfight.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.junior.pokemonfight.domain.Player;
import com.epam.junior.pokemonfight.domain.UniquePokemon;

@Configuration
public class PlayerConfig {

    private static final int NUMBER_OF_POKEMONS = 6;
    @Autowired
    UniquePokemonConfig pokemonConfig;

    @Bean
    public List<Player> allPlayers() {
        return Arrays.asList(ash(), misty(), brock(), gary(), jessie(), james(), tsubasa(), songoku());
    }

    @Bean
    public Player ash() {
        List<UniquePokemon> pokemons = getUniquePokemons(NUMBER_OF_POKEMONS);
        return new Player("Ash", pokemons);
    }

    @Bean
    public Player misty() {
        List<UniquePokemon> pokemons = getUniquePokemons(NUMBER_OF_POKEMONS);
        return new Player("Misty", pokemons);
    }

    @Bean
    public Player brock() {
        List<UniquePokemon> pokemons = getUniquePokemons(NUMBER_OF_POKEMONS);
        return new Player("Brock", pokemons);
    }

    @Bean
    public Player gary() {
        List<UniquePokemon> pokemons = getUniquePokemons(NUMBER_OF_POKEMONS);
        return new Player("Gary", pokemons);
    }

    @Bean
    public Player jessie() {
        List<UniquePokemon> pokemons = getUniquePokemons(NUMBER_OF_POKEMONS);
        return new Player("Team Rocket Jessie", pokemons);
    }

    @Bean
    public Player james() {
        List<UniquePokemon> pokemons = getUniquePokemons(NUMBER_OF_POKEMONS);
        return new Player("Team Rocket James", pokemons);
    }

    @Bean
    public Player tsubasa() {
        List<UniquePokemon> pokemons = getUniquePokemons(NUMBER_OF_POKEMONS);
        return new Player("Captain Tsubasa", pokemons);
    }

    @Bean
    public Player songoku() {
        List<UniquePokemon> pokemons = getUniquePokemons(NUMBER_OF_POKEMONS);
        return new Player("Son Goku", pokemons);
    }

    private List<UniquePokemon> getUniquePokemons(int numberOfPokemons) {
        List<UniquePokemon> pokemons = new ArrayList<>();
        for (int i = 0; i < numberOfPokemons; i++) {
            pokemons.add(pokemonConfig.getUniquePokemon());
        }
        return pokemons;
    }

}
