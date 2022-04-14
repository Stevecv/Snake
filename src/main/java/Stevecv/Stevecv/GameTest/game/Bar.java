package Stevecv.Stevecv.GameTest.game;

import Stevecv.Stevecv.GameTest.Main;
import Stevecv.Stevecv.GameTest.tiles.Draw;
import com.raylib.java.Raylib;
import com.raylib.java.core.Color;

public class Bar {
    public void renderBar(Raylib rlj) {
        rlj.shapes.DrawRectangle(0, 0, 595, 30, Color.GRAY);

        rlj.text.DrawText("SCORE: " + Draw.snakeLength, 5, 3, 24, Color.WHITE);
        rlj.text.DrawText("HIGH SCORE: " + Main.highest, 200, 3, 24, Color.WHITE);
    }
}
