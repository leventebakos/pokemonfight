package com.epam.junior.pokemonfight;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epam.junior.pokemonfight.config.AppConfig;
import com.epam.junior.pokemonfight.domain.PokemonFight;

public class App {
    public static void main(String[] args) {
        new App().start();
    }

    private void start() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            PokemonFight pokemonFight = context.getBean(PokemonFight.class);
            pokemonFight.startChampionship();
        }
    }
}
