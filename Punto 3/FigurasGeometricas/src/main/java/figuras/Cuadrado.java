package figuras;

public class Cuadrado extends FiguraGeometrica {
    private double lado;
    
    public Cuadrado(double lado) {
        super("Cuadrado");
        this.lado = lado;
    }
    
    public double getLado() {
        return lado;
    }
    
    public void setLado(double lado) {
        this.lado = lado;
    }
    
    public double calcularArea() {
        return lado * lado;
    }
    
    public double calcularPerimetro() {
        return 4 * lado;
    }
    
    public String toString() {
        return "Cuadrado con lado: " + lado + " cm";
    }
}