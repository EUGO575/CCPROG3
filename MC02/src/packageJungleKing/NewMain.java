/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Testing!
        int x = 0;
        int y = 0;
        Land land = new Land(x, y);

        String owner = "Eugo";

        Elephant e = new Elephant(owner, land);

        System.out.println(e.getOwner());
        System.out.println(e.getPosition().getPosX());
        System.out.println(e.getPosition().getPosY());
        System.out.println(e.getStrength());
        System.out.println(e.getPosition().getType());
    }

}
