package com.company;

import visual.vis;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public static void main(String[] args)
    {
        int width,height;
        width = 800;
        height = 600;
        Game G = new Game(width,height);
        EventQueue.invokeLater(() -> {
            var ex = new vis(G,width,height);
            ex.setVisible(true);
        });



    }


}
