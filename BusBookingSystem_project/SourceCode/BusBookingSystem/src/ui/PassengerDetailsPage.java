package ui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import db.DBConnection;
import javax.swing.JOptionPane;

public class PassengerDetailsPage extends JFrame {

    public PassengerDetailsPage() {

        setTitle("Passenger Details");
        setLayout(new GridLayout(5,2,10,10));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JLabel genderLabel = new JLabel("Gender:");
        String[] gender = {"Male","Female","Other"};
        JComboBox<String> genderBox = new JComboBox<>(gender);

        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();

        JButton confirm = new JButton("Confirm Booking");
        confirm.addActionListener(e -> {

            try {

                Connection con = DBConnection.getConnection();

                String sql = "INSERT INTO bookings(name,age,gender,phone,bus_name,source,destination,seats,price) VALUES (?,?,?,?,?,?,?,?,?)";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, nameField.getText());
                ps.setInt(2, Integer.parseInt(ageField.getText()));
                ps.setString(3, genderBox.getSelectedItem().toString());
                ps.setString(4, phoneField.getText());

                ps.setString(5, "KSRTC Express");
                ps.setString(6, "Bangalore");
                ps.setString(7, "Mysore");
                ps.setString(8, "1");
                ps.setInt(9, 450);

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Ticket Booked Successfully!");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        });

        add(nameLabel);
        add(nameField);

        add(ageLabel);
        add(ageField);

        add(genderLabel);
        add(genderBox);

        add(phoneLabel);
        add(phoneField);

        add(new JLabel(""));
        add(confirm);

        setSize(400,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
