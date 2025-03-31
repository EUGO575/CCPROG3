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
    private JPanel boardPanel;

    public BoardView() {
        setTitle("Jungle King");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(900, 700);
        setLayout(new BorderLayout());
        ImageIcon image = new ImageIcon("src/images/logo.png");
        this.setIconImage(image.getImage());

        boardPanel = new JPanel(new GridLayout(rows, cols));
        boardButtons = new JButton[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boardButtons[i][j] = new JButton();
                // Set action command to track position
                boardButtons[i][j].setActionCommand(i + "," + j); // FIXED HERE
                boardButtons[i][j].setPreferredSize(new Dimension(80, 80));
                boardButtons[i][j].setBackground(Color.LIGHT_GRAY);
                boardButtons[i][j].setOpaque(true);
                boardButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boardPanel.add(boardButtons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);
    }

    public void placeIcon(Tile position, String imagePath) {
        java.net.URL imgURL = getClass().getResource("/images/" + imagePath);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(new ImageIcon(imgURL).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));
            boardButtons[position.getPosX()][position.getPosY()].setIcon(icon);
        } else {
            System.err.println("Image not found: " + imagePath);
        }
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }
}