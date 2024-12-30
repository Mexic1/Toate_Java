package Lab3.ex1;

public class Parabola {
    private final double a;
    private final double b;
    private final double c;
    public Parabola(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Override
    public String toString() {
        return "f(x) = " + a + "x^2 + " + b + "x + " + c;
    }

    public double[] Varf() {
        double x_v = -b / (2 * a);
        double y_v = -b*b/(4*a)+c;
        return new double[] {x_v, y_v};
    }

    public double[] Mij_Segment(double a,double b,double c) {
        double x=((-b/(2*a))+(-this.b/(2*this.a)))/2;
        double y=((-b*b/(4*a)+c)+(-this.b*this.b/(4*this.a)+this.c))/2;
        return new double[] {x,y};
    }

    public  double Lungime_one(double a,double b,double c) {
        double x = -b / (2 * a);
        double y = -b*b/(4*a)+c;
        return Math.hypot(this.Varf()[0]-x,this.Varf()[1]-y);
    }

}
