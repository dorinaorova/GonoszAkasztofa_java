package game;

import java.util.ArrayList;
import java.util.Arrays;

public class PositionList {
    private ArrayList<Position> list = new ArrayList<>() ;

    public boolean searchNumber(int[] number){ //megkeres egy szamot
        for(Position i : list){
            if(Arrays.equals(number, i.getNumber())) {
                i.increaseCnt();
                return true;
            }
        }
        return false;
    }

    public void addNewNumber(int[] number){ //uj poziciot ad a listahoz
        list.add(new Position( number));
    }

    public Position positionMax(){//megkeresi, hogy a betuk milyen elrendezesben szerepelnek a legtobbszor
        Position max = list.get(0);
        for(Position i : list){
            if(max.getCnt()<i.getCnt()) max = i;
        }
        return max;
    }


}
