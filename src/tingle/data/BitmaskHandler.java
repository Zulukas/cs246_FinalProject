/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tingle.data;

import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class BitmaskHandler {
    private int mask;
    private Boolean hasBeenDecoded;
    private ArrayList<Boolean> decodedMask;
    
    /**
     * Create an empty BitmaskHandler object
     */
    public BitmaskHandler() {
        mask = 0;
        hasBeenDecoded = false;
        decodedMask = new ArrayList<>();
    }
    
    /**
     * Create a BitmaskHandler from a passed in mask
     * @param mask 
     */
    public BitmaskHandler(int mask) {
        this.mask = mask;
        hasBeenDecoded = false;
        decodeProperties();        
    }
       
    /**
     * Creates a BitmaskHandler from a passed in list of Booleans.
     * @param decodedMask 
     */
    public BitmaskHandler(ArrayList<Boolean> decodedMask) {
        this.decodedMask = decodedMask;
        hasBeenDecoded = true;
        
        if (decodedMask.size() < 31) {
            for (int i = decodedMask.size(); i < 32; i++) {
                decodedMask.add(false);
            }
        }
        
        encodeProperties();
    }
    
    /**
     * 
     * @return 
     */
    public int getMask() {
        return mask;
    }
    
    /**
     * Set the mask of the BitmaskHandler; automatically decodes the properties
     * @param mask 
     */
    public void setMask(int mask) {
        this.mask = mask;
        hasBeenDecoded = false;
        decodeProperties();
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<Boolean> getDecodedMask() {
        return decodedMask;
    }
    
    /**
     * Set the decoded mask of the BitmaskHandler; automatically encodes the mask
     * @param decodedMask 
     */
    public void setDecodedMask(ArrayList<Boolean> decodedMask) {
        this.decodedMask = new ArrayList<>();
        mask = encodeProperties();
    }
    
    /**
     * encodes the ArrayList of Booleans held by the BitmaskHandler and returns
     * the encoded mask.
     * 
     * @return 
     */
    private int encodeProperties() {
        mask = 0;  //Reset mask              
        int i = 30; //Initialize a down counter
        
        //Encode the properties...
        for (Boolean item : decodedMask) {
            if (item) { //If the item is true...
                int power = power(2, i);    //Get the bit value...               
                mask += power;  //Add it on
            }
            
            i--;
        }     
        
        return mask;
    }
    
    /**
     * decodes the mask of the Bitmask Handler into an ArrayList of Booleans.  
     * List is sorted in terms of most significant bit (as in bit 31 is at the front
     * and bit 1 is at the back
     * 
     * @return ArrayList of Booleans
     */
    private ArrayList<Boolean> decodeProperties() {
        if (hasBeenDecoded == false) { //If this mask has not been decoded 
            decodedMask = new ArrayList<>(); //Initialize a new list    

            for (int i = 30; i >= 0; i--) { //Decode the mask
                int power = power(2, i);    //Grab the bit value
                
                if ((mask & power) != 0) { //Add on true or false appropriately
                    decodedMask.add(true);
                } else {
                    decodedMask.add(false);
                }
            }

            hasBeenDecoded = true; //Set the flag
            return decodedMask;    
        } else {
            return decodedMask;
        }
        
    }
    
    private int power(int number, int exp) {
        int result = 1;       
                
        for (int i = 1; i <= exp; i++) {
            result *= number;
        }
        
        return result;
    }
        
}
