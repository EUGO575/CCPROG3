/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing.Model;

/**
 *
 * @author peter parker
 */
public class Dog extends Animal {

    public Dog(String owner, Tile position) {
        super(owner, position);
        super.setStrength(3);
    }
}
