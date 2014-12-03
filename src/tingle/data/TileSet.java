/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.data;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Dallin
 */
public class TileSet {
    private BufferedImage image;
    private int tileHeight;
    private int tileWidth;

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public int getTileWidth() {
        return tileWidth;
    }
    
    public TileSet( String fileName){
        tileHeight = 32;
        tileWidth= 32;
        try{
            image = ImageIO.read(new File(fileName));
        } catch (IOException ex) {
            
        }
    }
}