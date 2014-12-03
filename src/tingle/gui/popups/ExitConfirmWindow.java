/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui.popups;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import tingle.gui.Tingle;

/**
 *
 * @author Kevin
 */
public class ExitConfirmWindow extends JDialog {
    public ExitConfirmWindow(JFrame frame) {
        super(frame, "Tingle Map Editor", true);
        setLayout(new FlowLayout());
        
        //Find out why this doesn't allow the window to pop up...
        //add(new JLabel("Do you want to save changes to \"" + Tingle.myTingleDataManager.getMapFile().getName() + "\"?"));
      
        add(new JButton("Save"));
        add(new JButton("Don't Save"));
        add(new JButton("Cancel"));
    }
}
