package frame;

import toplist.Player;
import toplist.PlayerData;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ToplistFrame extends JFrame  implements ActionListener {
    private PlayerData data;
    private JButton btnBack;
    private JFrame menu;

    private void initComponents() {
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable();
        table.setModel(data);
        JScrollPane panel = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(panel, BorderLayout.CENTER);

        JPanel newspanel = new JPanel(new FlowLayout());
        btnBack = new JButton("Vissza");
        newspanel.add(btnBack);
        this.add(newspanel, BorderLayout.SOUTH);
        btnBack.addActionListener(this);


        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);

    }

    public ToplistFrame(JFrame menu) {
        super("Toplista");
    this.menu = menu;
        try {
            data = new PlayerData();
            FileInputStream fis = new FileInputStream("players.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            data.players = (ArrayList<Player>)ois.readObject();
            fis.close();
            ois.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        setMinimumSize(new Dimension(500, 200));
        initComponents();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menu.setEnabled(true);
        this.dispose();
            }
}
