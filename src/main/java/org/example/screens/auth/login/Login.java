package org.example.screens.auth.login;

import org.example.components.RoundedBorder;
import org.example.screens.StateManager;
import org.example.screens.annotations.Screen;
import org.example.screens.dashboard.Dashboard;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@Screen(isDefault = true)
public class Login extends JPanel {
    public JPanel panel1;
    private JTextField userNameTextField;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel spacer;

    public Login() {

        setLayout(new BorderLayout());

        panel1 = new JPanel();
        userNameTextField = new JTextField();
        passwordField1 = new JPasswordField();
        loginButton = new JButton("Login");
        spacer = new JPanel();

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
