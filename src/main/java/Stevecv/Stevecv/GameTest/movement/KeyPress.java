package Stevecv.Stevecv.GameTest.movement;

import com.raylib.java.Raylib;

public class KeyPress {
    public static String SANKE_DIR = "right";

    public void keyPress(Raylib rlj, String key) {
        SANKE_DIR = key;
    }
}
