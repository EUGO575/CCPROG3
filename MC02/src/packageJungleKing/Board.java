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
    private ArrayList<Animal> freeList;
    private ArrayList<Animal> capturedList;
    private String owner1;
    private String owner2;

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
        Animal E1 = new Elephant(owner1, tiles[0][2]);
        Animal L1 = new Lion(owner1, tiles[6][0]);
        Animal T1 = new Tiger(owner1, tiles[0][0]);
        Animal P1 = new Leopard(owner1, tiles[4][2]);
        Animal W1 = new Wolf(owner1, tiles[2][2]);
        Animal D1 = new Dog(owner1, tiles[5][1]);
        Animal C1 = new Cat(owner1, tiles[1][1]);
        Animal R1 = new Rat(owner1, tiles[6][2]);
        
        freeList.add(E1);
        freeList.add(L1);
        freeList.add(T1);
        freeList.add(P1);
        freeList.add(W1);
        freeList.add(D1);
        freeList.add(C1);
        freeList.add(R1);
        
        // Owner 2:
        Animal E2 = new Elephant(owner2, tiles[6][6]);
        Animal L2 = new Lion(owner1, tiles[0][8]);
        Animal T2 = new Tiger(owner1, tiles[6][8]);
        Animal P2 = new Leopard(owner1, tiles[2][6]);
        Animal W2 = new Wolf(owner1, tiles[4][6]);
        Animal D2 = new Dog(owner1, tiles[1][7]);
        Animal C2 = new Cat(owner1, tiles[5][7]);
        Animal R2 = new Rat(owner1, tiles[0][6]);
        
        freeList.add(E2);
        freeList.add(L2);
        freeList.add(T2);
        freeList.add(P2);
        freeList.add(W2);
        freeList.add(D2);
        freeList.add(C2);
        freeList.add(R2);
        
        
    }
    
}

