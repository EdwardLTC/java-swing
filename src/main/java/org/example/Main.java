package org.example;

import org.example.data.repositories.RepositoryFactory;
import org.example.presentation.screens.ScreenAutoRegistrar;
import org.example.presentation.screens.StateManager;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        RepositoryFactory.initializer();

        JFrame frame = new JFrame("Shoes Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1200, 800));
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        StateManager.init(frame);
        ScreenAutoRegistrar.registerScreens(Main.class.getPackageName());
        StateManager.getInstance().show();
    }
}