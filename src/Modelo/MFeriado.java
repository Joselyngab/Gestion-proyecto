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

import java.util.Date;


public class MFeriado {
   private Date fecha;
   private String descripcion;
  

    

    public MFeriado(Date fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
   
   public MFeriado()
    {
        this.fecha=null;
        this.descripcion="";
        
                
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
    
}
