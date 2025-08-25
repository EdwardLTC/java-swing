package org.example.presentation.screens;

import org.example.presentation.annotations.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

@Screen
public class Dashboard extends JPanel {
    private JPanel panel1;

    private JTabbedPane tabbedPane;
    private JPanel productPanel;
    private JPanel categoryPanel;
    private JPanel orderPanel;
    private JPanel supplierPanel;
    private JPanel accountPanel;
    private JPanel dashboardPanel;

    public Dashboard() {
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);

        initPanels();
        handleKeyboardEvent();

    }

    private void initPanels() {
        productPanel.add(new Products(), BorderLayout.CENTER);
        categoryPanel.add(new Categories(), BorderLayout.CENTER);
        orderPanel.add(new Orders(), BorderLayout.CENTER);
        supplierPanel.add(new Suppliers(), BorderLayout.CENTER);
        accountPanel.add(new Account(), BorderLayout.CENTER);
    }

    private void handleKeyboardEvent() {
        System.out.println(tabbedPane.getComponentCount());

        InputMap inputMap = tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = tabbedPane.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "moveLeft");
        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tabbedPane.getSelectedIndex();
                if (index > 0) {
                    tabbedPane.setSelectedIndex(index - 1);
                }
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "moveRight");
        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tabbedPane.getSelectedIndex();
                if (index < tabbedPane.getTabCount() - 1) {
                    tabbedPane.setSelectedIndex(index + 1);
                }
            }
        });
    }
}
