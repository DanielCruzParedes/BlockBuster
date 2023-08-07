package blockbuster;

import java.util.ArrayList;
import java.util.Scanner;

public class BlockBuster {

    private ArrayList<BlockBusterItem> items;
    
    public BlockBuster() {
        items = new ArrayList<>();
    }
    
    
      
     public BlockBusterItem buscarItem(int codigo, String tipo) {
        for (BlockBusterItem item : items) {
            if (item.getCodigo() == codigo && item instanceof MovieItem && tipo.equalsIgnoreCase("MOVIE")) {
                return item;
            }
            if (item.getCodigo() == codigo && item instanceof VideoGameItem && tipo.equalsIgnoreCase("GAME")) {
                return item;
            }
        }
        return null;
    }
     
    public void agregarItem(int codigo, String nombre, String tipoItem, String estado) {
        // Verificar si ya existe un ítem con ese código y tipo
        for (BlockBusterItem item : items) {
            if (item.getCodigo() == codigo) {
                
                
                //Ya existe un ítem con ese code
                return;
            }
        }

        double precioRenta=0;

        if (tipoItem.equalsIgnoreCase("MOVIE")) {
            
            items.add(new MovieItem(codigo, nombre, precioRenta, estado));
        } else if (tipoItem.equalsIgnoreCase("GAME")) {
            String consola="";
            items.add(new VideoGameItem(consola, codigo, nombre, precioRenta));
        } else {
            //no es valido
        }
    }
    
    public String rentar(int codigo, String tipoItem, int dias) {
    BlockBusterItem item = buscarItem(codigo, tipoItem);
    
    if (item != null) {
        
        double montoAPagar = item.pagoRenta(dias);
        return item.toString()+ "\nMonto a pagar: "+montoAPagar;
    } else {
        String respuesta="Item no existe.";
        return respuesta;
        
    }
}
    
    public void auditarMovieEstados() {
        auditarMovieEstadosRecursivo(items, 0);
    }

    private void auditarMovieEstadosRecursivo(ArrayList<BlockBusterItem> itemList, int index) {
        if (index >= itemList.size()) {
            return;
        }

        BlockBusterItem item = itemList.get(index);

        if (item instanceof MovieItem) {
            MovieItem movieItem = (MovieItem) item;
            movieItem.evaluarEstado();
        }

        auditarMovieEstadosRecursivo(itemList, index + 1);
    }



    
    
    
    
}
