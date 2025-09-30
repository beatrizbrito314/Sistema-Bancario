package sistema_bancario;

public class auxFuncoes {
	void printMenu() {
	 	System.out.println("=======Qual operação deseja realizar?=======");
        System.out.println("0 - Criar nova conta");
        System.out.println("1 - Realizar Depósito");
        System.out.println("2 - Realizar Saque");
        System.out.println("3 - Realizar Transferência");
        System.out.println("4 - Listar contas");
        System.out.println("5 - Calcular Total de Tributos");
        System.out.println("6 - Sair");
        System.out.println("============================================");
	}
	void printTipoConta() {
		System.out.println("Informe o tipo de conta: ");
		System.out.println("0 - Conta Corrente ");
		System.out.println("1 - Conta Poupança ");
	}
	

}
