import java.lang.Math;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class NetForce {
    public static DecimalFormat df = new DecimalFormat("0.00");

    public static void netForce(boolean radMode) {
        Scanner scan = new Scanner(System.in);

        System.out.println("How many forces are acting on the object?");
        int num = scan.nextInt();

        System.out.println("Enter all forces with the magnitude, followed by a comma, and the angle with respect to the horizontal. Leave out units. Separate each force by pressing enter or return");
        double[] forces = new double[num];
        double[] directions = new double[num];

        for(int i = 0; i < num; i++) {
            Scanner s = new Scanner(System.in);
            String forceAndDirection = s.nextLine();
            double force = Double.parseDouble(forceAndDirection.substring(0, forceAndDirection.indexOf(',')));
            double direction = Double.parseDouble(forceAndDirection.substring(forceAndDirection.indexOf(',') + 1));
            forces[i] = force;
            directions[i] = direction;
        }

        System.out.println(calculateForce(directions, forces, radMode));

    }

    public static String calculateForce(double[] d, double[] f, boolean b) {
        int len = d.length;
        ArrayList<Double> horizForces = new ArrayList<>();
        ArrayList<Double> vertForces = new ArrayList<>();

        // Convert angles and forces into horizontal and vertical components
        if(b) {
            for(int i = 0; i < len; i++) {
                horizForces.add(Math.cos(d[i]) * f[i]);
                vertForces.add(Math.sin(d[i]) * f[i]);
            }
        }
        else {
            for(int i = 0; i < len; i++) {
                horizForces.add(Math.cos(d[i] * Math.PI/180) * f[i]);
                vertForces.add(Math.sin(d[i] * Math.PI/180) * f[i]);
            }
        }

        // Create two forces that sum up the horizontal and vertical forces
        double horiz = 0.0;
        double vert = 0.0;

        for(int i = 0; i < horizForces.size(); i++) {
            horiz += horizForces.get(i);
            vert += vertForces.get(i);
        }

        // Vector calculation for net force
        double angle = Math.atan2(vert, horiz);
        if(!b) { angle = Math.atan2(vert, horiz) * 180/Math.PI; }

        double magnitude = Math.sqrt(Math.pow(horiz, 2) + Math.pow(vert, 2));
        String finalDir = "above";
        if(angle < 0 || (horiz < 0 && vert < 0)) { finalDir = "below"; }

        String unit = " degrees ";
        if(b) { unit = " radians "; }

        if(b) {
            String radAngle = df.format(Math.abs(angle/Math.PI)) + "π";
            return "Net force on the object is " + df.format(magnitude) + " newtons at " + radAngle + unit  + finalDir + " the horizontal";
        }

        return "Net force on the object is " + df.format(magnitude) + " newtons at " + df.format(Math.abs(angle)) + unit  + finalDir + " the horizontal";
    }

}
