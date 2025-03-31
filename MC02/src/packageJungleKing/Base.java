/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
public class Base extends Tile {

    private String owner;
    
    public Base(String owner, int posX, int posY) {
        super(posX, posY);
        super.setType("Base");
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }
}
