package ru.vsu.cs.Lukashev;

import java.awt.*;

public class Cell
{

    private final Coord coord;
    private boolean leftWall=false;
    private boolean rightWall=false;
    private boolean upWall=false;
    private boolean underWall=false;
    private int whichCell;
//    private boolean isGamerHere=false;

    public Cell(Coord coord)
    {
        this.coord = coord;
        this.whichCell=getRandomWhichCell();
//        this.leftWall = getRandomBoolean();
//        this.rightWall = getRandomBoolean();
//        this.upWall = getRandomBoolean();
//        this.underWall = getRandomBoolean();
    }

    public Cell(Coord coord, boolean leftWall, boolean rightWall, boolean upWall, boolean underWall) {
        this.coord = coord;
        this.leftWall = leftWall;
        this.rightWall = rightWall;
        this.upWall = upWall;
        this.underWall = underWall;
    }

    public Coord getCoord() {
        return coord;
    }

    public boolean isLeftWall() {
        return leftWall;
    }

    public boolean isRightWall() {
        return rightWall;
    }

    public boolean isUpWall() {
        return upWall;
    }

    public boolean isUnderWall() {
        return underWall;
    }

    private int getRandomWhichCell()
    {
        return (int)(Math.random()*10);
    }


//    public void setGamerHere(boolean gamerHere) {
//        isGamerHere = gamerHere;
//    }




    public void paint(Graphics2D g)
    {
        g.setColor(Color.decode("#0b5950"));
        g.setStroke(new BasicStroke(3));

        switch (whichCell)
        {
//            case 0,2,4:
//                underWall=true;
//                upWall=true;
//                break;
            case 1:
                upWall=true;
                rightWall=true;
                break;
            case 2:
                leftWall=true;
                underWall=true;
                break;
            case 3:
                leftWall=true;
                rightWall=true;
                break;
            case 4:
                upWall=true;
                leftWall=true;
                break;
            case 5:
                rightWall=true;
                underWall=true;
                break;
            case 0:
                break;
//            case 7:
//                leftWall=true;
//                rightWall=true;
//                underWall=true;
//                upWall=true;
//                break;
        }









        drawLeftWall(g);
        drawRightWall(g);
        drawUnderWall(g);
        drawUpWall(g);
    }

    public void paintFirstLast(Graphics2D g)
    {
        g.setColor(Color.decode("#ff5d00"));
        g.drawLine(coord.getX(), coord.getY(), coord.getX(), coord.getY()+50);
        g.drawLine(coord.getX()+50, coord.getY(), coord.getX()+50, coord.getY()+50);
        g.drawLine(coord.getX(), coord.getY(), coord.getX()+50, coord.getY());
        g.drawLine(coord.getX(), coord.getY()+50, coord.getX()+50, coord.getY()+50);


    }

    public void drawLeftWall(Graphics2D g)
    {
        if(leftWall)
        {
            g.drawLine(coord.getX(), coord.getY(), coord.getX(), coord.getY()+50);
        }
    }

    public void drawRightWall(Graphics2D g)
    {
        if(rightWall)
        {
            g.drawLine(coord.getX()+50, coord.getY(), coord.getX()+50, coord.getY()+50);
        }
    }

    public void drawUpWall(Graphics2D g)
    {
        if(upWall)
        {
            g.drawLine(coord.getX(), coord.getY(), coord.getX()+50, coord.getY());
        }
    }

    public void drawUnderWall(Graphics2D g)
    {
        if(underWall)
        {
            g.drawLine(coord.getX(), coord.getY()+50, coord.getX()+50, coord.getY()+50);
        }
    }


}
