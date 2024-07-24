package com.mycompany.employeemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Splash extends JFrame implements ActionListener {

    Image image;
    JLabel heading;
    JLabel imageLabel;
    JButton clickHereBtn;

    public Splash() {
        setLayout(null);
        setSize(1170, 650);
        setLocationRelativeTo(null);
        heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(0, 30, getWidth(), 60);
        heading.setForeground(Color.YELLOW);
        heading.setFont(new Font("Monospace", Font.BOLD, 60));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        add(heading);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        image = imageIcon.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(0, 0, 1170, 650);
        add(imageLabel);

        clickHereBtn = new JButton("CLICK HERE TO CONTINUE");
        clickHereBtn.addActionListener(this);
        clickHereBtn.setBounds(585, 500, 300, 70); //initial bounds of JButton
        clickHereBtn.setBackground(Color.BLACK);
        clickHereBtn.setForeground(Color.WHITE);
        imageLabel.add(clickHereBtn);

        //Component Listener to detect resize events on the JFrame
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeImage();
            }
        });
        setVisible(true); //JFrame
    }

    private void resizeImage() {
        int width = getWidth();
        int height = getHeight();

        //heading adjust its width to match the JFrame's width
        heading.setBounds(0, 30, width, 60);

        //adjusts the image size and the bounds of the imageLabel whenever the JFrame is resized
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setBounds(0, 0, width, height);

        // Update the button position to be near the bottom of the JFrame
        int btnWidth = clickHereBtn.getWidth();
        int btnHeight = clickHereBtn.getHeight();
        int btnX = (width - btnWidth) / 2; // Center horizontally
        int btnY = height - btnHeight - 90; // 90 pixels from the bottom
        clickHereBtn.setBounds(btnX, btnY, btnWidth, btnHeight);
    }

    public static void main(String[] args) {
        new Splash();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
}
