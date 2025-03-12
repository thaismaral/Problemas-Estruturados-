import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto Temaki = new Produto ("Temaki",25 );
        Produto Sushi = new Produto ("Sushi",35 );
        Produto Guioza = new Produto ("Guioza",30 );

        System.out.println("Digite 1 para fazer pedido e 2 para sair");

        int menu = scanner.nextInt();
        if (menu == 1) {
            System.out.print("Digite seu nome: ");
            String nomeCliente = scanner.next();

            Pedido pedido = new Pedido();

            int numeroPedido;

            do {
                System.out.print("===========================================================\n");
                System.out.print("0 - Finalizar Pedido \n1 - Temaki \n2 - Sushi \n3 - Guioza \n");
                System.out.print("===========================================================\n");

                System.out.print("Escolha um item para adicionar ao pedido: ");
                numeroPedido = scanner.nextInt();

                switch (numeroPedido) {
                    case 1:
                        pedido.adicionarProduto(Temaki);
                        break;
                    case 2:
                        pedido.adicionarProduto(Sushi);
                        break;
                    case 3:
                        pedido.adicionarProduto(Guioza);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (numeroPedido != 0);

            pedido.exibirPedido();

            if (numeroPedido == 0){
                int valorTotalPedido = pedido.getTotal();

                if (valorTotalPedido == 0) {
                    System.out.print("Obrigada "+nomeCliente+" volte sempre!");
                    System.exit(0);
                } else{
                    System.out.println("Valor Total: R$" + valorTotalPedido);
                    int taxaServico = (int) (valorTotalPedido * 0.10);
                    System.out.println("Taxa de Serviço (10%): R$" + taxaServico);

                    int valorTotalComTaxa = valorTotalPedido + taxaServico;
                    System.out.println("Total a Pagar: R$" + valorTotalComTaxa);

                    System.out.print("Quanto foi enserido em dinheiro? ");
                    int valorPagar = scanner.nextInt();

                    int troco = valorPagar - valorTotalComTaxa;
                    System.out.print("Seu troco é: " + troco + "\n");
                    System.out.print("Obrigada "+nomeCliente+" volte sempre!");
                }

            }

        } else {
            System.out.println("Volte sempre!");
            System.exit(0);
        }
        scanner.close();
    }
}