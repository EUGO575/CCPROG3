/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
public class Dog extends Animal {

    public Dog(String owner, Tile position, Board board) {
        super("Dog", owner, position, board);
        super.setStrength(3);
    }
}
