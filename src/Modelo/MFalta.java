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


public class MFalta {
    
        private String idCandidato;
        private String descripcion;
        private Date fecha;
        private String estatus;
        private int canthoras;
            
    public MFalta(String idCandidato,
                   String descripcion,
                   Date fecha,
                   String estatus,
                   int canthoras)
    {
        this.idCandidato = idCandidato;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estatus = estatus;
        this.canthoras = canthoras;
    }
    
    public MFalta(){
        this.idCandidato = "";
        this.descripcion = "";
        this.fecha = null;
        this.estatus = "";
        this.canthoras = 0;
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getCanthoras() {
        return canthoras;
    }

    public void setCanthoras(int canthoras) {
        this.canthoras = canthoras;
    }
            
}
