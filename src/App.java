public class App {
    public static void main(String[] args) {
        System.out.println("INICIANDO SISTEMA DE PEDIDOS v2.0 (Refactorizado)...");
        // --- CLIENTE 1 ---
        Cliente Cliente1 = new Cliente("TechSolutions SL", "B12345678", "Calle Industria 55");
        Pedido pedido1 = new Pedido(Cliente1);
        pedido1.agregarProducto(new Producto("Servidor Dell", 2500.0));
        pedido1.agregarProducto(new Producto("Windows Server", 800.0));
       
        procesarPedido(pedido1); // Código reutilizable
        //...
       }
       public static void procesarPedido(Pedido pedido) {

        System.out.println("-----------------------------------");
        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("ID: " + pedido.getCliente().getId());

        int i = 1;
        for (Producto p : pedido.getProductos()) {
            System.out.println(
                    String.format(
                            "Producto %d: %s - %.2f €",
                            i++, p.getNombre(), p.getPrecio()
                    )
            );
        }
        }
}
