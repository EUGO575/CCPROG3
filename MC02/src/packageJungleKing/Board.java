/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;
import java.util.*;

/**
 *
 * @author peter parker
 */
public class Board {

    private Tile[][] tiles;

    public Board(){
        
    }
    
}

// THIS IS MY ATTEMPT I KNOW IT IS VERY WRONG
    // MAYBE U CAN USE THIS AS TEMPLATE
    /*
    private String owner1;
    private String owner2;
    
    private Elephant E1;
    private Lion L1;
    private Tiger T1;
    private Leopard P1;
    private Wolf W1;
    private Dog D1;
    private Cat C1;
    private Rat R1;
    
    private Elephant E2;
    private Lion L2;
    private Tiger T2;
    private Leopard P2;
    private Wolf W2;
    private Dog D2;
    private Cat C2;
    private Rat R2;
   

    public Board() {
        tiles = new Tile[7][9];
        

        // 1. Fill the board with default land tiles.
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 9; col++) {
                tiles[row][col] = new Land(row, col);
            }
        }

        // 2. Set water tiles (using Swamp) in the two river areas.
        // Upper water block: rows 1-2, columns 3-5.
        for (int row = 1; row <= 2; row++) {
            for (int col = 3; col <= 5; col++) {
                tiles[row][col] = new Swamp(row, col);
            }
        }
        // Lower water block: rows 4-5, columns 3-5.
        for (int row = 4; row <= 5; row++) {
            for (int col = 3; col <= 5; col++) {
                tiles[row][col] = new Swamp(row, col);
            }
        }

        // 3. Set traps using the Trap subclass.
        // Left side traps at (2,0), (4,0) and (3,1)
        tiles[2][0] = new Trap(2, 0);
        tiles[4][0] = new Trap(4, 0);
        tiles[3][1] = new Trap(3, 1);

        // Right side traps at (2,8), (4,8) and (3,7)
        tiles[2][8] = new Trap(2, 8);
        tiles[4][8] = new Trap(4, 8);
        tiles[3][7] = new Trap(3, 7);

        // 4. Set bases using the Base subclass.
        // Left base at (3,0) and right base at (3,8).
        tiles[3][0] = new Base(3, 0);
        tiles[3][8] = new Base(3, 8);
        
        // 5. Set animals in their respective positions.
        // Owner 1:
        this.E1 = new Elephant(owner1, tiles[0][2]);
        this.L1 = new Lion(owner1, tiles[6][0]);
        this.T1 = new Tiger(owner1, tiles[0][0]);
        this.P1 = new Leopard(owner1, tiles[4][2]);
        this.W1 = new Wolf(owner1, tiles[2][2]);
        this.D1 = new Dog(owner1, tiles[5][1]);
        this.C1 = new Cat(owner1, tiles[1][1]);
        this.R1 = new Rat(owner1, tiles[6][2]);
        
        // Owner 2:
        this.E2 = new Elephant(owner2, tiles[6][6]);
        this.L2 = new Lion(owner1, tiles[0][8]);
        this.T2 = new Tiger(owner1, tiles[6][8]);
        this.P2 = new Leopard(owner1, tiles[2][6]);
        this.W2 = new Wolf(owner1, tiles[4][6]);
        this.D2 = new Dog(owner1, tiles[1][7]);
        this.C2 = new Cat(owner1, tiles[5][7]);
        this.R2 = new Rat(owner1, tiles[0][6]);
       
    }
    */
