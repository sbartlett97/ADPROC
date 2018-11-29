/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexboxordersystem;

/**
 *
 * @author up777815, up831038, up877101, up867692
 */

import javax.swing.JFrame;

public class Main 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        UserInterface userInterface = new UserInterface();
        userInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userInterface.setSize(720, 480);
        userInterface.setVisible(true);
    }
}
