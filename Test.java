import java.util.function.Supplier;

public class Test {
    static int passedTests = 0, failedTests = 0;
    static Polinomio p1;
    static Polinomio p2;
    static Polinomio p3;

    public static boolean testErroreCreazione() {
        try {
            new Polinomio(-12);
            return false;
        } catch (IllegalArgumentException e) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean testEquals(Polinomio p1, Polinomio p2) {
        if (p1.numeroCoefficienti() != p2.numeroCoefficienti()) return false;
        for(int i=0;i<p1.numeroCoefficienti();i++) {
            if (p1.get(i) != p2.get(i)) return false;
        }
        return true;
    }

    public static Polinomio testCreate(int idx, int n) {
        try {
            return new Polinomio(n);
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static Polinomio testCreate(int idx, double ... args) {
        try {
            Polinomio p = new Polinomio(args.length);
            for(int i=0;i<args.length;i++) {
                p.set(i, args[i]);
            }
            return p;
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return null;
        }
    }


    public static boolean testGetGrado(int idx, Polinomio p, int g) {
        try {
            int res = p.grado();
            if (res != g) {
                System.err.println("ERRORE TEST "+idx+": atteso "+g+" prodotto "+res);
                return false;
            }
            return true;
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean testSet(int idx, Polinomio p, int k, double x, boolean exp) {
        try {
            boolean res = p.set(k, x);
            if (res != exp) {
                System.err.println("ERRORE TEST "+idx+": atteso "+exp+" prodotto "+res);
                return false;
            }
            return true;
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean testGet(int idx, Polinomio p, int k, double exp) {
        try {
            double res = p.get(k);
            if (res != exp) {
                System.err.println("ERRORE TEST "+idx+": atteso "+exp+" prodotto "+res);
                return false;
            }
            return true;
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean testEval(int idx, Polinomio p, double x, double exp) {
        try {
            double res = p.eval(x);
            if (res != exp) {
                System.err.println("ERRORE TEST "+idx+": atteso "+exp+" prodotto "+res);
                return false;
            }
            return true;
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return false;
        }
    }


    public static Polinomio testSomma(int idx, Polinomio p1, Polinomio p2) {
        try {
            return p1.somma(p2);
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static Polinomio testMoltiplica(int idx, Polinomio p1, double x, int k) {
        try {
            return p1.moltiplica(x, k);
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static Polinomio testMoltiplica(int idx, Polinomio p1, Polinomio p2) {
        try {
            return p1.moltiplica(p2);
        } catch (Exception e) {
            System.err.println("ERRORE TEST "+idx);
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        int idx = 1;
        test(testErroreCreazione());
        idx++;
        Polinomio p1 = testCreate(idx++, 5);
        test(p1 != null);
        test(testGetGrado(idx++, p1, 0));
        test(testSet(idx++, p1, 3, 1.0, true));
        test(testGetGrado(idx++, p1, 3));
        test(testSet(idx++, p1, 10, 1.0, false));
        Polinomio p2 = testCreate(idx++, 1.0, 2.0, 3.0);
        test(p2 != null);
        Polinomio p3 = testSomma(idx++, p2, p2);
        test((p3 != null)&&(testCoefficienti(p3, 2.0, 4.0, 3.0)));
        Polinomio p4 = testMoltiplica(idx++, p2, 2.0, 2);
        test((p4 != null)&&(testCoefficienti(p4, 0.0, 0.0, 2.0, 4.0, 6.0)));
        Polinomio p5 = testMoltiplica(idx++, p2, p2);
        test((p5 != null)&&(testCoefficienti(p5, 1.0, 4.0, 10.0, 12.0, 9.0)));
        test(testEval(idx++, p2, 2.0, 17.0));
        test(testEval(idx++, p2, 0.0, 1.0));

    }

    private static boolean testCoefficienti(Polinomio p1, double ... args) {
        if (p1.numeroCoefficienti()<args.length) {
            return false;
        }
        for(int i=0;i<args.length;i++) {
            if (p1.get(i) != args[i]) {
                return false;
            }
        }
        return true;
    }

    private static void test(boolean b) {
        if (b) passedTests++; else  failedTests++;
        System.out.println(""+(passedTests+failedTests)+". "+(b?"OK":"NO"));
    }
}
