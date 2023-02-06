package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    GameStore store = new GameStore();
    Game game1 = store.publishGame("Game 1", "Sandbox");
    Game game2 = store.publishGame("Game 2", "RPG");
    Game game3 = store.publishGame("Game 3", "Shooter");
    Game game4 = store.publishGame("Game 4", "Sandbox");
    Game game5 = store.publishGame("Game 5", "Shooter");
    Game game6 = store.publishGame("Game 6", "RPG");

    @Test
    public void shouldSumGenreIfOneGame() {

        Player player = new Player("Player 1");
        player.installGame(game1);
        player.play(game1, 3);

        int expected = 3;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfGamesSameGenre() {

        Player player = new Player("Player 2");
        player.installGame(game1);
        player.installGame(game4);
        player.play(game1, 3);
        player.play(game4, 5);

        int expected = 8;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfGameReplay() {

        Player player = new Player("Player 3");
        player.installGame(game1);
        player.play(game1, 3);
        player.play(game1, 5);

        int expected = 8;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSumGenreIfGamesDifferentGenre() {

        Player player = new Player("Player 4");
        player.installGame(game1);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game3, 5);

        int expected = 3;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowExceptionIfGameNotInstalled() {
        Player player = new Player("Player 4");

        assertThrows(RuntimeException.class, () -> {
            player.play(game6, 6);
        });
    }

    @Test
    public void shouldShowGamePlayedMost() {
        Player player = new Player("Player 5");
        player.installGame(game2);
        player.installGame(game6);
        player.play(game2, 10);
        player.play(game6, 13);

        Game expected = game6;
        Game actual = player.mostPlayerByGenre("RPG");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowGamePlayedMostIfDifferentGenre() {
        Player player = new Player("Player 6");
        player.installGame(game4);
        player.installGame(game6);
        player.play(game4, 18);
        player.play(game6, 13);

        Game expected = game6;
        Game actual = player.mostPlayerByGenre("RPG");

        assertEquals(expected, actual);
    }


    @Test
    public void shouldNotShowGamePlayedMost() {
        Player player = new Player("Player 6");
        player.installGame(game1);
        player.installGame(game4);
        player.play(game1, 10);
        player.play(game4, 18);


        Game expected = null;
        Game actual = player.mostPlayerByGenre("RPG");

        assertEquals(expected, actual);
    }
}