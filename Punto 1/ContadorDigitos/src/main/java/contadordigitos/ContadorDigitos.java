package contadordigitos;

public class ContadorDigitos {
    private int numero;
    
    public ContadorDigitos() {
        this.numero = 0;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getNumero() {
        return this.numero;
    }
    
    public int contarDigitos() {
        int contador = 0;
        int temporal = Math.abs(this.numero); 
        
        if (this.numero == 0) {
            return 1;
        }
        
        while (temporal > 0) {
            temporal = temporal / 10;  
            contador++;                
        }
        
        return contador;
    }
    
    public String obtenerResultado() {
        int cantidadDigitos = contarDigitos();
        String mensaje = "El número " + this.numero + " tiene " + cantidadDigitos;
        
        if (cantidadDigitos == 1) {
            mensaje = mensaje + " dígito.";
        } else {
            mensaje = mensaje + " dígitos.";
        }
        
        return mensaje;
    }
}