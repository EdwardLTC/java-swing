package org.example.presentation.screens;

import org.example.presentation.annotations.Screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Screen
public class Dashboard extends JPanel {
    private JPanel panel1;

    private JTabbedPane tabbedPane1;
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

    }

    private void initPanels() {
        productPanel.add(new Products(), BorderLayout.CENTER);
        categoryPanel.add(new Categories(), BorderLayout.CENTER);
        orderPanel.add(new Orders(), BorderLayout.CENTER);
        supplierPanel.add(new Suppliers(), BorderLayout.CENTER);
        accountPanel.add(new Account(), BorderLayout.CENTER);
    }
}
