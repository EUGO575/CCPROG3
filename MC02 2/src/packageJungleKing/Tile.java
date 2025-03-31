/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing;

/**
 *
 * @author peter parker
 */
abstract class Tile {

    protected int posX;
    protected int posY;
    protected String type;
    protected Animal animal;

    public Tile(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public String getType() {
        return this.type;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}
