package com.fiap.br;

import com.fiap.br.dao.AccountDAO;
import com.fiap.br.dao.CheckTablesExistence;
import com.fiap.br.dao.InitSQL;
import com.fiap.br.models.account.Conta;
import com.fiap.br.models.register.Corretora;
import com.fiap.br.models.register.Endereco;
import com.fiap.br.models.register.Usuario;
import com.fiap.br.models.transaction.Transacao;
import com.fiap.br.utils.Art;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import static com.fiap.br.utils.InputUtils.*;

public class Main {
    public static void main(String[] args) {


        //Init.SQL
        try {
            CheckTablesExistence checkTablesExistence = new CheckTablesExistence();
            for (String tableName: checkTablesExistence.tablesToCheck) {
                if (!checkTablesExistence.checkTableExists(tableName)) {
                    try {
                        InitSQL initSQL = new InitSQL();
                        initSQL.initSQL();
                        initSQL.closeConection();
                        System.out.println("Init SQL Executado com Sucesso");
                    } catch (SQLException | IOException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                } else {
                    System.out.println("Tables already exist");
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        // Scanner Openning
        Scanner scanner = new Scanner(System.in);

        // ASCII Art
        Art.getWelcome();

        // Interaction Loop
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

            try {
                switch (option) {
                    case 1 -> {
                        userInput(scanner);
                    }
                    case 2 -> {
                        addressInput(scanner);
                    }
                    case 3 -> {
                        brokerInput(scanner);
                    }
                    case 4 -> {
                        accountInput(scanner);
                    }
                    case 5 -> {
                        transaction(scanner);
                    }
                    case -1 -> {
                        Art.getGoodbye();
                    }
                    default -> {
                        System.out.println("Valor Inválido");
                    }
                }
            }
            catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        } while (option != -1);

    }

    private static void transaction(Scanner scanner) {
        Transacao transacao = new Transacao();
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

    private static void accountInput(Scanner scanner) throws SQLException {
        Conta conta = new Conta();
        AccountDAO accountDAO = new AccountDAO();

        System.out.println("\n ### Cadastro de Conta. ### ");

        accountNumberInput(scanner, conta);
        accountPasswordInput(scanner, conta);
        accountTypeInput(scanner, conta);
        accountCryptoTypeInput(scanner, conta);
        accountStatusInput(scanner, conta);
        accountAddressInput(scanner, conta);

        accountDAO.registerAccount(conta);

        System.out.println("\nDados Cadastrados!!!!");
        System.out.println(conta.getResumoConta());
    }

    private static void brokerInput(Scanner scanner) {
        Corretora corretora = new Corretora();
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

    private static void addressInput(Scanner scanner) {
        Endereco endereco = new Endereco();
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

    private static void userInput(Scanner scanner) {
        Usuario usuario = new Usuario();
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