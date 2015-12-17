package com.epam.junior.pokemonfight.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayerBattle {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerBattle.class);
	private static final int NUMBER_OF_POKEMONS = 6;
	
	private Player player1;
	private Player player2;
	
	private Player winner;
	Player winnerOfFirstPokemonsClash;
	private int player1Score;
	private int player2Score;
	
	public PlayerBattle(Player player1, Player player2) {
		super();
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public Player battle() {
		LOGGER.warn("****Match between {} and {}!!!", player1.getName(), player2.getName());
		for (int i = 0; i < NUMBER_OF_POKEMONS; i++) {
			UniquePokemon player1Pokemon = player1.getPokemons().get(i);
			UniquePokemon player2Pokemon = player2.getPokemons().get(i);
			LOGGER.warn("********{} selects level {} {}, {} selects level {} {}:", 
					player1.getName(), player1Pokemon.getLevel(), player1Pokemon.getPokemon().getName(),
					player2.getName(), player2Pokemon.getLevel(), player2Pokemon.getPokemon().getName());
			UniquePokemon winningPokemon = player1Pokemon.fight(player2Pokemon);
			increaseWinnersScore(winningPokemon, player1Pokemon, player2Pokemon);
		}
		winner = determineWinner();
		LOGGER.warn("****The winner of this match and advancing to the next round is {}!!!", winner.getName());
		return winner;
	}

	private Player determineWinner() {
		Player ret;
		if (player1Score > player2Score) {
			ret = player1;
		} if (player1Score < player2Score) {
			ret = player2;
		} else {
			ret = winnerOfFirstPokemonsClash;
		}
		return ret;
	}

	private void increaseWinnersScore(UniquePokemon winningPokemon, UniquePokemon player1Pokemon, UniquePokemon player2Pokemon) {
		if (winningPokemon == player1Pokemon) {
			player1Score++;
			setWinnerOfFirstClash(player1);
		} else {
			player2Score++;
			setWinnerOfFirstClash(player2);
		}
		LOGGER.warn("************The winner of this battle is: {}, the standing is: {}-{}: {}-{}!", 
				winningPokemon.getPokemon().getName(),
				player1.getName(), player2.getName(),
				player1Score, player2Score);
	}

	private void setWinnerOfFirstClash(Player player) {
		if (winnerOfFirstPokemonsClash == null) {
			winnerOfFirstPokemonsClash = player;
		}
	}
}
