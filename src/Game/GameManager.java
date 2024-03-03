package Game;

public interface GameManager{
    // เริ่มเกม
    void startGame();

    // สลับตาไปยังผู้เล่นถัดไป
    void nextTurn();

    // ตรวจสอบว่าเกมจบหรือยัง
    void checkEndGame();

    // แสดงสถานะปัจจุบันของบริเวณในเกมและข้อมูลเกี่ยวกับผู้เล่น
    void displayGameBoard();

    // จบเกม
    void endGame();
}