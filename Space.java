import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Space extends JButton implements ActionListener {

    boolean bomb = false;
    Space(){


    this.addActionListener(this);

    }

    public void SetIsBomb(){
        this.bomb=true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!bomb){
        click();

    }else {

            setbomb();
            if(Gamepanel.losed){
            try {
                Gamepanel.losed = false;
                Gamepanel.lose();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);

            }}
        }}


    public void setimage(){
        ImageIcon icon = new ImageIcon("./images/one.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        this.setIcon(icon);


    }
    public void setbomb(){
        ImageIcon icon = new ImageIcon("./images/bomb.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        this.setIcon(icon);


    }
    public void click(){
                setimage();
    }







}
