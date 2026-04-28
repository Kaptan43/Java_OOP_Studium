package uebung03.polynomial;

public class Polynomial {
    private final int[] polynom;
    private final int degree;

    public Polynomial(int[] polynom) {
        this.polynom = polynom;
        int tempDegree = 0;
        for (int i = polynom.length - 1; i >= 0; i--) {
            if (polynom[i] != 0) {
                tempDegree = i;
                break;
            }
        }
        this.degree = tempDegree;
    }

    public Polynomial() {
        this(new int[]{0, 1});
    }

    public static Polynomial constant(int v) {
        return new Polynomial(new int[]{v});
    }

    public int getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean ersterTerm = true;
        for (int i = polynom.length - 1; i >= 0; i--) {
            //Block 1
            if (polynom[i] == 0) continue; //Überspringe Nullen
            else if (ersterTerm && polynom[i] < 0) {
                sb.append("-");
                ersterTerm = false;
            }
            else if (!ersterTerm && polynom[i] > 0) {
                sb.append(" + ");
            }
            else if (!ersterTerm && polynom[i] < 0) {
                sb.append(" - ");
            }

            //Block 2
            if (i == 0 || Math.abs(polynom[i]) != 1) {
                sb.append(Math.abs(polynom[i]));
            }

            //Block 3
            if (i > 1) {
                if (Math.abs(polynom[i]) != 1) {
                    sb.append("*");
                }
                sb.append("x^");
                sb.append(i);
            }
            else if (i == 1) {
                if (Math.abs(polynom[i]) != 1) {
                    sb.append("*");
                }
                sb.append("x");
            }
            ersterTerm = false;
        }
        if (sb.length() == 0) {
            sb.append("0");
        }
        return sb.toString();
    }

    public Polynomial add(Polynomial p) {
        int maxLength = Math.max(polynom.length, p.polynom.length);
        int result[] = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int a = (i < polynom.length) ? polynom[i] : 0;
            int b = (i < p.polynom.length) ? p.polynom[i] : 0;
            result[i] = a + b;
        }
        return new Polynomial(result);
    }

    public Polynomial sub(Polynomial p) {
        int maxLength = Math.max(polynom.length, p.polynom.length);
        int result[] = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            int a = (i < polynom.length) ? polynom[i] : 0;
            int b = (i < p.polynom.length) ? p.polynom[i] : 0;
            result[i] = a - b;
        }
        return new Polynomial(result);
    }

    public Polynomial mult(Polynomial p) {
        int maxLength = polynom.length + p.polynom.length - 1;
        int[] result = new int[maxLength];
        for (int i = 0; i < polynom.length; i++) {
            for (int j = 0; j < p.polynom.length; j++) {
                result[i + j] += polynom[i] * p.polynom[j]; //Hier ist das "+=" besonders wichtig, da mehrere Terme den gleichen Index haben können und miteinander addiert werden müssen! Es darf also kein "=" sein!
            }
        }
        return new Polynomial(result);
    }

    public Polynomial add(int v) {
        return add(Polynomial.constant(v));
    }

    public Polynomial sub(int v) {
        return sub(Polynomial.constant(v));
    }

    public Polynomial mult(int v) {
        return mult(Polynomial.constant(v));
    }

/* 
    public uebung03.polynomial.Polynomial add(uebung03.polynomial.Polynomial p){
        int maxLength = Math.max(polynom.length, p.polynom.length);
        int[] result = new int[maxLength];
        if(polynom.length == p.polynom.length){
            for(int i = polynom.length-1; i >= 0; i--){
                result [i] = polynom[i] + p.polynom[i];
            }
        }
        else if(polynom.length < p.polynom.length){
            for(int i = p.polynom.length-1; i >= 0; i--){
                if(i < polynom.length){
                    result [i] = p.polynom[i];
                }
                result[i] = polynom[i] + p.polynom[i];
            }
        }
    }
*/

    public Polynomial exp(int exponent) {
        Polynomial p = Polynomial.constant(1);
        for (int i = 0; i < exponent; i++) {
            p = p.mult(this);
        }
        return p;
    }

    public int apply(int x) {
        int result = 0;
        for (int i = polynom.length - 1; i >= 0; i--) {
            result = result * x + polynom[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, -4, 5, 8, 9};
        Polynomial p = new Polynomial(array);
        System.out.println(p.toString());
        System.out.println(new Polynomial(new int[]{1, 2, 3, 4}).toString());
        System.out.println(new Polynomial(new int[]{0, 0, 0}).toString());
        System.out.println(new Polynomial(new int[]{3}).toString());
        System.out.println(new Polynomial().toString());
        System.out.println(Polynomial.constant(5).toString());
        System.out.println(new Polynomial(new int[]{0, -1, 2, 3, -2, 0, 1}).toString());

        System.out.println("\n");

        Polynomial p1 = new Polynomial(new int[]{1, 2, 3, 4});
        Polynomial p6 = new Polynomial(new int[]{0, -1, 2, 3, -2, 0, 1});
        System.out.println(p1.add(p6).toString());
        // => "x^6 - 2*x^4 + 7*x^3 + 5*x^2 + x + 1"
        System.out.println(p1.sub(p6).toString());
        // => "-x^6 + 2*x^4 + x^3 + x^2 + 3*x + 1"
        System.out.println(p1.mult(p1).toString());
        // => "16*x^6 + 24*x^5 + 25*x^4 + 20*x^3 + 10*x^2 + 4*x + 1"

        System.out.println("\n");

        System.out.println(p1.add(5).toString());
        // => "4*x^3 + 3*x^2 + 2*x + 6"
        System.out.println(p1.mult(5).toString());
        // => "20*x^3 + 15*x^2 + 10*x + 5"

        System.out.println("\n");

        System.out.println(p1.exp(5).toString());
        // => "1024*x^15 + 3840*x^14 + ..."

        System.out.println("\n");

        System.out.println(p1.apply(0));  // => 1
        System.out.println(p1.apply(1));  // => 10
        System.out.println(p1.apply(2));  // => 49
    }
}