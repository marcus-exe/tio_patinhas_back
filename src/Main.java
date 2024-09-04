import java.util.*;

import Ativos.Ativo;
import Cadastro.Corretora;
import Cadastro.Endereco;
import Cadastro.Usuario;
import Contas.ContaInvestimento;
import Procedimentos.Transacao;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        Usuario usuario = new Usuario();
        Corretora corretora = new Corretora();
        Ativo ativo = new Ativo();
        ContaInvestimento contaInvestimento = new ContaInvestimento();
        Transacao transacao = new Transacao();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--------- Bem-vindo ao Banco de Investimentos de Bitcoins!!! ----------");

        /*--------------USUARIO-------------------------*/

        System.out.println("\nAntes de começar a investir, realize o seu cadastro" +
                " preenchendo as informações a seguir:");

        String id_usuario = "";
        do {
            System.out.println("Qual o seu Id?");
            id_usuario = scanner.nextLine();
            usuario.setIdUsuario(id_usuario);
        }while(id_usuario == "");

        String nome_completo_usuario = "";
        do {
            System.out.println("Qual o seu nome completo?");
            nome_completo_usuario = scanner.nextLine();
            usuario.setNomeCompleto(nome_completo_usuario);
        }while(nome_completo_usuario == "");

        String email_usuario = "";
        do {
            System.out.println("Qual o seu email?");
            email_usuario = scanner.nextLine();
            usuario.setEmail(email_usuario);
        }while(email_usuario == "");

        String senha_usuario = "";
        do {
            System.out.println("Qual a sua senha?");
            senha_usuario = scanner.nextLine();
            usuario.setSenha(senha_usuario);
        }while(senha_usuario == "");

        String cpf_cnpj_usuario = "";
        do {
            System.out.println("Qual o seu CPF ou CNPJ?");
            cpf_cnpj_usuario = scanner.nextLine();
            usuario.setCpfCnpj(cpf_cnpj_usuario);
        }while(cpf_cnpj_usuario == "");

        String telefone_usuario = "";
        do {
            System.out.println("Qual o seu número de telefone?");
            telefone_usuario = scanner.nextLine();
            usuario.setTelefone(telefone_usuario);
        }while(telefone_usuario == "");

        String data_de_criacao_usuario = "";
        do {
            System.out.println("Que dia é hoje?");
            data_de_criacao_usuario = scanner.nextLine();
            usuario.setDataCriacao(data_de_criacao_usuario);
        }while(data_de_criacao_usuario == "");

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(usuario.getResumoUsuario());


        /*--------------ENDEREÇO-------------------------*/


        System.out.println("\n Ótimo! Vamos ver agora sobre o seu endereço.");

        String id_endereco = "";
        do {
            System.out.println("Qual o Id do seu endereço?");
            id_endereco = scanner.nextLine();
            endereco.setIdEndereco(id_endereco);
        }while(id_endereco == "");

        String rua = "";
        do {
            System.out.println("Em qual rua você mora?");
            rua = scanner.nextLine();
            endereco.setRua(rua);
        }while(rua == "");

        int numero = -1;
        do {
            try {
                System.out.println("Qual o número do seu endereço?");
                numero = scanner.nextInt();
                scanner.nextLine();
                endereco.setNumero(numero);
            }catch (Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(numero < 0);

        String complemento = "";
        do {
            System.out.println("Qual o complemento do seu endereço?");
            complemento = scanner.nextLine();
            endereco.setComplemento(complemento);
        }while(complemento == "");

        String bairro = "";
        do {
            System.out.println("Qual o bairro do seu endereço?");
            bairro = scanner.nextLine();
            endereco.setBairro(bairro);
        }while(bairro == "");

        String cidade = "";
        do {
            System.out.println("Qual a cidade do seu endereço?");
            cidade = scanner.nextLine();
            endereco.setCidade(cidade);
        }while(cidade == "");

        String cd_estado = "";
        do {
            System.out.println("Qual o cd do estado do seu endereço?");
            cd_estado = scanner.nextLine();
            endereco.setCdEstado(cd_estado);
        }while(cd_estado == "");

        String cep = "";
        do {
            System.out.println("Qual o CEP do seu endereço?");
            cep = scanner.nextLine();
            endereco.setCep(cep);
        }while(cep == "");

        String pais = "";
        do {
            System.out.println("Qual o país que você reside?");
            pais = scanner.nextLine();
            endereco.setPais(pais);
        }while(pais == "");

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(endereco.getResumoEndereco());


        /*--------------CORRETORA-------------------------*/


        System.out.println("Para finalizar o cadastro, preencha as" +
                " informações a seguir sobre a sua corretora: ");

        String id_corretora = "";
        do {
            System.out.println("Qual o id da sua corretora?");
            id_corretora = scanner.nextLine();
            corretora.setIdCorretora(id_corretora);
        }while(id_corretora == "");

        String nome_corretora = "";
        do {
            System.out.println("Qual o nome da sua corretora?");
            nome_corretora = scanner.nextLine();
            corretora.setNomeCorretora(nome_corretora);
        }while(nome_corretora == "");

        String cnpj_corretora = "";
        do {
            System.out.println("Qual o CNPJ da sua corretora?");
            cnpj_corretora = scanner.nextLine();
            corretora.setCnpj(cnpj_corretora);
        }while(cnpj_corretora == "");

        String telefone_corretora = "";
        do {
            System.out.println("Qual o telefone da sua corretora?");
            telefone_corretora = scanner.nextLine();
            corretora.setTelefone(telefone_corretora);
        }while(telefone_corretora == "");

        String email_corretora = "";
        do {
            System.out.println("Qual o email da sua corretora?");
            email_corretora = scanner.nextLine();
            corretora.setEmail(email_corretora);
        }while(email_corretora == "");

        String tipos_corretora = "";
        do {
            System.out.println("Qual são os tipos de criptoativos suportados pela sua corretora?");
            tipos_corretora = scanner.nextLine();
            corretora.setTiposCriptoativosSuportados(tipos_corretora);
        }while(id_corretora == "");

        String endereco_carteira_corretora = "";
        do {
            System.out.println("Qual o endereço de carteira da sua corretora?");
            endereco_carteira_corretora = scanner.nextLine();
            corretora.setEnderecoCarteiraCorretora(endereco_carteira_corretora);
        }while(endereco_carteira_corretora == "");

        System.out.println("\nDados cadastrados!!!!");
        System.out.println(corretora.getResumoCorretora());


        /*--------------CONTA INVESTIMENTO-------------------------*/


        System.out.println("\nObrigado por realizar o cadastro. Agora, preencha" +
                " as informações sobre a sua conta de investimento: ");

        String nr_conta = "";
        do{
            System.out.println("Digite o número da sua conta: ");
            nr_conta = scanner.nextLine();
            contaInvestimento.setNrConta(nr_conta);
        }while(nr_conta == "");

        double saldo = 0;
        do{
            try {
                System.out.println("Digite o valor do seu saldo: ");
                saldo = scanner.nextDouble();
                scanner.nextLine();
                contaInvestimento.setSaldo(saldo);
            }catch(Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(saldo < 0);

        String senha_conta = "";
        do{
            System.out.println("Digite a senha da sua conta: ");
            senha_conta = scanner.nextLine();
            contaInvestimento.setSenhaConta(senha_conta);
        }while(senha_conta == "");

        String tipo_conta = "";
        do{
            System.out.println("Digite o tipo da sua conta: ");
            tipo_conta = scanner.nextLine();
            contaInvestimento.setTipoConta(tipo_conta);
        }while(tipo_conta == "");

        String tipo_moeda = "";
        do{
            System.out.println("Digite o tipo de moeda da sua conta: ");
            tipo_moeda = scanner.nextLine();
            contaInvestimento.setTipoMoeda(tipo_moeda);
        }while(tipo_moeda == "");

        String data_abertura = "";
        do{
            System.out.println("Digite a data de abertura da sua conta: ");
            data_abertura = scanner.nextLine();
            contaInvestimento.setDataAbertura(data_abertura);
        }while(data_abertura == "");

        String status_conta = "";
        do{
            System.out.println("Digite o status da sua conta: ");
            status_conta = scanner.nextLine();
            contaInvestimento.setStatusConta(status_conta);
        }while(status_conta == "");

        String endereco_carteira = "";
        do{
            System.out.println("Digite o endereço da carteira da sua conta: ");
            endereco_carteira = scanner.nextLine();
            contaInvestimento.setEnderecoCarteira(endereco_carteira);
        }while(endereco_carteira == "");

        System.out.println("\nDados Cadastrados!!!!");
        System.out.println(contaInvestimento.getResumoConta());


        /*--------------ATIVOS-------------------------*/


        System.out.println("\nAgora, preencha os dados referentes ao ativo.");

        String id_registro = "";
        do {
            System.out.println("Qual o id do registro do ativo?");
            id_registro = scanner.nextLine();
            ativo.setIdRegistro(id_registro);
        }while(id_registro == "");

        String data_hora = "";
        do {
            System.out.println("Qual a data e hora?");
            data_hora = scanner.nextLine();
            ativo.setDataHora(data_hora);
        }while(data_hora == "");

        double preco_abertura = 0;
        do {
            try {
                System.out.println("Qual o preço de abertura do ativo?");
                preco_abertura = scanner.nextDouble();
                scanner.nextLine();
                ativo.setPrecoAbertura(preco_abertura);
            }catch (Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(preco_abertura < 0);

        double preco_fechamento = 0;
        do {
            try {
                System.out.println("Qual o preço de fechamento do ativo?");
                preco_fechamento = scanner.nextDouble();
                scanner.nextLine();
                ativo.setPrecoFechamento(preco_fechamento);
            }catch(Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(preco_fechamento < 0);

        double preco_max = 0;
        do {
            try {
                System.out.println("Qual o preço máximo do ativo?");
                preco_max = scanner.nextDouble();
                scanner.nextLine();
                ativo.setPrecoMax(preco_max);
            }catch(Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(preco_max < 0);

        double preco_min = 0;
        do {
            try {
                System.out.println("Qual o preço mínimo do ativo?");
                preco_min = scanner.nextDouble();
                scanner.nextLine();
                ativo.setPrecoMin(preco_min);
            }catch(Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(preco_min < 0);

        double volume_negociacao = 0;
        do {
            try {
                System.out.println("Qual o volume de negociação do ativo?");
                volume_negociacao = scanner.nextDouble();
                scanner.nextLine();
                ativo.setVolumeNegociacao(volume_negociacao);
            }catch(Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(volume_negociacao < 0);

        String id_ativo = "";
        do {
            System.out.println("Qual o id do ativo?");
            id_ativo = scanner.nextLine();
            ativo.setIdAtivo(id_ativo);
        }while(id_ativo == "");

        String nome_ativo = "";
        do {
            System.out.println("Qual o nome do ativo?");
            nome_ativo = scanner.nextLine();
            ativo.setNome(nome_ativo);
        }while(nome_ativo == "");

        double preco_atual = 0;
        do {
            try {
                System.out.println("Qual o preço atual do ativo?");
                preco_atual = scanner.nextDouble();
                scanner.nextLine();
                ativo.setPrecoAtual(preco_atual);
            }catch(Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(preco_atual < 0);

        String simbolo = "";
        do {
            System.out.println("Qual o símbolo do ativo?");
            simbolo = scanner.nextLine();
            ativo.setSimbolo(simbolo);
        }while(simbolo == "");

        System.out.println("\nDados Cadastrados!!!!");
        System.out.println(ativo.getResumoAtivo());


        /*--------------Transação-------------------------*/


        System.out.println("Para realizar uma transação, preeencha as informações a seguir.");

        String id_transacao = "";
        do {
            System.out.println("Qual o id da transação?");
            id_transacao = scanner.nextLine();
            transacao.setIdTransacao(id_transacao);
        }while(id_transacao == "");

        String tipo_transacao = "";
        do {
            System.out.println("Qual o tipo transacao da transação?");
            tipo_transacao = scanner.nextLine();
            transacao.setTipoTransacao(tipo_transacao);
        }while(tipo_transacao == "");

        double montante = 0;
        do {
            try {
                System.out.println("Qual o montante da transação?");
                montante = scanner.nextDouble();
                scanner.nextLine();
                transacao.setMontante(montante);
            }catch(Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(montante < 0);

        String hora_transacao = "";
        do {
            System.out.println("Qual a hora da transação?");
            hora_transacao = scanner.nextLine();
            transacao.setHora(hora_transacao);
        }while(hora_transacao == "");

        String data_transacao = "";
        do {
            System.out.println("Qual a data da transação?");
            data_transacao = scanner.nextLine();
            transacao.setData(data_transacao);
        }while(data_transacao == "");

        boolean permissao_transacao = true;
        do {
            try {
                System.out.println("A transação foi permitida? (true / false)");
                permissao_transacao = scanner.nextBoolean();
                transacao.setPermissao(permissao_transacao);
            }catch (Exception e) {
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(permissao_transacao != true);

        String descricao_transacao = "";
        do {
            System.out.println("Qual a descrição da transação?");
            descricao_transacao = scanner.nextLine();
            transacao.setDescricao(descricao_transacao);
        }while(descricao_transacao == "");

        String endereco_origem = "";
        do {
            System.out.println("Qual o endereco de origem da transação?");
            endereco_origem = scanner.nextLine();
            transacao.setContaOrigem(endereco_origem);
        }while(endereco_origem == "");

        String endereco_destino = "";
        do {
            System.out.println("Qual o endereco de destino da transação?");
            endereco_destino = scanner.nextLine();
            transacao.setContaDestino(endereco_destino);
        }while(endereco_destino == "");

        String hash_transacao = "";
        do {
            System.out.println("Qual hash da transação?");
            hash_transacao = scanner.nextLine();
            transacao.setHashTransacao(hash_transacao);
        }while(hash_transacao == "");

        double taxa = 0;
        do {
            try {
                System.out.println("Qual a taxa da transação?");
                taxa = scanner.nextDouble();
                scanner.nextLine();
                transacao.setTaxaTransacao(taxa);
            }catch (Exception e){
                System.out.println("Digite um valor válido :)");
                scanner.nextLine();
            }
        }while(taxa < 0);

        System.out.println("\nDados Cadastrados!!!!");
        System.out.println(transacao.getResumoTransacao());

        System.out.println("Obrigado por usar a nossa ferramenta!!!!");
        System.out.println("Finalizando Sistema....");

    }
}