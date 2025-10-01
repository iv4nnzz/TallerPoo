package sistemamateria;

public class Materia {
    private String codMat;
    private String nomMat;
    private int numGrupos;
    private Grupo[] grupos;
    private int indice;
    
    public Materia(String codMat, String nomMat, int numGrupos) {
        this.codMat = codMat;
        this.nomMat = nomMat;
        this.numGrupos = numGrupos;
        this.grupos = new Grupo[numGrupos];
        this.indice = 0;
    }
    
    public String getCodMat() {
        return codMat;
    }
    
    public String getNomMat() {
        return nomMat;
    }
    
    public int getNumGrupos() {
        return numGrupos;
    }
    
    public Grupo[] getGrupos() {
        return grupos;
    }
    
    public int getIndice() {
        return indice;
    }
    
    public void setCodMat(String codMat) {
        this.codMat = codMat;
    }
    
    public void setNomMat(String nomMat) {
        this.nomMat = nomMat;
    }
    
    public void setNumGrupos(int numGrupos) {
        this.numGrupos = numGrupos;
    }
    
    public void setGrupos(Grupo[] grupos) {
        this.grupos = grupos;
    }
    
    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public void agregarGrupo(Grupo grupo) {
        if (indice < numGrupos) {
            grupos[indice] = grupo;
            indice++;
        }
    }
    
    public String toString() {
        String info = "===== MATERIA =====\n";
        info += "Código Materia: " + codMat + "\n";
        info += "Nombre Materia: " + nomMat + "\n";
        info += "Número de Grupos: " + numGrupos + "\n\n";
        info += "===== GRUPOS =====\n";
        
        for (int i = 0; i < indice; i++) {
            info += "\n--- Grupo " + (i + 1) + " ---\n";
            info += grupos[i].toString() + "\n";
        }
        
        return info;
    }
    
    public String buscarGrupoPorCodGrupo(int codigoGrupo) {
        for (int i = 0; i < indice; i++) {
            if (grupos[i].getCodGrupo() == codigoGrupo) {
                return grupos[i].toString();
            }
        }
        return "No existe un grupo con este código de grupo";
    }
    
    public double mayorPromedioGrupo() {
        if (indice == 0) {
            return 0;
        }
        
        double mayor = grupos[0].getPromGrupo();
        
        for (int i = 1; i < indice; i++) {
            if (grupos[i].getPromGrupo() > mayor) {
                mayor = grupos[i].getPromGrupo();
            }
        }
        
        return mayor;
    }
    
    public void modificarProfesorGrupo(int codigoGrupo, String nuevoProfesor) {
        for (int i = 0; i < indice; i++) {
            if (grupos[i].getCodGrupo() == codigoGrupo) {
                grupos[i].setProfesor(nuevoProfesor);
                break;
            }
        }
    }
}