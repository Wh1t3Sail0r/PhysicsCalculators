
import java.lang.Math;


public class ProjectileMotion {

    // v = velocity
    // T = theta
    // R = range
    // t = time
    // H = max height

    double v,T,R,t,H;
    double vx,vy;
    final double g = 9.80665;

    public ProjectileMotion(double v,double T){
        this.v = v;
        this.T = Math.abs((3.1416/180)*T);
    }
    public void set(){
        vy = Math.sin(T);
        vx = Math.cos(T);
        this.R = (2*(vx*vy))/g;
        this.t = (2*vy)/g;
        this.H = (vy*vy)/(2*g);
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
        return 4*Math.sqrt(H*(v*v/(2*g)-H));
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
        return (vy*time-0.5*g*time*time);
    }
    public double HeightAtDistance(double x){
        return (x*Math.tan(T)-(g*x*x/(2*Math.pow(vx,2))));
    }

}
