package org.example.presentation.screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Products extends JPanel {
    private JPanel panel1;
    private JTable table1;
    private JScrollPane scrollPane;
    private JToolBar toolbar;

    public Products() {

        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Thêm");
        JButton btnEdit = new JButton("Sửa");
        JButton btnDelete = new JButton("Xóa");
        JButton btnRefresh = new JButton("Làm mới");

        toolbar.add(btnAdd);
        toolbar.add(btnEdit);
        toolbar.add(btnDelete);
        toolbar.addSeparator();
        toolbar.add(btnRefresh);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tên");
        model.addColumn("Tuổi");

        model.addRow(new Object[]{1, "Nguyễn Văn A", 20});
        model.addRow(new Object[]{2, "Trần Thị B", 22});

        table1.setModel(model);

        btnAdd.addActionListener(e -> {
            model.addRow(new Object[]{model.getRowCount() + 1, "Người mới", 18});
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = table1.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(panel1, "Chọn dòng cần xóa!");
            }
        });

        btnRefresh.addActionListener(e -> {
            JOptionPane.showMessageDialog(panel1, "Làm mới dữ liệu!");
        });

    }
}
