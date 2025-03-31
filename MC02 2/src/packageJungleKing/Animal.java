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

    protected String species;
    protected String owner;
    protected Tile position;
    protected int strength;
    protected boolean isCaptured;
    protected Board board;

    public Animal(String species, String owner, Tile position, Board board) {
        this.species = species;
        this.owner = owner;
        this.position = position;
        this.isCaptured = false;
        this.board = board;
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

    public String getSpecies() {
        return this.species;
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
        // First check if this animal is currently in a trap - if so, can't move at all
        if (this.getPosition().getType().equals("Trap") && !((Trap)this.getPosition()).getOwner().equals(this.getOwner())) {
            return false;  // Completely immobilized in trap
        }
        

        // Normal boundary checks
        if (targetPosition.getPosX() < 0 || targetPosition.getPosX() >= 7
                || targetPosition.getPosY() < 0 || targetPosition.getPosY() >= 9) {
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

        // Allow moving into opponent's trap (will be immobilized next turn)
        return true;
    }

    public boolean isValidCapture(Animal target) {
        // Can't capture your own team
        if (target.getOwner().equals(this.owner)) {
            return false;
        }

        // Special capture rules for traps:
        // If target is in a trap, can capture regardless of strength
        if (target.getPosition().getType().equals("Trap") && !(target.getOwner().equals(this.owner))) {
            return true;
        }

        // Normal capture rules
        return this.strength >= target.getStrength();
    }
}
