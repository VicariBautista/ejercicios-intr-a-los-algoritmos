import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Fecha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fecha{
    private int dia;
    private int mes;
    private int anho;
    //private List<String> fechas;
    
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
        assert mes >= 0 && mes <= 12;
        
        return 1;
    }
}