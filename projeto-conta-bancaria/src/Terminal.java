import java.util.Scanner;

public class Terminal {

    private final static Scanner scanner = new Scanner(System.in);

    private final static Conta conta = new Conta("1234", "123456-0" , "Karla", 100);

    public static void main(String[] args) {

	var option1 = -1;
	
	    do{
            System.out.println("===Escolha uma das opções:==="); 
            System.out.println("1 - Consultar Saldo."); 
            System.out.println("2 - Consultar Cheque Especial."); 
            System.out.println("3 - Depositar Dinheiro."); 
            System.out.println("4 - Sacar Dinheiro."); 
            System.out.println("5 - Pagar Boleto."); 
            System.out.println("6 - Verificar se a conta está usando cheque especial."); 
            System.out.println("0 - Sair.");

            option1 = scanner.nextInt();

            switch (option1){
                case 1 -> {
                    System.out.println("O saldo da conta corrente atual é: " + conta.getSaldoCC() + " reais.");
                    }
                case 2 -> {
                    System.out.println("O limite do cheque especial desta conta é: " + conta.getLimiteChequeEspecial() + " reais.");
                    System.out.println("O saldo do cheque especial atual é: " + conta.getSaldoChequeEspecial() + " reais.");
                    }
                case 3 -> depositarDinheiro();
                case 4 -> sacarDinheiro();
                case 5 -> pagarBoleto();
                case 6 -> {
                    if(conta.getSaldoChequeEspecial() < conta.getLimiteChequeEspecial()){
                        System.out.println("Você está usando " + (conta.getLimiteChequeEspecial() - conta.getSaldoChequeEspecial()) + " reais do cheque especial.");
                    }
                    else{
                        System.out.println("Você não está utilizando o cheque especial.");
                    }
                }
                case 0 -> {
                    System.out.println("Saindo.");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida");                          
           }
        } while (option1 != 0);
    }

	public static void depositarDinheiro(){
		double valorDeposito = 0.0;
		System.out.println("Informe o valor a ser depositado.");
		valorDeposito = scanner.nextDouble();
		conta.setDeposito(valorDeposito);
        conta.realizarDeposito();
	}

	public static void sacarDinheiro(){
		double valorSaque = 0.0;
		System.out.println("Informe o valor a ser sacado.");
		valorSaque = scanner.nextDouble();
		conta.setSaque(valorSaque);
        conta.realizarSaque();
	}

    public static void pagarBoleto(){
		double valorBoleto = 0.0;
		System.out.println("Informe o valor do boleto a ser pago.");
		valorBoleto = scanner.nextDouble();
		conta.setValorBoleto(valorBoleto);
        conta.realizarPagamentoBoleto();
	}



}
