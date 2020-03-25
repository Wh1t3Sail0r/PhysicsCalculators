import java.text.DecimalFormat;
import java.util.Scanner;

public class MissingFinalPosition {

    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void missingFinalPosition() {
        Scanner in = new Scanner(System.in);

        // double x = 0;
        // double d = 0;
        double t = 0;

        double vi = 0;
        double vf = 0;
        double a = 0;

        System.out.println("Which value are you trying to find?\n Press 1 for final velocity");
        System.out.println(" Press 2 for initial velocity\n Press 3 for time\n Press 4 for acceleration");
        int value = in.nextInt();

        if(value == 1) {
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            vf = vi + a*t;
            System.out.println("Final velocity is " + df.format(vf) + " m/s");
        }
        else if(value == 2) {
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            vi = vf - a*t;
            System.out.println("Initial velocity is " + df.format(vi) + " m/s");
        }
        else if(value == 3) {
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the acceleration?");
            a = in.nextDouble();
            t = (vf-vi)/a;
            System.out.println("Total time is " + df.format(t) + " s");
        }
        else if(value == 4) {
            System.out.println("What is the initial velocity?");
            vi = in.nextDouble();
            System.out.println("What is the final velocity?");
            vf = in.nextDouble();
            System.out.println("What is the total time?");
            t = in.nextDouble();
            a = (vf-vi)/t;
            System.out.println("Constant acceleration is " + df.format(a) + " m/s/s");
        }

        in.close();
    }

}