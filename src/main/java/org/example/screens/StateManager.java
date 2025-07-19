package org.example.screens;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class StateManager {
    private static StateManager instance;
    private final JFrame frame;
    private final Map<String, JPanel> screens = new HashMap<>();
    private Class<? extends JPanel> defaultScreen;

    private StateManager(JFrame frame) {
        this.frame = frame;
    }

    public static void init(JFrame frame) {
        if (instance == null) {
            instance = new StateManager(frame);
        } else {
            throw new IllegalStateException("StateManager has already been initialized.");
        }
    }

    public static StateManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("StateManager is not initialized. Call init(frame) first.");
        }
        return instance;
    }

    public void registerScreen(@NotNull Class<? extends JPanel> screenClass, JPanel panel, boolean isDefault) {
        screens.put(screenClass.getSimpleName(), panel);
        if (isDefault || defaultScreen == null) {
            defaultScreen = screenClass;
        }
    }

    public void show(@NotNull Class<? extends JPanel> screenClass) {
        JPanel panel = screens.get(screenClass.getSimpleName());
        if (panel == null) {
            throw new IllegalArgumentException("Screen not found: " + screenClass.getSimpleName());
        }
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }

    public void show() {
        if (defaultScreen == null) {
            throw new IllegalStateException("No default screen is set.");
        }
        show(defaultScreen);
    }
}
