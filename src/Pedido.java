import java.util.ArrayList;

public class Pedido {

    private Cliente Cliente;
    private ArrayList<Producto> productos;
    public static double Tasa_IVA = 0.21;

    public Pedido(Cliente Cliente) {
        this.Cliente = Cliente;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double calcularTotalNeto() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }

        if (total > 3000) {
            total *= 0.95;
        }

        return total;
    }
}
