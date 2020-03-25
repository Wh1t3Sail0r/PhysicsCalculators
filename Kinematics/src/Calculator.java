
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Arrays;


public class Calculator {
    static double velocity, angle, inith, range1, time, maxh1, range2, range3, maxh2;
    static int x = 0;
    public static void Input() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Please answer these questions about the projectile motion problem");
        System.out.println("Enter angle of projection in degrees");
        angle = in.nextDouble();
        System.out.println("The launch angle is " + angle + " degrees");
        System.out.println("Enter the projectile's velocity");
        velocity = in.nextDouble();
        System.out.println("The projectile's velocity is " + velocity + " m/s");
        System.out.println("Enter the initial height of the object in meters");
        inith = in.nextDouble();
        System.out.println("The projectile's initial height is " + inith + " m");
        in.close();
    }

    public static void question() {
        Scanner in = new Scanner(System.in);
        System.out.println("Which value is missing from the problem? (not the one you are solving for)");
        System.out.println(" Press 1 if final velocity is missing\n Press 2 if acceleration is missing");
        System.out.println(" Press 3 if change in position is missing\n Press 4 if total time is missing");
        int missing = in.nextInt();

        if(missing == 1) {
            MissingFinalVelocity.missingFinalVelocity();
        }
        if(missing == 2) {
            MissingAcceleration.missingAcceleration();
        }
        if(missing == 3) {
            MissingFinalPosition.missingFinalPosition();
        }
        if(missing == 4) {
            MissingTime.missingTime();
        }
        in.close();
    }

    public static DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        System.out.println("WELCOME TO THE KINEMATIC EQUATIONS CALCULATOR");
        System.out.println("All units are SI, meaning time is seconds and displacement is meters.");
        System.out.println("All answers are truncated to two (2) decimal places");
        System.out.println("What type of problem are you trying to solve? \n Press 1 for constant velocity in one dimension");
        System.out.println(" Press 2 for average velocity in one dimension\n Press 3 for constant acceleration in one dimension");
        System.out.println(" Press 4 for projectile motion");
        int choice = in.nextInt();
        if(choice == 1) {

            ConstantVelocity.constantVelocity();
        }
        else if(choice == 2) {

            ConstantVelocity.averageVelocity();
        }
        else if(choice == 3) {
            question();
        }
        else if(choice == 4) {
            System.out.println("To completely solve any projectile motion problem, the only required values are the velocity at which the object \nis launched at, the angle at which it is launched, and the initial height.");
            System.out.println("However, it is possible to solve parts of a projectile motion problem with just the maximum height, total time, and velocity.");
            System.out.println("Here are all the values you can find \n Velocity\n Angle\n Initial height\n Maximum height\n Horizontal distance\n Total time");
            System.out.println("How many values are you missing?");
            int missing = in.nextInt();
            System.out.println("Which values are you missing? If any values equal 0, do not include them in this list. Please separate each value by pressing 'enter' or 'return'");
            in.nextLine();
            String[] criteria = new String[missing];
            for(int i = 0; i < criteria.length; i++) {
                criteria[i] = in.nextLine();
            }
            if(Arrays.asList(criteria).contains("velocity")) {
                System.out.println("Looks like you are missing the projectile's velocity.");
                System.out.println("Try using one of the constant acceleration equations to calculate the velocity of the x and y components.");
                System.out.println("Once you have calculated that, use Pythagorean's theorem to calculate the projectile's velocity");
                System.out.println();
                x++;
            }
            if(Arrays.asList(criteria).contains("angle")) {
                System.out.println("Looks like you are missing the projectile's angle.");
                System.out.println("Try using one of the constant acceleration equations to calculate the velocity of the x and y components.");
                System.out.println("Once you have calculated that, use Pythagorean's theorem to calculate the projectile's velocity");
                System.out.println("To find the angle from there, use either the sine, cosine, or tangent functions to calculate the angle");
                System.out.println("Make sure you are in degrees!");
                System.out.println();
                x++;
            }
            if(x != 0) {
                System.out.println("Let's see which equation you need so we can solve the projectile motion problem");
                question();
            }
            else {
                Input();
                if(inith == 0) {
                    ProjectileMotion p1 = new ProjectileMotion(velocity,angle);
                    range1=p1.MaxHorRange();
                    time=p1.TimeOfFlight();
                    maxh1=p1.MaxHeight();
                    System.out.println("Horizontal range for this projectile is " + df.format(range1) + " m");
                    System.out.println("Maximum height for this projectile is " + df.format(maxh1) + " m");
                    System.out.println("Time of flight for this projectile is " + df.format(time) + " s");
                }
                else if(inith != 0) {
                    ProjectileMotionWithHeight p1 = new ProjectileMotionWithHeight(velocity,angle,inith);
                    range1=p1.MaxHorRange();
                    time=p1.TimeOfFlight();
                    maxh1=p1.MaxHeight();
                    range2=p1.RusingHandV();
                    range3=p1.RusingTandV();
                    maxh2=p1.HusingT();
                    System.out.println("Horizontal range for this projectile is " + df.format(range1) + " m");
                    System.out.println("Maximum height for this projectile is " + df.format(maxh1) + " m");
                    System.out.println("Time of flight for this projectile is " + df.format(time) + " s");
                }
            }

        }
        in.close();

    }

}
