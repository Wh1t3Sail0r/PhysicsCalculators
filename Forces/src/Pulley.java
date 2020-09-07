import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Pulley {
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void pulleyForce(boolean mode) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Does the pulley have mass?\n Press 1 if it doesn't have mass\n Press 2 if it does have mass");
        int choice = scan.nextInt();
        boolean b = false;
        String unit = "deg";
        if(choice == 2) { b = true; }
        if(mode) { unit = "rad"; }

        // Use the pulley formula to calculate acceleration and force on each object on the pulley
        // a = g(m2 - m1)/(m1 + m2) for massless
        // a = g(m2 - m1)/(m1 + m2 + km) for mass: k is the moment of inertia constant
        
        double[] args = getPulleyArgs(b);
        if(!b) {
            String acceleration = df.format(Math.abs(9.8 * (args[0] - args[1]) / (args[1] + args[0])));
            System.out.println("The magnitude of acceleration on both objects is " + acceleration + " m/s/s");
            System.out.println("The magnitude of force on object 1 is " + df.format(args[0] * Double.parseDouble(acceleration)));
            System.out.println("The magnitude of force on object 2 is " + df.format(args[1] * Double.parseDouble(acceleration)));
        }
        else {
            String acceleration = df.format(Math.abs(9.8 * (args[0] - args[1]) / (args[1] + args[0] + 0.5 * args[2])));
            System.out.println("The magnitude of linear acceleration on both objects is " + acceleration + " m/s/s");
            if(mode) { System.out.println("The magnitude of angular acceleration of the pulley is " + df.format(Double.parseDouble(acceleration) * args[3]) + " " + unit + "/s/s");  }
            else { System.out.println("The magnitude of angular acceleration of the pulley is " + df.format(Double.parseDouble(acceleration) * args[3] * 180/Math.PI) + " " + unit + "/s/s");  }

                System.out.println("The magnitude of force on object 1 is " + df.format(args[0] * Double.parseDouble(acceleration)) + " newtons");
            System.out.println("The magnitude of torque on object 1 is " + df.format(args[0] * Double.parseDouble(acceleration) * args[3]) + " newton meters");

            System.out.println("The magnitude of force on object 2 is " + df.format(args[1] * Double.parseDouble(acceleration)) + " newtons");
            System.out.println("The magnitude of torque on object 2 is " + df.format(args[1] * Double.parseDouble(acceleration) * args[3]) + " newton meters");
        }
    }

    public static double[] getPulleyArgs(boolean b) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the mass of the first object on the pulley. Hit return or enter when finished: ");
        double mass1 = scan.nextDouble();
        System.out.print("Enter the mass of the second object on the pulley. Hit return or enter when finished: ");
        double mass2 = scan.nextDouble();

        if(b) {
            System.out.print("Enter the mass of the pulley. Hit return or enter when finished: ");
            double pulleyMass = scan.nextDouble();
            System.out.print("Enter the radius of the pulley. Hit return or enter when finished: ");
            double pulleyRadius = scan.nextDouble();
            System.out.println();
            return new double[]{mass1, mass2, pulleyMass, pulleyRadius};
        }
        System.out.println();
        return new double[]{mass1, mass2};
    }

}
