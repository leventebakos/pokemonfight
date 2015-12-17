package com.epam.junior.pokemonfight.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public final class Player {
	
	private final String name;
	private final List<UniquePokemon> pokemons;
	
	public Player(final String name, final List<UniquePokemon> pokemons) {
		super();
		this.name = name;
		this.pokemons = Collections.unmodifiableList(pokemons);
	}
	
	public String getName() {
		return name;
	}
	
	public List<UniquePokemon> getPokemons() {
		return deepCopy();
	}

	private List<UniquePokemon> deepCopy() {
		List<UniquePokemon> ret = new ArrayList<>();
		for (UniquePokemon poke : pokemons) {
			ret.add(poke);
		}
		return ret;
	}
	
}
