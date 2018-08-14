/*
*    Proyecto de Laboratorio 1 (Sección 1)
*     Integrantes:
*     Canelon Valmore CI: 22270191
*     Cohen Kevin  CI: 20670359
*     Jiménez Jaimary CI: 22263583
*     Lugo Brisleidy CI: 22181168
*     Serrano Joselyn CI: 22271356
*/
package Modelo;


public class MAsignarCand {
  
    private String IdCand;
    private float sueldo;
    private String TMoneda;
    private String TPago;

    public MAsignarCand(String IdCand, float sueldo, String TMoneda, 
                        String TPago) {
        this.IdCand = IdCand;
        this.sueldo = sueldo;
        this.TMoneda = TMoneda;
        this.TPago = TPago;
    }

    public MAsignarCand() {
        IdCand = " ";
        sueldo = (float) 0.0;
        TMoneda = "";
        TPago = "";
    }
    
    

    public String getIdCand() {
        return IdCand;
    }

    public void setIdCand(String IdCand) {
        this.IdCand = IdCand;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public String getTMoneda() {
        return TMoneda;
    }

    public void setTMoneda(String TMoneda) {
        this.TMoneda = TMoneda;
    }

    public String getTPago() {
        return TPago;
    }

    public void setTPago(String TPago) {
        this.TPago = TPago;
    }
    
    
    
}
