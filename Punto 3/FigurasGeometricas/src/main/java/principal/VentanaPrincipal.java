package principal;

import figuras.*;
import javax.swing.JOptionPane;

public class VentanaPrincipal {
    
    private static FiguraGeometrica figuraActual;
    
    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }
    
    public static void mostrarMenuPrincipal() {
        boolean continuar = true;
        
        while (continuar) {
            String[] opciones = {
                "Círculo",
                "Rectángulo", 
                "Cuadrado",
                "Triángulo Rectángulo",
                "Salir"
            };
            
            String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "CALCULADORA DE FIGURAS GEOMÉTRICAS\n\n" +
                "Seleccione una figura para calcular:",
                "Menú Principal",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            
            if (seleccion == null || seleccion.equals("Salir")) {
                JOptionPane.showMessageDialog(null, 
                    "Gracias por usar el programa", 
                    "Hasta luego", 
                    JOptionPane.INFORMATION_MESSAGE);
                continuar = false;
            } else {
                procesarSeleccion(seleccion);
            }
        }
    }
    
    private static void procesarSeleccion(String seleccion) {
        try {
            switch (seleccion) {
                case "Círculo":
                    crearCirculo();
                    break;
                case "Rectángulo":
                    crearRectangulo();
                    break;
                case "Cuadrado":
                    crearCuadrado();
                    break;
                case "Triángulo Rectángulo":
                    crearTrianguloRectangulo();
                    break;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, 
                "Error: Debe ingresar valores numéricos válidos", 
                "Error de entrada", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private static void crearCirculo() {
        double radio = leerNumeroPositivo("Ingrese el radio del círculo (cm):");
        
        if (radio > 0) {
            figuraActual = new Circulo(radio);
            mostrarResultadosCirculo();
        }
    }
    
    private static void crearRectangulo() {
        double base = leerNumeroPositivo("Ingrese la base del rectángulo (cm):");
        if (base <= 0) return;
        
        double altura = leerNumeroPositivo("Ingrese la altura del rectángulo (cm):");
        if (altura <= 0) return;
        
        figuraActual = new Rectangulo(base, altura);
        mostrarResultadosRectangulo();
    }
    
    private static void crearCuadrado() {
        double lado = leerNumeroPositivo("Ingrese el lado del cuadrado (cm):");
        
        if (lado > 0) {
            figuraActual = new Cuadrado(lado);
            mostrarResultadosCuadrado();
        }
    }
    
    private static void crearTrianguloRectangulo() {
        double base = leerNumeroPositivo("Ingrese la base del triángulo rectángulo (cm):");
        if (base <= 0) return;
        
        double altura = leerNumeroPositivo("Ingrese la altura del triángulo rectángulo (cm):");
        if (altura <= 0) return;
        
        figuraActual = new TrianguloRectangulo(base, altura);
        mostrarResultadosTriangulo();
    }
    
    private static double leerNumeroPositivo(String mensaje) {
        String entrada = JOptionPane.showInputDialog(null, mensaje);
        
        if (entrada == null) {
            return -1;
        }
        
        try {
            double valor = Double.parseDouble(entrada);
            
            if (valor <= 0) {
                JOptionPane.showMessageDialog(null, 
                    "El valor debe ser mayor que cero", 
                    "Valor inválido", 
                    JOptionPane.WARNING_MESSAGE);
                return -1;
            }
            
            return valor;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "Debe ingresar un número válido", 
                "Error de formato", 
                JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    private static void mostrarResultadosCirculo() {
        Circulo circulo = (Circulo) figuraActual;
        
        String resultado = "====== RESULTADOS DEL CÍRCULO ======\n\n";
        resultado += "Radio: " + String.format("%.2f", circulo.getRadio()) + " cm\n\n";
        resultado += "Área: " + String.format("%.2f", circulo.calcularArea()) + " cm²\n";
        resultado += "Perímetro: " + String.format("%.2f", circulo.calcularPerimetro()) + " cm\n";
        
        JOptionPane.showMessageDialog(null, 
            resultado, 
            "Resultados - Círculo", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void mostrarResultadosRectangulo() {
        Rectangulo rectangulo = (Rectangulo) figuraActual;
        
        String resultado = "====== RESULTADOS DEL RECTÁNGULO ======\n\n";
        resultado += "Base: " + String.format("%.2f", rectangulo.getBase()) + " cm\n";
        resultado += "Altura: " + String.format("%.2f", rectangulo.getAltura()) + " cm\n\n";
        resultado += "Área: " + String.format("%.2f", rectangulo.calcularArea()) + " cm²\n";
        resultado += "Perímetro: " + String.format("%.2f", rectangulo.calcularPerimetro()) + " cm\n";
        
        JOptionPane.showMessageDialog(null, 
            resultado, 
            "Resultados - Rectángulo", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void mostrarResultadosCuadrado() {
        Cuadrado cuadrado = (Cuadrado) figuraActual;
        
        String resultado = "====== RESULTADOS DEL CUADRADO ======\n\n";
        resultado += "Lado: " + String.format("%.2f", cuadrado.getLado()) + " cm\n\n";
        resultado += "Área: " + String.format("%.2f", cuadrado.calcularArea()) + " cm²\n";
        resultado += "Perímetro: " + String.format("%.2f", cuadrado.calcularPerimetro()) + " cm\n";
        
        JOptionPane.showMessageDialog(null, 
            resultado, 
            "Resultados - Cuadrado", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static void mostrarResultadosTriangulo() {
        TrianguloRectangulo triangulo = (TrianguloRectangulo) figuraActual;
        
        String resultado = "====== RESULTADOS DEL TRIÁNGULO RECTÁNGULO ======\n\n";
        resultado += "Base: " + String.format("%.2f", triangulo.getBase()) + " cm\n";
        resultado += "Altura: " + String.format("%.2f", triangulo.getAltura()) + " cm\n";
        resultado += "Hipotenusa: " + String.format("%.2f", triangulo.calcularHipotenusa()) + " cm\n\n";
        resultado += "Tipo de triángulo: " + triangulo.tipoTriangulo() + "\n\n";
        resultado += "Área: " + String.format("%.2f", triangulo.calcularArea()) + " cm²\n";
        resultado += "Perímetro: " + String.format("%.2f", triangulo.calcularPerimetro()) + " cm\n";
        
        JOptionPane.showMessageDialog(null, 
            resultado, 
            "Resultados - Triángulo Rectángulo", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}