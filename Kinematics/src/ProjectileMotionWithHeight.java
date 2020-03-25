
import java.lang.Math;


public class ProjectileMotionWithHeight {

    // v = velocity
    // T = theta
    // R = range
    // t = time
    // h = initial height
    // H = max height

    double v,T,R,t,h,H;
    double vx, vy;
    double radical;
    final double g = 9.80665;

    public ProjectileMotionWithHeight(double v,double T, double h){
        this.v = v;
        this.T = Math.abs((3.1416/180)*T);
        this.h = h;
    }
    public void set(){
        this.vx = v*Math.cos(T);
        this.vy = v*Math.sin(T);
        this.radical = (vy*vy) + (2*g*h);
        this.R = vx * (vy+Math.sqrt(radical))/g;
        this.t = (vy+Math.sqrt(radical))/g;
        this.H = h+((vy*vy)/(2*g));
    }
    public double MaxHorRange(){
        set();
        return this.R;
    }
    public double TimeOfFlight(){
        set();
        return this.t;
    }
    public double MaxHeight(){
        set();
        return this.H;
    }
    public double RusingHandV(){
        set();
        return this.R;
    }
    public double HusingT(){
        set();
        return g*t*t*0.125;
    }
    public double RusingTandV(){
        set();
        return 0.5*t*Math.sqrt(4*v*v-g*t*g*t);
    }
    public double HorDistanceAtTime(double time){
        return v*Math.cos(T)*time;
    }
    public double HeightAtTime(double time){
        return (v*Math.sin(T)*time-0.5*g*time*time);
    }
    public double HeightAtDistance(double x){
        return (x*Math.tan(T)-(g*x*x/(2*Math.pow(v*Math.cos(T),2))));
    }

}
