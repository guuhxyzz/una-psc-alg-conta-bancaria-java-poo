public class ContaBancaria {
    private String nomePessoa;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String nomePessoa, String numeroConta, double saldoInicial) {
        this.nomePessoa = nomePessoa;
        this.numeroConta = numeroConta;
        this.saldo = Math.max(0, saldoInicial); // evitar o usuario a ter um saldo negativo
        System.out.println("Conta bancária criada com sucesso para " + this.nomePessoa + ".");
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println(String.format("Depósito de R$ %.2f realizado com sucesso. Novo saldo: R$ %.2f", valor, this.saldo));
        } else {
            System.out.println("Valor de depósito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque deve ser positivo.");
            return;
        }

        if (valor > 5000.00) {
            System.out.println("Valor do saque acima do permitido. Limite: R$ 5000,00.");
            return;
        }

        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println(String.format("Saque de R$ %.2f realizado com sucesso. Novo saldo: R$ %.2f", valor, this.saldo));
        } else {
            System.out.println("Saldo insuficiente para realizar a operação. Saldo atual: R$ " + String.format("%.2f", this.saldo));
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}