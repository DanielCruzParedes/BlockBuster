package blockbuster;

import java.util.Calendar;



public class MovieItem extends BlockBusterItem {
    
    public String estado;
    public MovieItem(){
        
    }
    
    public MovieItem(int codigo, String nombre, double precioRenta,String estado){
        super(codigo,nombre,precioRenta=50);
        this.estado=estado="ESTRENO";  
    }
    
    @Override
    public String toString() {
        return "BlockBusterItem{" + "codigo=" + codigo + ", nombre=" + nombre + ", precioRenta=" + precioRenta + ", estado= " +estado+" -Movie"+'}';
    }
    
    @Override
     public double pagoRenta(int dias){
         if(estado.equalsIgnoreCase("ESTADO")&& dias>2){
            return precioRenta+50*(dias-2);
         }else if(estado.equalsIgnoreCase("NORMAL")&& dias>5){
             return precioRenta+30*(dias-5);
             
         }
        return precioRenta;
     }
     
     public void evaluarEstado(){
        Calendar fechaAdicionCalendar = Calendar.getInstance();
     
        Calendar fechaActualCalendar = Calendar.getInstance();

        int anoDiferencia = fechaActualCalendar.get(Calendar.YEAR) - fechaAdicionCalendar.get(Calendar.YEAR);
        int mesDiferencia = fechaActualCalendar.get(Calendar.MONTH) - fechaAdicionCalendar.get(Calendar.MONTH);

        int totalMeses = anoDiferencia * 12 + mesDiferencia;

        if (totalMeses >= 5) {
            estado = "NORMAL";
        } 
         
     }

    
    
    
    
    
}