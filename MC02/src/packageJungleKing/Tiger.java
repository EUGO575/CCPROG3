/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
public class Tiger extends Animal {

    public Tiger(String owner, Tile position) {
        super(owner, position);
        super.setStrength(6);
    }
    
    // TO DO
    @Override
    public boolean isValidPosition(Tile position) {
        return true;
    }
}
