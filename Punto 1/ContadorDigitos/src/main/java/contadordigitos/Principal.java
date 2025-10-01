package contadordigitos;

import javax.swing.JOptionPane;

public class Principal {
    private ContadorDigitos contadorDigitos;
    private InterfazUsuario interfaz;
    
    public Principal() {
        this.contadorDigitos = new ContadorDigitos();
        this.interfaz = new InterfazUsuario();
    }
    
    public static void main(String[] args) {
        Principal programa = new Principal();
        programa.ejecutar();
    }
    
    public void ejecutar() {
        boolean continuar = true;
        
        JOptionPane.showMessageDialog(null,
            "Bienvenido al Contador de Dígitos\n" +
            "Este programa cuenta cuántos dígitos tiene un número entero.",
            "Bienvenida",
            JOptionPane.INFORMATION_MESSAGE);
        
        while (continuar) {
            int numeroUsuario = interfaz.solicitarNumero();
            
            contadorDigitos.setNumero(numeroUsuario);
            
            String resultado = contadorDigitos.obtenerResultado();
            interfaz.mostrarResultado(resultado);
            
            int opcion = JOptionPane.showConfirmDialog(null,
                "¿Desea contar los dígitos de otro número?",
                "Continuar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            
            if (opcion != JOptionPane.YES_OPTION) {
                continuar = false;
            }
        }
        
        JOptionPane.showMessageDialog(null,
            "Gracias por usar el Contador de Dígitos\n" +
            "¡Hasta pronto!",
            "Despedida",
            JOptionPane.INFORMATION_MESSAGE);
        
        System.exit(0);
    }
}