package com.epam.junior.pokemonfight.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class KnockOutPokemonFightAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(KnockOutPokemonFightAspect.class);

    @Before("execution(* com.epam.junior.pokemonfight.domain.KnockOutPokemonFight.startChampionship(..))")
    public void logStartOfChampionship() {
        LOGGER.warn("Pokemon championship is starting with {} players!!!");
    }
}
