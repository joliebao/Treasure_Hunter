/**
 * This class is responsible for controlling the Treasure Hunter game.<p>
 * It handles the display of the menu and the processing of the player's choices.<p>
 * It handles all of the display based on the messages it receives from the Town object.
 *
 */
import java.util.Scanner;

public class TreasureHunter
{
    //Instance variables
    private Town currentTown;
    private Hunter hunter;
    private Treasure currentTreasure;
    private Casino casino;
    private boolean hardMode;
    private boolean easyMode;
    private static boolean cheatMode;

    //Constructor
    /**
     * Constructs the Treasure Hunter game.
     */
    public TreasureHunter()
    {
        // these will be initialized in the play method
        currentTreasure = new Treasure();
        currentTown = null;
        hunter = null;
        hardMode = false;
        easyMode = false;
        cheatMode = false;
    }

    // starts the game; this is the only public method
    public void play ()
    {
        welcomePlayer();
        enterTown();
        showMenu();
    }

    /**
     * Creates a hunter object at the beginning of the game and populates the class member variable with it.
     */
    private void welcomePlayer()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to TREASURE HUNTER!");
        System.out.println("Going hunting for the big treasure, eh?");
        System.out.print("What's your name, Hunter? ");
        String name = scanner.nextLine();

        // set hunter instance variable
        hunter = new Hunter(name, 10);

        System.out.print("Hard mode? Normal mode? Easy mode? (h/n/e): ");
        String difficulty = scanner.nextLine();
        difficulty = difficulty.toUpperCase();

        if (difficulty.equals("H")) {
            System.out.println("\nHard mode is on...");
            hardMode = true;
        } else if (difficulty.equals("E")) {
            System.out.println("\nEasy mode is on");
            easyMode = true;
        } else if (difficulty.equals("CH347M0D3")){
            System.out.println("\nCheat mode is on! - - -- - ");
            cheatMode = true;
        }
    }

    public static boolean isCheatMode() {
        return cheatMode;
    }

    /**
     * Creates a new town and adds the Hunter to it.
     */
    private void enterTown()
    {
        double markdown = 0.25;
        double toughness = 0.4;
        if (hardMode) {
            // in hard mode, you get less money back when you sell items
            markdown = 0.5;
            // and the town is "tougher"
            toughness = 0.75;
        }
        else if (easyMode) {
            markdown = 0.1;
            toughness = 0.25;
        }
        else if (cheatMode) {
            markdown = 0;
            toughness = 0;
        }
        else {
            markdown = 0.3;
            toughness = 0.5;
        }


        currentTreasure.generateTreasure();

        // note that we don't need to access the Shop object
        // outside of this method, so it isn't necessary to store it as an instance
        // variable; we can leave it as a local variable
        Shop shop = new Shop(markdown);

        // creating the new Town -- which we need to store as an instance
        // variable in this class, since we need to access the Town
        // object in other methods of this class
        currentTown = new Town(shop, toughness);

        // calling the hunterArrives method, which takes the Hunter
        // as a parameter; note this also could have been done in the
        // constructor for Town, but this illustrates another way to associate
        // an object with an object of a different class

        System.out.println("_________________________________________");
        currentTown.hunterArrives(hunter);
    }

    /**
     * Displays the menu and receives the choice from the user.<p>
     * The choice is sent to the processChoice() method for parsing.<p>
     * This method will loop until the user chooses to exit.
     */
    private void showMenu()
    {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        while (!(choice.equals("X") || choice.equals("x") || hunter.getGold() == 0 || Treasure.hasAllThreeTreasures()))
        {
            System.out.println();
            System.out.println(currentTown.getLatestNews());
            System.out.println("***");
            System.out.println(hunter);
            System.out.println(currentTown);
            System.out.println("(B)uy something at the shop.");
            System.out.println("(S)ell something at the shop.");
            System.out.println("(M)ove on to a different town.");
            System.out.println("(L)ook for trouble!");
            System.out.println("(H)unt for treasure!");
            System.out.println("(G)amble!");
            System.out.println("Give up the hunt and e(X)it.");
            System.out.println();
            System.out.print("What's your next move? ");
            choice = scanner.nextLine();
            choice = choice.toUpperCase();
            processChoice(choice);
        }

        if (hunter.getGold() == 0){
            System.out.println(currentTown.getLatestNews());
            System.out.println();
            System.out.println(hunter.getHunterName() + " has " + hunter.getGold() + " gold.");
            System.out.println("You lose! You have gone broke " + hunter.getHunterName() + "!");
        } else if (Treasure.hasAllThreeTreasures()){
            System.out.println(currentTown.getLatestNews());
            System.out.println();
            System.out.println(hunter.getHunterName() + " has " + hunter.getGold() + " gold.");
            System.out.println("You win! You found all three treasures " + hunter.getHunterName() + "!");

        }
    }

    /**
     * Takes the choice received from the menu and calls the appropriate method to carry out the instructions.
     * @param choice The action to process.
     */
    private void processChoice(String choice)
    {
        if (choice.equals("B") || choice.equals("S")) // buying or selling
        {
            currentTown.enterShop(choice);
        }
        else if (choice.equals("M")) // moving
        {
            if (currentTown.leaveTown())
            {
                //This town is going away so print its news ahead of time.
                System.out.println(currentTown.getLatestNews());
                enterTown();
            }
        }
        else if (choice.equals("L")) { // fighting
            currentTown.lookForTrouble();

        } else if(choice.equals("H")){ // hunting
            System.out.println();

            if (!currentTown.getHasHunted()) {
                System.out.println("You hunted for treasure and found....");
                System.out.println(currentTreasure);

                if (Treasure.isTreasure1() && currentTreasure.getCurrentTreasure().equals("Sapphire Ring")) {
                    System.out.println("You already got a sapphire ring, so you gave it away to a beggar...");
                }

                if (Treasure.isTreasure2() && currentTreasure.getCurrentTreasure().equals("Jade Necklace")) {
                    System.out.println("You already got a Jade Necklace, so you sent it to your mother as a gift...");
                }

                if (Treasure.isTreasure3() && currentTreasure.getCurrentTreasure().equals("Crystal Skull")) {
                    System.out.println("You already got a Crystal Skull, so you donated it to a museum...");
                }

                if (Treasure.hasAllThreeTreasures()) {
                    System.out.println("You got all the treasures!");
                    System.out.println("Congratulations, you're rich now!");
                }

                if (currentTreasure.getCurrentTreasure().equals("Sapphire Ring")) {
                        currentTreasure.gotTreasure1();
//                        hunter.addTreasureToKit("Sapphire Ring");
                    }

                if (currentTreasure.getCurrentTreasure().equals("Jade Necklace")) {
                    currentTreasure.gotTreasure2();
//                    hunter.addTreasureToKit("Jade Necklace");
                }

                if (currentTreasure.getCurrentTreasure().equals("Crystal Skull")) {
                    currentTreasure.gotTreasure3();
//                    hunter.addTreasureToKit("Crystal Skull");
                }

            } else {
                System.out.println("You already hunted here, try another town!");
            }
            currentTown.setHasHunted();

        } else if (choice.equals("G")){ // gamble
            casino = new Casino(hunter);
            casino.wager();
            casino.gamble();

        } else if (choice.equals("X")) { // exiting
            System.out.println("Fare thee well, " + hunter.getHunterName() + "!");

        } else {
            System.out.println("Yikes! That's an invalid option! Try again.");
        }
    }
}
