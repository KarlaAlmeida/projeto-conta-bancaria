## Objetivos

O projeto consiste em desenvolvimento de código em Java para realizar as seguintes operações em uma conta bancária: 

* Consultar saldo;
* Consultar cheque especial;
* Depositar dinheiro;
* Sacar dinheiro;
* Pagar um boleto;
* Verificar se a conta está usando cheque especial.

## Regras do negócio

* A conta bancária deve ter um limite de cheque especial somado ao saldo da conta;
* O o valor do cheque especial é definido no momento da criação da conta, de acordo com o valor depositado na conta em sua criação;
* Se o valor depositado na criação da conta for de R$500,00 ou menos o cheque especial deve ser de R$50,00;
* Para valores acima de R$500,00 o cheque especial deve ser de 50% do valor depositado;
* Caso o limite de cheque especial seja usado, assim que possível a conta deve cobrar uma taxa de 20% do valor usado do cheque especial.
