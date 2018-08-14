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


public class MIngresos {
    
    private float monto;
    private int mes;
    private int anno;
    private String codProy;

    public MIngresos(float monto, int mes, int anno, String codProy) {
        this.monto = monto;
        this.mes = mes;
        this.anno = anno;
        this.codProy = codProy;
    }

    public MIngresos() {
        this.monto=0.0f;
        this.mes=0;
        this.anno=0;
        this.codProy=" ";
    }

    
    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getCodProy() {
        return codProy;
    }

    public void setCodProy(String codProy) {
        this.codProy = codProy;
    }
    
    
    
}
