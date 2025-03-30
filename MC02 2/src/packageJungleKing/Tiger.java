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
    public boolean isValidMove (Tile position) {
        
        // Check if new coordinates are within bounds
        if (position.getPosX() < 0 || position.getPosX() > 8 || position.getPosY() < 0 || position.getPosY() > 6) {
            System.out.println("Invalid move! Out of bounds.");
            return false;
        }

 
        // Check if new coordinates is a swamp
        if (position.getType() == "Swamp") {

            Tile currentTile = position;
            int i = 0;
            String direction;
            int numOfMoves = 0;
            boolean hasRat = false;

            // Get direction
            if(this.position.getPosX() == position.getPosX()) // moving left or right
            {
                if(this.position.getPosY() > position.getPosY()){ // moving left
                    direction = "Left";
                }
                else { // moving right
                    direction = "Right";
                }            
            }
            else {
                if(this.position.getPosX() > position.getPosX()){ // moving up
                    direction = "Up";
                }
                else { // moving down
                    direction = "Down";
                }  

            }

            while(currentTile.getType() == "Swamp") {
                if(direction == "Left")
                {
                    currentTile = tiles[currentTile.getPosX][currentTile.getPosY];
                }

            }
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
}
