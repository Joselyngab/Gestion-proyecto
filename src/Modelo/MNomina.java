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


public class MNomina 
{
     
     private   String idcandidato;
     private   int nroHoras;
     private   int mes;
     private  float montoneto;
     private float montopagado;
     private int anno;

    public MNomina(String idcandidato, int nroHoras, int mes,
            float montoneto, float montopagado, int anno) {
        this.idcandidato = idcandidato;
        this.nroHoras = nroHoras;
        this.mes = mes;
        this.montoneto = montoneto;
        this.montopagado = montopagado;
        this.anno=anno;
    }
    
 
    public MNomina() {
            idcandidato=" ";
            nroHoras=0;
            mes=0;
            montoneto=0;
            montopagado=0;
            anno=0;

            
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

 

    public float getMontoneto() {
        return montoneto;
    }

    public void setMontoneto(float montoneto) {
        this.montoneto = montoneto;
    }

    public float getMontopagado() {
        return montopagado;
    }

    public void setMontopagado(float montopagado) {
        this.montopagado = montopagado;
    }

    public String getIdcandidato() {
        return idcandidato;
    }

   
    public void setIdcandidato(String idcandidato) {
        this.idcandidato = idcandidato;
    }

    public int getNroHoras() {
        return nroHoras;
    }

    public void setNroHoras(int nroHoras) {
        this.nroHoras = nroHoras;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
        
        
    
   }
        
        
     
  