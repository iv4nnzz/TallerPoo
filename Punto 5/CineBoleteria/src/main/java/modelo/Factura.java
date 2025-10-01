package modelo;
//Agregar Ejercicio 5
public class Factura {
    private String nombrePromotora;
    private String tipoFuncion;
    private int cantidadBoletas;
    private boolean tieneTarjetaDescuento;
    private double precioUnitario;
    private double subtotal;
    private double descuento;
    private double totalPagar;
    
    public Factura(String nombrePromotora, String tipoFuncion, int cantidadBoletas, 
                   boolean tieneTarjetaDescuento, double precioUnitario) {
        this.nombrePromotora = nombrePromotora;
        this.tipoFuncion = tipoFuncion;
        this.cantidadBoletas = cantidadBoletas;
        this.tieneTarjetaDescuento = tieneTarjetaDescuento;
        this.precioUnitario = precioUnitario;
        calcularTotal();
    }
    
    private void calcularTotal() {
        this.subtotal = precioUnitario * cantidadBoletas;
        if (tieneTarjetaDescuento) {
            this.descuento = subtotal * 0.10;
        } else {
            this.descuento = 0;
        }
        this.totalPagar = subtotal - descuento;
    }
    
    public String getNombrePromotora() {
        return nombrePromotora;
    }
    
    public void setNombrePromotora(String nombrePromotora) {
        this.nombrePromotora = nombrePromotora;
    }
    
    public String getTipoFuncion() {
        return tipoFuncion;
    }
    
    public void setTipoFuncion(String tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }
    
    public int getCantidadBoletas() {
        return cantidadBoletas;
    }
    
    public void setCantidadBoletas(int cantidadBoletas) {
        this.cantidadBoletas = cantidadBoletas;
        calcularTotal();
    }
    
    public boolean isTieneTarjetaDescuento() {
        return tieneTarjetaDescuento;
    }
    
    public void setTieneTarjetaDescuento(boolean tieneTarjetaDescuento) {
        this.tieneTarjetaDescuento = tieneTarjetaDescuento;
        calcularTotal();
    }
    
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        calcularTotal();
    }
    
    public double getSubtotal() {
        return subtotal;
    }
    
    public double getDescuento() {
        return descuento;
    }
    
    public double getTotalPagar() {
        return totalPagar;
    }
    
    public String toString() {
        return "===== FACTURA DE VENTA =====" +
               "\nPromotora: " + nombrePromotora +
               "\nTipo de Función: " + tipoFuncion +
               "\nCantidad de Boletas: " + cantidadBoletas +
               "\nPrecio Unitario: $" + precioUnitario +
               "\nSubtotal: $" + subtotal +
               "\nDescuento (10%): $" + descuento +
               "\nTotal a Pagar: $" + totalPagar +
               "\n============================";
    }
}
