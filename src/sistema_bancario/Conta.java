package sistema_bancario;

public abstract class Conta {
	protected int numero;//vou fazer por auto-increment dps
	protected String nomeCliente;
	protected Double saldo;

	public Conta(String nome, Double saldo) {
		this.nomeCliente=nome;
		this.saldo=saldo;
	}

	public int getNumero() {
		return numero;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Double getSaldo() {
		return saldo;
	}
	void sacar(double valorSaque) {
		if(valorSaque<0) {
			System.out.println("Informe um valor válido");
		}else if(valorSaque>this.saldo) {
			System.out.println("Saldo insuficiente");
		}else {
			this.saldo-=valorSaque;
		}
	}
	void depositar(double valorDeposito) {
		if(valorDeposito<=0) {
			System.out.println("Informe um valor válido");
		}else {
			this.saldo+=valorDeposito;
		}
		}
	void transferir(double valorTransferencia, Conta origem, Conta destino) {
		if(valorTransferencia>origem.saldo) {
			System.out.println("Saldo insuficiente");
		}else {
			origem.saldo-=valorTransferencia;
			destino.saldo+=valorTransferencia;
		}
		
	
		}


}
