/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import static java.lang.Double.NaN;
import java.math.BigDecimal;
import java.util.Stack;

/**
 *
 * @author USER
 */
public class EvalPostFix {

    static Stack<String> Oprnds = new Stack<String>();
    static String exp[];

    public static String eval(String ss) {
        exp = ss.split(" ");

        int l = exp.length, i = 0;
        //System.out.print("e");
        while (i < l) {
            if (Calculator.isOp(exp[i])) {
//                for (int ii = 0; ii <Oprnds.size(); ii++) {
//                    System.out.println(ii+Oprnds.peek());
//                }
                if (exp[i].equals("+")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d2 = Double.valueOf(opd);
                        } else {
                            d2 = Math.PI;
                        }
                    }
                    //System.out.println("op= "+exp[i]);
                    d1 = d1 + d2;
                    if (Double.isNaN(d1) || Double.isNaN(d2)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("-")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d2 = Double.valueOf(opd);
                        } else {
                            d2 = Math.PI;
                        }
                    }
                    //System.out.println("op= "+exp[i]);
                    d1 = d2 - d1;
                    if (Double.isNaN(d1) || Double.isNaN(d2)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("*")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d2 = Double.valueOf(opd);
                        } else {
                            d2 = Math.PI;
                        }
                    }
                    d1 = d2 * d1;
                    if (Double.isNaN(d1) || Double.isNaN(d2)) {
                        return "~";
                    }
                    System.out.println(d1);
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("/")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d2 = Double.valueOf(opd);
                        } else {
                            d2 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    if (d1 == 0.0) {
                        return "~";
                    }
                    d1 = d2 / d1;
                    if (Double.isNaN(d1) || Double.isNaN(d2)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("^")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d2 = Double.valueOf(opd);
                        } else {
                            d2 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.pow(d2, d1);
                    if (Double.isNaN(d1) || Double.isNaN(d2)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("√")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.sqrt(d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("S")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.sin(d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("C")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.cos(d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("T")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.tan(d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("L")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.log10(d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("l")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.log(d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("s")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println("asin ("+d1 + ") " );
                    d1 = Math.asin(d1);
                    //System.out.println(" after asin ="+d1 + " "+Double.NaN );
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    d1 = (180 * d1) / Math.PI;
                    System.out.println(" after asin =" + d1 + " ");
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("c")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.acos(d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    d1 = (180 * d1) / Math.PI;
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("t")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    //System.out.println(d1 + " " + d2 + " " + (d1 / d2));
                    d1 = Math.atan(d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    d1 = (180 * d1) / Math.PI;
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("P")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d2 = Double.valueOf(opd);
                        } else {
                            d2 = Math.PI;
                        }
                    }
                    
                    d1 = nPr(d2,d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                } else if (exp[i].equals("M")) {
                    double d1 = 0;
                    double d2 = 0;
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d1 = Double.valueOf(opd);
                        } else {
                            d1 = Math.PI;
                        }
                    }
                    if (!Oprnds.isEmpty()) {
                        String opd = Oprnds.pop();
                        if (!opd.equals("π")) {
                            d2 = Double.valueOf(opd);
                        } else {
                            d2 = Math.PI;
                        }
                    }
                    
                    d1 = nCr(d2,d1);
                    if (Double.isNaN(d1)) {
                        return "~";
                    }
                    Oprnds.push(String.valueOf(d1));

                }
            } else if (exp[i].equals(" ")) {
                //System.out.println("Continue");

            } else {
                //System.out.println("Inserted"+exp[i]);
                if (!exp[i].isEmpty()) {
                    Oprnds.push(exp[i]);
                }
                //System.out.println(Oprnds.peek());
            }
            i++;
        }
        //System.out.println("wtf = "+Oprnds.peek());
        BigDecimal bc = new BigDecimal(Oprnds.peek()).setScale(3, 4);
        return bc.toString();
    }
    public static double factorial(double n) {
        //1
        double fact = 1;
        //2
        for (double i = 1; i <= n; i++) {
            //3
            fact = fact * i;
        }
        //4
        return fact;
    }
    public static double nCr(double n, double r)
    {
        double ncr = (factorial(n) / (factorial(n - r) * factorial(r)));
        
        return ncr;
    }
    public static double nPr(double n, double r)
    {
        double npr = (factorial(n) / (factorial(n - r) ));
        
        return npr;
    }

}
