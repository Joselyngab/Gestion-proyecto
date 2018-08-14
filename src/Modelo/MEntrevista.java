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

public class MEntrevista {
    private String codigo;
    private String descripcion;
    private Date fecha;
    private String identrevistador;
    private String observacion;
    private String modalidad;
    private String calificacion;
    private String codigoproyecto;
    private Float salarioofertado;
    private Float salariopretendido;
    private int codigotipoentrevista;
    private int codigocargo;
    private String idcandidato;
    
    public MEntrevista (String descripcion,
                        Date fecha,
                        String identrevistador,
                        String observacion,
                        String modalidad,
                        String calificacion,
                        String codigoproyecto,
                        Float salarioofertado,
                        Float salariopretendido,
                        int codigotipoentrevista,
                        int codigocargo,
                        String idcandidato){
        this.descripcion=descripcion;
        this.fecha=fecha;
        this.identrevistador=identrevistador;
        this.observacion=observacion;
        this.modalidad=modalidad;
        this.calificacion=calificacion;
        this.codigoproyecto=codigoproyecto;
        this.salarioofertado=salarioofertado;
        this.salariopretendido=salariopretendido;
        this.codigotipoentrevista=codigotipoentrevista;
        this.codigocargo=codigocargo;
        this.idcandidato=idcandidato;
    }
//==========================================
    public MEntrevista() {
        this.codigo="";
        this.descripcion="";
        this.fecha=null;
        this.identrevistador="";
        this.observacion="";
        this.modalidad="";
        this.calificacion="";
        this.codigoproyecto="";
        this.salarioofertado=0.00f;
        this.salariopretendido=0.00f;
        this.codigotipoentrevista=0;
        this.codigocargo=0;
        this.idcandidato="";
    }
//==========================================
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdentrevistador() {
        return identrevistador;
    }

    public void setIdentrevistador(String identrevistador) {
        this.identrevistador = identrevistador;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getCodigoproyecto() {
        return codigoproyecto;
    }

    public void setCodigoproyecto(String codigoproyecto) {
        this.codigoproyecto = codigoproyecto;
    }

    public Float getSalarioofertado() {
        return salarioofertado;
    }

    public void setSalarioofertado(Float salarioofertado) {
        this.salarioofertado = salarioofertado;
    }

    public Float getSalariopretendido() {
        return salariopretendido;
    }

    public void setSalariopretendido(Float salariopretendido) {
        this.salariopretendido = salariopretendido;
    }

    public int getCodigotipoentrevista() {
        return codigotipoentrevista;
    }

    public void setCodigotipoentrevista(int codigotipoentrevista) {
        this.codigotipoentrevista = codigotipoentrevista;
    }

    public int getCodigocargo() {
        return codigocargo;
    }

    public void setCodigocargo(int codigocargo) {
        this.codigocargo = codigocargo;
    }

    public String getIdcandidato() {
        return idcandidato;
    }

    public void setIdcandidato(String idcandidato) {
        this.idcandidato = idcandidato;
    }
    
}
