package frame;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GameFrame extends JFrame {
    private final JFrame frame = new JFrame("Gonosz akasztófa");
    private final Game jatek;
    private final JFrame menu;

    //buttons
    private JButton bA = new JButton("A");
    private JButton bB = new JButton("B");
    private JButton bC = new JButton("C");
    private JButton bD = new JButton("D");
    private JButton bE = new JButton("E");
    private JButton bF = new JButton("F");
    private JButton bG = new JButton("G");
    private JButton bH = new JButton("H");
    private JButton bI = new JButton("I");
    private JButton bJ = new JButton("J");
    private JButton bK = new JButton("K");
    private JButton bL = new JButton("L");
    private JButton bM = new JButton("M");
    private JButton bN = new JButton("N");
    private JButton bO = new JButton("O");
    private JButton bP = new JButton("P");
    private JButton bQ = new JButton("Q");
    private JButton bR = new JButton("R");
    private JButton bS = new JButton("S");
    private JButton bT = new JButton("T");
    private JButton bU = new JButton("U");
    private JButton bV = new JButton("V");
    private JButton bW = new JButton("W");
    private JButton bX = new JButton("X");
    private JButton bY = new JButton("Y");
    private JButton bZ = new JButton("Z");

    private final JLabel text = new JLabel();
    private final JLabel word = new JLabel();
    private final JLabel life = new JLabel();
    private final JLabel wrongletters = new JLabel();

    private final Hangman hangman;


    public GameFrame (JFrame menu) {
        jatek= new Game(this);
        this.menu=menu;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);


        JPanel btnpanels = new JPanel(new BorderLayout());
        btnpanels.setLayout(new BoxLayout(btnpanels, BoxLayout.Y_AXIS));

        JPanel btnpanel1 = new JPanel(new FlowLayout());
        btnpanel1.add(bA);
        btnpanel1.add(bB);
        btnpanel1.add(bC);
        btnpanel1.add(bD);
        btnpanel1.add(bE);
        btnpanel1.add(bF);
        btnpanel1.add(bG);
        btnpanel1.add(bH);
        btnpanel1.add(bI);

        JPanel btnpanel2 = new JPanel(new FlowLayout());
        btnpanel2.add(bJ);
        btnpanel2.add(bK);
        btnpanel2.add(bL);
        btnpanel2.add(bM);
        btnpanel2.add(bN);
        btnpanel2.add(bO);
        btnpanel2.add(bP);
        btnpanel2.add(bQ);

        JPanel btnpanel3 = new JPanel(new FlowLayout());
        btnpanel3.add(bR);
        btnpanel3.add(bS);
        btnpanel3.add(bT);
        btnpanel3.add(bU);
        btnpanel3.add(bV);
        btnpanel3.add(bW);
        btnpanel3.add(bX);
        btnpanel3.add(bY);
        btnpanel3.add(bZ);

        btnpanels.add(btnpanel1);
        btnpanels.add(btnpanel2);
        btnpanels.add(btnpanel3);

        Font font = new Font("font", Font.BOLD, 14);
        text.setFont(font);
        word.setFont(new Font("font2", Font.BOLD, 18));
        life.setFont(font);
        JPanel panel1 = new JPanel( );
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        panel1.add (text);
        panel1.add(Box.createRigidArea(new Dimension(0,10)));
        panel1.add (word);
        panel1.add(Box.createRigidArea(new Dimension(0,10)));
        panel1.add (wrongletters);

        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        word.setAlignmentX(Component.CENTER_ALIGNMENT);
        wrongletters.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(life, BorderLayout.EAST);

        hangman = new Hangman();

        frame.add(hangman);
        frame.add(panel2);
        frame.add(panel1);
        frame.add(btnpanels);

        Dimension sizelife = btnpanels.getPreferredSize();
        panel2.setBounds(0,0,sizelife.width,50);
        Dimension sizetext = btnpanels.getPreferredSize();
        panel1.setBounds(25,70,sizetext.width,sizetext.height );

        Dimension sizehangman = hangman.getPreferredSize();
        hangman.setBounds(0,150,sizehangman.width,sizehangman.height );

        Dimension sizebuttons = btnpanels.getPreferredSize();
        btnpanels.setBounds(25,350,sizebuttons.width,sizebuttons.height);

        ButtonActionListener l = new ButtonActionListener();
        for (JButton jButton : Arrays.asList(bA, bB, bC, bD, bE, bF, bG, bH,bI,  bJ, bK, bL, bM, bN, bO, bP, bQ, bR, bS, bT, bU, bV, bW, bX, bY, bZ)) {
            jButton.addActionListener(l);
        }
        jatek.gameStart();
    }

    public void setLife(int i) {
        life.setText("Még "+  i +" életed maradt");
    }

    public void setText(int i){
        text.setText("Gondoltam egy "+i+" betûs szóra");
    }

    public void setWord (String s){
        word.setText(s);
    }

    public void setWrongletters(String s){
        wrongletters.setText(s);
    }

    public class ButtonActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            source.setEnabled(false);
            source.setBackground(Color.DARK_GRAY);
            boolean correct =jatek.tipp(source.getText().charAt(0));
            if(!correct) {
                hangman.step();
                hangman.repaint();
            }
            int i=jatek.gameCheck();
            if(i==1){
                word.setForeground(Color.RED);
                endGame(0, false);
            }
            else if(i==2){
                endGame(jatek.getPoints(), true);
            }
        }
    }

    public void endGame(double points , boolean win){
        ExitFrame c = new ExitFrame( points, win, this);
        frame.setEnabled(false);
    }

    public void exitframe(){
        menu.setVisible(true);
        frame.dispose();
    }


}
