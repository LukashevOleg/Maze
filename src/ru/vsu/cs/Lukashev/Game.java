package ru.vsu.cs.Lukashev;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private Cell[][] mazeField;
    private List<Coord> listRightWay=new ArrayList<>();

    @Override
    public String toString() {
        return "Game{" +
                "listRightWay=" + listRightWay +
                '}';
    }

    private Gamer gamer;
    public Game()
    {

    }

    public Cell[][] getMazeField() {
        return mazeField;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void UpdateMaze()
    {
        mazeField=new Cell[GameParams.getGAME_MAZE_COLUMN()][GameParams.getGAME_MAZE_ROW()];

        int x=10;
        int y=10;
        for(int i=0; i< mazeField.length;i++)
        {
            for(int k=0; k<mazeField[0].length; k++)
            {
                mazeField[i][k]=new Cell(new Coord(x, y, k, i));
                x+=50;
            }
            y+=50;
            x=10;
        }
//        rightWay();

        gamer=new Gamer(mazeField[0][0]);
    }



    public boolean checkWinner()
    {
        return gamer.getCell().getCoord().getRow() == GameParams.getGAME_MAZE_ROW() - 1 &&
                gamer.getCell().getCoord().getColumn() == GameParams.getGAME_MAZE_COLUMN()-1;
    }




    public void stepRight()
    {
        int row=gamer.getCell().getCoord().getRow();
        int column=gamer.getCell().getCoord().getColumn();
        if(gamer.getCell().getCoord().getRow()<GameParams.getGAME_MAZE_ROW()-1&&
                !mazeField[column][row+1].isLeftWall()&&
                !mazeField[column][row].isRightWall())
        {
            gamer.setCell(mazeField[column][row+1]);
//            gamer.setCoord(new Coord(gamer.getCoord().getX()+50, gamer.getCoord().getY(),
//                    gamer.getCoord().getRow()+1, gamer.getCoord().getColumn()));
        }
    }

    public void stepLeft()
    {
        int row=gamer.getCell().getCoord().getRow();
        int column=gamer.getCell().getCoord().getColumn();
        if(gamer.getCell().getCoord().getRow()>0&&
                !mazeField[column][row-1].isRightWall()&&
                !mazeField[column][row].isLeftWall())
        {
            gamer.setCell(mazeField[column][row-1]);
        }
    }

    public void stepUp()
    {
        int row=gamer.getCell().getCoord().getRow();
        int column=gamer.getCell().getCoord().getColumn();
        if(gamer.getCell().getCoord().getColumn()>0&&
                !mazeField[column-1][row].isUnderWall()&&
                !mazeField[column][row].isUpWall())
        {
            gamer.setCell(mazeField[column-1][row]);
        }
    }

    public void stepUnder()
    {
        int row=gamer.getCell().getCoord().getRow();
        int column=gamer.getCell().getCoord().getColumn();
        if(gamer.getCell().getCoord().getColumn()<GameParams.getGAME_MAZE_COLUMN()-1&&
                !mazeField[column+1][row].isUpWall()&&
                !mazeField[column][row].isUnderWall())
        {
            gamer.setCell(mazeField[column+1][row]);
        }
    }



//    private List<Coord> rightWay()
//    {
//        int i=0;
//        int x=0, y=0;
//        List<Coord> listRightWay=new ArrayList<>();
////        Coord coord=new Coord(0,0);
//        Coord lastCoord=new Coord(9,9);
//
//        listRightWay.add(new Coord(0,0));
////        listRightWay.add(coord);
////        listRightWay.add(coord);
//        do
//        {
////            Coord coord=new Coord(x,y);
//            int count=0;
//
//
//            if(getRandomNumber()==0)
//            {
//                if(x==0)
//                {
//                    x++;
//                }
//                else if(x==9)
//                {
//                    x--;
//                } else
//                {
//                    x+=Math.pow((-1),getRandomNumber());
//                }
////                coord.setRow(x);
//            } else
//            {
//                if(y==0)
//                {
//                    y++;
//                }
//                else if(y==9)
//                {
//                    y--;
//                } else
//                {
//                    y+=Math.pow((-1),getRandomNumber());
//                }
////                coord.setColumn(y);
//            }
//
//
//            System.out.println(i);
//            i++;
//            if(i==50)
//            {
//                listRightWay.clear();
//                x=0; y=0;
//                i=0;
//            }
//            listRightWay.add(new Coord(x, y));
//        } while (!new Coord(x, y).equals(lastCoord));
//        return listRightWay;
//    }

    private int getRandomNumber()
    {
        return (Math.random() <0.5) ? 1 : 0;
    }

}
