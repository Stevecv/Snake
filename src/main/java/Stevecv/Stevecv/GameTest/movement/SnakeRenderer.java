package Stevecv.Stevecv.GameTest.movement;

import Stevecv.Stevecv.GameTest.game.Wall;
import Stevecv.Stevecv.GameTest.tiles.Draw;
import com.raylib.java.Raylib;

import java.util.ArrayList;

public class SnakeRenderer {
    public static ArrayList<Integer> snakeHistoryX = new ArrayList<Integer>() {};
    public static ArrayList<Integer> snakeHistoryY = new ArrayList<Integer>() {};

    public void renderSnake(Raylib rlj) {
        String direction = KeyPress.SANKE_DIR;

        if (direction.equals("right")) {
            Draw.snakesX.set(0, Draw.snakesX.get(0) + 1);
        }
        if (direction.equals("left")) {
            Draw.snakesX.set(0, Draw.snakesX.get(0) - 1);
        }
        if (direction.equals("up")) {
            Draw.snakesY.set(0, Draw.snakesY.get(0) - 1);
        }
        if (direction.equals("down")) {
            Draw.snakesY.set(0, Draw.snakesY.get(0) + 1);
        }

        new Wall().checkCrashWall(Draw.snakesX.get(0), Draw.snakesY.get(0));

        snakeHistoryX.add(Draw.snakesX.get(0));
        snakeHistoryY.add(Draw.snakesY.get(0));

        if(snakeHistoryX.size() > 256) {
            snakeHistoryX.remove(0);
            snakeHistoryY.remove(0);
        }
    }
}
