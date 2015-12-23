package com.epam.junior.pokemonfight.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KnockOutPokemonFight implements PokemonFight {
    private static final Logger LOGGER = LoggerFactory.getLogger(KnockOutPokemonFight.class);

    @Resource(name = "allPlayers")
    private List<Player> players;

    private List<Player> remainingPlayers = new ArrayList<>();
    private List<Player> winningPlayers = new ArrayList<>();
    private Random random = new Random();

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void startChampionship() {
        remainingPlayers.addAll(players);
        LOGGER.warn("Pokemon championship is starting with {} players!!!", players.size());
        while (remainingPlayers.size() != 1) {
            Player player1 = getRandomPlayer();
            Player player2 = getRandomPlayer();
            PlayerBattle playerBattle = new PlayerBattle(player1, player2);
            Player winner = playerBattle.battle();
            winningPlayers.add(winner);
            addWinningPlayersIfEverybodyFighted();
        }
        LOGGER.warn("The champion is: {}! Congratulations!!!", remainingPlayers.get(0).getName());
    }

    private Player getRandomPlayer() {
        int index = random.nextInt(remainingPlayers.size());
        return remainingPlayers.remove(index);
    }

    private void addWinningPlayersIfEverybodyFighted() {
        if (remainingPlayers.isEmpty()) {
            remainingPlayers.addAll(winningPlayers);
            winningPlayers.clear();
        }
    }

}
