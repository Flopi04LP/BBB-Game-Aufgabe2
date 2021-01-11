/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 *
 * @author flori
 */
public class Trap implements GameObject {

    private int x;
    private int y;
    private final String drawstring = "X";
    private boolean isdead = false;
    private CSIColor csicolortrap = CSIColor.AQUA;
    
    public Trap(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(WSwingConsoleInterface csi, Player player) {

    }

    @Override
    public String getDrawString() {
        return drawstring;
    }

    @Override
    public boolean isDead() {
        return isdead;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public CSIColor getColor() {
        return csicolortrap;
    }

}
