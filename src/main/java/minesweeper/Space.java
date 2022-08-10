package minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Space extends JButton implements ActionListener, Runnable{

    boolean bomb = false;
    boolean canclick = true;
    Space(){


    this.addActionListener(this);

    }

    public void SetIsBomb(){
        this.bomb=true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.canclick = false;
        Thread th = new Thread(this);
        th.start();
       }
       public void caniclick(){
        if(canclick){
            this.doClick();
        }
       }

    public int number() {
        int numberlist = 0;
        int n = 0;
        for (int i = 0; i <= Gamepanel.game.size(); i++) {
            if (Gamepanel.game.get(i).contains(this)) {
                numberlist = i;
                n = Gamepanel.game.get(i).indexOf(this);
                break;
            }
        }
        int bombs = 0;
        try {
            bombs += Gamepanel.game.get(numberlist+1).get(n + 1).isbomb();


        }catch (Exception err){}
        try {
            bombs += Gamepanel.game.get(numberlist+1).get(n).isbomb();


        }catch (Exception err){}try {
            bombs += Gamepanel.game.get(numberlist+1).get(n - 1).isbomb();


        }catch (Exception err){}try {
            bombs += Gamepanel.game.get(numberlist).get(n + 1).isbomb();


        }catch (Exception err){}try {
            bombs += Gamepanel.game.get(numberlist).get(n).isbomb();


        }catch (Exception err){}try {
            bombs += Gamepanel.game.get(numberlist).get(n - 1).isbomb();


        }catch (Exception err){}try {
            bombs += Gamepanel.game.get(numberlist-1).get(n + 1).isbomb();


        }catch (Exception err){}try {
            bombs += Gamepanel.game.get(numberlist-1).get(n).isbomb();


        }catch (Exception err){}try {
            bombs += Gamepanel.game.get(numberlist-1).get(n - 1).isbomb();


        }catch (Exception err){}








        if(bombs == 0){
            try {
                Gamepanel.game.get(numberlist).get(n + 1).caniclick();
            }catch (Exception err){

            }try {
                Gamepanel.game.get(numberlist).get(n).caniclick();
            }catch (Exception err){

            }try {
                Gamepanel.game.get(numberlist).get(n - 1).caniclick();
            }catch (Exception err){

            }
            try {
                Gamepanel.game.get(numberlist+1).get(n + 1).caniclick();
            }catch (Exception err){

            }
            try {
                Gamepanel.game.get(numberlist+1).get(n).caniclick();
            }catch (Exception err){

            }
            try {
                Gamepanel.game.get(numberlist+1).get(n - 1).caniclick();
            }catch (Exception err){

            }try {
                Gamepanel.game.get(numberlist-1).get(n + 1).caniclick();
            }catch (Exception err){

            }try {
                Gamepanel.game.get(numberlist-1).get(n).caniclick();
            }catch (Exception err){

            }try {
                Gamepanel.game.get(numberlist-1).get(n-1).caniclick();
            }catch (Exception err){

            }

        }
        return bombs;


    }
      public int isbomb(){
        if(bomb){

            return 1;
        }
        return 0;
    }
    public void click(int number){
        URL url = getClass().getResource("/images/" + number + ".png");
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        this.setIcon(icon);
    }
    public void setbomb(){
        URL url = getClass().getResource("/images/bomb.png");
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        this.setIcon(icon);


    }


    @Override
    public void run() {
        if(!bomb){

            int number = number();

            click(number);

        }else {

            setbomb();
            if(Gamepanel.losed){
                try {
                    Gamepanel.losed = false;
                    Gamepanel.lose();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);

                }}
        }
    }
}
