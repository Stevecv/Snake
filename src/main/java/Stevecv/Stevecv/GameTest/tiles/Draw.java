package Stevecv.Stevecv.GameTest.tiles;

import Stevecv.Stevecv.GameTest.game.CheckCrash;
import Stevecv.Stevecv.GameTest.game.GetApple;
import Stevecv.Stevecv.GameTest.movement.SnakeRenderer;
import com.raylib.java.Raylib;

import java.util.ArrayList;

public class Draw {
    public static int[] apple = {9, 6};
    public static ArrayList<Integer> snakesX = new ArrayList();
    public static ArrayList<Integer> snakesY = new ArrayList();

    public static int snakeLength = 1;

    public void loadSnake() {
        snakesX.add(4);
        snakesY.add(6);

        SnakeRenderer.snakeHistoryX.add(4);
        SnakeRenderer.snakeHistoryY.add(6);
    }

    public void drawGame(Raylib rlj) {
        for(int y = 0; y < 16; y++) {
            for(int x = 0; x < 16; x++) {
                int tile = 0;

                //Render the apple
                if(x == apple[0] && y == apple[1]) {
                    tile = 1;
                }

                //Render the snake
                if (snakesX.get(0) == x && snakesY.get(0) == y) {
                    tile = 2;
                }

                for(int s = 0; s < snakeLength; s++) {
                    SnakeRenderer snakeRenderer = new SnakeRenderer();

                    int sX = snakeRenderer.snakeHistoryX.get(snakeRenderer.snakeHistoryX.size() - s - 1);
                    int sY = snakeRenderer.snakeHistoryY.get(snakeRenderer.snakeHistoryY.size() - s - 1);

                    //Reset the game if the snake crashes into itself
                    if (s != 0) {
                        new CheckCrash().checkCrash(sX, sY);
                    }

                    if (sX == x && sY == y) {
                        tile = 2;
                    }
                }

                //Apples + collision
                GetApple getApple = new GetApple();
                apple = getApple.checkApple(snakesX.get(0), snakesY.get(0), apple);

                new Tiles().renderTile(rlj, x, y, tile);
            }
        }
    }
}
