import java.text.DecimalFormat;
import java.util.Scanner;

public class MissingAcceleration {

    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void missingAcceleration() {
        Scanner in = new Scanner(System.in);

        double x = 0;
        double d = 0;
        double t = 0;

        double vi = 0;
        double vf = 0;
        // double a = 0;

        System.out.println("Which value are you trying to find?\n Press 1 for final position");
        System.out.println(" Press 2 for initial position\n Press 3 for time\n Press 4 for final velocity");
        System.out.println(" Press 5 for initial velocity");
        int value = in.nextInt();

        if(value == 1) {
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            x = d + 0.5*(vi+vf)*t;
            System.out.println("Final position is " + df.format(x) + " m");
        }
        else if(value == 2) {
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            d = x - 0.5*(vf+vi)*t;
            System.out.println("Initial position is " + df.format(d) + " m");
        }
        else if(value == 3) {
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            t = (2*(x-d))/(vi+vf);
            System.out.println("Total time is " + df.format(t) + " s");
        }
        else if(value == 4) {
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            vf = (2*(x-d)/t)-vi;
            System.out.println("Final velocity is " + df.format(vf) + " m/s");
        }
        else if(value == 5) {
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            vi = (2*(x-d)/t)-vf;
            System.out.println("Initial velocity is " + df.format(vi) + " m/s");
        }


        in.close();
    }
}