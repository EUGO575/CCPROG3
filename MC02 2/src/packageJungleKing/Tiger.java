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

    @Override
    public boolean isValidMove(Tile targetPosition) {
        // Check bounds
        if (targetPosition.getPosX() < 0 || targetPosition.getPosX() > 8 ||
                targetPosition.getPosY() < 0 || targetPosition.getPosY() > 6) {
            return false;
        }

        // Check if moving across lake (Swamp)
        if (targetPosition.getType().equals("Swamp")) {
            return isValidLakeCrossing(targetPosition);
        }

        // Normal move validation
        if (targetPosition.getAnimal() != null) {
            return isValidCapture(targetPosition.getAnimal());
        } else {
            return isAdjacentPosition(targetPosition);
        }
    }

    private boolean isValidLakeCrossing(Tile targetPosition, Board board) {
        // Determine direction of movement
        int dx = Integer.compare(targetPosition.getPosX(), this.position.getPosX());
        int dy = Integer.compare(targetPosition.getPosY(), this.position.getPosY());

        // Must move in straight line (either horizontal or vertical)
        if (dx != 0 && dy != 0) {
            return false; // Diagonal not allowed
        }

        // Check all tiles along the path
        int currentX = this.position.getPosX() + dx;
        int currentY = this.position.getPosY() + dy;

        while (currentX != targetPosition.getPosX() || currentY != targetPosition.getPosY()) {
            Tile currentTile = board.getTiles()[currentY][currentX]; // Assuming board is accessible

            // Must be continuous swamp tiles
            if (!currentTile.getType().equals("Swamp")) {
                return false;
            }

            // Check for blocking rat
            if (currentTile.getAnimal() != null &&
                    currentTile.getAnimal() instanceof Rat) {
                return false;
            }

            currentX += dx;
            currentY += dy;
        }

        // Final landing position must be valid
        if (targetPosition.getAnimal() != null) {
            return isValidCapture(targetPosition.getAnimal());
        }
        return true;
    }

    private boolean isAdjacentPosition(Tile targetPosition) {
        int dx = Math.abs(targetPosition.getPosX() - this.position.getPosX());
        int dy = Math.abs(targetPosition.getPosY() - this.position.getPosY());
        return (dx == 1 && dy == 0) || (dx == 0 && dy == 1);
    }
}
