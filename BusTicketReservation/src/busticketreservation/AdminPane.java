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
public class AdminPane extends JFrame implements ActionListener {

    JButton badd, bedit, bseeav, bsresv, beditresv, bret;
    Stack pagetransition;

    AdminPane() {
        init();
    }

    AdminPane(Stack s) {
        init();
        this.pagetransition = s;
    }

    void init() {
        this.pagetransition = new Stack();
        this.setTitle("Admin Panel");
        this.setBounds(200, 150, 400, 300);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        badd = new JButton("Add Bus");
        badd.setBounds(100, 20, 150, 20);
        badd.setBorder(null);
        bedit = new JButton("Edit Bus");
        bedit.setBounds(100, 60, 150, 20);
        bedit.setBorder(null);
        bseeav = new JButton("See Availables");
        bseeav.setBounds(100, 100, 150, 20);
        bseeav.setBorder(null);
        bsresv = new JButton("See Reservations");
        bsresv.setBounds(100, 140, 150, 20);
        bsresv.setBorder(null);
        beditresv = new JButton("Edit Reservations");
        beditresv.setBounds(100, 180, 150, 20);
        beditresv.setBorder(null);
        bret = new JButton("Return");
        bret.setBounds(100, 220, 150, 20);
        bret.setBorder(null);

        this.add(badd);
        this.add(bedit);
        this.add(bseeav);
        this.add(bsresv);
        this.add(beditresv);
        this.add(bret);

        badd.addActionListener(this);
        bedit.addActionListener(this);
        bsresv.addActionListener(this);
        bseeav.addActionListener(this);
        beditresv.addActionListener(this);
        bret.addActionListener(this);

    }

    public static void main(String[] args) {
        AdminPane a = new AdminPane();
        a.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bret) {
            int x = (int) pagetransition.pop();
            switch (x) {
                case 1:
                    dispose();
                    BusTicketReservation b = new BusTicketReservation();
                    b.setVisible(true);
                    break;
                case 2:
                    dispose();
                    LoginMain l = new LoginMain(this.pagetransition);
                    l.setVisible(true);
                    break;

            }
        }
    }

}
