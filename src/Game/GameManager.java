package Game;

public interface GameManager{
    void startGame();
    void nextTurn();
    void isDead();//checkว่าเสียเมืองหลวงไปหรือยัง
    void endGame();
}