package game;

import frame.GameFrame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private final GameFrame frame;
    private int life;
    private int length;
    private int unknownletters;
    private String wrong_letters="";
    private final ArrayList<Word> word_list=new ArrayList<>();
    private Word word;

    public Game(GameFrame frame){
        life=11;
        this.frame = frame;
    }
    public double getPoints(){return Math.round((life+0.0)/word.length()*100.0)/100.0;}

    public void gameStart() {
        //szavak beolvasasa
        try {
            File f = new File("szavak.txt");
            Scanner scanner = new Scanner(f);
            while(scanner.hasNextLine()){
                word_list.add(new Word(scanner.nextLine().toLowerCase()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //leghosszabb szo megkeresese

        int max= maxLength();

        //random hosszusagu szo kivalasztasa
        Random rand = new Random();
        do{
            length= rand.nextInt(max+1);
        }while(length<2 && !invalidLength());

        //jo hosszusagu szavak kivalogatasa
        deleteWrongLength();

        unknownletters =length;
        word= new Word(length);
        frame.setWord(word.wordToWrite());
        frame.setText(length);
        frame.setLife(life);
    }

    public int gameCheck(){
        if(life==0){
            word=word_list.get(0);
            frame.setWord(word.wordToWrite());
            return 1;
        }
        else if(unknownletters==0){
            return 2;
        }
        return 0;
    }

    public boolean tipp(char letter){
        boolean correct=false;
        letter=Character.toLowerCase(letter);
        int db= letterMin(letter);
        deleteMoreLetters(letter,db);   //kitorli azokat a szavakat, amikben tobbszor szerepel a betu

        if(db==0){                      //ha van olyan szo, amiben nincs meg ez a betu
            life-=1;
            frame.setLife(life);
            wrong_letters+=Character.toUpperCase(letter)+" ";
            frame.setWrongletters(wrong_letters);
        }
        else{
            unknownletters-=db;
            Position pos=positions(letter);                //ebben az elrendezesben szerepelnek a betuk a legtobbszor
            deleteWrongPosition(letter, pos);                  //megkeresi, hogy a betuk milyen elrendezesben szerepelnek a legtobbszor
            word.buildWord(letter, pos.getNumber());           //felepiti a szo kinezetet
            correct =true;
        }
        frame.setWord(word.wordToWrite());
        return correct;
    }


    public void deleteMoreLetters(char letter, int jodb){ //kitorli azokat a szavakat, amik nem lehetnek megoldasok a tippelesek utan, mert tobbszor szerepel bennuk az adott betu
        for(int iter= 0; iter < word_list.size(); iter++){
            if(jodb!=word_list.get(iter).countLetters(letter)){
                word_list.remove(iter);
                iter--;
            }
        }
    }

    public Position positions(char letter){
        PositionList poslist=new PositionList();
        for(Word iter: word_list){
            int[] number= iter.wordPositionCode(letter);
            if(!poslist.searchNumber(number)){
                poslist.addNewNumber(number);
            }
        }
        return poslist.positionMax();
    }

    public void deleteWrongPosition(char letter, Position pos){ //kitorli azokat a szavakat, amikben nem jo elrendezesben vannak a betuk
        for(int iter= 0; iter < word_list.size(); iter++){
            if(!(Arrays.equals(word_list.get(iter).wordPositionCode(letter), pos.getNumber()))){
                word_list.remove(iter);
                iter--;
                System.out.println("T");
            }
        }
    }

    public int letterMin(char letter){ //megszamolja h a szavak kozott melyikekben van benne a legkevesebbszer a betu
        int mindb=word_list.get(0).length();

        for(Word iter: word_list){
            int db=0;
            for(int i=0; i<iter.length(); i++){
                if(iter.charAt(i)==letter) db++;
            }
            if(mindb>db) mindb=db;
        }
        return mindb;
    }

    //-------------------------------------------------------------------------------------------
    public int maxLength(){ //megkeresi milyen hosszu a leghosszabb szo
        int max=0;
        for(Word i: word_list){
            if(max<i.length()) max = i.length();
        }
        return max;
    }

    public void deleteWrongLength(){ //kitorli a nem jo hosszusagu szavakat
        word_list.removeIf(word -> word.length() != length);
    }

    public boolean invalidLength(){
        for(Word iter: word_list){
            if(iter.length()==length) return true;
        }
        return false;
    }

}
