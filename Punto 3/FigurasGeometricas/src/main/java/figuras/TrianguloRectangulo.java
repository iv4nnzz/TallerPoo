package figuras;

public class TrianguloRectangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    
    public TrianguloRectangulo(double base, double altura) {
        super("Triángulo Rectángulo");
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
        return (base * altura) / 2;
    }
    
    public double calcularPerimetro() {
        double hipotenusa = calcularHipotenusa();
        return base + altura + hipotenusa;
    }
    
    public double calcularHipotenusa() {
        return Math.sqrt((base * base) + (altura * altura));
    }
    
    public String tipoTriangulo() {
        double hipotenusa = calcularHipotenusa();
        
        double baseRedondeada = Math.round(base * 100.0) / 100.0;
        double alturaRedondeada = Math.round(altura * 100.0) / 100.0;
        double hipotenusaRedondeada = Math.round(hipotenusa * 100.0) / 100.0;
        
        if (baseRedondeada == alturaRedondeada && 
            baseRedondeada == hipotenusaRedondeada) {
            return "Equilátero";
        }
        else if (baseRedondeada == alturaRedondeada || 
                 baseRedondeada == hipotenusaRedondeada || 
                 alturaRedondeada == hipotenusaRedondeada) {
            return "Isósceles";
        }
        else {
            return "Escaleno";
        }
    }
    
    public String toString() {
        return "Triángulo Rectángulo con base: " + base + " cm y altura: " + altura + " cm";
    }
}