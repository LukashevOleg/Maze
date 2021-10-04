package ru.vsu.cs.Lukashev;

import java.awt.*;

public class Draw
{

    public static void drawMaze(Graphics2D g, Cell[][] mazeField)
    {
        for (Cell[] cells : mazeField) {
            for (int k = 0; k < mazeField[0].length; k++) {
                cells[k].paint(g);
            }

        }
    }

    public static void drawGamer(Graphics2D g, Gamer gamer)
    {
        gamer.paint(g);
    }

}
