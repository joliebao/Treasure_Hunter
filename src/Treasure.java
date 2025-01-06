public class Treasure {
    private static boolean treasure1;
    private static boolean treasure2;
    private static boolean treasure3;
    private int counter;
    private String currentTreasure;
    private double treasureChance;

    public Treasure(){ // constructor method that sets all variables to their starting values.
        treasure1 =false;
        treasure1 =false;
        treasure1 =false;
        counter = 0;
        treasureChance=Math.random();
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

    public void gotTreasure1() {
        this.treasure1 = true;
    }

    public void gotTreasure2() {
        this.treasure2 = true;
    }

    public void gotTreasure3() {
        this.treasure3 = true;
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
        if (treasure1 && treasure2 && treasure3){
            return true;
        }
        return false;
    }

    public String toString(){
        return currentTreasure;

    }

}
