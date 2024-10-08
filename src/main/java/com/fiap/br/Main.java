package com.fiap.br;

import com.fiap.br.dao.InitSQL;
import com.fiap.br.models.account.ContaInvestimento;
import com.fiap.br.factory.ConnectionFactory;
import com.fiap.br.models.register.Corretora;
import com.fiap.br.models.register.Endereco;
import com.fiap.br.models.register.Usuario;
import com.fiap.br.models.transaction.Transacao;
import com.fiap.br.utils.Art;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.fiap.br.utils.InputUtils.*;

public class Main {
    public static void main(String[] args) {

        try {
            InitSQL initSQL = new InitSQL();
            initSQL.initSQL();
            initSQL.closeConection();
            System.out.println("Init SQL Executado com Sucesso");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        Endereco endereco = new Endereco();
        Usuario usuario = new Usuario();
        Corretora corretora = new Corretora();
        ContaInvestimento contaInvestimento = new ContaInvestimento();
        Transacao transacao = new Transacao();

        Scanner scanner = new Scanner(System.in);

        Art.getWelcome();

        int option = -1;
        do {
            System.out.println("\nEscolha uma das opções:\n" +
                    "1 - Cadastrar Usuário\n" +
                    "2 - Cadastrar Endereço\n" +
                    "3 - Cadastrar Corretora\n" +
                    "4 - Cadastrar ContaInvestimento\n" +
                    "5 - Realizar Transação\n" +
                    "-1 - Sair\n");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> {
                    userInput(scanner, usuario);
                }
                case 2 -> {
                    addressInput(scanner, endereco);
                }
                case 3 -> {
                    brokerInput(scanner, corretora);
                }
                case 4 -> {
                    accountInput(scanner, contaInvestimento);
                }
                case 5 -> {
                    transaction(scanner, transacao);
                }
                case -1 -> {
                    Art.getGoodbye();
                }
                default -> {
                    System.out.println("Valor Inválido");
                }
            }

        } while (option != -1);

    }

    private static void transaction(Scanner scanner, Transacao transacao) {
        System.out.println("\n### Realizar Transação. ###");

        double taxaInput = 0.1;

        transactionAmountInput(scanner, transacao);
        transactionDescriptionInput(scanner, transacao);
        transactionOriginAddressInput(scanner, transacao);
        transactionDestinyAddressInput(scanner, transacao);
        transactionHashInput(scanner, transacao);
        transactionTaxInput(taxaInput, scanner, transacao);

        System.out.println("\nDados Cadastrados!!!!");
        System.out.println(transacao.getResumoTransacao());
    }

    private static void accountInput(Scanner scanner, ContaInvestimento contaInvestimento) {
        System.out.println("\n ### Cadastro de Conta. ### ");

        accountNumberInput(scanner, contaInvestimento);
        accountPasswordInput(scanner, contaInvestimento);
        accountTypeInput(scanner, contaInvestimento);
        accountCryptoTypeInput(scanner, contaInvestimento);
        accountStatusInput(scanner, contaInvestimento);
        accountAddressInput(scanner, contaInvestimento);

        System.out.println("\nDados Cadastrados!!!!");
        System.out.println(contaInvestimento.getResumoConta());
    }

    private static void brokerInput(Scanner scanner, Corretora corretora) {
        System.out.println("\n### Cadastro de Corretora. ###");

        brokerNameInput(scanner, corretora);
        brokerCNPJInput(scanner, corretora);
        brokerTelNumberInput(scanner, corretora);
        brokerEmailInput(scanner, corretora);
        brokerCriptoActivesInput(scanner, corretora); //still need to make it a list
        brokerAddressInput(scanner, corretora);

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(corretora.getResumoCorretora());
    }

    private static void addressInput(Scanner scanner, Endereco endereco) {
        System.out.println("\n### Cadastro de Endereço. ###");

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
    }

    private static void userInput(Scanner scanner, Usuario usuario) {
        System.out.println("\n### Cadastro de Usuário ###");

        userNameInput(scanner, usuario);
        userEmailInput(scanner, usuario);
        userPasswordInput(scanner, usuario);
        userCPFInput(scanner, usuario);
        userTelNumberInput(scanner, usuario);

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(usuario.getResumoUsuario());
    }

}