import java.util.Scanner;

public class ForcesCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean radianMode = false;
        System.out.println("WELCOME TO THE FORCES CALCULATOR");
        System.out.println("All units are SI, meaning force is in newtons.");
        System.out.println("All answers are truncated to two (2) decimal places");
        System.out.println("Would you like to work with radians or degrees?\n Press 1 for radians\n Press 2 for degrees");

        int check = in.nextInt();
        if(check == 1) { radianMode = true; }

        System.out.println("What type of problem are you trying to solve?\n Press 1 to calculate net force\n Press 2 for a pulley problem");

        int choice = in.nextInt();
        if(choice == 1) { NetForce.netForce(radianMode); }
        if(choice == 2) { Pulley.pulleyForce(radianMode); }

    }
}
