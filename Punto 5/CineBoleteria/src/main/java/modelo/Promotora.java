package modelo;

public class Promotora {
    private String nombre;
    private double precio35mm;
    private double precio3D;
    private double totalFacturado;
    private int boletasVendidas35mm;
    private int boletasVendidas3D;
    
    public Promotora(String nombre, double precio35mm, double precio3D) {
        this.nombre = nombre;
        this.precio35mm = precio35mm;
        this.precio3D = precio3D;
        this.totalFacturado = 0;
        this.boletasVendidas35mm = 0;
        this.boletasVendidas3D = 0;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public double getPrecio35mm() {
        return precio35mm;
    }
    
    public void setPrecio35mm(double precio35mm) {
        this.precio35mm = precio35mm;
    }
    
    public double getPrecio3D() {
        return precio3D;
    }
    
    public void setPrecio3D(double precio3D) {
        this.precio3D = precio3D;
    }
    
    public double getTotalFacturado() {
        return totalFacturado;
    }
    
    public void setTotalFacturado(double totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
    
    public int getBoletasVendidas35mm() {
        return boletasVendidas35mm;
    }
    
    public void setBoletasVendidas35mm(int boletasVendidas35mm) {
        this.boletasVendidas35mm = boletasVendidas35mm;
    }
    
    public int getBoletasVendidas3D() {
        return boletasVendidas3D;
    }
    
    public void setBoletasVendidas3D(int boletasVendidas3D) {
        this.boletasVendidas3D = boletasVendidas3D;
    }
    
    public void agregarVenta(double monto, String tipoFuncion, int cantidadBoletas) {
        this.totalFacturado += monto;
        if (tipoFuncion.equals("35mm")) {
            this.boletasVendidas35mm += cantidadBoletas;
        } else if (tipoFuncion.equals("3D")) {
            this.boletasVendidas3D += cantidadBoletas;
        }
    }
    
    public String toString() {
        return "Promotora: " + nombre + 
               "\nTotal Facturado: $" + totalFacturado +
               "\nBoletas 35mm vendidas: " + boletasVendidas35mm +
               "\nBoletas 3D vendidas: " + boletasVendidas3D;
    }
}