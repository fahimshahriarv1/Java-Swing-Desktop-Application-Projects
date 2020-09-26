/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticketreservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class BusTicketReservation extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    JButton blogin, btickt, b3, b4, b5;
    JLabel LMain, LEx;
    Stack pagetransition;

    public BusTicketReservation() {
        init();
    }

    BusTicketReservation(Stack s) {
        init();
        this.pagetransition = s;
    }

    void init() {
        this.pagetransition = new Stack();
        this.setLayout(null);
        this.setTitle("Bus Ticket Reservation");
        this.setBounds(200, 150, 400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        blogin = new JButton("Admin Login");
        btickt = new JButton("Buy Ticket");

        blogin.setBounds(120, 100, 150, 40);
        blogin.setBorder(null);
        btickt.setBounds(120, 170, 150, 40);
        btickt.setBorder(null);
        LMain = new JLabel("WELCOME TO BUS TICKET RESERVATION");
        LMain.setBounds(80, 10, 250, 50);

        this.add(blogin);
        this.add(btickt);
        this.add(LMain);

        blogin.addActionListener(this);
        btickt.addActionListener(this);

    }

    public static void main(String[] args) {

        BusTicketReservation b = new BusTicketReservation();
        b.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == blogin) {

            pagetransition.add(1);
            dispose();
            LoginMain l = new LoginMain(this.pagetransition);
            l.setVisible(true);

        } else if (e.getSource() == btickt) {
            dispose();
            pagetransition.add(1);
            TicketingMain t = new TicketingMain(this.pagetransition);
            t.setVisible(true);
        }

    }

}
