package Stevecv.Stevecv.GameTest.game;

import Stevecv.Stevecv.GameTest.Main;
import Stevecv.Stevecv.GameTest.tiles.Draw;

public class CheckCrash {
    public void checkCrash(int sX, int sY) {
        int x = Draw.snakesX.get(0);
        int y = Draw.snakesY.get(0);

        if(sX == x && sY == y) {
            new Main().resetGame();
        }
    }
}
