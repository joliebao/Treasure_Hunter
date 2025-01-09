public class Treasure {
    private static boolean treasure1;
    private static boolean treasure2;
    private static boolean treasure3;
    private int counter;
    private String currentTreasure;
    private double treasureChance;
    private TreasureHunter game;


    public Treasure(){ // constructor method that sets all variables to their starting values.
        treasure1 =false;
        treasure2 =false;
        treasure3 =false;
        counter = 0;
        treasureChance=Math.random();

        if (game.isCheatMode() == true){
            treasureChance = 0;
        }
    }

    public void generateTreasure(){ // generates either one of four options, treasures 1-3 or nothing.
        double treasureSeed = treasureChance;

        if (treasureSeed<.25){
                currentTreasure = "Sapphire Ring";
            }
        if ((treasureSeed>=.25) && treasureSeed<.50){
                currentTreasure = "Jade Necklace";
            }
        if ((treasureSeed>=.50)&&(treasureSeed<.75)){
                currentTreasure = "Crystal Skull";
            }
        if (treasureSeed>=.75){
            currentTreasure = "Nothing";
        }

    }

    public String getCurrentTreasure() {
        return currentTreasure;
    }

    public void gotTreasure1() {
        treasure1 = true;
    }

    public void gotTreasure2() {
        treasure2 = true;
    }

    public void gotTreasure3() {
        treasure3 = true;
    }

    public static boolean isTreasure1() {
        return treasure1;
    }

    public static boolean isTreasure2() {
        return treasure2;
    }

    public static boolean isTreasure3() {
        return treasure3;
    }

    public static boolean hasAllThreeTreasures(){
        return treasure1 && treasure2 && treasure3;
    }

    public String toString(){
        return currentTreasure;

    }

}
