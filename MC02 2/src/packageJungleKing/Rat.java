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
        super("Rat", owner, position);
        super.setStrength(1);
    }

    @Override
    public boolean isValidMove(Tile targetPosition) {
        // Check bounds
        if (targetPosition.getPosX() < 0 || targetPosition.getPosX() > 8 ||
                targetPosition.getPosY() < 0 || targetPosition.getPosY() > 6) {
            return false;
        }

        // Rats can move 1 tile in any direction (land or water)
        int dx = Math.abs(targetPosition.getPosX() - this.position.getPosX());
        int dy = Math.abs(targetPosition.getPosY() - this.position.getPosY());
        if ((dx + dy) != 1) {
            return false;
        }

        // Check capture validity if target has animal
        if (targetPosition.getAnimal() != null) {
            return isValidCapture(targetPosition.getAnimal());
        }

        // Rats can move to any adjacent tile (land or water)
        return true;
    }

    @Override
    public boolean isValidCapture(Animal target) {
        // Can't capture own pieces
        if (target.getOwner().equals(this.owner)) {
            return false;
        }

        // Special case: Rat can always capture Elephant
        if (target instanceof Elephant) {
            return true;
        }

        // If in water, can only capture/be captured by other water rats
        if (this.getPosition().getType().equals("Swamp")) {
            return target instanceof Rat &&
                    target.getPosition().getType().equals("Swamp") &&
                    super.isValidCapture(target);
        }

        // On land: use normal capture rules
        return super.isValidCapture(target);
    }
}