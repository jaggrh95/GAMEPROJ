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
        Config C = Config.getInstance();
        //enemyrows, enemycolumns, enemyspeed, playerspeeds, playerprojectilespeed, playerlives
        C.setVarsConfig(2,8,5,10,10,1);
        Game G = Game.getInstance(width,height);

        EventQueue.invokeLater(() -> {
            var ex = new vis(G,width,height);
            ex.setVisible(true);
        });



    }


}
