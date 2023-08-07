package blockbuster;

import java.util.Calendar;

public abstract class BlockBusterItem {
    
    int codigo;
    String nombre;
    double precioRenta;
    Calendar fechaAdicion = Calendar.getInstance();
    
    
    

    public BlockBusterItem() {
    }

    public BlockBusterItem(int codigo, String nombre, double precioRenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioRenta = precioRenta;
    }
    

    @Override
    public String toString() {
        return "BlockBusterItem{" + "codigo=" + codigo + ", nombre=" + nombre + ", precioRenta=" + precioRenta + '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioRenta() {
        return precioRenta;
    }

    public Calendar getFecha() {
        return fechaAdicion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecioRenta(double precioRenta) {
        this.precioRenta = precioRenta;
    }

    public void setFecha(Calendar fecha) {
        this.fechaAdicion = fecha;
    }
    
    
    
    abstract double pagoRenta(int dias);
    
    
}
