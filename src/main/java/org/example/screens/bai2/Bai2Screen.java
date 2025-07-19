package org.example.screens.bai2;

import org.example.screens.StateManager;
import org.example.screens.annotations.Screen;
import org.example.screens.home.HomeScreen;

import javax.swing.*;
import java.awt.*;

@Screen
public class Bai2Screen extends JPanel {
    private final JTextArea textArea;

    public Bai2Screen() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Bài 2: Bảng cửu chương", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        textArea = new JTextArea(10,40);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);

        showTable();

        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(e -> StateManager.getInstance().show(HomeScreen.class));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(backButton);

        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showTable() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                sb.append(String.format("%2d x %2d = %2d", i, j, i * j)).append(" | ");
            }
            sb.append("\n");
        }
        textArea.setText(sb.toString());
    }
}