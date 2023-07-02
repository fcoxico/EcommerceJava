public class Admin extends Cliente {

   public Admin(String nome, String cpf, int idade) {
        super(nome, cpf, idade);
    }

        public void inserirProduto(Produto produto) {
            produtos.add(produto);
        }
    
        public void alterarProduto(Produto produto) {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equals(produto.getNome())) {
                    produtos.set(i, produto);
                    break;
                }
            }
        }
    
        public void removerProduto(Produto produto) {
            produtos.remove(produto);
        }
    
        public void atualizarEstoque(Produto produto, int quantidade) {
            for (int i = 0; i < produtos.size(); i++) {
                if (produtos.get(i).getNome().equals(produto.getNome())) {
                    Produto produtoExistente = produtos.get(i);
                    produtoExistente.setQuantidadeEstoque(produtoExistente.getQuantidadeEstoque() + quantidade);
                    break;
                }
            }
        }
    
        public void exibirRelatorio() {
            System.out.println("Relatório de Produtos em Falta no Estoque:");
            for (Produto produto : produtos) {
                if (produto.getQuantidadeEstoque() == 0) {
                    System.out.println("Nome: " + produto.getNome());
                    System.out.println("Categoria: " + produto.getCategoria());
                    System.out.println("---------------------------");
                }
            }
        }
    }
    
