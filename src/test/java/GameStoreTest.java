package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAFindMost() {
        GameStore store = new GameStore();

        store.addPlayTime("Даша246", 10);
        store.addPlayTime("Никита386", 12);
        store.addPlayTime("Света566", 8);

        String expected = ("Никита386");
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDoubleOne() {
        GameStore store = new GameStore();

        store.addPlayTime("Даша246", 6);
        store.addPlayTime("Даша246", 8);

        int expected = (14);
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMostWithTwo() {
        GameStore store = new GameStore();


        store.addPlayTime("Никита386", 12);
        store.addPlayTime("Илья346", 12);
        store.addPlayTime("Даша246", 10);
        store.addPlayTime("Света566", 8);

        String expected = ("Никита386");
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCountTimeWithOne() {
        GameStore store = new GameStore();


        store.addPlayTime("Володя545", 1);

        int expected = (1);
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }
    @Test
    public void shouldAFindMostWithNone() {
        GameStore store = new GameStore();

        store.addPlayTime("Даша246", 0);
        store.addPlayTime("Никита386", 0);

        String expected = (null);
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldAFindMostWithNull() {
        GameStore store = new GameStore();

        String expected = null;
        String actual = store.getMostPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSum() {
        GameStore store = new GameStore();

        store.addPlayTime("Даша246", 10);
        store.addPlayTime("Никита386", 12);
        store.addPlayTime("Илья346", 12);
        store.addPlayTime("Света566", 8);

        int expected = (42);
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);
    }
}