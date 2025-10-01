package sistemamateria;

import javax.swing.JOptionPane;

public class Main {
    
    private static Materia materia;
    
    public static void main(String[] args) {
        
        int opcion = 0;
        
        do {
            String menu = " SISTEMA DE GESTIÓN DE MATERIA\n\n";
            menu += "1. Crear materia y sus grupos\n";
            menu += "2. Ver reporte completo\n";
            menu += "3. Calcular porcentaje que perdió en un grupo\n";
            menu += "4. Buscar grupo por código\n";
            menu += "5. Obtener mayor promedio de grupo\n";
            menu += "6. Cambiar profesor de un grupo\n";
            menu += "7. Salir\n\n";
            menu += "Ingrese su opción:";
            
            String opcionStr = JOptionPane.showInputDialog(null, menu);
            
            if (opcionStr == null) {
                break;
            }
            
            try {
                opcion = Integer.parseInt(opcionStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido");
                continue;
            }
            
            switch (opcion) {
                case 1:
                    crearMateriaYGrupos();
                    break;
                case 2:
                    verReporteCompleto();
                    break;
                case 3:
                    calcularPorcentajePerdio();
                    break;
                case 4:
                    buscarGrupoPorCodigo();
                    break;
                case 5:
                    obtenerMayorPromedio();
                    break;
                case 6:
                    cambiarProfesor();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
            }
            
        } while (opcion != 7);
    }
    
    public static void crearMateriaYGrupos() {
        try {
            String codMat = JOptionPane.showInputDialog("Ingrese el código de la materia (3 a 5 caracteres):");
            if (codMat == null || codMat.length() < 3 || codMat.length() > 5) {
                JOptionPane.showMessageDialog(null, "Código inválido");
                return;
            }
            
            String nomMat = JOptionPane.showInputDialog("Ingrese el nombre de la materia:");
            if (nomMat == null || nomMat.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre inválido");
                return;
            }
            
            String numGruposStr = JOptionPane.showInputDialog("Ingrese el número de grupos (1 a 12):");
            int numGrupos = Integer.parseInt(numGruposStr);
            
            if (numGrupos < 1 || numGrupos > 12) {
                JOptionPane.showMessageDialog(null, "Número de grupos inválido");
                return;
            }
            
            materia = new Materia(codMat, nomMat, numGrupos);
            
            for (int i = 0; i < numGrupos; i++) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos del grupo " + (i + 1));
                
                String codGrupoStr = JOptionPane.showInputDialog("Código del grupo (1 a 60):");
                int codGrupo = Integer.parseInt(codGrupoStr);
                if (codGrupo < 1 || codGrupo > 60) {
                    JOptionPane.showMessageDialog(null, "Código de grupo inválido");
                    i--;
                    continue;
                }
                
                String profesor = JOptionPane.showInputDialog("Nombre del profesor:");
                if (profesor == null || profesor.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nombre del profesor inválido");
                    i--;
                    continue;
                }
                
                String promGrupoStr = JOptionPane.showInputDialog("Promedio del grupo (0.0 a 5.0):");
                double promGrupo = Double.parseDouble(promGrupoStr);
                if (promGrupo < 0 || promGrupo > 5) {
                    JOptionPane.showMessageDialog(null, "Promedio inválido");
                    i--;
                    continue;
                }
                
                String numEstudiantesStr = JOptionPane.showInputDialog("Número de estudiantes (0 a 25):");
                int numEstudiantes = Integer.parseInt(numEstudiantesStr);
                if (numEstudiantes < 0 || numEstudiantes > 25) {
                    JOptionPane.showMessageDialog(null, "Número de estudiantes inválido");
                    i--;
                    continue;
                }
                
                String ganaronStr = JOptionPane.showInputDialog("Número de estudiantes que ganaron (0 a " + numEstudiantes + "):");
                int ganaron = Integer.parseInt(ganaronStr);
                if (ganaron < 0 || ganaron > numEstudiantes) {
                    JOptionPane.showMessageDialog(null, "Número de estudiantes que ganaron inválido");
                    i--;
                    continue;
                }
                
                Grupo grupo = new Grupo(codGrupo, profesor, promGrupo, numEstudiantes, ganaron);
                materia.agregarGrupo(grupo);
            }
            
            JOptionPane.showMessageDialog(null, "Materia y grupos creados exitosamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear la materia: " + e.getMessage());
        }
    }
    
    public static void verReporteCompleto() {
        if (materia == null) {
            JOptionPane.showMessageDialog(null, "Primero debe crear una materia");
            return;
        }
        
        JOptionPane.showMessageDialog(null, materia.toString());
    }
    
    public static void calcularPorcentajePerdio() {
        if (materia == null) {
            JOptionPane.showMessageDialog(null, "Primero debe crear una materia");
            return;
        }
        
        try {
            String codGrupoStr = JOptionPane.showInputDialog("Ingrese el código del grupo:");
            int codGrupo = Integer.parseInt(codGrupoStr);
            
            Grupo[] grupos = materia.getGrupos();
            boolean encontrado = false;
            
            for (int i = 0; i < materia.getIndice(); i++) {
                if (grupos[i].getCodGrupo() == codGrupo) {
                    double porcentaje = grupos[i].porcentajeQuePerdio();
                    JOptionPane.showMessageDialog(null, 
                        "Grupo: " + codGrupo + "\n" +
                        "Porcentaje que perdió: " + String.format("%.2f", porcentaje) + "%");
                    encontrado = true;
                    break;
                }
            }
            
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontró el grupo con código: " + codGrupo);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public static void buscarGrupoPorCodigo() {
        if (materia == null) {
            JOptionPane.showMessageDialog(null, "Primero debe crear una materia");
            return;
        }
        
        try {
            String codGrupoStr = JOptionPane.showInputDialog("Ingrese el código del grupo a buscar:");
            int codGrupo = Integer.parseInt(codGrupoStr);
            
            String resultado = materia.buscarGrupoPorCodGrupo(codGrupo);
            JOptionPane.showMessageDialog(null, resultado);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public static void obtenerMayorPromedio() {
        if (materia == null) {
            JOptionPane.showMessageDialog(null, "Primero debe crear una materia");
            return;
        }
        
        double mayorPromedio = materia.mayorPromedioGrupo();
        JOptionPane.showMessageDialog(null, "El mayor promedio de grupo es: " + mayorPromedio);
    }
    
    public static void cambiarProfesor() {
        if (materia == null) {
            JOptionPane.showMessageDialog(null, "Primero debe crear una materia");
            return;
        }
        
        try {
            String codGrupoStr = JOptionPane.showInputDialog("Ingrese el código del grupo:");
            int codGrupo = Integer.parseInt(codGrupoStr);
            
            Grupo[] grupos = materia.getGrupos();
            boolean encontrado = false;
            
            for (int i = 0; i < materia.getIndice(); i++) {
                if (grupos[i].getCodGrupo() == codGrupo) {
                    encontrado = true;
                    break;
                }
            }
            
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "No se encontró el grupo con código: " + codGrupo);
                return;
            }
            
            String nuevoProfesor = JOptionPane.showInputDialog("Ingrese el nombre del nuevo profesor:");
            if (nuevoProfesor == null || nuevoProfesor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre del profesor inválido");
                return;
            }
            
            materia.modificarProfesorGrupo(codGrupo, nuevoProfesor);
            JOptionPane.showMessageDialog(null, "Profesor cambiado exitosamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
}