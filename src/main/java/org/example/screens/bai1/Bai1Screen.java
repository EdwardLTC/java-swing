package org.example.screens.bai1;

import org.example.screens.StateManager;
import org.example.screens.annotations.Screen;
import org.example.screens.home.HomeScreen;

import javax.swing.*;
import java.awt.*;

@Screen
public class Bai1Screen extends JPanel {
    public Bai1Screen() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel title = new JLabel("Kiểm tra số nguyên tố");
        title.setFont(new Font("Arial", Font.BOLD, 22));
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel label = new JLabel("Nhập số nguyên:");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
//        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField input = new JTextField();
        input.setMaximumSize(new Dimension(300, 30));
        input.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton checkButton = new JButton("Kiểm tra");
//        checkButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel result = new JLabel("");
        result.setFont(new Font("Arial", Font.ITALIC, 16));
        result.setForeground(Color.BLUE);
//        result.setAlignmentX(Component.LEFT_ALIGNMENT);

        checkButton.addActionListener(e -> {
            try {
                int num = Integer.parseInt(input.getText().trim());
                boolean isPrime = num > 1;
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                result.setText(num + (isPrime ? " là số nguyên tố." : " không phải là số nguyên tố."));
            } catch (NumberFormatException ex) {
                result.setText("⚠️ Vui lòng nhập số nguyên hợp lệ.");
            }
        });

        JButton backButton = new JButton("Quay lại");
        backButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        backButton.addActionListener(e -> StateManager.getInstance().show(HomeScreen.class));

        add(title);
        add(Box.createVerticalStrut(30));
        add(label);
        add(Box.createVerticalStrut(5));
        add(input);
        add(Box.createVerticalStrut(10));
        add(checkButton);
        add(Box.createVerticalStrut(10));
        add(result);
        add(Box.createVerticalStrut(30));
        add(backButton);
    }
}
