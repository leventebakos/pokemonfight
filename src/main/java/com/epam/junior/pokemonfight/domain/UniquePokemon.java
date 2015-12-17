package com.epam.junior.pokemonfight.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public final class UniquePokemon {
	private static final Logger LOGGER = LoggerFactory.getLogger(UniquePokemon.class);
	
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
			if (Math.random() >= 0.5) {
				winner = this; 
			} else {
				winner = player2CurrentPokemon;
			}
		}
		
		return winner;
	}
}
