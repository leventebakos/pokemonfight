package com.epam.junior.pokemonfight.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.epam.pokemonfight")
@Import({UniquePokemonConfig.class, PlayerConfig.class, KnockOutPokemonFightConfig.class})
public class AppConfig {

}
