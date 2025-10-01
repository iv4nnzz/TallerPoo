package modelo;

import javax.swing.JOptionPane;

public class GestorNotas {
    private Nota[] notas;
    private int cantidadNotas;
    private int notasAprobadas;
    
    public GestorNotas() {
        this.cantidadNotas = 5; 
        this.notas = new Nota[cantidadNotas];
        this.notasAprobadas = 0;
    }
    
    public void ingresarNotas() {
        String mensaje = "SISTEMA DE REGISTRO DE NOTAS\n";
        mensaje += "================================\n";
        mensaje += "Ingrese las 5 notas finales\n";
        mensaje += "(Rango válido: 0.0 a 5.0)\n";
        
        JOptionPane.showMessageDialog(null, mensaje, "Bienvenida", JOptionPane.INFORMATION_MESSAGE);
        
        for (int i = 0; i < cantidadNotas; i++) {
            boolean notaValida = false;
            double valorNota = 0;
            
            while (!notaValida) {
                try {
                    String entrada = JOptionPane.showInputDialog(
                        null,
                        "Ingrese la nota #" + (i + 1) + ":",
                        "Registro de Notas",
                        JOptionPane.QUESTION_MESSAGE
                    );
                    
                    if (entrada == null) {
                        int opcion = JOptionPane.showConfirmDialog(
                            null,
                            "¿Desea cancelar el registro de notas?",
                            "Confirmar",
                            JOptionPane.YES_NO_OPTION
                        );
                        if (opcion == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                        continue;
                    }
                    
                    valorNota = Double.parseDouble(entrada);
                    
                    if (valorNota >= 0.0 && valorNota <= 5.0) {
                        notaValida = true;
                    } else {
                        JOptionPane.showMessageDialog(
                            null,
                            "Error: La nota debe estar entre 0.0 y 5.0",
                            "Error de Validación",
                            JOptionPane.ERROR_MESSAGE
                        );
                    }
                    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Error: Debe ingresar un número válido",
                        "Error de Formato",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            
            notas[i] = new Nota(valorNota);
        }
    }
    
    public void contarNotasAprobadas() {
        notasAprobadas = 0;
        
        for (int i = 0; i < cantidadNotas; i++) {
            if (notas[i].esAprobada()) {
                notasAprobadas++;
            }
        }
    }
    
    public int getNotasAprobadas() {
        return notasAprobadas;
    }
    
    public void mostrarResultado() {
        String resultado = "RESULTADO DEL ANÁLISIS\n";
        resultado += "================================\n\n";
        resultado += "Detalle de las notas ingresadas:\n\n";
        
        for (int i = 0; i < cantidadNotas; i++) {
            resultado += "Nota " + (i + 1) + ": " + notas[i].getValor();
            if (notas[i].esAprobada()) {
                resultado += "(Aprobada)\n";
            } else {
                resultado += "(Reprobada)\n";
            }
        }
        
        resultado += "\n================================\n";
        resultado += "RESUMEN:\n";
        resultado += "Total de notas: " + cantidadNotas + "\n";
        resultado += "Notas aprobadas (>= 3.0): " + notasAprobadas + "\n";
        resultado += "Notas reprobadas (< 3.0): " + (cantidadNotas - notasAprobadas) + "\n";
        
        double porcentaje = (notasAprobadas * 100.0) / cantidadNotas;
        resultado += "Porcentaje de aprobación: " + String.format("%.1f", porcentaje) + "%\n";
        
        if (notasAprobadas == cantidadNotas) {
            resultado += "\nTodas las notas fueron aprobadas.";
        } else if (notasAprobadas > cantidadNotas / 2) {
            resultado += "\nLa mayoría aprobó.";
        } else if (notasAprobadas == 0) {
            resultado += "\nNinguna nota fue aprobada.";
        } else {
            resultado += "\nSe necesita mejorar el rendimiento.";
        }
        
        JOptionPane.showMessageDialog(
            null,
            resultado,
            "Resultado Final",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public void procesarNotas() {
        ingresarNotas();
        contarNotasAprobadas();
        mostrarResultado();
    }
}