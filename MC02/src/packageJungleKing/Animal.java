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

    public Animal(String owner, Tile position) {
        this.owner = owner;
        this.position = position;
    }
    
    public void setStrength(int strength) {
        this.strength = strength;
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

    // TO DO
    public boolean isValidPosition(Tile position) {
        return true;
    }

    public boolean isValidCapture(Animal target) {
        return this.strength >= target.getStrength();
    }
}
