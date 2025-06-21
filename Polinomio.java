/*Si vuole realizzare la classe Polinomio che implementi un generico polinomio e che metta a disposizione i seguenti metodi:



Il costruttore Polinomio(int numeroCoefficienti) produce un'eccezione IllegalArgumentException se il valore di numeroCoefficienti è minore
di zero. Il costruttore inizializza un Polinomio con numeroMassimo di coefficienti (double) tutti uguali a 0.
-int numeroCoefficienti() che restituisce il numero di coefficienti massimo nel polinomio.
-boolean set(int k, double c) che imposta il coefficiente di grado k al valore c ritornando true se k è l'indice di un coefficiente valido
nel polinomio, false altrimenti.
-double get(int k) che restituisce il valore del coefficiente di grado k o zero se k è un indice non valido.
-int grado() restituisce il grado del polinomio, ossia l'indice più grade dei coefficienti non nulli, o 0 se tutti i coefficienti sono 0.
-double eval(double x) restituisce il valore del polinomio nel punto x.
-Polinomio somma(Polinomio p) che restituisce la somma del Polinomio con quello ricevuto come parametro.
-Polinomio moltiplica(double c, int k) che restituisce il risultato del prodotto del Polinomio per il monomio c*x^k.
-Polinomio moltiplica(Polinomio p) che restituisce il prodotto del Polinomio con quello ricevuto come parametro. */

public class Polinomio {
    private int numeroCoefficienti;
    private double[] polinomio;

    public Polinomio(int numeroCoefficienti) {
        if (numeroCoefficienti < 0) {
            throw new IllegalArgumentException("Il grado minimo è 0");
        }
        this.numeroCoefficienti = numeroCoefficienti;
        polinomio = new double[numeroCoefficienti];

        //Java inizializza a 0 tutti i valori dell'Array, ma per sicurezza si può sempre aggiungere un ciclo for
        //per inizializzare a zero l'Array
        for (int i = 0; i < polinomio.length; i++) {
            polinomio[i] = 0.0;
        }
    }

    public int numeroCoefficienti() {
        return numeroCoefficienti;
    }

    public boolean set(int k, double c) {
        if ((k < 0) || (k > numeroCoefficienti)) return false;

        polinomio[k] = c;
        System.out.println("Il valore è " + polinomio[k]);
        return true;
    }

    public double get(int k) {
        if ((k < 0) || (k > numeroCoefficienti)) return 0.0;
        return polinomio[k];
    }

    //int grado() restituisce il grado del polinomio, ossia l'indice più grade dei coefficienti non nulli, o 0 se tutti i coefficienti sono 0.
    public int grado() {
        int grado = -1;
        for (int i = 0; i < polinomio.length; i++) {
            if (polinomio[i] != 0) grado++;
        }
        if (grado == -1) grado = 0;
        return grado;
    }

    public double valore_di_x(int indice, double valore){
        for (int i = 0; i < indice; i++) {
           valore*=valore;
        }
        return valore;
    }
    public double eval(double x){
        double result = polinomio[0];
        for (int i = 0; i < polinomio.length; i++) {
           result += polinomio[i] * valore_di_x(i,x);
        }
        return result;
    }

    public Polinomio somma(Polinomio p){
        int lunghezza;
        if (p.polinomio.length < this.polinomio.length) lunghezza = this.polinomio.length;
        else lunghezza = p.polinomio.length;

        Polinomio somma = new Polinomio(lunghezza);

        for (int i = 0; i < lunghezza; i++) {
            somma.polinomio[i] = this.polinomio[i] + p.polinomio[i];
        }

        return somma;
    }
   // Polinomio moltiplica(double c, int k) che restituisce il risultato del prodotto del Polinomio per il monomio c*x^k
   public Polinomio moltiplica(double c, int k){
        int lunghezza = k + this.polinomio.length + 1;
       Polinomio prodotto = new Polinomio(lunghezza);
       for (int i = 0; i < lunghezza; i++) {
           prodotto.polinomio[i+k] = this.polinomio[i] * c;
       }
       return prodotto;
   }

    public Polinomio moltiplica(Polinomio p){
        int lunghezza = p.polinomio.length + this.polinomio.length + 1;
        int indice;
        Polinomio prodotto_polinomi = new Polinomio(lunghezza);
        for (int i = 0; i < lunghezza; i++) {

           // prodotto_polinomi.polinomio[indice] = ;
        }
        return prodotto_polinomi;
    }

}
