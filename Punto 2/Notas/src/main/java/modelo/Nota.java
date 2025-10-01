package modelo;

public class Nota {
    private double valor;
    private boolean aprobada;
    
    public Nota(double valor) {
        this.valor = valor;
        this.aprobada = (valor >= 3.0);
    }
    
    public boolean esAprobada() {
        return aprobada;
    }
    
    public double getValor() {
        return valor;
    }
    
    public String toString() {
        String estado = aprobada ? "Aprobada" : "Reprobada";
        return "Nota: " + valor + " - " + estado;
    }
}