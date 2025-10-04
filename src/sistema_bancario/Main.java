package sistema_bancario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 ArrayList<Conta> listaContas = new ArrayList<>();
		boolean validarWhile=true;
		int numConta;//conta origem
		boolean contaExiste;
		int numContaDestino; //conta destino
		int valor;
		Double tributos=0.0;
		
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
				sc.nextLine();
				System.out.println("Informe o saldo");
				Double saldo=sc.nextDouble();
				sc.nextLine();
				//funcao para imprimir as opcoes de tipo de conta
				auxFuncoes.printTipoConta();
				int tipoConta = sc.nextInt();
				sc.nextLine();
				boolean contaInvalida=true;
				int count=0;
				
				while(contaInvalida) {
					count++;
					if(count>=10) {
						System.out.println("Muitas tentativas incorretas, tente novamente mais tarde.");
						contaInvalida=false;
					}else {
						
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
				numConta=sc.nextInt();
				
				System.out.println("Informe o valor a ser depositado.");
				valor=sc.nextInt();
				
				contaExiste=false;
				
				for( Conta conta: listaContas) {
					if(numConta==conta.getNumero()) {
						conta.depositar(valor);
						contaExiste=true;
						System.out.println("Depósito realizado com sucesso!");
						break;
					}
				}if(contaExiste==false) {
					System.out.println("Conta não encontrada.");
					break;
				}
				break;
			case 2: //REALIZAR SAQUE
				System.out.println("Informe o número da conta.");
				numConta=sc.nextInt();
				
				System.out.println("Informe o valor do saque.");
				valor=sc.nextInt();
				
				contaExiste=false;
				sc.nextLine();
				
				for( Conta conta: listaContas) {
					if(numConta==conta.getNumero()) {
						conta.sacar(valor);
						contaExiste=true;
						System.out.println("Saque realizado com sucesso!");
						break;
					}
				}if(contaExiste==false) {
					System.out.println("Conta não encontrada.");
				}
				break;
			case 3: //REALIZAR TRANSFERENCIA
				System.out.println("Informe o número da conta de origem.");
				numConta=sc.nextInt();
				System.out.println("Informe o número da conta de destino.");
				numContaDestino=sc.nextInt();
				
				System.out.println("Informe o valor da transferencia.");
				valor=sc.nextInt();
				
				contaExiste=false;
				sc.nextLine();
				
				for( Conta conta1: listaContas) {
					
					if(numConta==conta1.getNumero()) {
						for(Conta conta2: listaContas) {
							if(numContaDestino==conta2.getNumero()) {
								conta1.transferir(valor, conta1, conta2);
								contaExiste=true;
							}
						}
						System.out.println("Saque realizado com sucesso!");
						break;
					}
				}if(contaExiste==false) {
					System.out.println("Conta não encontrada.");
					break;
				}
				break;
			case 4: //LISTAR CONTAS
				for( Conta conta: listaContas) {
					auxFuncoes.ListarContas(conta);
					}
				break;
			case 5: //CALCULAR TRIBUTOS
				for (Conta conta: listaContas) {
					if(conta instanceof ITributavel) {
						System.out.println("Contas correntes:" + conta.getNumero());
						ITributavel contaTributavel=(ITributavel) conta;
						tributos+=contaTributavel.calcularTributos();					}
				}
				System.out.println("\n======================================");
				System.out.println("Total de tributos a recolher: R$" + tributos);
				System.out.println("\n======================================");
				break;
			case 6: //SAIR
				validarWhile=false;
			default: 
				System.out.println("Informe uma opção válida.");
				break;
		
		}
		
		
		}

	}

}
