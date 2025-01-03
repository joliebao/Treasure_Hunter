public class Treasure {
    private boolean treasure1;
    private boolean treasure2;
    private boolean treasure3;
    private int treasureChance;
    private int counter;
    private String currentTreasure;

    public Treasure(){
        treasure1 =false;
        treasure1 =false;
        treasure1 =false;
        treasureChance =((int) Math.random()*100)+1;
        counter = 0;
    }

    public void generateTreasure(){
        double treasureSeed = Math.random();

        if (treasureSeed<.33){
                currentTreasure = "Sapphire treasure";
            }
        if ((treasureSeed>.33) && treasureSeed<.66){
                currentTreasure = "Jade treasure";
            }
        if (treasureSeed>.66){
                currentTreasure = "Diamond treasure";
            }

        }

    public boolean searchTreasure(){
        if (treasureChance>50){
            return true;
        }else {
            return false;
        }
    }



}
