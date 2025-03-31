package packageJungleKing;

public class GameModel {

    public GameModel() {
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
