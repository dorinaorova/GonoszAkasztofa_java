package game;

public class Position {
    private int cnt;
    private int[] number;

    public Position( int[] number){
        this.cnt=0;
        this.number=number;
    }

    public int[] getNumber(){
        return number;
    }

    public int getCnt(){
        return cnt;
    }

    public void increaseCnt(){
        cnt++;
    }

}
