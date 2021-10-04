package ru.vsu.cs.Lukashev;

import java.awt.*;

public class Gamer
{



    private Cell cell;

    public Gamer(Cell cell)
    {
        this.cell=cell;
    }

    public Cell getCell() {
        return cell;
    }
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void paint(Graphics2D g)
    {
        g.setColor(Color.decode("#5458e8"));
        g.fillRect(cell.getCoord().getX()+12, cell.getCoord().getY()+12,25,25 );


    }
}
