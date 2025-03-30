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

    public boolean isValidMove(Tile targetPosition) {
        // Check bounds
        if (targetPosition.getPosX() < 0 || targetPosition.getPosX() > 8 ||
                targetPosition.getPosY() < 0 || targetPosition.getPosY() > 6) {
            return false;
        }

        // Normal animals can't move to swamp tiles
        if (targetPosition.getType().equals("Swamp")) {
            return false;
        }

        // Check adjacent movement (1 tile in any direction)
        int dx = Math.abs(targetPosition.getPosX() - this.position.getPosX());
        int dy = Math.abs(targetPosition.getPosY() - this.position.getPosY());
        if ((dx + dy) != 1) {
            return false;
        }

        // Check capture validity if target has animal
        if (targetPosition.getAnimal() != null) {
            return isValidCapture(targetPosition.getAnimal());
        }

        return true;
    }

    public boolean isValidCapture(Animal target) {
        // Can't capture your own team
        if (targetAnimal.getOwner().equals(this.owner)) {
            return false;
        }
        return this.strength >= target.getStrength();
    }
}
