package Stevecv.Stevecv.GameTest;

import Stevecv.Stevecv.GameTest.game.Bar;
import Stevecv.Stevecv.GameTest.movement.KeyPress;
import Stevecv.Stevecv.GameTest.movement.SnakeRenderer;
import Stevecv.Stevecv.GameTest.tiles.Draw;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.core.Core;

public class Main {
    public static int highest = 1;

    public void resetGame() {
        Main.gameStart = false;

        Draw.snakeLength = 1;
        Draw.apple = new int[] {9, 6};

        Draw.snakesX.set(0, 4);
        Draw.snakesY.set(0, 6);

        KeyPress.SANKE_DIR = "right";
    }

    public static boolean gameStart = false;
    public static void main(String[] args){


        Raylib rlj = new Raylib();
        Core core = rlj.core;
        core.InitWindow(595, 625, "Snake");

        core.SetTargetFPS(60);

        //Make the snake
        new Draw().loadSnake();

        int frames = 0;
        while (!core.WindowShouldClose()){ // Gameloop
            //Make the snake move if the game has started
            if(frames == 10) {
                if (Main.gameStart == true) {
                    new SnakeRenderer().renderSnake(rlj);
                }

                frames = 0;
            }
            frames = frames+1;


            // DRAW
            core.BeginDrawing();
            core.ClearBackground(Color.WHITE);
            new Draw().drawGame(rlj);
            core.EndDrawing();

            keyPresses(rlj);

            new Bar().renderBar(rlj);
        }
    }

    private static void keyPresses(Raylib rlj) {
        Core core = rlj.core;


        // KEYPRESSES
        int arrow_left = 263;
        int arrow_right = 262;
        int arrow_up = 265;
        int arrow_down = 264;

        int w = 87;
        int a = 65;
        int s = 83;
        int d = 68;

        KeyPress keyPress = new KeyPress();
        if (core.GetKeyPressed() != 0) { Main.gameStart = true; }

        String dir = KeyPress.SANKE_DIR;
        if (core.IsKeyPressed(arrow_left) || core.IsKeyPressed(a)) {
            if (dir != "right" && Draw.snakeLength > 1) keyPress.keyPress(rlj, "left");
        }

        if (core.IsKeyPressed(arrow_right) || core.IsKeyPressed(d)) {
            if (dir != "left" && Draw.snakeLength > 1) keyPress.keyPress(rlj, "right");
        }

        if (core.IsKeyPressed(arrow_up) || core.IsKeyPressed(w)) {
            if (dir != "down" && Draw.snakeLength > 1) keyPress.keyPress(rlj, "up");
        }

        if (core.IsKeyPressed(arrow_down) || core.IsKeyPressed(s)) {
            if (dir != "up" && Draw.snakeLength > 1) keyPress.keyPress(rlj, "down");
        }
    }
}
