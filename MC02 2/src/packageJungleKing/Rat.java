/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

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
    public boolean isValidMove(Tile position) {

        // Check if new coordinates are within bounds
        if (position.getPosX() < 0 || position.getPosX() > 8 || position.getPosY() < 0 || position.getPosY() > 6) {
            System.out.println("Invalid move! Out of bounds.");
            return false;
        }

         // Validate the move (capture or regular movement)
        if(position.getAnimal() != null) {
            if (isValidCapture(position.getAnimal()) && this.position.getType() != "Swamp" || position.getAnimal().getStrength() == this.getStrength() && position.getType() == this.position.getType()) {
                return true;
            } else {
                System.out.println("Move not allowed! Try again.");
                return false;
            }
        } else { //If target position is adjacent
            if (position.getPosX() == this.position.getPosX() - 1 && position.getPosY() == this.position.getPosY() ||
                position.getPosX() == this.position.getPosX() + 1 && position.getPosY() == this.position.getPosY() ||
                position.getPosX() == this.position.getPosX() && position.getPosY() == this.position.getPosY() + 1 ||
                position.getPosX() == this.position.getPosX() && position.getPosY() == this.position.getPosY() - 1) {
                return true;
            }
            else {
                System.out.println("Move not allowed! Try again.");
                return false;
            }
        }
    }

    @Override
    public boolean isValidCapture(Animal target) {
        return target.getStrength() == 8;
    }
}
