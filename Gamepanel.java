import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Gamepanel extends JPanel {
     final int SCREEN_WIDTH = 1300;
     final int SCREEN_HEIGHT = 750;
     final int ROWS = 16;
     final int COLS = 30;
     static Boolean losed = true;
     static ArrayList<ArrayList<Space>> game = new  ArrayList<ArrayList<Space>>();

    Gamepanel(){

        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));

        this.setLayout(new GridLayout(ROWS,COLS));


        startGame();
    }
    public void startGame(){
        addbuttons();
        setbombs();
    }
    public void setbombs(){};
    static void lose () throws InterruptedException {


        for (int i = 0; i < game.size(); i++) {
            for (int j = 0; j <game.get(i).size() ; j++) {
                game.get(i).get(j).doClick();
            }


        }
    }
    public void addbuttons(){

        for(int i=0;i<ROWS;i++) {
            ArrayList<Space> row = new ArrayList<Space>();
            for(int j=0;j<COLS;j++) {
                Space button= new Space();
                this.add(button);
                row.add(button);
            }
            game.add(row);
        }

    }
}
