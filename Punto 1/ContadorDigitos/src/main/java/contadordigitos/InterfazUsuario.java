package contadordigitos;

import javax.swing.JOptionPane;

public class InterfazUsuario {
    
    public InterfazUsuario() {
    }
    
    public int solicitarNumero() {
        String entrada = "";
        int numeroIngresado = 0;
        boolean numeroValido = false;
        
        while (!numeroValido) {
            try {
                entrada = JOptionPane.showInputDialog(null,
                    "Ingrese un número entero:",
                    "Contador de Dígitos",
                    JOptionPane.QUESTION_MESSAGE);
                
                if (entrada == null) {
                    int opcion = JOptionPane.showConfirmDialog(null,
                        "¿Desea salir del programa?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION);
                    
                    if (opcion == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
                } else {
                    numeroIngresado = Integer.parseInt(entrada);
                    numeroValido = true;
                }
                
            } catch (NumberFormatException e) {
                mostrarError("Por favor ingrese un número entero válido.");
            }
        }
        
        return numeroIngresado;
    }
    
    public void mostrarResultado(String mensaje) {
        JOptionPane.showMessageDialog(null,
            mensaje,
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mostrarError(String mensajeError) {
        JOptionPane.showMessageDialog(null,
            mensajeError,
            "Error",
            JOptionPane.ERROR_MESSAGE);
    }
}