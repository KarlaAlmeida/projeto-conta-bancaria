public class Conta {

    private String agencia;

	private String numeroConta;

	private String nome;

	private double saldoCC = 0.0;

	private double limiteChequeEspecial = 0.0;

    private double saldoChequeEspecial;

    private double valorDeposito;

    private double valorSaque;

    private double valorBoleto;

	private double taxa = 0.0;

	
    //Construtor
    public Conta(String agencia, String numeroConta, String nome, double saldoCC){
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.nome = nome;
		this.saldoCC = saldoCC;

		if(saldoCC <= 500){
			limiteChequeEspecial = 50;
			saldoChequeEspecial = limiteChequeEspecial;
		}
		else{
			limiteChequeEspecial = 0.5*saldoCC;
			saldoChequeEspecial = limiteChequeEspecial;
		}

		System.out.println("Olá, "+ this.nome + ". Seja bem vindo(a) ao nosso banco.");
		System.out.println("O número da sua agência é " + this.agencia);
		System.out.println("O número da sua conta é " + this.numeroConta);
		System.out.println("O saldo atual da sua conta é " + this.saldoCC + " reais.");
		System.out.println("Você tem o benefício de um cheque especial no valor limite de " + limiteChequeEspecial + " reais. Quando utilizado, será cobrada uma taxa de 20% sobre o valor utilizado.");

	}
	    
    public double getSaldoCC() {
        return saldoCC;
    }

    public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}


    public double getSaldoChequeEspecial() {
		return saldoChequeEspecial;
	}

	public void setDeposito(double valorDeposito) {
        this.valorDeposito = valorDeposito;
    }

    public void setSaque(double valorSaque) {
        this.valorSaque = valorSaque;
    }

    public void setValorBoleto(double valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

	public void realizarDeposito(){
		double valorDepositoCheque = 0.0;
		double valorDepositoCC = 0.0;
		if(saldoChequeEspecial < limiteChequeEspecial){
			if((valorDeposito > (limiteChequeEspecial - saldoChequeEspecial))&&(valorDeposito < (limiteChequeEspecial - saldoChequeEspecial + taxa))){
				valorDepositoCheque = limiteChequeEspecial - saldoChequeEspecial;
				valorDepositoCC = valorDeposito - valorDepositoCheque;
				saldoChequeEspecial += valorDepositoCheque;
				saldoCC += valorDepositoCC;
			}
			else if(valorDeposito >= (limiteChequeEspecial - saldoChequeEspecial + taxa)){
				valorDepositoCheque = limiteChequeEspecial - saldoChequeEspecial;
				valorDepositoCC = valorDeposito - valorDepositoCheque - taxa;
				saldoChequeEspecial += valorDepositoCheque;
				saldoCC += valorDepositoCC;
				if(taxa>0){
					System.out.println("Foi cobrada uma taxa de " + taxa + " reais da utilização anterior do cheque especial.");
				}
				taxa = 0.0;
			}
			else{
				valorDepositoCheque = valorDeposito;
				saldoChequeEspecial += valorDepositoCheque;
			}
		}
		else{
			valorDepositoCC = valorDeposito - taxa;
			saldoCC += valorDepositoCC;
			if(taxa>0){
				System.out.println("Foi cobrada uma taxa de " + taxa + " reais da utilização anterior do cheque especial.");
			}
			taxa = 0.0;
		}
		System.out.println("O valor depositado no cheque especial foi " + valorDepositoCheque + " reais e o valor depositado na conta corrente foi " + valorDepositoCC + " reais.");
	}

	public void realizarSaque(){
		if(valorSaque <= saldoCC){
			saldoCC -= valorSaque;
			System.out.println("O saque de " + valorSaque + " reais foi realizado com sucesso. O saldo atual da conta corrente é " + saldoCC + " reais.");
		}
		else{
			if((valorSaque - saldoCC) <= saldoChequeEspecial){
				saldoChequeEspecial = saldoChequeEspecial - (valorSaque - saldoCC);
				System.out.println("O valor solicitado é maior que o saldo da conta corrente. Foi realizado o saque de " +  (valorSaque - saldoCC) + " reais do cheque especial.");
				saldoCC = 0.0;
				System.out.println("O saldo atual da conta corrente é " + saldoCC + " reais e o saldo atual do cheque especial é " + saldoChequeEspecial + " reais.");
				taxa = 0.2* (limiteChequeEspecial - saldoChequeEspecial);
			}
			else{
				System.out.println("Não há saldo suficiente para realizar o saque.");
				System.out.println("O saldo atual da conta corrente é " + saldoCC + " reais e o saldo atual do cheque especial é " + saldoChequeEspecial + " reais. Valor máximo permitido para saque: " + (saldoCC + saldoChequeEspecial) + " reais.");
			}
		}
	}

	public void realizarPagamentoBoleto(){
		if(valorBoleto <= saldoCC){
			saldoCC -= valorBoleto;
			System.out.println("O pagamento do boleto no valor de " + valorBoleto + " reais foi realizado com sucesso. O saldo atual da conta corrente é " + saldoCC + " reais.");
		}
		else{
			if((valorBoleto - saldoCC) <= saldoChequeEspecial){
				saldoChequeEspecial = saldoChequeEspecial - (valorBoleto - saldoCC);
				System.out.println("O valor do boleto é maior que o saldo da conta corrente. Foi retirado o valor de " +  (valorBoleto - saldoCC) + " reais do cheque especial.");
				saldoCC = 0.0;
				System.out.println("O saldo atual da conta corrente é " + saldoCC + " reais e o saldo atual do cheque especial é " + saldoChequeEspecial + " reais.");
				taxa = 0.2* (limiteChequeEspecial - saldoChequeEspecial);
			}
			else{
				System.out.println("Não há saldo suficiente para realizar o pagamento.");
				System.out.println("O saldo atual da conta corrente é " + saldoCC + " reais e o saldo atual do cheque especial é " + saldoChequeEspecial + " reais. Valor máximo permitido para pagamento: " + (saldoCC + saldoChequeEspecial) + " reais.");
			}
		}
	}


}
