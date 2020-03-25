import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class MissingFinalVelocity {

    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void missingFinalVelocity() {
        Scanner in = new Scanner(System.in);

        double x = 0;
        double d = 0;
        double t = 0;

        double vi = 0;
        // double vf = 0;
        double a = 0;

        System.out.println("Which value are you trying to find?\n Press 1 for final position");
        System.out.println(" Press 2 for initial position\n Press 3 for time\n Press 4 for acceleration");
        System.out.println(" Press 5 for initial velocity");
        int value = in.nextInt();

        if(value == 1) {
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            double timeSquared = Math.pow(t, 2);
            x = d + vi*t + 0.5*a*timeSquared;
            System.out.println("Final position is " + df.format(x) + " m");
        }
        else if(value == 2) {
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            double timeSquared = Math.pow(t, 2);
            d = x - vi*t - 0.5*a*timeSquared;
            System.out.println("Initial position is " + df.format(d) + " m");
        }
        else if(value == 3) {
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the final position");
            x = in.nextDouble();
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            double radical = Math.sqrt((vi*vi) - 4*(0.5*a*(d-x)));
            t = (radical - vi)/a;
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
            double timeSquared = Math.pow(t, 2);
            a = 2*(x-d-(vi*t))/timeSquared;
            System.out.println("Constant acceleration is " + df.format(a) + " m/s/s");
        }
        else if(value == 5) {
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            double timeSquared = Math.pow(t, 2);
            vi = (x-d-(0.5*a*timeSquared))/t;
            System.out.println("Initial velocity is " + df.format(vi) + " m/s");
        }


        in.close();

    }

}