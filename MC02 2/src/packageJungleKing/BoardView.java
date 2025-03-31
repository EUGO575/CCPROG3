package packageJungleKing;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*;

public class BoardView extends JFrame {
    
    private final int rows = 7;
    private final int cols = 9;
    private JButton[][] boardButtons;

    public BoardView() {

    setTitle("Jungle King"); //Title of frame
    setVisible(true); //Set frame to true
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked
    setResizable(true); // Set resizable t or f
    setSize(900,700); // Set frame size , x by y
    setLayout(new BorderLayout());
    ImageIcon image = new ImageIcon("src/images/logo.png"); // create image icon
    this.setIconImage(image.getImage()); // create icon of frame

    JPanel boardPanel = new JPanel(new GridLayout(rows, cols));
        boardButtons = new JButton[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boardButtons[i][j] = new JButton();
                boardButtons[i][j].setPreferredSize(new Dimension(80, 80));
                boardButtons[i][j].setBackground(Color.LIGHT_GRAY);
                boardButtons[i][j].setOpaque(true);
                boardButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boardPanel.add(boardButtons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);
    }

    //gameBoard.placeIcon(target Tile, "src/images/elephant.png");

    // Method to place an animal piece with an image
    public void placeIcon(Tile position, String imagePath) {
        java.net.URL imgURL = getClass().getResource("/images/" + imagePath);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            boardButtons[position.getPosX()][position.getPosY()].setIcon(icon);
        } else {
            System.err.println("Image not found: " + imagePath);
        }
    }
    

    public String getImageName(Animal animal) {
        char owner = animal.getOwner().charAt(animal.getOwner().length() - 1); // 1 or 2
        String imagePath = "" + animal.getSpecies() + owner + ".png";
        return imagePath;
    }
    
    
}