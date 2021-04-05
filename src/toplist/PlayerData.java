package toplist;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class PlayerData extends AbstractTableModel{

    public ArrayList<Player> players = new ArrayList<Player>();

    @Override
    public int getRowCount() {
        return players.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Player player = players.get(rowIndex);
        switch(columnIndex) {
            case 0: return player.getName();
            case 1: return player.getPoints();
            default: return player.getWins();
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] oszlopok =  {"Név", "Pontok", "Nyerési arány (%)"};
        return oszlopok[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
if(columnIndex!=0) return Double.class;
        return String.class;
    }


}

