package ui;

import javax.swing.*;
import java.awt.*;

public class SeatSelectionPage extends JFrame {

    public SeatSelectionPage(String busName) {

        setTitle("Select Seat - " + busName);

        setLayout(new BorderLayout());

        JPanel seatPanel = new JPanel();

        // 10 rows, 5 columns (2 seats + aisle + 2 seats)
        seatPanel.setLayout(new GridLayout(10,5,10,10));

        int seatNumber = 1;

        for(int row=1; row<=10; row++){

            for(int col=1; col<=5; col++){

                // aisle
                if(col==3){
                    seatPanel.add(new JLabel(""));
                }
                else{

                    JButton seat = new JButton(String.valueOf(seatNumber));

                    seat.setPreferredSize(new Dimension(60,60));

                    seat.setBackground(Color.LIGHT_GRAY);

                    seat.addActionListener(e -> {

                        if(seat.getBackground() == Color.GREEN){
                            seat.setBackground(Color.LIGHT_GRAY);   // deselect seat
                        } 
                        else{
                            seat.setBackground(Color.GREEN);        // select seat
                        }

                    });

                    seatPanel.add(seat);

                    seatNumber++;
                }
            }
        }

        // Driver seat
        JButton driver = new JButton("Driver");
        driver.setBackground(Color.ORANGE);

        JPanel driverPanel = new JPanel();
        driverPanel.add(driver);

        add(driverPanel,BorderLayout.NORTH);
        add(seatPanel,BorderLayout.CENTER);
        
        JButton continueBtn = new JButton("Continue Booking");

        continueBtn.addActionListener(e -> {
            new PassengerDetailsPage();
        });

        add(continueBtn, BorderLayout.SOUTH);

        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
