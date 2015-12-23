package com.epam.junior.pokemonfight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epam.junior.pokemonfight.domain.KnockOutPokemonFight;

@Configuration
public class KnockOutPokemonFightConfig {

    @Bean
    public KnockOutPokemonFight knockOutPokemonFight() {
        return new KnockOutPokemonFight();
    }

}
