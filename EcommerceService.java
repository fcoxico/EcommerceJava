import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EcommerceService {
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Compra> compras;

    public EcommerceService(List<Cliente> clientes, List<Produto> produtos, List<Compra> compras) {
        this.clientes = clientes;
        this.produtos = produtos;
        this.compras = compras;
    }

    public boolean loginAdmin(String username, String password) {
        // Lógica para autenticação do admin
        // Verificar se o username e senha correspondem a um admin válido
        String adminUsername = "admin";
        String adminPassword = "admin123";

        return adminUsername.equals(username) && adminPassword.equals(password);
    }

    public boolean loginCliente(String cpf, String senha) {
        // Lógica para autenticação do cliente
        // Verificar se o CPF e senha correspondem a um cliente válido
        String clienteCpf = "123456789";
        String clienteSenha = "senha123";

        return clienteCpf.equals(cpf) && clienteSenha.equals(senha);
    }

    public void adicionarProduto(Produto produto) {
        // Lógica para adicionar um produto
        produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        // Lógica para remover um produto
        produtos.remove(produto);
    }

    public void realizarCompra(Cliente cliente, List<Produto> produtosSelecionados) {
        // Lógica para realizar uma compra

        // Criar uma nova compra
        Compra compra = new Compra(cliente, produtosSelecionados);

        // Adicionar a compra à lista de compras
        compras.add(compra);

        // Atualizar o estoque dos produtos
        for (Produto produto : produtosSelecionados) {
            int quantidadeComprada = produto.getQuantidadeNoCarrinho();
            produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() - quantidadeComprada);
        }
    }

    public void atualizarEstoque(Produto produto, int quantidade) {
        // Lógica para atualizar o estoque de um produto

        // Encontrar o produto na lista de produtos
        for (Produto p : produtos) {
            if (p.equals(produto)) {
                // Atualizar a quantidade em estoque do produto
                p.setQuantidadeEmEstoque(quantidade);
                break;
            }
        }
    }

    public void exibirRelatorioClientesMaisCompram() {
        // Lógica para exibir o ranking dos clientes que mais compram

        Map<Cliente, Integer> mapaQuantidadeCompras = new HashMap<>();

        // Atualizar o mapa com base nas compras realizadas
        for (Compra compra : compras) {
            Cliente cliente = compra.getCliente();
            int quantidadeCompras = mapaQuantidadeCompras.getOrDefault(cliente, 0);
            mapaQuantidadeCompras.put(cliente, quantidadeCompras + 1);
        }

        // Classificar o mapa com base nas quantidades de compras em ordem decrescente
        List<Map.Entry<Cliente, Integer>> listaOrdenada = new ArrayList<>(mapaQuantidadeCompras.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Exibir o ranking dos clientes que mais compram
        System.out.println("Ranking dos clientes que mais compram:");
        int posicao = 1;
        for (Map.Entry<Cliente, Integer> entry : listaOrdenada) {
            Cliente cliente = entry.getKey();
            int quantidadeCompras = entry.getValue();
            System.out.println(posicao + ". " + cliente.getNome() + " - Quantidade de compras: " + quantidadeCompras);
            posicao++;
        }
    }

    public void exibirRelatorioProdutosEmFalta() {
        // Lógica para exibir os produtos em falta no estoque

        List<Produto> produtosEmFalta = new ArrayList<>();

        // Verificar quais produtos estão em falta no estoque
        for (Produto produto : produtos) {
            if (produto.getQuantidadeEmEstoque() == 0) {
                produtosEmFalta.add(produto);
            }
        }

        // Exibir os produtos em falta
        System.out.println("Produtos em falta no estoque:");
        for (Produto produto : produtosEmFalta) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Categoria: " + produto.getCategoria());
            // Exibir outras informações relevantes do produto, se necessário
        }
    }
}
