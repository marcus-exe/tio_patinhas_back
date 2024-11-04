package com.fiap.br;

import com.fiap.br.dao.*;
import com.fiap.br.exception.EntidadeNaoEcontradaException;
import com.fiap.br.models.account.Conta;
import com.fiap.br.models.register.Corretora;
import com.fiap.br.models.register.Endereco;
import com.fiap.br.models.register.Usuario;
import com.fiap.br.models.transaction.Transacao;
import com.fiap.br.utils.Art;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static com.fiap.br.utils.InputUtils.*;

public class Main {
    public static void main(String[] args) {


        //Init.SQL
        try {
            CheckTablesExistence checkTablesExistence = new CheckTablesExistence();
            for (String tableName : checkTablesExistence.tablesToCheck) {
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
        System.out.println("- Disclaimer: \n" +
                "  - Projeto adaptado a uma lógica de CLI, ou seja, nem todos os elementos estão conforme a documentação\n" +
                "  - Não foi possível implementar os métodos delete, put : por questão de tempo, não de desafio técnico");
        String continuar = "S";
        do {
            // Interaction Loop 1
            int classe = -10;
            do {
                try {
                    System.out.println("\nEscolha uma das classes:\n" +
                            "1 - Usuário\n" +
                            "2 - Endereço\n" +
                            "3 - Corretora\n" +
                            "4 - ContaInvestimento\n" +
                            "5 - Transação\n" +
                            "-1 - Sair\n"
                    );
                    classe = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite um dos números indicados.");
                }
            } while (classe != 1 && classe != 2 && classe != 3 && classe != 4 && classe != 5 && classe != -1);

            if (classe == -1) {
                break;
            }
            // Interaction Loop 2
            int option = -1;
            do {
                try {
                    System.out.println("\nEscolha uma das opções:\n" +
                            "1 - Cadastrar um registro \n" +
                            "2 - Exibir um registro \n" +
                            "3 - Exibir todos os registros \n" +
                            "4 - Atualizar um registro \n" +
                            "5 - Deletar um registro \n");
                    option = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Digite um dos números indicados.");
                }
            } while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5);

            try {
                switch (option) {
                    case 1 -> {

                        try {
                            if (classe == 1) {
                                userInput(scanner);
                            } else if (classe == 2) {
                                addressInput(scanner);
                            } else if (classe == 3) {
                                brokerInput(scanner);
                            } else if (classe == 4) {
                                accountInput(scanner);
                            } else if (classe == 5) {
                                transaction(scanner);
                            } else {
                                System.out.println("A classe foi tratada de forma errada !!!");
                            }
                        } catch (SQLException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    case 2 -> {
                        try {
                            if (classe == 1) {
                                userExibir(scanner);
                            } else if (classe == 2) {
                                addressExibir(scanner);
                            } else if (classe == 3) {
                                brokerExibir(scanner);
                            } else if (classe == 4) {
                                accountExibir(scanner);
                            } else if (classe == 5) {
                                transactionExibir(scanner);
                            } else {
                                System.out.println("A classe foi tratada de forma errada !!!");
                            }
                        } catch (SQLException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            if (classe == 1) {
                                userListar(scanner);

                            } else if (classe == 2) {
                                addressListar(scanner);
                            } else if (classe == 3) {
                                brokerListar(scanner);
                            } else if (classe == 4) {
                                accountListar(scanner);
                            } else if (classe == 5) {
                                transactionListar(scanner);
                            } else {
                                System.out.println("A classe foi tratada de forma errada !!!");
                            }
                        } catch (SQLException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                    case 4 -> {
                        try {
                            if (classe == 1) {
                                userAtualizar(scanner);
                            } else if (classe == 2) {
                                addressAtualizar();
                            } else if (classe == 3) {
                                brokerAtualizar(scanner);
                            } else if (classe == 4) {
                                accountAtualizar(scanner);
                            } else if (classe == 5) {
                                transactionAtualizar(scanner);
                            } else {
                                System.out.println("A classe foi tratada de forma errada !!!");
                            }
                        } catch (SQLException e) {
                            System.err.println(e.getMessage());
                        }

                    }
                    case 5 -> {
                        try {
                            if (classe == 1) {
                                userRemover(scanner);
                            } else if (classe == 2) {
                                addressRemover(scanner);
                            } else if (classe == 3) {
                                brokerRemover(scanner);
                            } else if (classe == 4) {
                                accountRemover(scanner);
                            } else if (classe == 5) {
                                transactionRemover(scanner);
                            } else {
                                System.out.println("A classe foi tratada de forma errada !!!");
                            }
                        } catch (SQLException e) {
                            System.err.println(e.getMessage());
                        }

                    }

                    default -> {
                        System.out.println("Valor Inválido");
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

        System.out.println("\nVocê deseja continuar? S/N");
        continuar = scanner.next();
        } while(Objects.equals(continuar, "S") || Objects.equals(continuar, "s"));

        Art.getGoodbye();
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

    private static void userExibir(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            System.out.println("\n### Exibição de um registro de usuário ###");
            System.out.println("\nDigite o id do usuário: ");
            String id_usuario_pesquisar = scanner.next();

            Usuario usuario = usuarioDAO.getUsuario(id_usuario_pesquisar);
            System.out.println(usuario.getIdUsuario() + " " + usuario.getNomeCompleto() + ".");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Codigo não existe na tabela");
        }
    }

    private static void addressExibir(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            EnderecoDAO enderecoDAO = new EnderecoDAO();

            System.out.println("\n### Exibição de um registro de endereço ###");
            System.out.println("\nDigite o id do endereço: ");
            String id_endereco_pesquisar = scanner.next();

            Endereco endereco = enderecoDAO.getEndereco(id_endereco_pesquisar);
            System.out.println(endereco.getIdEndereco() + " " + endereco.getResumoEndereco() + ".");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Codigo não existe na tabela");
        }
    }

    private static void brokerExibir(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            CorretoraDAO corretoraDAO = new CorretoraDAO();

            System.out.println("\n### Exibição de um registro de corretora ###");
            System.out.println("\nDigite o id da corretora: ");
            String id_corretora_pesquisar = scanner.next();

            Corretora corretora = corretoraDAO.getCorretora(id_corretora_pesquisar);
            System.out.println(corretora.getIdCorretora() + " " + corretora.getNomeCorretora() + ".");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Codigo não existe na tabela");
        }
    }

    private static void accountExibir(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            AccountDAO accountDAO = new AccountDAO();

            System.out.println("\n### Exibição de um registro de conta de investimento ###");
            System.out.println("\nDigite o número da conta de investimento: ");
            String nr_account_pesquisar = scanner.next();

            Conta conta = accountDAO.getAccount(nr_account_pesquisar);
            System.out.println(conta.getNrConta() + " " + conta.getTipoConta() + ".");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Codigo não existe na tabela");
        }
    }

    private static void transactionExibir(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            TransacaoDAO transacaoDAO = new TransacaoDAO();

            System.out.println("\n### Exibição de um registro de transação ###");
            System.out.println("\nDigite id da transação: ");
            String id_transacao_pesquisar = scanner.next();

            Transacao transacao = transacaoDAO.getTransacao(id_transacao_pesquisar);
            System.out.println(transacao.getIdTransacao() + " " + transacao.getContaOrigem() + ".");

        }catch(SQLException e){
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Codigo não existe na tabela");
        }
    }

    private static void userListar(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuarios = usuarioDAO.listar();
            for (Usuario usuario : usuarios) {
                //System.out.println(usuario.getIdUsuario() + " " + usuario.getNomeCompleto() + ".");
                System.out.println(usuario.getResumoUsuario());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addressListar(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            EnderecoDAO enderecoDAO = new EnderecoDAO();
            List<Endereco> enderecos = enderecoDAO.listar();
            for (Endereco endereco : enderecos) {
                System.out.println(endereco.getResumoEndereco());
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void brokerListar(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            CorretoraDAO corretoraDAO = new CorretoraDAO();
            List<Corretora> corretoras = corretoraDAO.listar();
            for (Corretora corretora : corretoras) {
                System.out.println(corretora.getIdCorretora() + " " + corretora.getNomeCorretora() + ".");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void accountListar(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            AccountDAO accountDAO = new AccountDAO();
            List<Conta> contas = accountDAO.listar();
            for (Conta conta : contas) {
                System.out.println(conta.getNrConta() + " " + conta.getTipoConta() + ".");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void transactionListar(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            TransacaoDAO transacaoDAO = new TransacaoDAO();
            List<Transacao> transacoes = transacaoDAO.listar();
            for (Transacao transacao : transacoes) {
                System.out.println(transacao.getIdTransacao() + " " + transacao.getContaOrigem() + ".");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void userAtualizar(Scanner scanner) throws SQLException {
        Scanner scanner2 = null;
        try {
            scanner2 = new Scanner(System.in);

            UsuarioDAO usuarioDao = new UsuarioDAO();

            System.out.println("\n### Atualização de um usuário ###");
            System.out.println("Digite id do usuário: ");


            String id_usuario_pesquisar = scanner2.nextLine();

            Usuario usuario = usuarioDao.getUsuario(id_usuario_pesquisar);

            System.out.println("Digite o novo nome do usuário: ");
            String novo_nome = scanner2.nextLine();
            usuario.setNomeCompleto(novo_nome);


            usuarioDao.updateUsuario(usuario);
            System.out.println("Usuário atualizado!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Usuário não encontrado");
        } finally {
            assert scanner2 != null;
            scanner2.close();
        }
    }

    private static void addressAtualizar() throws SQLException{
        Scanner scanner2 = null;
        try {
            scanner2 = new Scanner(System.in);

            EnderecoDAO enderecoDao = new EnderecoDAO();

            System.out.println("\n### Atualização de um endereço ###");
            System.out.println("\nDigite id do endereço: ");
            String id_endereco_pesquisar = scanner2.nextLine();

            Endereco endereco = enderecoDao.getEndereco(id_endereco_pesquisar);

            System.out.println("Digite o nova rua do endereco: ");
            String nova_rua = scanner2.nextLine();
            endereco.setRua(nova_rua);

            System.out.println("Digite o novo numero: ");
            String novo_numero = scanner2.nextLine();
            endereco.setNumero(Integer.parseInt(novo_numero));

            enderecoDao.updateEndereco(endereco);
            System.out.println("Endereço atualizado!");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Endereço não encontrado");
        } finally {
            assert scanner2 != null;
            scanner2.close();
        }
    }

    private static void brokerAtualizar(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            CorretoraDAO corretoraDao = new CorretoraDAO();

            System.out.println("\n### Atualização de uma corretora ###");
            System.out.println("\nDigite id da corretora: ");
            String id_corretora_pesquisar = scanner.nextLine();

            Corretora corretora = corretoraDao.getCorretora(id_corretora_pesquisar);

            System.out.println("Digite o novo nome da corretora: ");
            String novo_nome_corretora = scanner.nextLine();
            corretora.setNomeCorretora(novo_nome_corretora);

            System.out.println("Digite o novo email da corretora: ");
            String novo_email_corretora = scanner.nextLine();
            corretora.setEmail(novo_email_corretora);

            corretoraDao.updateCorretora(corretora);
            System.out.println("Corretora atualizada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Corretora não encontrada");
        }
    }

    private static void accountAtualizar(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            AccountDAO accountDao = new AccountDAO();

            System.out.println("\n### Atualização de uma conta de investimento ###");
            System.out.println("\nDigite número da conta: ");
            String nr_conta_pesquisar = scanner.nextLine();

            Conta conta = accountDao.getAccount(nr_conta_pesquisar);

            System.out.println("Digite a nova senha da conta: ");
            String novo_senha_conta = scanner.nextLine();
            conta.setSenhaConta(novo_senha_conta);

            System.out.println("Digite o novo saldo da conta: ");
            double novo_saldo_conta = scanner.nextDouble();
            conta.setSaldo(novo_saldo_conta);

            accountDao.updateAccount(conta);
            System.out.println("Conta atualizada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Conta não encontrada");
        }
    }

    private static void transactionAtualizar(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            TransacaoDAO transacaoDao = new TransacaoDAO();

            System.out.println("\n### Atualização de uma transação ###");
            System.out.println("\nDigite o id da transação: ");
            String id_transacao_pesquisar = scanner.nextLine();

            Transacao transacao = transacaoDao.getTransacao(id_transacao_pesquisar);

            System.out.println("Digite o novo endereço de origem da transação: ");
            String novo_origem = scanner.nextLine();
            transacao.setContaOrigem(novo_origem);

            System.out.println("Digite o novo endereço destino da transação: ");
            String novo_destino = scanner.nextLine();
            transacao.setContaDestino(novo_destino);

            transacaoDao.updateTransacao(transacao);
            System.out.println("Transação atualizada!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntidadeNaoEcontradaException e) {
            System.err.println("Transação não encontrada");
        }
    }

    private static void userRemover(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        Scanner scanner2 = null;
        try {
            scanner2 = new Scanner(System.in);
            UsuarioDAO usuarioDao = new UsuarioDAO();

            System.out.println("\n### Remoção de um usuário ###");
            System.out.println("\nDigite o id do usuário: ");
            String id_usuario_pesquisar = scanner2.nextLine();

            usuarioDao.deleteUsuario(id_usuario_pesquisar);
            System.out.println("Usuário Removido!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            assert scanner2 != null;
            scanner2.close();
        }
    }

    private static void addressRemover(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            EnderecoDAO enderecoDao = new EnderecoDAO();

            System.out.println("\n### Remoção de um endereço ###");
            System.out.println("\nDigite o id do endereço: ");
            String id_endereco_pesquisar = scanner.nextLine();

            enderecoDao.deleteEndereco(id_endereco_pesquisar);
            System.out.println("Endereço Removido!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void brokerRemover(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            CorretoraDAO corretoraDao = new CorretoraDAO();

            System.out.println("\n### Remoção de uma corretora ###");
            System.out.println("\nDigite o id da corretora: ");
            String id_corretora_pesquisar = scanner.nextLine();

            corretoraDao.deleteCorretora(id_corretora_pesquisar);
            System.out.println("Corretora Removida!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void accountRemover(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            AccountDAO accountDao = new AccountDAO();

            System.out.println("\n### Remoção de uma conta de investimento ###");
            System.out.println("\nDigite o número da conta: ");
            String nr_conta_pesquisar = scanner.nextLine();

            accountDao.deleteAccount(nr_conta_pesquisar);
            System.out.println("Conta Removida!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void transactionRemover(Scanner scanner) throws SQLException, EntidadeNaoEcontradaException {
        try {
            TransacaoDAO transacaoDao = new TransacaoDAO();

            System.out.println("\n### Remoção de uma transação ###");
            System.out.println("\nDigite o id da transação: ");
            String id_transacao_pesquisar = scanner.nextLine();

            transacaoDao.deleteTransacao(id_transacao_pesquisar);
            System.out.println("Transação Removida!");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}