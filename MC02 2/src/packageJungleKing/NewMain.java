/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package packageJungleKing;
import javax.swing.*;

/**
 *
 * @author peter parker
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Board board = new Board();
            GameModel model = new GameModel();
            BoardView view = new BoardView();
            new GameController(board, model, view); // This triggers clickTile()
        });
    }

}
