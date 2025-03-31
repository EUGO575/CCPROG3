package packageJungleKing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class GameController {
    private Board board;
    private GameModel gameModel;
    private BoardView boardView;
    private int playerTurn;
    private ActionListener actionListener;
    private boolean isPieceSelected = false;
    private Animal selectedAnimal = null;
    private Tile selectedTile = null;

    public GameController(Board board, GameModel gameModel, BoardView boardView) {
        this.board = board;
        this.gameModel = gameModel;
        this.boardView = boardView;
        this.playerTurn = 0;
        updateGUI();
        clickTile();
    }

    public void updateGUI() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                Tile tile = board.getTiles()[i][j];
                Animal animal = tile.getAnimal();

                if (animal != null) {
                    char owner = animal.getOwner().charAt(animal.getOwner().length() - 1);
                    String imagePath = animal.getSpecies() + owner + ".png";
                    boardView.placeIcon(tile, imagePath);
                } else if ("Swamp".equals(tile.getType())) {
                    boardView.placeIcon(tile, "Swamp.png");
                } else if ("Trap".equals(tile.getType())) {
                    boardView.placeIcon(tile, "Trap.png");
                } else if ("Base".equals(tile.getType())) {
                    boardView.placeIcon(tile, (tile.getPosX() == 3 && tile.getPosY() == 0) ? "Base1.png" : "Base2.png");
                } else {
                    boardView.placeIcon(tile, "Land.png");
                }
            }
        }
    }

    public void clickTile() {
        actionListener = e -> {
            String command = ((JButton) e.getSource()).getActionCommand();
            // Handle invalid action commands
            if (command == null || command.isEmpty()) {
                System.err.println("Invalid action command!");
                return;
            }

            String[] parts = command.split(",");
            if (parts.length != 2) {
                System.err.println("Invalid command format!");
                return;
            }

            try {
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);
                Tile clickedTile = board.getTiles()[row][col];
                Animal clickedAnimal = clickedTile.getAnimal();

                if (!isPieceSelected) {
                    if (clickedAnimal != null && clickedAnimal.getOwner().equals("owner" + (playerTurn + 1))) {
                        selectedAnimal = clickedAnimal;
                        selectedTile = clickedTile;
                        isPieceSelected = true;
                    }
                } else {
                    if (selectedAnimal.isValidMove(clickedTile)) {
                        if (clickedTile.getAnimal() != null) {
                            gameModel.capture(selectedAnimal, clickedTile);
                        }
                        Tile sourceTile = selectedAnimal.getPosition();
                        gameModel.movePiece(selectedAnimal, clickedTile);
                        sourceTile.setAnimal(null);
                        updateGUI();
                        playerTurn = (playerTurn + 1) % 2;
                    }
                    isPieceSelected = false;
                    selectedAnimal = null;
                    selectedTile = null;
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                System.err.println("Error parsing tile position: " + ex.getMessage());
            }
        };

        JPanel boardPanel = boardView.getBoardPanel();
        for (Component comp : boardPanel.getComponents()) {
            if (comp instanceof JButton) {
                ((JButton) comp).addActionListener(actionListener);
            }
        }
    }
}