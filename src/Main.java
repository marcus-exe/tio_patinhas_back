import java.math.BigDecimal;
import java.util.*;

import register.Corretora;
import register.Endereco;
import register.Usuario;
import account.ContaInvestimento;
import transaction.Transacao;
import enums.StatusConta;
import enums.TipoConta;
import enums.TipoCriptoativo;

import static utils.InputUtils.*;

public class Main {
    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        Usuario usuario = new Usuario();
        Corretora corretora = new Corretora();
        ContaInvestimento contaInvestimento = new ContaInvestimento();
        Transacao transacao = new Transacao();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--------- Bem-vindo ao Banco de Investimentos de Bitcoins!!! ----------");

        /*--------------USUARIO-------------------------*/

        System.out.println("\nAntes de começar a investir, realize o seu cadastro" +
                " preenchendo as informações a seguir:");
        

        userNameInput(scanner, usuario);
        userEmailInput(scanner, usuario);
        userPasswordInput(scanner, usuario);
        userCPFCNPJInput(scanner, usuario);
        userTelNumberInput(scanner, usuario);

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(usuario.getResumoUsuario());


        /*--------------ENDEREÇO-------------------------*/

        System.out.println("\nÓtimo! Vamos ver agora sobre o seu endereço.");
        int numberInput = -1;
        addressStreetInput(scanner, endereco);
        addressNumberInput(numberInput, scanner, endereco);
        addressExtraInfoInput(scanner, endereco);
        addressNeighborhoodInput(scanner, endereco);
        addressCityInput(scanner, endereco);
        addressStateCodeInput(scanner, endereco);
        addressZipCodeInput(scanner, endereco);
        addressCountryInput(scanner, endereco);

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(endereco.getResumoEndereco());


        /*--------------CORRETORA-------------------------*/

        System.out.println("\nPara finalizar o cadastro, preencha as" +
                " informações a seguir sobre a sua corretora: ");

        brokerNameInput(scanner, corretora);
        brokerCNPJInput(scanner, corretora);
        brokerTelNumberInput(scanner, corretora);
        brokerEmailInput(scanner, corretora);
        brokerCriptoActivesInput(scanner, corretora); //still need to make it a list
        brokerAddressInput(scanner, corretora);

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(corretora.getResumoCorretora());


        /*--------------CONTA INVESTIMENTO-------------------------*/


        System.out.println("\nObrigado por realizar o cadastro. Agora, preencha" +
                " as informações sobre a sua conta de investimento: ");
        
        accountNumberInput(scanner, contaInvestimento);
        accountPasswordInput(scanner, contaInvestimento);
        accountTypeInput(scanner, contaInvestimento);
        accountCryptoTypeInput(scanner, contaInvestimento);
        accountStatusInput(scanner, contaInvestimento);
        accountAddressInput(scanner, contaInvestimento);

        System.out.println("\nDados Cadastrados!!!!");
        System.out.println(contaInvestimento.getResumoConta());


        /*--------------Transação-------------------------*/


        System.out.println("Para realizar uma transação, preeencha as informações a seguir.");

        double taxaInput = 0.1;

        transactionAmountInput(scanner, transacao);
        transactionDescriptionInput(scanner, transacao);
        transactionOriginAddressInput(scanner, transacao);
        transactionDestinyAddressInput(scanner, transacao);
        transactionHashInput(scanner, transacao);
        transactionTaxInput(taxaInput, scanner, transacao);


        System.out.println("\nDados Cadastrados!!!!");
        System.out.println(transacao.getResumoTransacao());

        System.out.println("Obrigado por usar a nossa ferramenta!!!!");
        System.out.println("Finalizando Sistema....");

    }



}