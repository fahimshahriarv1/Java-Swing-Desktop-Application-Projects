/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author USER
 */
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;
import javafx.scene.layout.Border;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Calculator
        extends JFrame implements ActionListener {

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bdot, ex, PL, eq, min, div, mul, CL, erase, bcos, btan, bsin, broot, brace1, brace2, bpow, blog, bln, bnpr, bncr, bfact, bE, bshift, bpi;
    JTextField t, t1;
    int n, i;
    int n2, t1length, isShifted = 1;
    double n1, ans = 0;
    String op = "xx";
    Vector braceOpen, braceClose;
    Stack Brace;
    boolean isDotpress = false, isOppress, isBraceclose = true, isTrigpress = false, isShiftPress = false;
    String inFix = "", reSult = "";

    Calculator() {
        this.Brace = new Stack();
        this.setLayout(null);
//        Dimension dimn=Toolkit.getDefaultToolkit().getScreenSize();
//        this.setLocation(dimn.width/2-this.getSize().width/2,dimn.width/2-this.getSize().width/2);
        this.setBackground(Color.BLUE);
        this.setBounds(500,100,300,300);
        //this.setM

        ex = new JButton("exit");
        ex.setBorder(null);
        bshift = new JButton("shift");
        bshift.setBorder(null);
        bpi = new JButton("π");
        bpi.setBorder(null);

        braceOpen = new Vector();
        braceClose = new Vector();
        braceOpen.clear();
        braceClose.clear();

        b1 = new JButton(" 1 ");
        b1.setBorder(null);
        b2 = new JButton(" 2 ");
        b2.setBorder(null);
        b3 = new JButton(" 3 ");
        b3.setBorder(null);
        PL = new JButton("+");
        PL.setBorder(null);

        b4 = new JButton(" 4 ");
        b4.setBorder(null);
        b5 = new JButton(" 5 ");
        b5.setBorder(null);
        b6 = new JButton(" 6 ");
        b6.setBorder(null);
        min = new JButton("-");
        min.setBorder(null);

        b7 = new JButton(" 7 ");
        b7.setBorder(null);
        b8 = new JButton(" 8 ");
        b8.setBorder(null);
        b9 = new JButton(" 9 ");
        b9.setBorder(null);
        mul = new JButton("x");
        mul.setBorder(null);
        bsin = new JButton("sin");
        bsin.setBorder(null);

        btan = new JButton("tan");
        btan.setBorder(null);
        b0 = new JButton(" 0 ");
        b0.setBorder(null);
        div = new JButton("/");
        div.setBorder(null);
        eq = new JButton("=");
        eq.setBorder(null);
        bcos = new JButton("cos");
        bcos.setBorder(null);

        blog = new JButton("log");
        blog.setBorder(null);
        bln = new JButton("ln");
        bln.setBorder(null);
        bnpr = new JButton("nPr");
        bnpr.setBorder(null);
        bncr = new JButton("nCr");
        bncr.setBorder(null);
        bfact = new JButton(" n! ");
        bfact.setBorder(null);

        bpow = new JButton("^");
        bpow.setBorder(null);
        brace1 = new JButton("(");
        brace1.setBorder(null);
        brace2 = new JButton(")");
        brace2.setBorder(null);
        broot = new JButton("√x");
        broot.setBorder(null);
        bdot = new JButton(" . ");
        bdot.setBorder(null);

        //bdot.setBorder(null);
        CL = new JButton("AC");
        CL.setBorder(null);
        erase = new JButton("erase");
        erase.setBorder(null);

        t1 = new JTextField(50);
        t1.setEditable(false);
        t1.setHorizontalAlignment(JTextField.RIGHT);
        t = new JTextField(50);
        t.setEditable(false);
        t.setHorizontalAlignment(JTextField.RIGHT);

        b1.setBounds(30, 100, 50, 30);
        b2.setBounds(80, 100, 50, 30);
        b3.setBounds(130, 100, 50, 30);
        PL.setBounds(180, 100, 50, 30);
        CL.setBounds(230, 100, 80, 30);

        b4.setBounds(30, 130, 50, 30);
        b5.setBounds(80, 130, 50, 30);
        b6.setBounds(130, 130, 50, 30);
        min.setBounds(180, 130, 50, 30);
        erase.setBounds(230, 130, 80, 30);

        b7.setBounds(30, 160, 50, 30);
        b8.setBounds(80, 160, 50, 30);
        b9.setBounds(130, 160, 50, 30);
        mul.setBounds(180, 160, 50, 30);
        bsin.setBounds(230, 160, 80, 30);

        btan.setBounds(30, 190, 52, 30);
        b0.setBounds(80, 190, 50, 30);
        div.setBounds(130, 190, 50, 30);
        eq.setBounds(180, 190, 50, 30);
        bcos.setBounds(230, 190, 80, 30);

        blog.setBounds(30, 220, 52, 30);
        bln.setBounds(80, 220, 52, 30);
        bnpr.setBounds(130, 220, 52, 30);
        bncr.setBounds(180, 220, 52, 30);
        bfact.setBounds(230, 220, 80, 30);

        bpow.setBounds(30, 250, 52, 30);
        brace1.setBounds(80, 250, 52, 30);
        brace2.setBounds(130, 250, 52, 30);
        broot.setBounds(180, 250, 52, 30);
        bdot.setBounds(230, 250, 80, 30);

        ex.setBounds(0, 0, 65, 30);
        bshift.setBounds(0, 30, 65, 30);
        bpi.setBounds(0, 60, 65, 30);
        t1.setBounds(80, 25, 180, 30);
        t1.setBackground(Color.white);
        t.setBounds(80, 60, 180, 30);
        t.setBackground(Color.white);

        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                onExit();
            }

        });

        this.add(b0);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        this.add(bdot);

        this.add(ex);
        this.add(PL);
        this.add(mul);
        this.add(min);
        this.add(div);
        this.add(eq);
        this.add(CL);
        this.add(erase);
        this.add(t);
        this.add(t1);
        this.add(bsin);
        this.add(bcos);
        this.add(btan);
        this.add(broot);
        this.add(brace1);
        this.add(brace2);
        this.add(bpow);
        this.add(blog);
        this.add(bln);
        this.add(bnpr);
        this.add(bncr);
        this.add(bfact);
        this.add(bshift);
        this.add(bpi);
        this.setResizable(false);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        ex.addActionListener(this);
        PL.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        min.addActionListener(this);
        eq.addActionListener(this);
        CL.addActionListener(this);
        erase.addActionListener(this);
        bdot.addActionListener(this);
        broot.addActionListener(this);
        brace1.addActionListener(this);
        brace2.addActionListener(this);
        bsin.addActionListener(this);
        bcos.addActionListener(this);
        btan.addActionListener(this);
        bpow.addActionListener(this);
        blog.addActionListener(this);
        bln.addActionListener(this);
        bnpr.addActionListener(this);
        bncr.addActionListener(this);
        bfact.addActionListener(this);
        bshift.addActionListener(this);
        bpi.addActionListener(this);
    }

    void onExit() {

        JOptionPane.showMessageDialog(null, "Thank You For Using", "Thank you", WIDTH);
        System.exit(0);

    }

    void bsetText(int x) {
        if (x == 1) {
            bsin.setText("sin^-1");
            bcos.setText("cos^-1");
            btan.setText("tan^-1");
            isShifted = 2;
        } else if (x == 2) {
            bsin.setText("sin");
            bcos.setText("cos");
            btan.setText("tan");
            isShifted = 1;
        }
    }

    @SuppressWarnings("override")
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == ex) {
            JOptionPane.showMessageDialog(null, "Thank You For Using", "Thank you", WIDTH);
            System.exit(0);
        } else if (ae.getSource() == PL) // while pressing plus
        {

            int l = 0;

            if (!t1.getText().isEmpty()) {
                l = t1.getText().length();
            }
            if (l >= 1000) {
                ShowMsg.ShowErr("Expression Is Too Large");
            } else if (!t1.getText().isEmpty() && ((t1.getText().charAt(l - 1) == '+' || t1.getText().charAt(l - 1) == '*' || t1.getText().charAt(l - 1) == '/' || t1.getText().charAt(l - 1) == '-') && !isDotpress && l > 0)) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 1));
                inFix = inFix.substring(0, inFix.length() - 1);
                t1.setText(t1.getText() + "+");
                inFix = inFix + "+";
            } else if (!t1.getText().isEmpty()) {
                if ((((t1.getText().charAt(l - 1) >= 48 && t1.getText().charAt(l - 1) <= 57) || t1.getText().charAt(l - 1) == 'π') && !isDotpress && l > 0) || (t1.getText().charAt(l - 1) == ')' && !isDotpress && l > 0)) {
                    t1.setText(t1.getText() + "+");
                    inFix = inFix + "+";
                }
            }
            isDotpress = false;
            isOppress = true;

        } else if (ae.getSource() == min) // while pressing minus
        {

            int l = 0;
            if (!t1.getText().isEmpty()) {
                l = t1.getText().length();
            }
            if (l >= 1000) {
                ShowMsg.ShowErr("Expression Is Too Large");
            } else if (!t1.getText().isEmpty() && ((t1.getText().charAt(l - 1) == '+' || t1.getText().charAt(l - 1) == '*' || t1.getText().charAt(l - 1) == '/' || t1.getText().charAt(l - 1) == '-') && !isDotpress && l > 0)) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 1));
                inFix = inFix.substring(0, inFix.length() - 1);
                t1.setText(t1.getText() + "-");
                inFix = inFix + "-";
            } else if (!t1.getText().isEmpty()) {
                if ((((t1.getText().charAt(l - 1) >= 48 && t1.getText().charAt(l - 1) <= 57) || t1.getText().charAt(l - 1) == 'π') && !isDotpress && l > 0) || (t1.getText().charAt(l - 1) == ')' && !isDotpress && l > 0)) {
                    t1.setText(t1.getText() + "-");
                    inFix = inFix + "-";
                }
            }
            isDotpress = false;
            isOppress = true;

        } else if (ae.getSource() == mul) // while pressing multiplication
        {
            int l = 0;
            if (!t1.getText().isEmpty()) {
                l = t1.getText().length();
            }
            if (l >= 1000) {
                ShowMsg.ShowErr("Expression Is Too Large");
            } else if (!t1.getText().isEmpty() && ((t1.getText().charAt(l - 1) == '+' || t1.getText().charAt(l - 1) == '*' || t1.getText().charAt(l - 1) == '/' || t1.getText().charAt(l - 1) == '-') && !isDotpress && l > 0)) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 1));
                inFix = inFix.substring(0, inFix.length() - 1);
                t1.setText(t1.getText() + "*");
                inFix = inFix + "*";
            } else if (!t1.getText().isEmpty()) {
                if ((((t1.getText().charAt(l - 1) >= 48 && t1.getText().charAt(l - 1) <= 57) || t1.getText().charAt(l - 1) == 'π') && !isDotpress && l > 0) || (t1.getText().charAt(l - 1) == ')' && !isDotpress && l > 0)) {
                    t1.setText(t1.getText() + "*");
                    inFix = inFix + "*";
                }
            }

            isDotpress = false;
            isOppress = true;

        } else if (ae.getSource() == div) // while pressing division
        {

            int l = 0;
            if (!t1.getText().isEmpty()) {
                l = t1.getText().length();
            }
            if (l >= 1000) {
                ShowMsg.ShowErr("Expression Is Too Large");
            } else if (!t1.getText().isEmpty() && ((t1.getText().charAt(l - 1) == '+' || t1.getText().charAt(l - 1) == '*' || t1.getText().charAt(l - 1) == '/' || t1.getText().charAt(l - 1) == '-') && !isDotpress && l > 0)) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 1));
                inFix = inFix.substring(0, inFix.length() - 1);
                t1.setText(t1.getText() + "/");
                inFix = inFix + "/";
            } else if (!t1.getText().isEmpty()) {
                if ((((t1.getText().charAt(l - 1) >= 48 && t1.getText().charAt(l - 1) <= 57) || t1.getText().charAt(l - 1) == 'π') && !isDotpress && l > 0) || (t1.getText().charAt(l - 1) == ')' && !isDotpress && l > 0)) {
                    t1.setText(t1.getText() + "/");
                    inFix = inFix + "/";
                }
            }
            isDotpress = false;
            isOppress = true;

        } else if (ae.getSource() == CL) // while pressing all clear
        {

            t1.setText(null);
            t.setText(null);
            inFix = "";
            braceOpen.clear();
            braceClose.clear();
            isDotpress = false;
            isBraceclose = true;

        } else if (ae.getSource() == erase) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) >= 48 && t1.getText().charAt(l - 1) >= 57) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 1));
                inFix = inFix.substring(0, inFix.length() - 1);
                System.out.println(t1.getText() + "\n in=> " + inFix);
            } else if (!t1.getText().isEmpty() && t1.getText().length() >= 4 && (t1.getText().charAt(l - 2) == '√' || t1.getText().charAt(l - 2) == '^')) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 2));
                inFix = inFix.substring(0, inFix.length() - 2);
                System.out.println(t1.getText() + "\n in=> " + inFix);
            } else if (!t1.getText().isEmpty() && t1.getText().length() >= 4 && (t1.getText().charAt(l - 4) == 'c' || t1.getText().charAt(l - 4) == 't' || t1.getText().charAt(l - 4) == 's' || t1.getText().charAt(l - 4) == 'l')) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 4));
                inFix = inFix.substring(0, inFix.length() - 2);
                System.out.println(t1.getText() + "\n in=> " + inFix);
            } else if (!t1.getText().isEmpty() && t1.getText().length() >= 3 && (t1.getText().charAt(l - 3) == 'l')) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 3));
                inFix = inFix.substring(0, inFix.length() - 2);
                System.out.println(t1.getText() + "\n in=> " + inFix);
            } else if (!t1.getText().isEmpty() && t1.getText().length() >= 6 && (t1.getText().charAt(l - 6) == 'c' || t1.getText().charAt(l - 6) == 't' || t1.getText().charAt(l - 6) == 's')) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 6));
                inFix = inFix.substring(0, inFix.length() - 2);
                System.out.println(t1.getText() + "\n in=> " + inFix);
            } else if (!t1.getText().isEmpty()) {
                t1.setText(t1.getText().substring(0, t1.getText().length() - 1));
                inFix = inFix.substring(0, inFix.length() - 1);
                System.out.println(t1.getText() + "\n in=> " + inFix);
            }
        } else if (ae.getSource() == b0) {

            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*0");
                inFix = inFix + "*0";
            } else {
                t1.setText(t1.getText() + "0");
                inFix = inFix + "0";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == b1) {

            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*1");
                inFix = inFix + "*1";
            } else {
                t1.setText(t1.getText() + "1");
                inFix = inFix + "1";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == b2) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*2");
                inFix = inFix + "*2";
            } else {
                t1.setText(t1.getText() + "2");
                inFix = inFix + "2";
            }
            isDotpress = false;
            isOppress = false;

        } else if (ae.getSource() == b3) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*3");
                inFix = inFix + "*3";
            } else {
                t1.setText(t1.getText() + "3");
                inFix = inFix + "3";
            }
            isDotpress = false;
            isOppress = false;

        } else if (ae.getSource() == b4) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*4");
                inFix = inFix + "*4";
            } else {
                t1.setText(t1.getText() + "4");
                inFix = inFix + "4";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == b5) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*5");
                inFix = inFix + "*5";
            } else {
                t1.setText(t1.getText() + "5");
                inFix = inFix + "5";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == b6) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*6");
                inFix = inFix + "*6";
            } else {
                t1.setText(t1.getText() + "6");
                inFix = inFix + "6";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == b7) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*7");
                inFix = inFix + "*7";
            } else {
                t1.setText(t1.getText() + "7");
                inFix = inFix + "7";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == b8) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*8");
                inFix = inFix + "*8";
            } else {
                t1.setText(t1.getText() + "8");
                inFix = inFix + "8";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == b9) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*9");
                inFix = inFix + "*9";
            } else {
                t1.setText(t1.getText() + "9");
                inFix = inFix + "9";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == bdot) {

            if (isDotpress == false && !ifDotpressd()) {
                t1.setText(t1.getText() + ".");
                inFix = inFix + ".";
            }
            isDotpress = true;

        } else if (ae.getSource() == broot) {

            if (!t1.getText().isEmpty()) {
                if (t1.getText().endsWith(")") || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                    t1.setText(t1.getText() + "*√(");
                    inFix = inFix + "*√(";
                } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                    t1.setText(t1.getText() + "√(");
                    inFix = inFix + "√(";
                }
            } else {
                t1.setText(t1.getText() + "√(");
                inFix = inFix + "√(";
            }
            isOppress = true;

        } else if (ae.getSource() == bsin) {

            if (!isShiftPress) {

                if (!t1.getText().isEmpty()) {
                    if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                        t1.setText(t1.getText() + "*sin(");
                        inFix = inFix + "*S(";
                    } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                        t1.setText(t1.getText() + "sin(");
                        inFix = inFix + "S(";
                    }
                } else {
                    t1.setText(t1.getText() + "sin(");
                    inFix = inFix + "S(";
                }

            } else {
                if (!t1.getText().isEmpty()) {
                    if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                        t1.setText(t1.getText() + "*sin-1(");
                        inFix = inFix + "*s(";
                    } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                        t1.setText(t1.getText() + "sin-1(");
                        inFix = inFix + "s(";
                    }
                } else {
                    t1.setText(t1.getText() + "sin-1(");
                    inFix = inFix + "s(";
                }
                isShiftPress = false;
                bsetText(2);
            }
            isOppress = true;
            isTrigpress = true;

        } else if (ae.getSource() == bcos) {
            if (!isShiftPress) {

                if (!t1.getText().isEmpty()) {
                    if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                        t1.setText(t1.getText() + "*cos(");
                        inFix = inFix + "*C(";
                    } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                        t1.setText(t1.getText() + "cos(");
                        inFix = inFix + "C(";
                    }
                } else {
                    t1.setText(t1.getText() + "cos(");
                    inFix = inFix + "C(";
                }

            } else {
                if (!t1.getText().isEmpty()) {
                    if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                        t1.setText(t1.getText() + "*cos-1(");
                        inFix = inFix + "*c(";
                    } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                        t1.setText(t1.getText() + "cos-1(");
                        inFix = inFix + "c(";
                    }
                } else {
                    t1.setText(t1.getText() + "cos-1(");
                    inFix = inFix + "c(";
                }
                isShiftPress = false;
                bsetText(2);
            }
            isOppress = true;
            isTrigpress = true;

        } else if (ae.getSource() == btan) {

            if (!isShiftPress) {

                if (!t1.getText().isEmpty()) {
                    if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                        t1.setText(t1.getText() + "*tan(");
                        inFix = inFix + "*T(";
                    } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                        t1.setText(t1.getText() + "tan(");
                        inFix = inFix + "T(";
                    }
                } else {
                    t1.setText(t1.getText() + "tan(");
                    inFix = inFix + "T(";
                }

            } else {
                if (!t1.getText().isEmpty()) {
                    if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                        t1.setText(t1.getText() + "*tan-1(");
                        inFix = inFix + "*t(";
                    } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                        t1.setText(t1.getText() + "tan-1(");
                        inFix = inFix + "t(";
                    }
                } else {
                    t1.setText(t1.getText() + "tan-1(");
                    inFix = inFix + "t(";
                }
                isShiftPress = false;
                bsetText(2);
            }
            isOppress = true;
            isTrigpress = true;

        } else if (ae.getSource() == bpow) {

            if (t1.getText().endsWith(")") || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                t1.setText(t1.getText() + "^(");
                inFix = inFix + "^(";
            }
            isOppress = true;

        } else if (ae.getSource() == brace1) {

            if (t1.getText().isEmpty()) {
                t1.setText(t1.getText() + "(");
                inFix = inFix + "(";
            } else if (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57) {
                t1.setText(t1.getText() + "*(");
                inFix = inFix + "*(";
            } else {
                t1.setText(t1.getText() + "(");
                inFix = inFix + "(";
            }

            isOppress = true;

        } else if (ae.getSource() == brace2) {

            if (!isOppress) {
                t1.setText(t1.getText() + ")");
                inFix = inFix + ")";
            }

        } else if (ae.getSource() == bshift) {

            bsetText(isShifted);
            if (isShifted == 2) {
                isShiftPress = true;
            } else {
                isShiftPress = false;
            }

        } else if (ae.getSource() == bpi) {
            int l = t1.getText().length();
            if (!t1.getText().isEmpty() && t1.getText().charAt(l - 1) == ')') {
                t1.setText(t1.getText() + "*π");
                inFix = inFix + "*π";
            } else {
                t1.setText(t1.getText() + "π");
                inFix = inFix + "π";
            }
            isDotpress = false;
            isOppress = false;
        } else if (ae.getSource() == blog) {

            if (!t1.getText().isEmpty()) {
                if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                    t1.setText(t1.getText() + "*log(");
                    inFix = inFix + "*L(";
                } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                    t1.setText(t1.getText() + "log(");
                    inFix = inFix + "L(";
                }
            } else {
                t1.setText(t1.getText() + "log(");
                inFix = inFix + "L(";
            }

        } else if (ae.getSource() == bln) {

            if (!t1.getText().isEmpty()) {
                if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                    t1.setText(t1.getText() + "*ln(");
                    inFix = inFix + "*l(";
                } else if (isOp(t1.getText().charAt(t1.getText().length() - 1))) {
                    t1.setText(t1.getText() + "ln(");
                    inFix = inFix + "l(";
                }
            } else {
                t1.setText(t1.getText() + "ln(");
                inFix = inFix + "l(";
            }

        } else if (ae.getSource() == bncr) {

            if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                t1.setText(t1.getText() + "C");
                inFix = inFix + "M";
            }

            isDotpress = false;
            isOppress = true;

        } else if (ae.getSource() == bnpr) {

            if (t1.getText().charAt(t1.getText().length() - 1) == ')' || (t1.getText().charAt(t1.getText().length() - 1) >= 48 && t1.getText().charAt(t1.getText().length() - 1) <= 57)) {
                t1.setText(t1.getText() + "P");
                inFix = inFix + "P";
            }

            isDotpress = false;
            isOppress = true;

        } else if (ae.getSource() == eq) {
            System.out.println("infix now = " + inFix);
            String tt1 = inFix;
            int l = 0;
            if (!t1.getText().isEmpty()) {
                l = inFix.length();
            }

            if (!t1.getText().isEmpty()) {
                StringBuffer postfix = new StringBuffer();
                if ((!isOp(inFix.charAt(l - 1)) && !isDotpress && !ifBraceOpen()) || (isOp(inFix.charAt(l - 1)) && inFix.charAt(l - 1) == ')' && !isDotpress && !ifBraceOpen())) {

                    for (int i = 0; i < l; i++) {
                        if (isOp(tt1.charAt(i))) {
                            postfix.append(' ');
                            postfix.append(tt1.charAt(i));
                            postfix.append(' ');
                        } else {
                            postfix.append(tt1.charAt(i));
                        }

                    }
                    System.out.println("pre infix = " + postfix);
                    postfix.append(' ');
                    reSult = postfix.toString();
                    System.out.println(reSult);
                    InfixToPostfix in = new InfixToPostfix();
                    reSult = in.convert(reSult);
                    System.out.println("infix = " + reSult);
                    StringBuffer post = new StringBuffer("");
                    //post.append(inFix.charAt(0));
                    for (int ii = 0; ii < reSult.length() - 1; ii++) {
                        if (isOp(reSult.charAt(ii)) && isOp(reSult.charAt(ii + 1))) {
                            //System.out.println(inFix.charAt(ii - 1) + " , " + inFix.charAt(ii));
                            post.append(reSult.charAt(ii));
                            post.append(' ');

                        } else {
                            post.append(reSult.charAt(ii));
                        }
                    }
                    post.append(reSult.charAt(reSult.length() - 1));
                    System.out.println(post);
                    reSult = post.toString();
                    System.out.println("infix after = " + reSult);
                    t.setText(EvalPostFix.eval(reSult));

                }
            }

        }

    }

    public static boolean isOp(char x) {
        if (x == '√' || x == '^' || x == '!' || x == 'P' || x == 'M' || x == 'L' || x == 'l' || x == 'T' || x == 'c' || x == 'C' || x == 's' || x == 'S' || x == '/' || x == '+' || x == '*' || x == '-' || x == 't' || x == ')' || x == '(') {
            return true;
        }
        return false;
    }

    public static boolean isOp(String x) {
        if (x.equals("√") || x.equals("^") || x.equals("T") || x.equals("l") || x.equals("L") || x.equals("!") || x.equals("P") || x.equals("M") || x.equals("c") || x.equals("C") || x.equals("s") || x.equals("S") || x.equals("/") || x.equals("+") || x.equals("*") || x.equals("-") || x.equals("t") || x.equals(")") || x.equals("(")) {
            return true;
        }
        return false;
    }

    boolean ifBraceOpen() {
        String ss = inFix;
        int l = inFix.length();
        for (int i = 0; i < l; i++) {
            if (ss.charAt(i) == '(') {
                Brace.add(ss.charAt(i));
            } else if (ss.charAt(i) == ')') {
                if (Brace.empty()) {
                    JOptionPane.showMessageDialog(null, "Some Braces Are Open...", "Open Braces..", JOptionPane.OK_OPTION, null);
                    return true;
                } else {
                    Brace.pop();
                }
            }
        }
        if (Brace.empty()) {
            Brace.clear();
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Some Braces Are Open...", "Open Braces..", JOptionPane.OK_OPTION, null);
            Brace.clear();
            return true;
        }
    }

    boolean ifDotpressd() {
        String s = t1.getText();
        int i = 0, j = 0;
        if (!t1.getText().isEmpty()) {
            for (i = s.length() - 1; i >= 0; i--) {
                if (isOp(s.charAt(i))) {
                    break;
                }
            }
            if (i >= 0) {
                for (j = i; j < s.length(); j++) {
                    if (s.charAt(j) == '.') {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String free[]) {

        JFrame c = new Calculator();
        //c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
        //c.setForeground(Color.CYAN);
        c.setTitle("Calculator");
        c.setSize(350, 350);
        c.setVisible(true);

    }

}
