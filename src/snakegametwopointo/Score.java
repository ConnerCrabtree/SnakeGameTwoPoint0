/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegametwopointo;

import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author ilovesoccer127
 */
public class Score {
    public void draw(Graphics graphics){
        graphics.drawString("Score: " + value, getPositon().x, getPositon().y);
    }
    
    private int value = 0;
    private Point positon;

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    public void addToValue(int amount){
        this.value += amount;
    }

    /**
     * @return the positon
     */
    public Point getPositon() {
        return positon;
    }

    /**
     * @param positon the positon to set
     */
    public void setPositon(Point positon) {
        this.positon = positon;
    }
}
