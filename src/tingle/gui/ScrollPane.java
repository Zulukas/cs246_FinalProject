/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *
 * @author Kevin
 */
public class ScrollPane {
    JScrollPane scrollPane = new JScrollPane();
    JLabel label = new JLabel();
    
    public ScrollPane() {
        scrollPane.setViewportView(label);
        
    }
}
