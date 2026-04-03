package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login;
    JCheckBox showPassword;

    public LoginPage(){

        setTitle("Bus Booking System");
        setSize(400,320);
        setLayout(null);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(240,240,240));

        // Logo
        ImageIcon logoIcon = new ImageIcon("src/ui/logo.png");
        JLabel logo = new JLabel(logoIcon);
        logo.setBounds(160,10,80,40);
        add(logo);

        // Title
        JLabel title = new JLabel("Bus Booking System");
        title.setBounds(120,50,200,30);
        title.setFont(new Font("Arial",Font.BOLD,18));
        add(title);

        // Login panel (white card)
        JPanel panel = new JPanel();
        panel.setBounds(75,90,250,170);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        add(panel);

        // Username label
        JLabel userLabel = new JLabel("Username");
        userLabel.setBounds(20,20,80,25);
        panel.add(userLabel);

        // Username field
        username = new JTextField();
        username.setBounds(100,20,120,25);
        panel.add(username);

        // Password label
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(20,60,80,25);
        panel.add(passLabel);

        // Password field
        password = new JPasswordField();
        password.setBounds(100,60,120,25);
        panel.add(password);

        // Show password checkbox
        showPassword = new JCheckBox("Show");
        showPassword.setBounds(100,90,80,20);
        panel.add(showPassword);

        showPassword.addActionListener(e -> {

            if(showPassword.isSelected()){
                password.setEchoChar((char)0);
            }else{
                password.setEchoChar('*');
            }

        });

        // Login button
        login = new JButton("Login");
        login.setBounds(70,120,100,30);
        login.setBackground(new Color(217,30,24));
        login.setForeground(Color.WHITE);
        login.setFocusPainted(false);
        panel.add(login);

        login.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){

        String user = username.getText();
        String pass = new String(password.getPassword());

        if(user.equals("admin") && pass.equals("1234")){

            JOptionPane.showMessageDialog(this,"Login Successful");

            new SearchBusPage();

            dispose();

        }else{

            JOptionPane.showMessageDialog(this,"Invalid Username or Password");

        }

    }

    public static void main(String[] args){

        new LoginPage();

    }
}