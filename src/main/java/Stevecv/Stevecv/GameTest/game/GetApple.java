package Stevecv.Stevecv.GameTest.game;

import Stevecv.Stevecv.GameTest.Main;
import Stevecv.Stevecv.GameTest.movement.SnakeRenderer;
import Stevecv.Stevecv.GameTest.tiles.Draw;

import java.util.ArrayList;
import java.util.Random;

public class GetApple {
    public int[] checkApple(int x, int y, int[] apple) {
        if (x == apple[0] && y == apple[1]) {
            //Snake is on apple

            ArrayList<Integer> snakeListX = new ArrayList<>();
            ArrayList<Integer> snakeListY = new ArrayList<>();
            for(int s = 0; s < Draw.snakeLength; s++) {
                SnakeRenderer snakeRenderer = new SnakeRenderer();

                snakeListX.add(snakeRenderer.snakeHistoryX.get(snakeRenderer.snakeHistoryX.size() - s - 1));
                snakeListY.add(snakeRenderer.snakeHistoryY.get(snakeRenderer.snakeHistoryY.size() - s - 1));
            }

            //Set apple to spawn at snake head
            int newX = snakeListX.get(0);
            int newY = snakeListY.get(0);

            //Randomise then check if the snake is there, if not, continue
            Random rand = new Random();
            while (snakeListX.contains(newX) && snakeListY.contains(newY)) {
                newX = rand.nextInt((11 - 1) + 1) + 1;
                newY = rand.nextInt((11 - 1) + 1) + 1;
            }

            apple = new int[] {newX, newY};

            Draw.snakeLength = Draw.snakeLength+1;

            if (Draw.snakeLength > Main.highest) {
                Main.highest = Draw.snakeLength;
            }
        }

        return apple;
    }
}
