/*
 */
package ch.bbbaden.games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.slashie.libjcsi.CSIColor;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;

/**
 *
 * @author flori
 */
public class LibBasicsEvents {

    private final WSwingConsoleInterface csi;
    private final List<GameObject> gameobjects = new ArrayList<>();     //List for Gameobjects zb. Zombie, Person...
    Random rand = new Random();
    Player player = new Player(0, 0);
    
    public LibBasicsEvents() {
        csi = new WSwingConsoleInterface("BBB-Game");
        System.out.println("X-Dimension: " + csi.getXdim());
        System.out.println("Y-Dimension: " + csi.getYdim());
    }

    public void run() {
        boolean isdead = false;
        int health = 0;
        // Draw static part
        setupGameBoard();
        setupGameObjects();
        boolean exit = false;
        while (!isdead) {
            // Draw game board
            csi.restore();

            for (GameObject gm : gameobjects) {
                gm.update(csi, (Player) gameobjects.get(0));
                csi.print(gm.getX(), gm.getY(), gm.getDrawString(), gm.getColor());

            }
            // Draw dynamic part    
            csi.print(0, 0,"Health:"+ Integer.toString(player.getHealth()), CSIColor.WHITE);

            // Push to screen
            csi.refresh();

            // Wait for key
            int key = csi.inkey().code;
            Player player = (Player) gameobjects.get(0);
            player.action(key, csi);
            gameobjects.set(0, player);
            
            
            
            if (player.getHealth()<=0) {
                isdead=true;
            }

        }
        csi.print(1, 20, "YOU LOST! Press space to exit");
        csi.refresh();
        csi.waitKey(CharKey.SPACE);
        System.exit(0);
    }

    private void setupGameBoard() {
        csi.cls();
        csi.saveBuffer();
    }

    private void setupGameObjects() {

        //Add Player
        
        System.out.println("x: " + player.getX() + "  y: " + player.getY());
        gameobjects.add(player);

        //Add Medkits
       for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            int random = rand.nextInt(79);
            int randomtwo = rand.nextInt(25);
            gameobjects.add(new Medikit(random, randomtwo));
            
        }
        
        

        //Add Traps
        for (int i = 0; i < 50; i++) {
            Random rand = new Random();
            int random = rand.nextInt(79);
            int randomtwo = rand.nextInt(25);
            gameobjects.add(new Trap(random, randomtwo));
            
        }
        
        //Add Zombies
        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            int random = rand.nextInt(79);
            int randomtwo = rand.nextInt(25);
            gameobjects.add(new Zombie(random, randomtwo));
            
        }
    }

}
