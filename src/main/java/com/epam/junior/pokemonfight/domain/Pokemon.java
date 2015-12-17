package com.epam.junior.pokemonfight.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Pokemon {
	
	CHARIZARD("Charizard", PokemonType.FIRE),
	MAGMAR("Magmar", PokemonType.FIRE),
	VULPIX("Vulpix", PokemonType.FIRE),
	BLASTOISE("Blastoise", PokemonType.WATER),
	PSYDUCK("Psyduck", PokemonType.WATER),
	LAPRAS("Lapras", PokemonType.WATER),
	PIKACHU("Pikachu", PokemonType.ELECTRIC),
	VOLTORB("Voltorb", PokemonType.ELECTRIC),
	MAGNEMITE("Megnemite", PokemonType.ELECTRIC),
	BULBASAUR("Bulbasaur", PokemonType.GRASS),
	GLOOM("Gloom", PokemonType.GRASS),
	EXEGGUTOR("Exeggutor", PokemonType.GRASS);
	
	private static final List<Pokemon> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();

	private String name;
	private PokemonType type;
	
	private Pokemon(String name, PokemonType type) {
		this.name = name;
		this.type = type;
	}

	public PokemonType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public static Pokemon getRandomPokemon() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
}
