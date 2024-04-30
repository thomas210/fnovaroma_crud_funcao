package projeto_java;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CRUD_funcao {

    // criar o "banco de dados"
    // cada arrayList representa uma coluna do banco de dados
    static ArrayList<String> cpfs = new ArrayList<String>();
    static ArrayList<String> nomes = new ArrayList<String>();
    static ArrayList<Integer> medias = new ArrayList<Integer>();

    /**
     * Codigos Retorno da Funcao
     * Numero positivo: indice do aluno
     * -1: Deu certo
     * -2: Aluno nao encontrado
     * -3: Aluno ja existe
     * @return
     */

    
     /**
      * tesafkldsjfsdlfjsdlf
      * @param nome
      * @param cpf
      * @param media
      * @return 
      */
    public static int create(String nome, String cpf, int media){

        // buscar se o aluno ja existe no banco
        int aluno_existe = read(cpf);

        if (aluno_existe != -2){
            return -3;
        }

        cpfs.add(cpf);
        nomes.add(nome);
        medias.add(media);        

        return -1;
    }

    public static int read(String cpf){

        // buscando aluno no banco | arraylist de cpf
        for(int indice = 0; indice < cpfs.size(); indice++){
            String cpf_busca = cpfs.get(indice);
            if (cpf_busca.equals(cpf)){
                return indice;
            }
        }

        return -2;
    }

    public static int update (String nome, String cpf){

        // buscar se o aluno ja existe no banco
        int indice_aluno = read(cpf);

        if (indice_aluno == -2){
            return -2;
        }

        nomes.set(indice_aluno, nome);

        return -1;
    }

    public static int delete (String cpf){

        // buscar se o aluno ja existe no banco
        int indice_aluno = read(cpf);

        if (indice_aluno == -2){
            return -2;
        }

        cpfs.remove(indice_aluno);
        nomes.remove(indice_aluno);
        medias.remove(indice_aluno);

        return -1;

    }

    public static void main(String[] args) {

        // variaveis que serao usadas no codigo
        String nome = "";
        String cpf = "";
        int media = 0;
        int opcao;
        int indice;
        int resultado;

        // iniciando o scanner
        Scanner scan = new Scanner(System.in);

        // gerando seed
        // dados ficticios para testes
        for (int seed = 0; seed < 10; seed++){

            // Gera um número entre 100 e 999
            int numeroAleatorio = new Random().nextInt(900) + 100;

            // Convertendo o número em uma string
            String cpfFicticio = Integer.toString(numeroAleatorio);

            // add no banco de dados
            cpfs.add(cpfFicticio);

            // add nome ficticio no banco
            nomes.add("Aluno"+seed);

            // gerando media aleatoria entre 0 e 10
            int mediaFIcticia = new Random().nextInt(10);

            // add no banco
            medias.add(mediaFIcticia);

        }


        // laco infinito, para o programar sempre rodar
        // para parar basta usar um break (opcao 9
        while (true) {

            // apresentacao do menu
            System.out.println("|---- Faculdade Nova Roma ----|");

            System.out.println("Escolha a opcao desejada:");
            System.out.println("1 - Criar Aluno");
            System.out.println("2 - Buscar Aluno");
            System.out.println("3 - Atualizar Aluno");
            System.out.println("4 - Remover Aluno");
            System.out.println("5 - Listar Tudo");
            System.out.println("9 - Sair");

            // recebendo a opcao
            opcao = scan.nextInt();

            /**
             * operacao Create
             * criar usuario
             * Para criar um usuário
             * é necessário que o cpf não esteja cadastrado
             */
            if (opcao == 1){
                System.out.println("Create");

                // pegando as informacoes do aluno
                System.out.println("Digite o nome do aluno");
                nome = scan.next();
                System.out.println("Digite o cpf do aluno");
                cpf = scan.next();
                System.out.println("Digite a media do aluno");
                media = scan.nextInt();

                resultado = create(nome, cpf, media);

                System.out.println(resultado);
                
                // caso encontre, nao pode cadastrar o cpf duas vezes
                if (resultado == -3){
                    System.out.println("N posso criar pois o cpf ja esta cadastrado");
                }else if (resultado == -1){

                    System.out.println("Aluno cadastrado com sucesso");
                } else {
                    System.out.println("Aconteceu algo que n esperada");
                }

            
                
            }else if (opcao == 2){
            /**
             * operacao Read
             * buscar aluno e mostrar informações
             * busca e feita pelo cpf
             * caso nao encontre, informar que o aluno n esta cadastrado
             */
                System.out.println("Read");

                // cpf do aluno que quero buscar
                System.out.println("Digite o cpf do aluno");
                cpf = scan.next();

                indice = read(cpf);

                System.out.println(indice);
                
                if (indice != -2){
                    // caso encontre o aluno, mostrar informacoes
                    System.out.println(cpfs.get(indice));
                    System.out.println(nomes.get(indice));
                    System.out.println(medias.get(indice));
                }else {
                    // caso n encontre, informar ao usuario
                    System.out.println("Aluno n encontrado");
                }
                

            
            }else if (opcao == 3){
            /**
             * operacao Update
             * atualizar as informacoes do aluno
             * para atualizar, e necessario que o aluno já esteja no banco
             * caso nao esteja, informar ao usuário
             */
                System.out.println("Update");

                // pegar o cpf para busca
                System.out.println("Digite o cpf do aluno");
                cpf = scan.next();

                // pegando o novo nome
                System.out.println("Digite o novo nome do aluno");

                nome = scan.next();

                resultado = update(nome, cpf);
                
                // caso encontre, mostrar na tela as informacoes
                if (resultado == -1){
                    System.out.println("ALuno atualizado com sucesso");


                }else if (resultado == -2){
                    // caso n encontre, informar ao usuario
                    System.out.println("Aluno n encontrado, nao e possivel atualizar");
                } else {
                    System.out.println("Deu alguma coisa ai, pede ajuda");
                }

            
            }else if (opcao == 4){
            /**
             * operacao delete
             * deletar usuario do sistema
             * para deletar, e necessario que o usuario ja esteja cadastrado
             * caso nao, informar na tela
             */
                System.out.println("Delete");

                // pegar o cpf do aluno que deseja deletar
                System.out.println("Digite o cpf do aluno");
                cpf = scan.next();

                resultado = delete(cpf);

               if (resultado == -1){
                System.out.println("Aluno removido com sucesso");
               } else if (resultado == -2){
                System.out.println("Aluno n encontrado");
               } else {
                System.out.println("Deu merda ai viss");
               }

            
            }else if(opcao == 5){
            /**
             * Mostrar todos os alunos cadastrados
             */
                System.out.println(cpfs);
                System.out.println(nomes);
                System.out.println(medias);
            }else if(opcao == 9){
            /**
             * Sair do sistema
             */
                System.out.println("Saindo...");
                break;
            }else {
            /**
             * caso informe um numero errado, só volta ao menu
             */
                System.out.println("Opcao invalida");
            }

            
        }
        
        

    }

    
}
