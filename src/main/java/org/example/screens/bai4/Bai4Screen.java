package org.example.screens.bai4;

import org.example.screens.StateManager;
import org.example.screens.annotations.Screen;
import org.example.screens.home.HomeScreen;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

@Screen
public class Bai4Screen extends JPanel {
    private final JTextField nameField;
    private final JTextField scoreField;
    private final DefaultTableModel tableModel;
    private final ArrayList<Student> students = new ArrayList<>();

    public Bai4Screen() {
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Bài 4: Nhập sinh viên và học lực", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        // ==== Input + button layout ====
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        // Input fields


        JLabel nameLabel = new JLabel("Họ tên:");
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(200, 30));

        JLabel scoreLabel = new JLabel("Điểm:");
        scoreField = new JTextField();
        scoreField.setPreferredSize(new Dimension(80, 30));

        JPanel inputNameRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        inputNameRow.add(nameLabel);
        inputNameRow.add(nameField);

        JPanel inputScoreRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        inputScoreRow.add(scoreLabel);
        inputScoreRow.add(scoreField);


        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(Box.createVerticalStrut(10));
        formPanel.add(scoreLabel);
        formPanel.add(scoreField);
        formPanel.add(Box.createVerticalStrut(15));

        JPanel buttonPanel = getJPanel();

        formPanel.add(buttonPanel);
        formPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        String[] columns = {"Họ tên", "Điểm", "Học lực"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(500, 300));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.add(formPanel);
        centerPanel.add(Box.createVerticalStrut(20));
        centerPanel.add(scrollPane);

        add(centerPanel, BorderLayout.CENTER);
    }

    @NotNull
    private JPanel getJPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JButton addButton = new JButton("Thêm sinh viên");
        JButton sortButton = new JButton("Sắp xếp theo điểm");
        JButton backButton = new JButton("Quay lại");

        addButton.addActionListener(e -> addStudent());
        sortButton.addActionListener(e -> sortByScore());
        backButton.addActionListener(e -> StateManager.getInstance().show(HomeScreen.class));

        buttonPanel.add(addButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(backButton);
        return buttonPanel;
    }

    private void addStudent() {
        String name = nameField.getText().trim();
        String scoreText = scoreField.getText().trim();

        if (name.isEmpty() || scoreText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double score = Double.parseDouble(scoreText);
            if (score < 0 || score > 10) {
                JOptionPane.showMessageDialog(this, "Điểm phải từ 0 đến 10.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Student student = new Student(name, score);
            students.add(student);
            tableModel.addRow(new Object[]{student.name(), student.score(), student.rank()});
            nameField.setText("");
            scoreField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Điểm không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sortByScore() {
        students.sort(Comparator.comparingDouble(Student::score));
        tableModel.setRowCount(0);
        for (Student student : students) {
            tableModel.addRow(new Object[]{student.name(), student.score(), student.rank()});
        }
    }

    public record Student(String name, double score) {
        public String rank() {
            if (score < 5) return "Yếu";
            if (score < 6.5) return "Trung bình";
            if (score < 7.5) return "Khá";
            if (score < 9) return "Giỏi";
            return "Xuất sắc";
        }
    }
}