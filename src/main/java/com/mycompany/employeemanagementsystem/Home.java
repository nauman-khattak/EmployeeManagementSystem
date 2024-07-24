package com.mycompany.employeemanagementsystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove;
    JLabel heading, imageLabel;
    Image image;

    public Home() {
        setLayout(new BorderLayout());
        setSize(1120, 630);
        setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        image = imageIcon.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        imageLabel = new JLabel(new ImageIcon(image));
        add(imageLabel, BorderLayout.CENTER);
        imageLabel.setLayout(new BorderLayout());

        heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBackground(Color.BLACK);
        heading.setForeground(Color.WHITE);
        heading.setOpaque(true);
        heading.setFont(new Font("Monospace", Font.BOLD, 50));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        imageLabel.add(heading, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setOpaque(false);

        view = new JButton("View Employees");
        view.setFont(new Font("Raleway", Font.BOLD, 13));
        view.addActionListener(this);
        buttonPanel.add(view);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        add = new JButton("Add Employee");
        add.setFont(new Font("Raleway", Font.BOLD, 13));
        add.addActionListener(this);
        buttonPanel.add(add);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        update = new JButton("Update Employee");
        update.setFont(new Font("Raleway", Font.BOLD, 13));
        update.addActionListener(this);
        buttonPanel.add(update);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        remove = new JButton("Remove Employee");
        remove.setFont(new Font("Raleway", Font.BOLD, 13));
        remove.addActionListener(this);
        buttonPanel.add(remove);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0)));

        JPanel centeredPanel = new JPanel(new GridBagLayout());
        centeredPanel.setOpaque(false);
        centeredPanel.add(buttonPanel);
        imageLabel.add(centeredPanel, BorderLayout.CENTER);

        //Component Listener to detect resize events on the JFrame
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeImage();
            }
        });

        setVisible(true);
    }

    private void resizeImage() {
        int width = getWidth();
        int height = getHeight();
        Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (e.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (e.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if (e.getSource() == remove) {
            setVisible(false);
            new RemoveEmployee();
        }
    }
}
