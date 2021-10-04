package ru.vsu.cs.Lukashev;

public class Coord
{
    private int x, y;
    private int row, column;

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    public Coord(int x, int y, int row, int column)
    {
        this.x = x;
        this.y = y;
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    public Coord(int row, int column)
    {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }


}
