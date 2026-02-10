import java.io.FileWriter;
import java.io.IOException;
public class SistemaPedidos {
// Variables globales mal ubicadas y poco descriptivas
public static double TASA_IVA = 0.21; // Esto es el IVA
public static String f = "reporte_pedidos.txt"; // Archivo de salida
public static void main(String[] args) {
System.out.println("INICIANDO SISTEMA DE PEDIDOS v1.0...");
  // ----- CLIENTE 1 -----
  Cliente cliente1 = new Cliente(
    "TechSolutions SL",
    "B12345678",
    "Calle Industria 55, Madrid"
);

Pedido pedido1 = new Pedido(cliente1);
pedido1.agregarProducto(new Producto("Servidor Dell PowerEdge", 2500.00));
pedido1.agregarProducto(new Producto("Licencia Windows Server", 800.00));
pedido1.agregarProducto(new Producto("Cableado Estructurado", 250.50));

procesarPedido(pedido1);

// ====================================================================
 // --- CLIENTE 2: COPY-PASTE DEL CÓDIGO ANTERIOR (El horror) ---
 // ====================================================================
Cliente cliente2 = new Cliente(
    "Libreria Moderna",
    "A98765432",
    "Av. Diagonal 200, Barcelona"
);

Pedido pedido2 = new Pedido(cliente2);
pedido2.agregarProducto(new Producto("Pack Libros Escolares", 1200.00));
pedido2.agregarProducto(new Producto("Estantería Metálica", 300.00));

procesarPedido(pedido2);
}


public static void procesarPedido(Pedido pedido) {

Cliente cliente = pedido.getCliente();

System.out.println("----------------------------------------------");
System.out.println("Procesando pedido para: " + cliente.getNombre());
System.out.println("ID Cliente: " + cliente.getId());

int contador = 1;
for (Producto p : pedido.getProductos()) {
System.out.println(
        String.format(
                "Item %d: %s - %.2f EUR",
                contador++, p.getNombre(), p.getPrecio()
        )
);
}

double totalNeto = pedido.calcularTotalNeto();
double totalConIVA = totalNeto + (totalNeto * TASA_IVA);

System.out.println(String.format("Total Neto: %.2f EUR", totalNeto));
System.out.println(String.format(
    "Total con IVA (%.0f%%): %.2f EUR",
    TASA_IVA * 100,
    totalConIVA
));

guardarFacturaEnArchivo(cliente, totalConIVA);
}

public static void guardarFacturaEnArchivo(Cliente cliente, double total) {

String nombreArchivo = "pedido_" + cliente.getId() + ".txt";

try (FileWriter writer = new FileWriter(nombreArchivo)) {

writer.write("FACTURA\n");
writer.write("Cliente: " + cliente.getNombre() + "\n");
writer.write("Dirección: " + cliente.getDireccion() + "\n");
writer.write(String.format("Total a pagar: %.2f EUR\n", total));

System.out.println("Factura guardada en: " + nombreArchivo);

} catch (IOException e) {
System.out.println("Error al guardar la factura");
e.printStackTrace();
}
}
}
