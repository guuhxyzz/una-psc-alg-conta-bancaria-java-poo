
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Bem-vindo ao Sistema Bancário ---");

        System.out.print("Digite o Nome do Titular da Conta: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o Número da Conta: ");
        String numeroConta = scanner.nextLine();

        double saldoInicial = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            System.out.print("Digite o Saldo Inicial: R$ ");
            try {
                saldoInicial = scanner.nextDouble();
                if (saldoInicial < 0) {
                    System.out.println("Saldo inicial não pode ser negativo. Por favor, digite um valor não negativo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número para o saldo.");
                scanner.next(); 
            }
        }
        scanner.nextLine(); // limpar buffer

        ContaBancaria minhaConta = new ContaBancaria(nome, numeroConta, saldoInicial);

        String opcao;
        do {
            System.out.println("\n--- Menu de Operações ---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Obter Saldo");
            System.out.println("Q - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextLine().toUpperCase();

            switch (opcao) {
                case "1":
                    System.out.print("Digite o valor para depositar: R$ ");
                    try {
                        double valorDeposito = scanner.nextDouble();
                        minhaConta.depositar(valorDeposito);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número para o depósito.");
                    }
                    scanner.nextLine(); 
                    break;
                case "2":
                    System.out.print("Digite o valor para sacar: R$ ");
                    try {
                        double valorSaque = scanner.nextDouble();
                        minhaConta.sacar(valorSaque);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número para o saque.");
                    }
                    scanner.nextLine(); 
                    break;
                case "3":
                    System.out.println(String.format("Saldo disponível: R$ %.2f", minhaConta.getSaldo()));
                    break;
                case "Q":
                    System.out.println("Encerrando Programa");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        } while (!opcao.equals("Q"));

        scanner.close();
    }
}
