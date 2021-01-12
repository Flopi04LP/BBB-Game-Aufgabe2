/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.games;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 *
 * @author flori
 */
public class Player implements GameObject {

    private int health = 10;
    private int points = 0;
    private int x;
    private int playerNextX = 0;
    private int y;
    private int playerNextY = 0;
    private final String drawstring = "P";
    private boolean isDead = false;
    private CSIColor csicolorplayer = CSIColor.ATOMIC_TANGERINE;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void action(int keyChar, WSwingConsoleInterface csi) {
        switch (keyChar) {
            case CharKey.UARROW:
                playerNextY = y - 1;
                break;
            case CharKey.DARROW:
                playerNextY = y + 1;
                break;
            case CharKey.LARROW:
                playerNextX = x - 1;
                break;
            case CharKey.RARROW:
                playerNextX = x + 1;
                break;
            case CharKey.Q:
                System.exit(0);
                break;
            case CharKey.q:
                System.exit(0);
                break;
        }
        System.out.println("X: " + playerNextX);
        System.out.println("Y: " + playerNextY);

        switch (playerNextX) {
            case -1:
                playerNextX = x;
                break;
            case 79:
                playerNextX = x;
                break;
            default:
                playerNextX = playerNextX;

                break;
        }
        switch (playerNextY) {
            case -1:
                playerNextY = y;
                break;
            case 24:
                playerNextY = y;
                break;
            default:
                playerNextY = playerNextY;
                break;
        }

        if (csi.peekChar(playerNextX, playerNextY) == 'X') {
            System.out.println("OHOH TRAP!");
            health = health - 1;
        }
        if (csi.peekChar(playerNextX, playerNextY) == 'M') {
            System.out.println("Ein Medikit wuhuu!");
            if (health<5) {
                addHealth(5);
            }
            
        }
        if (csi.peekChar(playerNextX, playerNextY) == 'Z') {
            System.out.println("EIN ZOMBIE!");
            health = health - 5;
        }
        x = playerNextX;
        y = playerNextY;

    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int health) {

        this.health = this.health + health;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
    }

    public void update(WSwingConsoleInterface csi, Player player) {

    }

    @Override
    public String getDrawString() {
        return drawstring;
    }

    @Override
    public boolean isDead() {
        return isDead;
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
        return csicolorplayer;
    }

}
