package principal;

import modelo.Factura;
import modelo.Promotora;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class SistemaCine {
    
    private static ArrayList<Factura> listaFacturas = new ArrayList<>();
    private static Promotora cineColombia = new Promotora("Cine Colombia", 8000, 9500);
    private static Promotora royalFilms = new Promotora("Royal Films", 6500, 8500);
    
    public static void main(String[] args) {
        
        int opcion;
        String menu = "===== SISTEMA DE VENTA DE BOLETAS =====\n" +
                      "1. Vender Boletas\n" +
                      "2. Ver Total Facturado por Promotora\n" +
                      "3. Ver Tipo de Función más Vendida\n" +
                      "4. Ver Todas las Facturas\n" +
                      "5. Salir\n" +
                      "Seleccione una opción:";
        
        do {
            String opcionStr = JOptionPane.showInputDialog(menu);
            
            if (opcionStr == null) {
                opcion = 5;
            } else {
                try {
                    opcion = Integer.parseInt(opcionStr);
                } catch (NumberFormatException e) {
                    opcion = 0;
                }
            }
            
            switch(opcion) {
                case 1:
                    venderBoletas();
                    break;
                case 2:
                    verTotalFacturado();
                    break;
                case 3:
                    verTipoFuncionMasVendida();
                    break;
                case 4:
                    verTodasLasFacturas();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while(opcion != 5);
    }
    
    private static void venderBoletas() {
        String[] promotoras = {"Cine Colombia", "Royal Films"};
        String promotoraSeleccionada = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione la promotora:",
            "Venta de Boletas",
            JOptionPane.QUESTION_MESSAGE,
            null,
            promotoras,
            promotoras[0]
        );
        
        if (promotoraSeleccionada == null) return;
        
        String[] tiposFuncion = {"35mm", "3D"};
        String tipoFuncionSeleccionada = (String) JOptionPane.showInputDialog(
            null,
            "Seleccione el tipo de función:",
            "Venta de Boletas",
            JOptionPane.QUESTION_MESSAGE,
            null,
            tiposFuncion,
            tiposFuncion[0]
        );
        
        if (tipoFuncionSeleccionada == null) return;
        
        String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad de boletas:");
        if (cantidadStr == null) return;
        
        int cantidadBoletas;
        try {
            cantidadBoletas = Integer.parseInt(cantidadStr);
            if (cantidadBoletas <= 0) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida");
            return;
        }
        
        int respuestaDescuento = JOptionPane.showConfirmDialog(
            null,
            "¿El cliente tiene tarjeta de descuento?",
            "Descuento",
            JOptionPane.YES_NO_OPTION
        );
        boolean tieneDescuento = (respuestaDescuento == JOptionPane.YES_OPTION);
        
        double precioUnitario = 0;
        Promotora promotoraActual = null;
        
        if (promotoraSeleccionada.equals("Cine Colombia")) {
            promotoraActual = cineColombia;
            if (tipoFuncionSeleccionada.equals("35mm")) {
                precioUnitario = cineColombia.getPrecio35mm();
            } else {
                precioUnitario = cineColombia.getPrecio3D();
            }
        } else {
            promotoraActual = royalFilms;
            if (tipoFuncionSeleccionada.equals("35mm")) {
                precioUnitario = royalFilms.getPrecio35mm();
            } else {
                precioUnitario = royalFilms.getPrecio3D();
            }
        }
        
        Factura nuevaFactura = new Factura(
            promotoraSeleccionada,
            tipoFuncionSeleccionada,
            cantidadBoletas,
            tieneDescuento,
            precioUnitario
        );
        
        listaFacturas.add(nuevaFactura);
        
        promotoraActual.agregarVenta(
            nuevaFactura.getTotalPagar(),
            tipoFuncionSeleccionada,
            cantidadBoletas
        );
        
        JOptionPane.showMessageDialog(null, nuevaFactura.toString());
        
        String pagoStr = JOptionPane.showInputDialog(
            "Total a pagar: $" + nuevaFactura.getTotalPagar() + 
            "\nIngrese el monto recibido:"
        );
        
        if (pagoStr != null) {
            try {
                double montoRecibido = Double.parseDouble(pagoStr);
                if (montoRecibido >= nuevaFactura.getTotalPagar()) {
                    double cambio = montoRecibido - nuevaFactura.getTotalPagar();
                    JOptionPane.showMessageDialog(null, 
                        "Pago exitoso!\nMonto recibido: $" + montoRecibido +
                        "\nCambio: $" + cambio);
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Monto insuficiente. Faltan: $" + 
                        (nuevaFactura.getTotalPagar() - montoRecibido));
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Monto inválido");
            }
        }
    }
    
    private static void verTotalFacturado() {
        String reporte = "===== TOTAL FACTURADO POR PROMOTORA =====\n\n";
        reporte += cineColombia.toString() + "\n\n";
        reporte += royalFilms.toString();
        
        JOptionPane.showMessageDialog(null, reporte);
    }
    
    private static void verTipoFuncionMasVendida() {
        int total35mm = cineColombia.getBoletasVendidas35mm() + royalFilms.getBoletasVendidas35mm();
        int total3D = cineColombia.getBoletasVendidas3D() + royalFilms.getBoletasVendidas3D();
        
        String reporte = "===== TIPO DE FUNCIÓN MÁS VENDIDA =====\n\n";
        reporte += "Total boletas 35mm: " + total35mm + "\n";
        reporte += "Total boletas 3D: " + total3D + "\n\n";
        
        if (total35mm > total3D) {
            reporte += "El tipo de función más vendida es: 35mm";
        } else if (total3D > total35mm) {
            reporte += "El tipo de función más vendida es: 3D";
        } else {
            reporte += "Ambos tipos de función tienen las mismas ventas";
        }
        
        JOptionPane.showMessageDialog(null, reporte);
    }
    
    private static void verTodasLasFacturas() {
        if (listaFacturas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay facturas registradas");
            return;
        }
        
        String reporte = "===== LISTADO DE FACTURAS =====\n\n";
        for (int i = 0; i < listaFacturas.size(); i++) {
            reporte += "Factura #" + (i + 1) + "\n";
            reporte += listaFacturas.get(i).toString() + "\n\n";
        }
        
        JOptionPane.showMessageDialog(null, reporte);
    }
}