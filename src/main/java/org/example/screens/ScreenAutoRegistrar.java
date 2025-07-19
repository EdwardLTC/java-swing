package org.example.screens;

import org.example.screens.annotations.Screen;

import javax.swing.*;
import java.util.Set;

import org.reflections.Reflections;
import org.slf4j.LoggerFactory;

public class ScreenAutoRegistrar {
    public static void registerScreens(String basePackage) {
        Reflections reflections = new Reflections(basePackage);

        Set<Class<?>> screenClasses = reflections.getTypesAnnotatedWith(Screen.class);
        StateManager manager = StateManager.getInstance();

        for (Class<?> clazz : screenClasses) {
            if (JPanel.class.isAssignableFrom(clazz)) {
                try {
                    Screen annotation = clazz.getAnnotation(Screen.class);
                    Class<? extends JPanel> screenClass = clazz.asSubclass(JPanel.class);

                    if (!JPanel.class.isAssignableFrom(screenClass)) {
                        LoggerFactory.getLogger(ScreenAutoRegistrar.class).warn("{} is NOT a JPanel subclass.", screenClass.getName());
                        continue;
                    }

                    JPanel panel = (JPanel) clazz.getDeclaredConstructor().newInstance();

                    manager.registerScreen(screenClass, panel, annotation.isDefault());
                } catch (Exception e) {
                    LoggerFactory.getLogger(ScreenAutoRegistrar.class).error("Failed to register screen: {}", clazz.getName(), e);
                    e.fillInStackTrace();
                }
            }
        }
    }
}
