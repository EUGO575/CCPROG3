/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packageJungleKing.Model;

/**
 *
 * @author peter parker
 */
abstract class Tile {

    protected int posX;
    protected int posY;
    protected String type;

    public Tile(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public void setType(String type) {
        this.type = type;
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
}
