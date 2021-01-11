/*
 */
package ch.bbbaden.games;

import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 *
 * @author flori
 */
public class LibBasicsEvents {

    private final WSwingConsoleInterface csi;

    public LibBasicsEvents() {
        csi = new WSwingConsoleInterface("BBB-Game");
        System.out.println("X-Dimension: " + csi.getXdim());
        System.out.println("Y-Dimension: " + csi.getYdim());
    }

    public void run() {
        int playerX = 0;
        int playerNextX = 0;
        int playerY = 0;
        int playerNextY = 0;
        int anzahlZuege = 0;
        // Draw static part
        setupGameBoard();
        boolean exit = false;
        while (!exit) {
            // Draw game board
            csi.restore();
            
            // Draw dynamic part    
            csi.print(0, 0, Integer.toString(anzahlZuege), CSIColor.AQUA);
            csi.print(playerX, playerY, "@", CSIColor.ATOMIC_TANGERINE);
            // Push to screen
            csi.refresh();

            // Wait for key
            int key = csi.inkey().code;
            switch (key) {
                case CharKey.UARROW:
                    playerNextY = playerY - 1;
                    break;
                case CharKey.DARROW:
                    playerNextY = playerY + 1;
                    break;
                case CharKey.LARROW:
                    playerNextX = playerX - 1;
                    break;
                case CharKey.RARROW:
                    playerNextX = playerX + 1;
                    break;
                case CharKey.Q:
                case CharKey.q:
                    exit = true;
            }
            System.out.println("X: " + playerNextX);
            System.out.println("Y: " + playerNextY);

            switch (playerNextX) {
                case -1:
                    playerNextX = playerX;
                    break;
                case 79:
                    playerNextX = playerX;
                    break;
                default:
                    playerNextX = playerNextX;
                    anzahlZuege++;
                    break;
            }
            switch (playerNextY) {
                case -1:
                    playerNextY = playerY;
                    break;
                case 24:
                    playerNextY = playerY;
                    break;
                default:
                    anzahlZuege++;
                    playerNextY = playerNextY;
                    break;
            }
            if (csi.peekChar(playerNextX, playerNextY) == '#') {
                playerNextX = playerX;
                playerNextY = playerY;
                System.out.println("OHOH Objekt im Weg!");
                anzahlZuege--;
            }
            playerX = playerNextX;
            playerY = playerNextY;
            anzahlZuege = anzahlZuege - 1;
        }
        csi.print(1, 20, "Press space to exit");
        csi.refresh();
        csi.waitKey(CharKey.SPACE);
        System.exit(0);
    }

    private void setupGameBoard() {
        csi.cls();
        csi.print(5, 5, "Welcome to TEH game!", CSIColor.BABY_BLUE);
        csi.print(10, 9, "##############", CSIColor.LIGHT_GRAY);
        csi.print(10, 10, "#  #         #", CSIColor.LIGHT_GRAY);
        csi.print(10, 11, "#  ####      #", CSIColor.LIGHT_GRAY);
        csi.print(10, 12, "#      #     #", CSIColor.LIGHT_GRAY);
        csi.print(10, 13, "#       #    #", CSIColor.LIGHT_GRAY);
        csi.print(10, 14, "#   ######   #", CSIColor.LIGHT_GRAY);
        csi.saveBuffer();
    }
    
    private void setupGameObjects(){
        
    }

}
