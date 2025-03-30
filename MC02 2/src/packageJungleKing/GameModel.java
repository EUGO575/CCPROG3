package packageJungleKing;

import java.util.Scanner;

public class GameModel {

    private Board board;

    public GameModel(Board board) {
        this.board = board;
    }

    public void movePiece(Animal animal, Tile target) {
        target.setAnimal(animal);
        target.getAnimal().setPosition(target);
    }

    public void capture(Animal animal, Tile target) {
        target.getAnimal().setCaptured(true);
        target.getAnimal().setPosition(null);
    }

}
