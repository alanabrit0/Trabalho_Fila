import java.util.Scanner;

public class Principal {
    private String[] fila;
    private int tamanho;
    private int quantidade;

    public Principal(int capacidade) {
        fila = new String[capacidade];
        tamanho = capacidade;
        quantidade = 0;
    }

    public void adicionarCliente(String nome) {
        if (quantidade == tamanho) {
            System.out.println("Fila cheia! Não é possível adicionar mais clientes.");
            return;
        }
        fila[quantidade] = nome;
        quantidade++;
        System.out.println("Cliente " + nome + " adicionado à fila.");
    }

    public void atenderCliente() {
        if (quantidade == 0) {
            System.out.println("Nenhum cliente para atender.");
            return;
        }
        String clienteAtendido = fila[0];
        System.out.println("Atendendo cliente: " + clienteAtendido);

        for (int i = 0; i < quantidade - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[quantidade - 1] = null;
        quantidade--;
    }

    public void listarClientes() {
        if (quantidade == 0) {
            System.out.println("Nenhum cliente aguardando.");
            return;
        }
        System.out.println("Clientes aguardando:");
        for (int i = 0; i < quantidade; i++) {
            System.out.println((i + 1) + " - " + fila[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Principal sistema = new Principal(5);

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Atender cliente");
            System.out.println("3 - Listar clientes");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    sistema.adicionarCliente(nome);
                    break;
                case 2:
                    sistema.atenderCliente();
                    break;
                case 3:
                    sistema.listarClientes();
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
