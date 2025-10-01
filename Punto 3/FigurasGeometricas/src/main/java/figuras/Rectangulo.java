package figuras;

public class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura) {
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }
    
    public double getBase() {
        return base;
    }
    
    public void setBase(double base) {
        this.base = base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double calcularArea() {
        return base * altura;
    }
    
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
    
    public String toString() {
        return "Rectángulo con base: " + base + " cm y altura: " + altura + " cm";
    }
}