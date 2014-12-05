/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import tingle.data.TileSet;

/**
 *
 * @author Kevin Andres
 */
public class ObjectPane extends JPanel{
    public ObjectPane(File file, Boolean isTileSelector) {

        setBorder(new LineBorder(Color.RED));
        setPreferredSize(new Dimension(500, 500));
        
        if (isTileSelector == true)
            add(new TileSelector(new TileSet(file.getPath())));
        else
            add(new MapGridGUI(new TileSet(file.getPath())));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        
    }
}
