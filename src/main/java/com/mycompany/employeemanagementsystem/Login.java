package com.mycompany.employeemanagementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JTextField usernameTF, passwordTF;

    public Login() {
        setSize(570, 270);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);

        JLabel usernameLbl = new JLabel("Username");
        usernameLbl.setBounds(40, 20, 100, 30);
        add(usernameLbl);

        JLabel passwordLbl = new JLabel("Password");
        passwordLbl.setBounds(40, 70, 100, 30);
        add(passwordLbl);

        usernameTF = new JTextField();
        usernameTF.setBounds(150, 20, 150, 30);
        add(usernameTF);

        passwordTF = new JTextField();
        passwordTF.setBounds(150, 70, 150, 30);
        add(passwordTF);

        JButton login = new JButton("LOGIN");
        login.addActionListener(this);
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(350, 0, 200, 200);
        add(imageLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = usernameTF.getText();
            String password = passwordTF.getText();

            Conn c = new Conn();

            String query = "Select * from Login where username = '" + username + "' and password = '" + password + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
