import java.util.Date;
import java.util.Map;

public class Compra {
    private Cliente cliente;
    private Date dataDaCompra;
    private Map<Produto, Integer> produtosComprados; // Associa um produto à quantidade comprada.
    private double valorTotal;
    private int pontosGanhos;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(Date dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public Map<Produto, Integer> getProdutosComprados() {
        return produtosComprados;
    }

    public void setProdutosComprados(Map<Produto, Integer> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(int pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    // Construtor, getters e setters
}
