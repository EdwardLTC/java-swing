package org.example;

import org.example.data.repositories.RepositoryFactory;
import org.example.screens.ScreenAutoRegistrar;
import org.example.screens.StateManager;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        RepositoryFactory.initializer();
        JFrame frame = new JFrame("Edward's Swing Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 900);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        StateManager.init(frame);
        ScreenAutoRegistrar.registerScreens(Main.class.getPackageName());
        StateManager.getInstance().show();
    }
}