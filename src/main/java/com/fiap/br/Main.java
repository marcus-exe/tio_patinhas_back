package com.fiap.br;

import com.fiap.br.dao.*;
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

        // Scanner Opening
        Scanner scanner = new Scanner(System.in);

        // ASCII Art
        Art.getWelcome();

        // Disclaimer
        // Disclaimer
        System.out.println("- Disclaimer: \n" +
                "  - Projeto adaptado a uma lógica de CLI, ou seja, nem todos os elementos estão conforme a documentação\n" +
                "  - Não foi possível implementar os métodos delete, put : por questão de tempo, não de desafio técnico");

        // Interaction Loop
        int option = -1;
        do {
            System.out.println("\nEscolha uma das opções:\n" +
                    "1 - Central de  Usuários\n" +
                    "2 - Central de Endereços\n" +
                    "3 - Central de Corretoras\n" +
                    "4 - Central de ContasInvestimento\n" +
                    "5 - Central de Transações\n" +
                    "-1 - Sair\n");
            option = scanner.nextInt();

            try {
                switch (option) {
                    case 1 -> {
                        do {
                            System.out.println("\nCentral de ações de Usuários:\n" +
                                    "1 - Cadastrar Usuário\n" +
                                    "2 - Modificar Usuário\n" +
                                    "3 - Apagar Usuário\n" +
                                    "4 - Mostrar todos os Usuários\n" +
                                    "-1 - Sair\n");
                            option = scanner.nextInt();
                            switch (option) {
                                case 1 -> {
                                    userInput(scanner);
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
                    case 2 -> {
                        do {
                            System.out.println("\nCentral de ações de Endereços:\n" +
                                    "1 - Cadastrar Endereço\n" +
                                    "2 - Modificar Endereço\n" +
                                    "3 - Apagar Endereço\n" +
                                    "4 - Mostrar todos os Endereços\n" +
                                    "-1 - Sair\n");
                            option = scanner.nextInt();
                            switch (option) {
                                case 1 -> {
                                    addressInput(scanner);
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
                    case 3 -> {
                        do {
                            System.out.println("\nCentral de ações de Corretoras:\n" +
                                    "1 - Cadastrar Corretora\n" +
                                    "2 - Modificar Corretora\n" +
                                    "3 - Apagar Corretora\n" +
                                    "4 - Mostrar todos os Corretoras\n" +
                                    "-1 - Sair\n");
                            option = scanner.nextInt();
                            switch (option) {
                                case 1 -> {
                                    brokerInput(scanner);
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
                    case 4 -> {
                        do {
                            System.out.println("\nCentral de ações de ContasInvestimento:\n" +
                                    "1 - Cadastrar ContaInvestimento\n" +
                                    "2 - Modificar ContaInvestimento\n" +
                                    "3 - Apagar ContaInvestimento\n" +
                                    "4 - Mostrar todos os ContasInvestimento\n" +
                                    "-1 - Sair\n");
                            option = scanner.nextInt();
                            switch (option) {
                                case 1 -> {
                                    accountInput(scanner);
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
                    case 5 -> {
                        do {
                            System.out.println("\nCentral de ações de Transações:\n" +
                                    "1 - Cadastrar Transação\n" +
                                    "2 - Modificar Transação\n" +
                                    "3 - Apagar Transação\n" +
                                    "4 - Mostrar todas as Transações\n" +
                                    "-1 - Sair\n");
                            option = scanner.nextInt();
                            switch (option) {
                                case 1 -> {
                                    transaction(scanner);
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

    private static void brokerInput(Scanner scanner) throws SQLException {
        Corretora corretora = new Corretora();
        CorretoraDAO corretoraDAO = new CorretoraDAO();
        System.out.println("\n### Cadastro de Corretora. ###");

        brokerNameInput(scanner, corretora);
        brokerCNPJInput(scanner, corretora);
        brokerTelNumberInput(scanner, corretora);
        brokerEmailInput(scanner, corretora);
        brokerCriptoActivesInput(scanner, corretora); //still need to make it a list
        brokerAddressInput(scanner, corretora);

        corretoraDAO.registerCorretora(corretora);

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(corretora.getResumoCorretora());
    }

    private static void addressInput(Scanner scanner) throws SQLException {
        Endereco endereco = new Endereco();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
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

        enderecoDAO.registerEndereco(endereco);

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(endereco.getResumoEndereco());
    }

    private static void userInput(Scanner scanner) throws SQLException {
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println("\n### Cadastro de Usuário ###");

        userNameInput(scanner, usuario);
        userEmailInput(scanner, usuario);
        userPasswordInput(scanner, usuario);
        userCPFInput(scanner, usuario);
        userTelNumberInput(scanner, usuario);

        usuarioDAO.registerUsuario(usuario);

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(usuario.getResumoUsuario());
    }

}