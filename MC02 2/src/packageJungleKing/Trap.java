/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
public class Trap extends Tile {

    private String owner;

    public Trap(int posX, int posY, String owner) {
        super(posX, posY);
        this.owner = owner;
        super.setType("Trap");
    }
    
    public String getOwner() {
        return this.owner;
    }
}
