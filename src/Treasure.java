public class Treasure {
    private boolean treasure1;
    private boolean treasure2;
    private boolean treasure3;
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

    public boolean searchTreasure(){
        double treasureSeed = treasureChance;

        if (treasureSeed<.25){
            treasure1=true;

        }
        if ((treasureSeed>=.25) && treasureSeed<.50){
            treasure2 = true;
        }
        if ((treasureSeed>=.50)&&(treasureSeed<.75)){
            treasure3 = true;
        }

        if (treasureSeed>=.75){
            return false;
        }

        return false;

    }



}
