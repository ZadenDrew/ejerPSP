/* 
 *Simular a caixa dunha empresa con dous fíos. Un simulará o ingreso, ca compra 
 *de artigos por parte de clientes e o outro a extracción de cartos da caixa co
 *pago a proveedores. A conta terá un capital inicial. Realizar 10 ingresos e 5 
 *extraccións
 */
package ex6psp;

/**
 *
 * @author oracle
 */
public class Ex6psp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*chamada ós constructores de productor e consumidor */
        Caixa p = new Caixa("Productor");
        Caixa c = new Caixa("Consumidor");
        /*inicializamos los hilos*/
        p.start();
        c.start();
    }

}
