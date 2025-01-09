import java.util.Scanner;

public class Casino {
        private int bet;
        private int guess;
        private int number;
        private Hunter hunter;

        public Casino(Hunter h){
            hunter = h;
            bet = 0;
            guess = 0;
            number = 0;
        }

        public void wager(){
            Scanner s = new Scanner(System.in);
            System.out.print("How much do you want to wager? ");
            bet = Integer.parseInt(s.next());

            while (bet > hunter.getGold() || bet < 0){
                System.out.println();
                System.out.println("Do you really think you have that much gold?");
                System.out.println();
                System.out.print("How much do you want to wager? ");
                bet = Integer.parseInt(s.next());
            }
        }

        public void gamble(){
            Scanner s = new Scanner(System.in);
            System.out.print("Pick a number from 1-12: ");
            guess = Integer.parseInt(s.next());

            if (guess < 0 || guess > 12) {
                System.out.println("No take-backs. You really want to lose huh!");
                hunter.changeGold(0);
            } else {
                number = 1 + ((int) Math.random() * 12);
                if (guess < number + 2 && guess > number + 2){
                    System.out.println("The number was: " + number);
                    System.out.println("Double the bet was returned");
                    hunter.changeGold(2 * bet);
                } else {
                    System.out.println("The number was: " + number);
                    System.out.println("Hand us your gold.");
                    hunter.changeGold(-hunter.getGold());
                }
            }
        }
}
