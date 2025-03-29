/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing.Model;

/**
 *
 * @author peter parker
 */
public class Rat extends Animal {

    public Rat(String owner, Tile position) {
        super(owner, position);
        super.setStrength(1);
    }
    
    // TO DO
    @Override
    public boolean isValidPosition(Tile position){return true;}

    @Override
    public boolean isValidCapture(Animal target) {
        return target.getStrength() == 8;
    }
}
