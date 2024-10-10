import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

            Scanner console = new Scanner(System.in);
            Random rand = new Random();
            int die1 = 0;
            int die2 = 0;
            int dieSum = 0;
            int point = 0;
            boolean done = false;
            boolean continueYN = true;
            String trash = "";
        do {
            die1 = rand.nextInt(6) + 1;//inital roll
            die2 = rand.nextInt(6) + 1;
            dieSum = die1 + die2;

            if (dieSum == 2 || dieSum == 3 || dieSum == 12) {//check if they won
                System.out.println("You got " + dieSum + ", which is craps. You lose!");
                done = true;
            } else if (dieSum == 7 || dieSum == 11) {
                System.out.println("You got " + dieSum + " which is a natural. You win!");
                done = true;
            } else { //Start the game!

                point = dieSum;
                System.out.print("The point is " + point + ". Start rolling! [Enter R to roll]: ");
                do {
                    if (console.nextLine().equalsIgnoreCase("R")) {
                        System.out.println("Rolling for point..");
                        die1 = rand.nextInt(6) + 1;
                        die2 = rand.nextInt(6) + 1;
                        dieSum = die1 + die2;
                        if (dieSum == point) {
                            System.out.println("You rolled " + dieSum + ". You win!");
                            done = true;
                        } else if (dieSum == 7) {
                            System.out.println("You rolled a 7. You lose!");
                            done = true;
                        } else {
                            System.out.print("You rolled " + dieSum + ". Roll again! [Enter R to roll]:");
                        }
                    } else{
                        trash = console.nextLine();
                        System.out.print(trash + " is not a valid input. Press R to roll: ");
                    }
                } while (!done);
                System.out.print("Do you want to play again?[Y/N]: ");
                if (console.nextLine().equalsIgnoreCase("Y")) {
                    continueYN = true;
                    die1 = 0;
                    die2 = 0;
                    dieSum = 0;
                    point = 0;
                    done = false;
                } else {
                    continueYN = false;
                }
            }
        }while (continueYN);
    }
}