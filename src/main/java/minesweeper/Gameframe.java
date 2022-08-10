package minesweeper;

import javax.swing.*;

public class Gameframe extends JFrame {

    Gameframe(){
        this.setIconImage(new ImageIcon("./images/bomb.png"));
        
        this.setTitle("Minesweeper");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Gamepanel());
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void setIconImage(ImageIcon imageIcon) {
    }
}
