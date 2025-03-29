/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
abstract class Animal {

    protected String owner;
    protected Tile position;
    protected int strength;
    protected boolean isCaptured;
    
    public Animal(String owner, Tile position) {
        this.owner = owner;
        this.position = position;
        this.isCaptured = false;
    }
    
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setPosition(Tile position) {
        this.position = position;
    }

    public void setCaptured(boolean isCaptured) {
        this.isCaptured = isCaptured;
    }
    
    public String getOwner() {
        return this.owner;
    }

    public Tile getPosition() {
        return this.position;
    }

    public int getStrength() {
        return this.strength;
    }
    
    public boolean getCapturedStatus() {
        return this.isCaptured;
    }

    // TO DO
    public boolean isValidMove(Tile position) {

        // Check if new coordinates are within bounds
        if (position.getPosX() < 0 || position.getPosX() > 8 || position.getPosY() < 0 || position.getPosY() > 6) {
            System.out.println("Invalid move! Out of bounds.");
            return false;
        }

        // Check if new coordinates is a swamp
        if (position.getType() == "Swamp") {
            System.out.println("Move not allowed! Try again.");
            return false;
        }

         // Validate the move (capture or regular movement)
        if(position.getAnimal() != null) {
            if (isValidCapture(position.getAnimal())) {
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

    public boolean isValidCapture(Animal target) {
        return this.strength >= target.getStrength();
    }
}
