/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui;

import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Kevin
 */
public class PropertiesBox {
    private JLabel label;
    private ArrayList<JCheckBox> boxes;
    private JPanel panel;
    private JScrollPane scrollPane;
    
    public PropertiesBox () {
        label = new JLabel("Properties");
        boxes = new ArrayList<>();
        panel = new JPanel();
        scrollPane = new JScrollPane();
        
        
        for (int i = 0; i < 10; i++) {
            JCheckBox temp = new JCheckBox();
            temp.setText(getCheckBoxTitle(i));
            
            if (i % 2 == 0)
                temp.setBounds(new Rectangle(25, (i * 20) + 20, 125, 20));
            else
                temp.setBounds(new Rectangle(150, ((i - 1) * 20) + 20, 125, 20));
            
            boxes.add(temp);
            panel.add(temp);
            scrollPane.add(temp);
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

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the boxes
     */
    public ArrayList<JCheckBox> getBoxes() {
        return boxes;
    }

    /**
     * @param boxes the boxes to set
     */
    public void setBoxes(ArrayList<JCheckBox> boxes) {
        this.boxes = boxes;
    }

    /**
     * @return the panel
     */
    public JPanel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    /**
     * @return the scrollPane
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * @param scrollPane the scrollPane to set
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
    
}
