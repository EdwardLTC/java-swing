package org.example.screens.bai3;

import org.example.screens.StateManager;
import org.example.screens.annotations.Screen;
import org.example.screens.home.HomeScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

@Screen
public class Bai3Screen extends JPanel {
    private final JTextField inputField;
    private final JTextArea outputArea;
    private final JTextField outputField;

    public Bai3Screen() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Bài 3: Mảng số nguyên", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        JPanel inputContainer = new JPanel(new BorderLayout(5, 5));
        JLabel inputLabel = new JLabel("Nhập mảng số nguyên (cách nhau bằng dấu phẩy):");
        inputField = new JTextField();
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        inputContainer.add(inputLabel, BorderLayout.NORTH);
        inputContainer.add(inputField, BorderLayout.CENTER);

        centerPanel.add(inputContainer);
        centerPanel.add(Box.createVerticalStrut(15));

        outputArea = new JTextArea(10, 40);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);

        centerPanel.add(scrollPane);
        centerPanel.add(Box.createVerticalStrut(15));

        JPanel outputFieldPanel = new JPanel(new BorderLayout(5, 5));
        outputField = new JTextField();
        outputField.setEditable(false);
        outputField.setFont(new Font("Arial", Font.BOLD, 14));
        outputField.setBackground(new Color(240, 240, 240));
        outputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        outputFieldPanel.add(new JLabel("Tóm tắt kết quả:"), BorderLayout.NORTH);
        outputFieldPanel.add(outputField, BorderLayout.CENTER);

        centerPanel.add(outputFieldPanel);
        centerPanel.add(Box.createVerticalStrut(10));

        add(centerPanel, BorderLayout.CENTER);

        // Buttons
        JButton processButton = new JButton("Xử lý");
        processButton.addActionListener(e -> processInput());

        JButton backButton = new JButton("Quay lại");
        backButton.addActionListener(e -> StateManager.getInstance().show(HomeScreen.class));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(processButton);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void processInput() {
        String inputText = inputField.getText().trim();
        if (inputText.isEmpty()) {
            outputArea.setText("Vui lòng nhập mảng số nguyên.");
            outputField.setText("");
            return;
        }

        String[] parts = inputText.split(",");
        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            for (String part : parts) {
                numbers.add(Integer.parseInt(part.trim()));
            }
        } catch (NumberFormatException ex) {
            outputArea.setText("Dữ liệu không hợp lệ. Vui lòng nhập các số nguyên cách nhau bởi dấu phẩy.");
            outputField.setText("");
            return;
        }

        int[] array = numbers.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);
        int min = array[0];

        int sumDiv3 = 0, countDiv3 = 0;
        for (int num : array) {
            if (num % 3 == 0) {
                sumDiv3 += num;
                countDiv3++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Mảng sau khi sắp xếp: ").append(Arrays.toString(array)).append("\n");
        sb.append("Giá trị nhỏ nhất: ").append(min).append("\n");
        if (countDiv3 > 0) {
            double avg = (double) sumDiv3 / countDiv3;
            sb.append("Trung bình cộng các phần tử chia hết cho 3: ").append(String.format("%.2f", avg)).append("\n");
            outputField.setText("Min = " + min + ", TB chia hết cho 3 = " + String.format("%.2f", avg));
        } else {
            sb.append("Không có phần tử nào chia hết cho 3.\n");
            outputField.setText("Min = " + min + ", Không có số chia hết cho 3");
        }

        outputArea.setText(sb.toString());
    }
}
