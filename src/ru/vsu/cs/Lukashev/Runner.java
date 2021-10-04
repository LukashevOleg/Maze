package ru.vsu.cs.Lukashev;

import java.util.ArrayList;
import java.util.List;

public class Runner
{

    List<Coord> listRightWay= new ArrayList<>();

//    private Runner() {
//    }

    public static List<Coord> rightWay(Cell[][] mazeField, int row, int column)
    {
        List<Coord> listRightWay = new ArrayList<>();
        Coord coordCrossroad;
        boolean isCrossroad=false;

        Coord coordContainer = new Coord(0,0);


            if(mazeField[column][row].isRightWall()&&mazeField[column][row].isLeftWall()||
                    mazeField[column][row].isLeftWall()&&mazeField[column][row].isUnderWall()||
                    mazeField[column][row].isRightWall()&&mazeField[column][row].isUnderWall())
            {
            coordCrossroad=new Coord(row, column);
            isCrossroad=true;
            }

            if(isCrossroad)
            {
                if(mazeField[column][row].isRightWall()&&row<GameParams.getGAME_MAZE_ROW()-1)
                {
                    if(rightWay(mazeField, row+1, column).get(0).equals(new Coord(9,9)))
                    {
                        listRightWay.addAll(rightWay(mazeField, row, column));
                        return listRightWay;
                    }
                }
                else if(mazeField[column][row].isLeftWall()&& row>0)
                {
                    if(rightWay(mazeField, row-1, column).get(0).equals(new Coord(9,9)))
                    {
                        listRightWay.addAll(rightWay(mazeField, row, column));
                        return listRightWay;
                    }
                } else if(mazeField[column][row].isUnderWall()&&column<GameParams.getGAME_MAZE_COLUMN()-1)
                {

                }







            }

//            rightWay(mazeField, row, column).addAll(listRightWay);
            if(!mazeField[column][row].isUnderWall())
            {
                coordContainer=new Coord(row, column+1);
            }

            System.out.println(listRightWay);

//            else if(!mazeField[column][row].isRightWall())
//            {
//                coordContainer=new Coord(row+1, column);
//            }
        return listRightWay;
    }
}
