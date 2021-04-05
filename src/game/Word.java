package game;

public class Word {
    String word;

    public Word(String word){
        this.word=word;
    } // ismert szó létrehozása
    public Word (int length){ //ismeretlen szó létrehozása (csak a szó hosszát tudjuk)
        word="";
        for(int i=0; i<length; i++){
            word+="_";
        }
    }

    public int length(){ return word.length();}

    public char charAt(int i){ return word.charAt(i);}

    public int[] wordPositionCode(char letter){  //egy szóban meghatározza, hogy az adott betű hol található
        int[] number = new int[countLetters(letter)];
        int k=0;
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)==letter){
                number[k]=i;
                k++;
            }
        }
        return number;
    }

    public void buildWord(char letter, int[] number){ //felepiti a szo kinezetet: beszurja az ismert betuket
        for (int k : number) {
            char[] temp = word.toCharArray();
            temp[k] = letter;
            word = String.valueOf(temp);
        }
    }

    public String wordToWrite(){
        String temp="";
        for(int i=0; i<word.length(); i++){
            temp+=word.charAt(i)+" ";
        }
        return temp;
    }

    public int countLetters(char letter){
        int db=0;
        for(int i=0; i< word.length(); i++){
            if(word.charAt(i)==letter) db++;
        }
        return db;
    }

}
