package packageJungleKing;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardView extends JFrame {
    private final int rows = 7;
    private final int cols = 9;
    private JButton[][] boardButtons;
    private JPanel boardPanel;
    private JLabel statusLabel; // CLASS-LEVEL STATUS LABEL
    private JLabel captureLabel; // CLASS-LEVEL STATUS LABEL
    private String[] animalTypes = {"Tiger", "Lion", "Wolf", "Dog", "Leopard", "Elephant", "Cat", "Rat"};
    private String player1Choice = null;
    private String player2Choice = null;

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
                boardButtons[i][j].setActionCommand(i + "," + j);
                boardButtons[i][j].setPreferredSize(new Dimension(80, 80));
                boardButtons[i][j].setBackground(Color.LIGHT_GRAY);
                boardButtons[i][j].setOpaque(true);
                boardButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boardPanel.add(boardButtons[i][j]);
            }
        }

        add(boardPanel, BorderLayout.CENTER);

         // Create a status panel for messages
        JPanel statusPanel = new JPanel();
        statusPanel.setPreferredSize(new Dimension(900, 100)); 
        statusPanel.setLayout(new GridLayout(2, 1)); // Two rows: capture message & player turn

        // Capture message label
        captureLabel = new JLabel(" ");
        captureLabel.setFont(new Font("Arial", Font.BOLD, 18));
        captureLabel.setForeground(Color.RED); // Make it stand out

        // Player turn label
        statusLabel = new JLabel("Welcome to Jungle King! Each player please select a facedown piece.");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));

        // Add labels to status panel
        statusPanel.add(captureLabel);
        statusPanel.add(statusLabel);

        add(statusPanel, BorderLayout.SOUTH);
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

    public void setStatusMessage(String message) {
        SwingUtilities.invokeLater(() -> statusLabel.setText(message));
    }

    public void setCaptureMessage(String message) {
        SwingUtilities.invokeLater(() -> captureLabel.setText(message));
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

    public void showSelectionPopup(GameController controller) {
        ArrayList<String> shuffledAnimals = new ArrayList<>(Arrays.asList(animalTypes.clone()));
        Collections.shuffle(shuffledAnimals);

        Collections.shuffle(shuffledAnimals);

        Collections.shuffle(shuffledAnimals);
        
        JDialog selectionDialog = new JDialog(this, "Select Your Animal", true);
        selectionDialog.setLayout(new GridLayout(2, 4));
        selectionDialog.setSize(300, 300);

        for (String animal : shuffledAnimals) {
            JButton animalButton = new JButton(new ImageIcon("src/images/questionmark.png"));
            animalButton.setActionCommand(animal);
            animalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (player1Choice == null) {
                        player1Choice = e.getActionCommand();
                    } else if (player2Choice == null) {
                        player2Choice = e.getActionCommand();
                        determineFirstPlayer(controller);
                        selectionDialog.dispose();
                    }
                    
                    animalButton.setEnabled(false);
                }
            });
            selectionDialog.add(animalButton);
        }
        
        selectionDialog.setVisible(true);
    }

    private void determineFirstPlayer(GameController controller) {
        controller.declareFirstPlayer(player1Choice, player2Choice);
    }
}
