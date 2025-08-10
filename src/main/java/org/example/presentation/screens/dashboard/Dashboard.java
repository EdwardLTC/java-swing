package org.example.presentation.screens.dashboard;

import org.example.presentation.annotations.Screen;

import javax.swing.*;
import java.awt.*;

@Screen
public class Dashboard extends JPanel {
    private JPanel panel1;
    private JTabbedPane tabbedPane1;

    public Dashboard() {
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
    }
}
