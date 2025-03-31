package packageJungleKing;

public class GameController {
    
    private Board board;
    private GameModel gameModel;
    private BoardView boardView;
    private int playerTurn;

    public GameController (Board board, GameModel gameModel, BoardView boardView) {
        this.board = board;
        this.gameModel = gameModel;
        this.boardView = boardView;
        this.playerTurn = 0;
        updateGUI();
    }

    //boardView.getImageName(animal)

    public void updateGUI() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {

                Tile tile = board.getTiles()[i][j];
                Animal animal = tile.getAnimal();

                if (animal != null) {
                    
                    char owner = animal.getOwner().charAt(animal.getOwner().length() - 1); // 1 or 2
                    String imagePath = "" + animal.getSpecies() + owner + ".png";
                    boardView.placeIcon(tile, imagePath);

                } else if ("Swamp".equals(tile.getType())) {
                    boardView.placeIcon(tile, "Swamp.png"); 
                } else if ("Trap".equals(tile.getType())) {
                    boardView.placeIcon(tile, "Trap.png"); 
                } else if ("Base".equals(tile.getType())) {
                    if (tile.getPosX() == 3 && tile.getPosY() == 0) {
                        boardView.placeIcon(tile, "Base1.png"); 
                    } else {
                        boardView.placeIcon(tile, "Base2.png"); 
                    }
                } else {
                    boardView.placeIcon(tile, "Land.png"); // A fallback image
                }
            }
        }
    }
    
}
