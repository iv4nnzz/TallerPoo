package sistemamateria;

public class Grupo {
    private int codGrupo;
    private String profesor;
    private double promGrupo;
    private int numEstudiantes;
    private int ganaron;
    
    public Grupo(int codGrupo, String profesor, double promGrupo, int numEstudiantes, int ganaron) {
        this.codGrupo = codGrupo;
        this.profesor = profesor;
        this.promGrupo = promGrupo;
        this.numEstudiantes = numEstudiantes;
        this.ganaron = ganaron;
    }
    
    public int getCodGrupo() {
        return codGrupo;
    }
    
    public String getProfesor() {
        return profesor;
    }
    
    public double getPromGrupo() {
        return promGrupo;
    }
    
    public int getNumEstudiantes() {
        return numEstudiantes;
    }
    
    public int getGanaron() {
        return ganaron;
    }
    
    public void setCodGrupo(int codGrupo) {
        this.codGrupo = codGrupo;
    }
    
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    
    public void setPromGrupo(double promGrupo) {
        this.promGrupo = promGrupo;
    }
    
    public void setNumEstudiantes(int numEstudiantes) {
        this.numEstudiantes = numEstudiantes;
    }
    
    public void setGanaron(int ganaron) {
        this.ganaron = ganaron;
    }
    
    public String toString() {
        return "Código Grupo: " + codGrupo + "\n" +
               "Profesor: " + profesor + "\n" +
               "Promedio Grupo: " + promGrupo + "\n" +
               "Número Estudiantes: " + numEstudiantes + "\n" +
               "Ganaron: " + ganaron;
    }
    
    public double porcentajeQuePerdio() {
        if (numEstudiantes == 0) {
            return 0;
        }
        int perdieron = numEstudiantes - ganaron;
        return (perdieron * 100.0) / numEstudiantes;
    }
}