package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchBusPage extends JFrame implements ActionListener {

    JComboBox<String> source;
    JComboBox<String> destination;
    JButton search;

    public SearchBusPage(){

        setTitle("Search Bus");

        setLayout(null);

        JLabel title = new JLabel("Search Buses");
        title.setBounds(150,20,200,30);
        title.setFont(new Font("Arial",Font.BOLD,18));
        add(title);

        JLabel s1 = new JLabel("Source");
        s1.setBounds(50,80,100,30);
        add(s1);

        String[] districts = {
            "Bagalkot","Ballari","Belagavi","Bengaluru Rural","Bengaluru Urban",
            "Bidar","Chamarajanagar","Chikkaballapur","Chikkamagaluru",
            "Chitradurga","Dakshina Kannada","Davanagere","Dharwad","Gadag",
            "Hassan","Haveri","Kalaburagi","Kodagu","Kolar","Koppal",
            "Mandya","Mysuru","Raichur","Ramanagara","Shivamogga",
            "Tumakuru","Udupi","Uttara Kannada","Vijayapura","Yadgir"
        };

        source = new JComboBox<>(districts);
        source.setBounds(150,80,180,30);
        source.setEditable(true);
        add(source);

        JLabel s2 = new JLabel("Destination");
        s2.setBounds(50,130,100,30);
        add(s2);

        destination = new JComboBox<>(districts);
        destination.setBounds(150,130,180,30);
        destination.setEditable(true);
        add(destination);
        
        enableSearch(source, districts);
        enableSearch(destination, districts);

        search = new JButton("Search Bus");
        search.setBounds(140,200,120,35);
        search.setBackground(new Color(217,30,24));
        search.setForeground(Color.WHITE);
        add(search);
        search.addActionListener(this);

        setSize(420,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
        
        private void enableSearch(JComboBox<String> comboBox, String[] items) {

            JTextField textField = (JTextField) comboBox.getEditor().getEditorComponent();

            textField.addKeyListener(new java.awt.event.KeyAdapter() {

                public void keyReleased(java.awt.event.KeyEvent e) {

                    String text = textField.getText();

                    comboBox.removeAllItems();

                    for (String item : items) {
                        if (item.toLowerCase().contains(text.toLowerCase())) {
                            comboBox.addItem(item);
                        }
                    }

                    textField.setText(text);
                    comboBox.showPopup();
                }
            });
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            String src = (String) source.getSelectedItem();
            String dest = (String) destination.getSelectedItem();

            new BusListPage(src, dest);

        
}
}