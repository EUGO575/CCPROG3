/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
public class Cat extends Animal {

    public Cat(String owner, Tile position, Board board) {
        super("Cat", owner, position, board);
        super.setStrength(2);
    }
}
