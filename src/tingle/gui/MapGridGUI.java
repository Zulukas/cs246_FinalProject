/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.gui;

/**
 *
 * @author Dallin
 */
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import tingle.data.Tile;

import tingle.data.TileSet;
import tingle.data.TingleDataManager;

public class MapGridGUI extends JPanel implements MouseListener {

    public static Coordinates coord = new Coordinates();
    TileSet tiles;
    // Create a constructor method
    TingleDataManager dataManager = new TingleDataManager();

    MapGridGUI(TileSet tileSet) {
        super();
        tiles = tileSet;
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);

        for (Tile currentTile : dataManager.getMapTiles()) {
            g.drawImage(currentTile.getImage(), 32, 32, this);
        }

        int counter = 0;
        for (int h = 0; h < dataManager.getMapHeight(); h++) {
            for (int w = 0; w < dataManager.getMapWidth(); w++) {
               // g.drawImage(dataManager.getTile(counter).getImage);//0+(32*w),0 +(32*h), 32,32,this);

                // draw black grid (for some reason it is behind the image)
                // but at least the transparency works
                g.drawRect(w * 64, h * 64, 64, 64);
                //determine where to draw a white rectangle.
                if (coord.xSelected >= 0) {
                    g.setColor(Color.WHITE);
                    g.drawRect(coord.xSelected * 64, coord.ySelected * 64, 64, 64);
                    g.setColor(Color.BLACK);
                    counter++;
                }
            }

        }
    }

    /**
     * Coordinates stores the coordinates for the selected tile.
     *
     */
    public static class Coordinates {

        private static int xSelected;
        private static int ySelected;

        Coordinates() {
            xSelected = -1;
            ySelected = -1;
        }

        public int getx() {
            return xSelected;
        }

        public int gety() {
            return ySelected;
        }

        public void setx(int input) {
            xSelected = input;
        }

        public void sety(int input) {
            ySelected = input;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        // Set the coordinates for the selected tile.
        coord.setx(e.getX() / 64);
        coord.sety(e.getY() / 64);
        System.out.println("There was a click at " + coord.getx() + ", " + coord.gety() + "!");
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("here was a click ! ");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("here was a click ! ");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("here was a click ! ");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("here was a click ! ");
    }
}
