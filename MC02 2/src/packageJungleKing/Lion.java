/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
public class Lion extends Animal {
    public Lion(String owner, Tile position, Board board) {
        super("Lion", owner, position, board);
        super.setStrength(7);
    }

    @Override
    public boolean isValidMove(Tile targetPosition) {
        // Boundary check (7 rows x 9 columns)
        if (targetPosition.getPosX() < 0 || targetPosition.getPosX() >= 7 || 
            targetPosition.getPosY() < 0 || targetPosition.getPosY() >= 9) {
            return false;
        }

        // Can't move to swamp tiles
        if (targetPosition.getType().equals("Swamp")) return false;

        int dx = targetPosition.getPosX() - this.position.getPosX();
        int dy = targetPosition.getPosY() - this.position.getPosY();
        int absDx = Math.abs(dx);
        int absDy = Math.abs(dy);

        // Check normal adjacent move
        if ((absDx == 1 && dy == 0) || (absDy == 1 && dx == 0)) {
            return validateNormalMove(targetPosition);
        }

        // Check lake crossing (must move in straight line over swamp)
        if ((absDx > 0 && dy != 0) || (absDy > 0 && dx != 0)) return false;

        int stepX = Integer.signum(dx);
        int stepY = Integer.signum(dy);
        
        // Check intermediate swamp tiles
        int currentX = position.getPosX() + stepX;
        int currentY = position.getPosY() + stepY;
        boolean foundSwamp = false;

        while (currentX != targetPosition.getPosX() || currentY != targetPosition.getPosY()) {
            Tile currentTile = board.getTiles()[currentX][currentY];
            
            // Must be continuous swamp tiles
            if (!currentTile.getType().equals("Swamp")) return false;
            foundSwamp = true;

            // Check for blocking rat
            if (currentTile.getAnimal() != null && 
                currentTile.getAnimal().getSpecies().equals("Rat")) {
                return false;
            }

            currentX += stepX;
            currentY += stepY;
        }

        // Must cross at least 1 swamp tile and land on valid terrain
        return foundSwamp && validateNormalMove(targetPosition);
    }

    private boolean validateNormalMove(Tile targetPosition) {
        if (targetPosition.getAnimal() != null) {
            return isValidCapture(targetPosition.getAnimal());
        }
        return true;
    }
}
