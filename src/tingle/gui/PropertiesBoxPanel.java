/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author Kevin
 */
public class PropertiesBoxPanel extends JPanel {
    private final ArrayList<JCheckBox> boxes;
    
    public PropertiesBoxPanel() {
        boxes = new ArrayList<>();
                
        for (int i = 0; i < 10; i++) {
            JCheckBox temp = new JCheckBox();
            temp.setText(getCheckBoxTitle(i));
            
            if (i % 2 == 0)
                temp.setBounds(new Rectangle(25, (i * 20) + 20, 125, 20));
            else
                temp.setBounds(new Rectangle(150, ((i - 1) * 20) + 20, 125, 20));
            
            boxes.add(temp);            
            add(temp);
        }                                
    }
    
    private String getCheckBoxTitle(int number) {
        switch (number) {
            case 0:
                return "PROP_1";
            case 1:
                return "PROP_2";
            case 2:
                return "PROP_3";
            case 3:
                return "PROP_4";
            case 4:
                return "PROP_5";
            case 5:
                return "PROP_6";
            case 6:
                return "PROP_7";
            case 7:           
                return "PROP_8";
            case 8:
                return "PROP_9";
            case 9:
                return "PROP_10";
            default:
                return "NOT AVAILABLE";
        }       
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
