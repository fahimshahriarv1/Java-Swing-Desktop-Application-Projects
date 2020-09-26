/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ShowMsg 
{
    public static void ShowErr(String  ss)
    {
        JOptionPane.showMessageDialog(null, "Out Of Bounds", ss, JOptionPane.OK_OPTION, null);
    }
}
