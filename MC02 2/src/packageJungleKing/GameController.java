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
    }

    public void createBoard () {
        Board board = new Board();

        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 9; col++) {
                
            }
        }

    }


}
