package sistema_bancario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 ArrayList<Conta> listaContas = new ArrayList<>();
		boolean validarWhile=true;
		while(validarWhile) {
		//imprimir menu inicial
			auxFuncoes auxFuncoes = new auxFuncoes();
			auxFuncoes.printMenu();
		//case
			int operacao = sc.nextInt();
            sc.nextLine();
		switch(operacao) {
		
			case 0: //CRIAR CONTA
	            sc.nextLine();
	            System.out.println("Informe o nome do cliente:");
				String nome=sc.nextLine();
				System.out.println("Informe o saldo");
				Double saldo=sc.nextDouble();
				//funcao para imprimir as opcoes de tipo de conta
				auxFuncoes.printTipoConta();
				int tipoConta = sc.nextInt();
				boolean contaInvalida=true;
				int count=0;
				
				while(contaInvalida) {
					count++;
					if(count>=10) {
						System.out.println("Muitas tentativas incorretas, tente novamente mais tarde.");
						contaInvalida=false;
					}else {
						auxFuncoes.printTipoConta();
						tipoConta = sc.nextInt();
						if(tipoConta==0) {
							Contacorrente novaContaCorrente= new Contacorrente(nome, saldo);
							listaContas.add(novaContaCorrente);
							contaInvalida=false;
							
						}else if(tipoConta==1) {
							ContaPoupanca novaContaPoupanca= new ContaPoupanca(nome, saldo);
							listaContas.add(novaContaPoupanca);
							contaInvalida=false;
						}
					}
				}
				System.out.println("Conta criada com sucesso!");
				break;
			case 1: //REALIZAR DEPOSITO
				System.out.println("Informe o número da conta.");
				int numConta=sc.nextInt();
				
				System.out.println("Informe o valor a ser depositado.");
				int valorDeposito=sc.nextInt();
				
				boolean contaExiste=false;
				sc.nextLine();
				
				for( Conta conta: listaContas) {
					if(numConta==conta.getNumero()) {
						conta.depositar(valorDeposito);
						contaExiste=true;
						System.out.println("Depósito realizado com sucesso!");
						break;
					}
				}if(contaExiste==false) {
					System.out.println("Conta não encontrada.");
				}
				
	           
				
		
		}
		
		
		}

	}

}
