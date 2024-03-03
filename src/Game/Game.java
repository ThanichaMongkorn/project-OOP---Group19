package Game;

import Player.Player;
import java.util.List;

public class Game implements GameManager{
    private List<Player> players;
    private boolean gameOver;
    private Board gameBoard;

    public Game(List<Player> players, Board gameBoard) {
        this.players = players;
        this.gameBoard = gameBoard;
        this.gameOver = false;
    }

    @Override
    public void startGame() {

    }

    @Override
    public void nextTurn() {

    }

    @Override
    public void checkEndGame() {

    }

    @Override
    public void displayGameBoard() {

    }

    @Override
    public void endGame() {

    }
}
