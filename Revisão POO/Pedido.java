import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Produto> itens;
    private int total;

    public Pedido() {
        itens = new ArrayList<>();
        total = 0;
    }

    public void adicionarProduto(Produto produto) {
        itens.add(produto);
        total += produto.getPreco();
    }

    public int getTotal() {
        return total;
    }

    public void exibirPedido() {
        System.out.println("Itens do Pedido:");
        for (Produto produto : itens) {
            System.out.println(produto.getNome() + " - R$" + produto.getPreco());
        }
    }
}
