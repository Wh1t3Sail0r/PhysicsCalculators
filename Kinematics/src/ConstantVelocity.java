import java.text.DecimalFormat;
import java.util.Scanner;


public class ConstantVelocity {

    // x = final position
    // d = initial position
    // v = velocity
    // t = time

    // vf = final velocity
    // v0 = initial velocity
    // vAvg = average velocity
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void constantVelocity() {
        Scanner in = new Scanner(System.in);

        double x = 0;
        double d = 0;
        double v = 0;
        double t = 0;


        System.out.println("Which value is missing? (final position, initial position, velocity, or time)");
        String criteria = in.nextLine();
        if(criteria.equals("final position")) {
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the velocity?");
            v = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            x = d + (v*t);
            System.out.println("Final position is " + df.format(x) + " m");
        }
        else if(criteria.equals("initial position")) {
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the velocity?");
            v = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            d = x-(v*t);
            System.out.println("Initial position is " + df.format(d) + " m");
        }
        else if(criteria.equals("velocity")) {
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            v = (x-d)/t;
            System.out.println("Velocity is " + df.format(v) + " m/s");
        }
        else if(criteria.equals("time")) {
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the velocity?");
            v = in.nextDouble();
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            t = (x-d)/v;
            System.out.println("Time is " + df.format(t) + " s");
        }
        in.close();
    }

    public static void averageVelocity() {

        double vf = 0;
        double v0 = 0;
        double vAvg = 0;

        Scanner in = new Scanner(System.in);
        System.out.println("What is the final velocity?");
        vf = in.nextDouble();
        System.out.println("What is the initial velocity?");
        v0 = in.nextDouble();
        vAvg = (vf + v0)/2;
        System.out.println("The average velocity is " + df.format(vAvg) + " m/s");
        in.close();
    }
}