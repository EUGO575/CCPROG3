package packageJungleKing;

public class GameModel {

    public GameModel() {
    }

    public void movePiece(Animal animal, Tile target) {
        Tile source = animal.getPosition();
        source.setAnimal(null); // Clear source tile
        target.setAnimal(animal);
        animal.setPosition(target);
    }

    public void capture(Animal animal, Tile target) {
        target.getAnimal().setCaptured(true);
        target.getAnimal().setPosition(null);
    }

}
