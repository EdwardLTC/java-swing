package org.example.presentation.screens.auth.login;

import org.example.presentation.components.RoundedBorder;
import org.example.presentation.screens.StateManager;
import org.example.presentation.annotations.Screen;
import org.example.presentation.screens.dashboard.Dashboard;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

@Screen(isDefault = true)
public class Login extends JPanel {
    public JPanel panel1;
    private JTextField userNameTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel spacer;

    public Login() {

        setLayout(new BorderLayout());

//        panel1.setPreferredSize(new Dimension(800, 400));

        add(panel1, BorderLayout.CENTER);

        spacer.setPreferredSize(new Dimension(0, 40));

        loginButton.setContentAreaFilled(true);
        loginButton.setPreferredSize(new Dimension(150, 40));

        Border noBorder = BorderFactory.createEmptyBorder();
        Border focusBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE);

        userNameTextField.setPreferredSize(new Dimension(200, 40));

        userNameTextField.setBorder(new RoundedBorder(12));
        passwordField1.setPreferredSize(new Dimension(200, 40));

        passwordField1.setBorder(new RoundedBorder(12));


        loginButton.addActionListener(v -> {
            StateManager.getInstance().show(Dashboard.class);
        });
    }
}
