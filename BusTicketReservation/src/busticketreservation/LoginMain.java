/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busticketreservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class LoginMain extends JFrame implements ActionListener {

    JLabel unam, pass;
    JButton blogin, bret;
    JTextField tunam;
    JPasswordField tpass;
    Stack pagetransition;

    LoginMain() {
        init();

    }

    LoginMain(Stack s) {
        init();
        this.pagetransition = s;

    }

    void init() {
        this.pagetransition = new Stack();
        this.setTitle("Admin Login");
        this.setBounds(200, 150, 400, 300);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        unam = new JLabel("Username");
        unam.setBounds(40, 20, 80, 20);
        pass = new JLabel("Password");
        pass.setBounds(40, 60, 80, 20);

        tunam = new JTextField();
        tunam.setBounds(140, 20, 100, 20);
        tpass = new JPasswordField();
        tpass.setBounds(140, 60, 100, 20);

        blogin = new JButton("Login");
        blogin.setBounds(120, 100, 70, 20);
        blogin.setBorder(null);
        bret = new JButton("Return");
        bret.setBounds(200, 100, 80, 20);
        bret.setBorder(null);

        this.add(unam);
        this.add(pass);
        this.add(tunam);
        this.add(tpass);
        this.add(blogin);
        this.add(bret);

        blogin.addActionListener(this);
        bret.addActionListener(this);

    }

    public static void main(String[] args) {

        LoginMain l = new LoginMain();
        l.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == blogin) {

            if (tunam.getText().equals("admin") && tpass.getText().equals("admin")) {
                
                this.pagetransition.add(2);
                dispose();
                AdminPane a = new AdminPane(this.pagetransition);
                a.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Invalid Login...");
            }

        } else if (e.getSource() == bret) {
            int x = (int) pagetransition.pop();
            switch (x) {
                case 1:
                    dispose();
                    BusTicketReservation b = new BusTicketReservation();
                    b.setVisible(true);
                    break;

            }
        }

    }

}
