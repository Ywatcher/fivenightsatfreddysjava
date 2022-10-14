import java.util.LinkedList;

public class CharactersManager {

    private int difficulty;
    private LinkedList<Bonnie> bonnies = null;
    private LinkedList<Chicka> chickas = null;
    private LinkedList<Foxy> foxies = null;
    private LinkedList<Freddy> freddies = null;
    private LinkedList<Character> characters = null;

    //private int bonnieTick;
    //private int chickaTick;
    //private int foxyTick;
    //private int freddyTick;

    public CharactersManager(
            int difficulty,
            int NR_Bonnies,
            int NR_Chickas,
            int NR_Foxies,
            int NR_Freddies

    ){
        this.difficulty = difficulty;
        this.characters = new LinkedList<>();
        this.bonnies = new LinkedList<>();
        this.chickas = new LinkedList<>();
        this.foxies = new LinkedList<>();
        this.freddies = new LinkedList<>();
        for(int i=0; i<NR_Bonnies; i++){
            Bonnie bonnie = new Bonnie(difficulty);
            bonnies.add(bonnie);
            characters.add(bonnie);
        }
        for (int i=0; i<NR_Chickas; i++){
            Chicka chicka = new Chicka(difficulty);
            chickas.add(chicka);
            characters.add(chicka);
        }
        for (int i=0; i<NR_Foxies; i++){
            Foxy foxy = new Foxy(difficulty);
            foxies.add(foxy);
            characters.add(foxy);
        }
        for (int i=0; i<NR_Freddies; i++){
            Freddy freddy = new Freddy(difficulty);
            freddies.add(freddy);
            characters.add(freddy);
        }
    }

    public void timeIncreaseAndTick(){
        for (Character character : this.characters){
            character.timeIncreaseAndTick();
        }
    }

    public void clearTick(){
        for (Character character : this.characters){
            character.clearTick();
        }
    }
}
