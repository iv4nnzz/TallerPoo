package principal;

import modelo.GestorNotas;
import javax.swing.JOptionPane;

public class Principal {
    
    public static void main(String[] args) {
        String bienvenida = "UNIVERSIDAD AUTÓNOMA DE OCCIDENTE\n";
        bienvenida += "Programación Orientada a Objetos\n";
        bienvenida += "Sistema de Conteo de Notas Aprobadas\n\n";
        bienvenida += "Este programa permite ingresar 5 notas\n";
        bienvenida += "y determina cuántas son mayores o iguales a 3.0";
        
        JOptionPane.showMessageDialog(
            null,
            bienvenida,
            "Sistema de Notas",
            JOptionPane.INFORMATION_MESSAGE
        );
      
        GestorNotas gestor = new GestorNotas();
        gestor.procesarNotas();
        
        int opcion = JOptionPane.showConfirmDialog(
            null,
            "¿Desea analizar otro conjunto de notas?",
            "Continuar",
            JOptionPane.YES_NO_OPTION
        );
        
        if (opcion == JOptionPane.YES_OPTION) {
            main(args);
        } else {
            JOptionPane.showMessageDialog(
                null,
                "Gracias por usar el Sistema de Notas\n" +
                "¡Hasta pronto!",
                "Despedida",
                JOptionPane.INFORMATION_MESSAGE
            );
            System.exit(0);
        }
    }
}