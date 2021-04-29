package visual;

import com.company.Game;

import javax.swing.*;
import java.awt.*;

public class vis extends JFrame {
    private JLabel statusbar;

    public vis(Game G,int w,int h)
    {
        statusbar = new JLabel("SCORE");
        add(statusbar, BorderLayout.SOUTH);
        add(new Visualisation(G,this));
        setTitle("SPACE INVADERZ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(w+100, h);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public JLabel getStatusBar() {

        return statusbar;
    }
}
