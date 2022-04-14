package Stevecv.Stevecv.GameTest.tiles;

import com.raylib.java.Raylib;
import com.raylib.java.core.Color;
import com.raylib.java.shapes.Shapes;

public class Tiles {
    public void renderTile(Raylib rlj, int x, int y, int tile) {
        int tileWidthHeight = 50;

        int pixelX = tileWidthHeight*x;
        int pixelY = tileWidthHeight*y;

        Shapes shapes = rlj.shapes;

        Color color = Color.LIGHTGRAY;
        if (tile == 1) {
            color = Color.RED;
        }
        if (tile == 2) {
            color = Color.GREEN;
        }

        shapes.DrawRectangle(pixelX, pixelY+30, tileWidthHeight-5, tileWidthHeight-5, color);
    }
}
