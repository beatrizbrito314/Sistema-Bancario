package sistema_bancario;

public class Contacorrente extends Conta implements ITributavel {
	
	//não rende automaticamente
	public Contacorrente(String nome, Double saldo) {
		super(nome, saldo);
	}
	@Override
	void sacar(double valorSaque) {
		double taxaSaque=valorSaque*0.05;
		if(valorSaque<0) {
			System.out.println("Informe um valor válido");
		}else if(valorSaque+taxaSaque>this.saldo) {
			System.out.println("Saldo insuficiente");
		}else {
			this.saldo-=valorSaque+taxaSaque;
		}
	}
	
	@Override
	public double calcularTributos() {
		return (this.saldo*0.01);
		
	}
}
