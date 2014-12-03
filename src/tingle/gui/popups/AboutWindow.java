/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui.popups;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Kevin
 */
public class AboutWindow extends JDialog {
    public AboutWindow(JFrame frame) {
        super(frame, "Tingle Map Editor", true);
        setLayout(new FlowLayout());
        
        add(new JLabel("Project Information"));
        add(new JLabel("Dallin Beutler - Tyson Graham - Kevin Andres"));
        add(new JLabel("cs246 - Brother Burton - Brigham Young University-Idaho"));
        add(new JLabel("Fall 2014"));
    }
}
