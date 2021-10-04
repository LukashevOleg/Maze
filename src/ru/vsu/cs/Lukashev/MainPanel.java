package ru.vsu.cs.Lukashev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel
{
    private final Game game=new Game();



    public MainPanel()
    {
        newGame();
        addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode()==KeyEvent.VK_A)
                {
                    stepLeft();
                }
                if(e.getKeyCode()==KeyEvent.VK_D)
                {
                    stepRight();
                }
                if(e.getKeyCode()==KeyEvent.VK_W)
                {
                    stepUp();
                }
                if(e.getKeyCode()==KeyEvent.VK_S)
                {
                    stepUnder();
                }

                if (game.checkWinner()) {
                    JOptionPane.showMessageDialog(e.getComponent(), " You are winner!!!");
                    newGame();
                }
            }
        });
    }


    public void stepLeft()
    {
        game.stepLeft();
        repaint();
    }

    public void stepRight()
    {
        game.stepRight();
        repaint();
    }

    public void stepUp()
    {
        game.stepUp();
        repaint();
    }

    public void stepUnder()
    {
        game.stepUnder();
        repaint();
    }

    @Override
    public void paint(Graphics graphics)
    {
        super.paint(graphics);
        Graphics2D g=(Graphics2D)graphics;

        g.setColor(Color.decode("#0b5950"));
        g.setStroke(new BasicStroke(5));
        g.drawRect(GameParams.getGAME_MAZE_X(),GameParams.getGAME_MAZE_Y(),
                GameParams.getGAME_MAZE_ROW()*50,GameParams.getGAME_MAZE_COLUMN()*50);


        drawMaze(g);
        drawGamer(g);

        new Cell(new Coord(GameParams.getGAME_MAZE_X()+24*50,GameParams.getGAME_MAZE_Y()+15*50,0,0)).paintFirstLast(g);
        new Cell(new Coord(GameParams.getGAME_MAZE_X(),GameParams.getGAME_MAZE_Y(),0,0)).paintFirstLast(g);
        System.out.println("That's all");
    }

    public void drawGamer(Graphics2D g)
    {
        Draw.drawGamer(g, game.getGamer());
    }

    public void drawMaze(Graphics2D g)
    {
        Draw.drawMaze(g, game.getMazeField());
    }

    public void newGame()
    {
        game.UpdateMaze();
    }


}
