package frame;

import toplist.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ExitFrame extends Frame {
    private JButton btnexit = new JButton("OK");
    private JLabel result = new JLabel();
    private JLabel text = new JLabel();
    private JLabel givename = new JLabel("Add meg a neved:");
    private JTextField name=new JTextField(20);
    private JFrame frame = new JFrame();
    private boolean win;
    private double points;
    private GameFrame gameframe;


    public ExitFrame(double points, boolean win, GameFrame gameframe){
        this.gameframe=gameframe;
        this.points = points;
        this.win=win;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);

        JPanel panel = new JPanel(new FlowLayout());

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(result);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(text);
        panel.add(Box.createRigidArea(new Dimension(0,10)));
        panel.add(givename);
        panel.add(Box.createRigidArea(new Dimension(0,5)));
        panel.add(name);
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(btnexit);

        if(win) result.setText("Nyertél!");
        else result.setText("Vesztettél!");

        if(points == 0){
            text.setText("Ezzel a játékkal nem szereztél pontot");
            }
        else{
        text.setText("Ezzel a játékkal "+points+" pontot szerezté.");
            }
        result.setAlignmentX(Component.CENTER_ALIGNMENT);
        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        givename.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnexit.setAlignmentX(Component.CENTER_ALIGNMENT);


        frame.add(panel);
        Dimension size = panel.getPreferredSize();
        panel.setBounds(15,30,size.width,size.height);

        ExitButtonActionListener l = new ExitButtonActionListener();
        btnexit.addActionListener(l);
    }

    public class  ExitButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            savePlayer();
            gameframe.exitframe();
            frame.dispose();
        }
    }

    public void savePlayer(){

        ArrayList<Player> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("players.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Player>)ois.readObject();
            fis.close();
            ois.close();
        } catch(Exception ex) { //nem sikerült beolvasni a játékosok adatait
            ex.printStackTrace();
        }

        boolean findplayer =false;
        String playerName= name.getText();
        if(playerName.equals("")) playerName="Névtelen";
        for(Player iter: list){
            if(playerName.equals(iter.getName())){
                iter.setPoints(points);
                iter.setWins(win);
                iter.setGames();
                findplayer=true;
                break;
            }
        }
        if(!findplayer)  list.add(new Player(playerName, points,win ));

        try {
            FileOutputStream fos = new FileOutputStream("players.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.flush();
            fos.close();
            oos.close();
        }
        catch(IOException ioe) {  // nem siekrült beolvasni az adatokat
            ioe.printStackTrace();
        }
    }
}
