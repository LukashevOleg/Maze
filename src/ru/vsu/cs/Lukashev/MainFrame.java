package ru.vsu.cs.Lukashev;

import javax.swing.*;

public class MainFrame extends JFrame
{
    public MainFrame()
    {
        super("Maze");
        MainPanel mainPanel=new MainPanel();
        mainPanel.setFocusable(true);
        mainPanel.requestFocusInWindow();
        this.add(mainPanel);
        this.setSize(1300, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
