package figuras;

public class Circulo extends FiguraGeometrica {
    private double radio;
    
    public Circulo(double radio) {
        super("Círculo");
        this.radio = radio;
    }
    
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    public String toString() {
        return "Círculo con radio: " + radio + " cm";
    }
}