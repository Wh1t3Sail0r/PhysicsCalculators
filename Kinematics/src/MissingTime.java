import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class MissingTime {

    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void missingTime() {
        Scanner in = new Scanner(System.in);

        double x = 0;
        double d = 0;
        double xd = 0;
        // double t = 0;

        double vi = 0;
        double vf = 0;
        double a = 0;

        System.out.println("Which value are you trying to find?\n Press 1 for final velocity");
        System.out.println(" Press 2 for initial velocity\n Press 3 for acceleration\n Press 4 for final position");
        System.out.println(" Press 5 for initial position");
        int value = in.nextInt();

        if(value == 1) {
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            System.out.println("What is the change in position?");
            xd = in.nextDouble();
            double radical = (vi*vi) + 2*a*xd;
            vf = Math.sqrt(radical);
            System.out.println("Final velocity is " + df.format(vf) + " m/s");
        }
        else if(value == 2) {
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            System.out.println("What is the change in position?");
            xd = in.nextDouble();
            double radical = (vf*vf) - 2*a*xd;
            vi = Math.sqrt(radical);
            System.out.println("Initial velocity is " + df.format(vi) + " m/s");
        }
        else if(value == 3) {
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the change in position?");
            xd = in.nextDouble();
            a = ((vf*vf) - (vi*vi))/(2*xd);
            System.out.println("Constant acceleration is " + df.format(a) + " m/s/s");
        }
        else if(value == 4) {
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            System.out.println("What is the initial position?");
            d = in.nextDouble();
            x = (((vf*vf) - (vi*vi))/(2*a)) + d;
            System.out.println("Final position is " + df.format(x) + " m");
        }
        else if(value == 5) {
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the final position?");
            x = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            d = x - (((vf*vf) - (vi*vi))/(2*a));
            System.out.println("Initial position is " + df.format(d) + " m");
        }

        in.close();
    }

}