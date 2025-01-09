import java.util.Scanner;

public class Casino {
        private int bet;
        private int guess;
        private int number;
        private Hunter hunter;

        public Casino(){
            bet = 0;
            guess = 0;
            number = 0;
        }

        public void wager(){
            Scanner s = new Scanner(System.in);
            System.out.println("How much do you want to wager? ");
            bet = Integer.parseInt(s.next());

            if (bet > hunter.getGold()){
                System.out.println("Do you really think you have that much?");
            } else if (bet < 0){
                System.out.println("We are NOT giving YOU gold.");
            }
        }

        public void gamble(){
            Scanner s = new Scanner(System.in);
            System.out.println("Pick a number from 1-12: ");
            guess = Integer.parseInt(s.next());

            if (guess < 0 || guess > 12) {
                System.out.println("No take-backs. You really want to lose huh!");
                hunter.changeGold(0);
            } else {
                number = 1 + ((int) Math.random() * 12);
                if (guess > number + 2 || guess < number + 2){
                    hunter.changeGold(0);
                } else {
                    hunter.changeGold(2 * bet + hunter.getGold());
                }
            }
        }
}
