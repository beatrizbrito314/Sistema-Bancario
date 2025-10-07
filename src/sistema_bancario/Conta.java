package sistema_bancario;

public abstract class Conta {
	protected static int count=100;
	protected String nomeCliente;
	protected Double saldo;
	protected int numConta;

	public Conta(String nome, Double saldo) {
		this.nomeCliente=nome;
		this.saldo=saldo;
		this.numConta=count++;
	}

	public int getNumero() {
		return numConta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Double getSaldo() {
		return saldo;
	}
	void sacar(double valorSaque) {
			this.saldo-=valorSaque;
	}
	void depositar(double valorDeposito) {
		if(valorDeposito<=0) {
			System.out.println("Informe um valor válido");
		}else {
			this.saldo+=valorDeposito;
		}
		}
	void transferir(double valorTransferencia, Conta origem, Conta destino) {
			origem.saldo-=valorTransferencia;
			destino.saldo+=valorTransferencia;
		}




}
