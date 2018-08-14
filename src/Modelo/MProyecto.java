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

public class MProyecto 
{
    
    private String codigo;
    private String descripcion;
    private Date fechainicio;
    private Date fechafin;
    private String idcliente;
    private Float monto;
    private int horas;
       
    public  MProyecto(String codigo,
                      String descripcion,
                      Date fechainicio,
                      Date fechafin,
                      String idcliente,
                      Float monto,
                      int horas)
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
        this.fechafin = fechafin;
        this.idcliente = idcliente;
        this.monto = monto;
        this.horas=horas;
     
    }
    public MProyecto()
    {
        this.codigo = "";
        this.descripcion = "";
        this.fechainicio = null;
        this.fechafin = null;
        this.idcliente = "";
        this.monto = 0.00f;
        this.horas = 0;
    }        

   
//========================================
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    
}
