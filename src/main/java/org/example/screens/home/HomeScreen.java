package org.example.screens.home;

import org.example.screens.StateManager;
import org.example.screens.annotations.Screen;
import org.example.screens.bai1.Bai1Screen;
import org.example.screens.bai2.Bai2Screen;
import org.example.screens.bai3.Bai3Screen;
import org.example.screens.bai4.Bai4Screen;

import javax.swing.*;
import java.awt.*;

@Screen(isDefault = true)
public class HomeScreen extends JPanel {
    public HomeScreen() {
        setLayout(new GridLayout(5, 1, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel title = new JLabel("Danh sách bài tập Lab 3");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        add(createButton("Bài 1: Kiểm tra số nguyên tố", Bai1Screen.class));
        add(createButton("Bài 2: Bảng cửu chương", Bai2Screen.class));
        add(createButton("Bài 3: Mảng số nguyên", Bai3Screen.class));
        add(createButton("Bài 4: Họ tên và điểm", Bai4Screen.class));
    }

    private JButton createButton(String text, Class<? extends JPanel> screenClass) {
        JButton button = new JButton(text);
        button.addActionListener(e -> StateManager.getInstance().show(screenClass));
        return button;
    }
}