import java.util.ArrayList;
import java.util.List;
/**
 * La clase fecha para crear cualquier fecha valida.
 *
 * @author (Vicari Bautista)
 * @version (09/05/2026)
 */
public class Fecha{
    private int dia;
    private int mes;
    private int anho;    
    public Fecha(int dia, int mes, int anho){ 
        assert anho >= 1582;
        if(anho == 1582){
            assert mes >= 10;
        } else{
            assert mes >= 0 && mes <= 12;
        }
        if(anho == 1582){
            assert dia >= 15;
        } else{
            assert dia > 0 ;
        }
        assert fechaValida(dia, mes, anho);
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }
    
    private boolean esBisiesto(int anho){
        assert anho >= 1582;
        if(anho % 400 == 0){
            return true;
        } else{
            if(anho % 100 == 0){
                return false;
            } else{
                if(anho % 4 == 0){
                    return true;
                }
            }
        }
        return false;
    }
    
    private int cantidadDias(int mes, int anho){
        assert anho >= 1582;
        assert mes > 0 && mes <= 12;
        int dias = 0;
        if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            dias = 31;
        }else{
            if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
                dias = 30;
            }else{
                if(!esBisiesto(anho)){
                    dias = 28;
                } else {
                    dias = 29;
                }
            }
        }
        return dias;
    }
    
    private boolean fechaValida(int dia, int mes, int anho){
        if(anho < 1582) return false;
        if(mes <= 0 || mes > 12) return false;
        if(cantidadDias(mes, anho) < dia)return false;
        return true;
    }
    
    public void cambiarDia(int dia){
        assert cantidadDias(this.mes, this.anho) >= dia; 
        this.dia = dia;
    }
    
    public void cambiarMes(int mes){
        assert mes > 0 && mes <= 12;
        this.mes = mes;
    }
    
    public void cambiarAnho(int anho){
        assert anho >= 1582;
        this.anho = anho;
    }
    
    public int obtenerDia(){
        return dia;
    }
    
    public int obtenerMes(){
        return mes;
    }
    
    public int obtenerAnho(){
        return anho;
    }
    
    public String toString(){
        String fecha = "";
        if(dia < 10 && mes < 10) fecha = "0" + dia + "/0" + mes + "/" + anho;
        if(dia < 10 && mes >= 10) fecha = "0" + dia + "/" + mes + "/" + anho;
        if(dia > 10 && mes < 10) fecha = dia + "/0" + mes + "/" + anho;
        if(dia > 10 && mes >= 10)fecha = dia + "/" + mes + "/" + anho;
        return fecha;
    }
}