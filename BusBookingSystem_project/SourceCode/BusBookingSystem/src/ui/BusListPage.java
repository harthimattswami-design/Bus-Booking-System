package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BusListPage extends JFrame {

    JTable table;

    public BusListPage(String source, String destination) {

        setTitle("Available Buses");

        String[] columns = {"Bus Name", "Source", "Destination", "Time", "Price"};

        Object[][] data = {
                {"KSRTC Express", source, destination, "9:00 AM", "450"},
                {"VRL Travels", source, destination, "10:30 AM", "500"},
                {"SRS Travels", source, destination, "12:00 PM", "480"},
                {"Sugama Travels", source, destination, "3:30 PM", "520"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);

        table = new JTable(model);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int row = table.getSelectedRow();

                String busName = table.getValueAt(row,0).toString();

                new SeatSelectionPage(busName);

            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);

        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}