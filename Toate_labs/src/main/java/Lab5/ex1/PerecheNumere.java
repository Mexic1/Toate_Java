package Lab5.ex1;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere() {}
    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }


    public boolean isConsecutive() {
        if(a == b - 1 || a == b + 1) {
            return true;
        }
        else return false;
    }

    public int cmmdc() {
        int a = this.a;
        int b = this.b;
        while(a != b) {
            if(a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }

    public boolean isSumaCifrelorEgala() {
        int sumaCifreA = 0;
        int sumaCifreB = 0;
        int a = this.a;
        int b = this.b;
        while(a != 0) {
            sumaCifreA += a % 10;
            a = a / 10;
        }
        while(b != 0) {
            sumaCifreB += b % 10;
            b = b / 10;
        }
        if(sumaCifreA == sumaCifreB) {
            return true;
        }
        else return false;
    }

    public boolean isNumarCifrePareEgale() {
        int nrCifrePareA = 0;
        int nrCifrePareB = 0;
        int a = this.a;
        int b = this.b;
        while(a != 0) {
            if((a % 10) % 2 == 0) {
                nrCifrePareA++;
            }
            a = a / 10;
        }
        while(b != 0) {
            if((b % 10) % 2 == 0) {
                nrCifrePareB++;
            }
            b = b / 10;
        }
        if(nrCifrePareA == nrCifrePareB) {
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
