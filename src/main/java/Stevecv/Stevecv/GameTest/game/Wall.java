package Stevecv.Stevecv.GameTest.game;

import Stevecv.Stevecv.GameTest.Main;

public class Wall {
    public void checkCrashWall(int x, int y) {
        System.out.println(x + ", " + y);
        if (x > 11 || y > 11 || x < 0 || y < 0) {
            new Main().resetGame();
        }
    }
}
