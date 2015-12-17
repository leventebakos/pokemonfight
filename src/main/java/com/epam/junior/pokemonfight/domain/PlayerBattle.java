package com.epam.junior.pokemonfight.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerBattle {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerBattle.class);
	private static final int NUMBER_OF_POKEMONS = 6;
	
	private Player player1;
	private Player player2;
	
	public PlayerBattle(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public Player battle() {
		LOGGER.warn("****Match between {} and {}!!!", player1.getName(), player2.getName());
		Player winner;
		Player winnerOfFirstPokemonsClash = null;
		int player1Score = 0;
		int player2Score = 0;
		for (int i = 0; i < NUMBER_OF_POKEMONS; i++) {
			UniquePokemon player1CurrentPokemon = player1.getPokemons().get(i);
			UniquePokemon player2CurrentPokemon = player2.getPokemons().get(i);
			LOGGER.warn("********{} selects level {} {}, {} selects level {} {}:", 
					player1.getName(), player1CurrentPokemon.getLevel(), player1CurrentPokemon.getPokemon().getName(),
					player2.getName(), player2CurrentPokemon.getLevel(), player2CurrentPokemon.getPokemon().getName());
			UniquePokemon winningPokemon = player1CurrentPokemon.fight(player2CurrentPokemon);
			if (winningPokemon == player1CurrentPokemon) {
				player1Score++;
				if (winnerOfFirstPokemonsClash == null) {
					winnerOfFirstPokemonsClash = player1;
				}
			} else {
				player2Score++;
				if (winnerOfFirstPokemonsClash == null) {
					winnerOfFirstPokemonsClash = player2;
				}
			}
			LOGGER.warn("************The winner of this battle is: {}, the standing is: {}-{}: {}-{}!", 
					winningPokemon.getPokemon().getName(),
					player1.getName(), player2.getName(),
					player1Score, player2Score);
		}
		if (player1Score > player2Score) {
			winner = player1;
		} if (player1Score < player2Score) {
			winner = player2;
		} else {
			winner = winnerOfFirstPokemonsClash;
		}
		LOGGER.warn("****The winner of this match and advancing to the next round is {}!!!", winner.getName());
		return winner;
	}
}
