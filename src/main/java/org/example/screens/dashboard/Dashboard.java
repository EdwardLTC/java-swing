package org.example.screens.dashboard;

import org.example.screens.annotations.Screen;

import javax.swing.*;
import java.awt.*;

@Screen
public class Dashboard extends JPanel {
    private JPanel panel1;
    private JButton button1;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JButton button2;
    private JButton button3;
    //    private JPanel leftPanel;

    public Dashboard() {

//        leftPanel.setPreferredSize(new Dimension(200, 0));

        panel1 = new JPanel();
        topPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        button3 = new JButton("Button 3");


        topPanel.setPreferredSize(new Dimension(100, 100));
        leftPanel.setPreferredSize(new Dimension(200, 100));
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
    }
}
