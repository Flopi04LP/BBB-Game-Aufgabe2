/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games;

import java.util.Random;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 *
 * @author flori
 */
public class Zombie implements GameObject {

    private int x;
    private int y;
    private final String drawstring = "Z";
    private boolean isdead = false;
    private CSIColor csicolorzombie = CSIColor.RED_PIGMENT;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(WSwingConsoleInterface csi, Player player) {
        getX();
        getY();
    }

    @Override
    public String getDrawString() {
        return drawstring;
    }

    @Override
    public boolean isDead() {
        return false;
    }

    @Override
    public int getX() {
        /*Random rand = new Random();
        int randomX = rand.nextInt(2);
        
        switch (randomX) {
            case 1:
                x= x - 1;
                break;
            case 2:
                x = x + 1;
                break;
        }*/
        return x;
    }

    @Override
    public int getY() {
        /*Random rand = new Random();
        int randomY = rand.nextInt(2);
        
        switch (randomY) {
            case CharKey.UARROW:
                y= y - 1;
                break;
            case CharKey.DARROW:
                y = y + 1;
                break;
        }*/
        return y;
    }

    @Override
    public CSIColor getColor() {
        return csicolorzombie;
    }

}
