package com.epam.junior.pokemonfight.domain;

import org.springframework.stereotype.Component;

@Component
public final class UniquePokemon {
    private static final double HALF = 0.5;
    private final Pokemon pokemon;
    private final int level;

    public UniquePokemon(final Pokemon pokemon, final int level) {
        super();
        this.pokemon = pokemon;
        this.level = level;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "UniquePokemon [pokemon=" + pokemon + ", level=" + level + "]";
    }

    public UniquePokemon fight(UniquePokemon player2CurrentPokemon) {
        int player2PokemonLevel = player2CurrentPokemon.getLevel();
        UniquePokemon winner;

        if (level > player2PokemonLevel) {
            winner = this;
        } else if (level < player2PokemonLevel) {
            winner = player2CurrentPokemon;
        } else {
            winner = selectWinnerBasedOnRandom(this, player2CurrentPokemon);
        }

        return winner;
    }

    private UniquePokemon selectWinnerBasedOnRandom(UniquePokemon player1Pokemon, UniquePokemon player2Pokemon) {
        UniquePokemon ret;
        if (Math.random() >= HALF) {
            ret = player1Pokemon;
        } else {
            ret = player2Pokemon;
        }
        return ret;
    }
}
