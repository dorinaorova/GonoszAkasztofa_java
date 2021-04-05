package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends Frame {
    private final JButton start = new JButton("START");
    private final JButton toplist = new JButton("Toplista");
    private final JButton rules = new JButton("J�t�kszab�lyok");

    private JFrame frame = new JFrame("Gonosz akaszt�fa");

    public MenuFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout(null);

        JPanel btnpanel = new JPanel();
        btnpanel.setLayout(new BoxLayout(btnpanel, BoxLayout.Y_AXIS));
        btnpanel.add(start);
        btnpanel.add(Box.createRigidArea(new Dimension(0,5)));
        btnpanel.add(toplist);
        btnpanel.add(Box.createRigidArea(new Dimension(0,5)));
        btnpanel.add(rules);

        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        toplist.setAlignmentX(Component.CENTER_ALIGNMENT);
        rules.setAlignmentX(Component.CENTER_ALIGNMENT);


        frame.add(btnpanel);
        Dimension size = btnpanel.getPreferredSize();
        btnpanel.setBounds(180,150,size.width,size.height);

        StartButtonActoinListener l = new StartButtonActoinListener();
        start.addActionListener(l);

        RulestButtonActoinListener s = new RulestButtonActoinListener();
        rules.addActionListener(s);
        ToplistButtonActionListener t = new ToplistButtonActionListener();
        toplist.addActionListener(t);
    }


    public void startGame(){
        frame.setVisible(false);
        GameFrame c = new GameFrame(frame);
    }

    public class StartButtonActoinListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            startGame();
        }
    }
    public class RulestButtonActoinListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
           createwindow();
        }
    }
    public class  ToplistButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            frame.setEnabled(false);
            ToplistFrame c = new ToplistFrame(frame);
        }
    }

    public void createwindow(){
        JOptionPane opt = new JOptionPane("A j�t�kban az angol abc bet�ire lehet tippelni."+
                "A j�t�kosnak 11\npr�b�lkoz�si lehet�s�ge van." +
                " Ah�nyszor rossz bet�re tippel vesz�t egy\n�letet. " +
                "A j�t�k addig tart, am�g a j�t�kos ki nem tal�lja a sz�t, vagy el\nnem fogy az �sszes �lete.");
        JDialog jd = opt.createDialog(frame, "J�t�kszab�lyok");
        jd.setVisible(true);
    }

}