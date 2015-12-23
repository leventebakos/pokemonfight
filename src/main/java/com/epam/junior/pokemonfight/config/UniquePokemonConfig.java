package com.epam.junior.pokemonfight.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epam.junior.pokemonfight.domain.Pokemon;
import com.epam.junior.pokemonfight.domain.UniquePokemon;

@Configuration
public class UniquePokemonConfig {

    private static final int LEVEL_RANGE = 31;
    private static final int MINIMUM_LEVEL = 50;
    private Random random = new Random();

    @Bean
    @Scope("prototype")
    public UniquePokemon getUniquePokemon() {
        Pokemon pokemon = Pokemon.getRandomPokemon();
        int level = random.nextInt(LEVEL_RANGE) + MINIMUM_LEVEL;
        return new UniquePokemon(pokemon, level);
    }
}
