package Classes.Features;

import java.io.IOException;
import java.util.Scanner;

import Classes.Produtos.Produto;
import Classes.Usuarios.Usuario;
import Estruturas.Arvore;
import Estruturas.Lista;

// Menu Principal
public class Menu {

    // Primeira Tela
    private static Usuario loginScreen(Arvore<Usuario> tree, Scanner scnr) throws IOException, InterruptedException{
        Usuario x = new Usuario(null, null, null, null, null);
        int opção;

        System.out.println("Seja Bem-Vindo a Loja!!");
        System.out.println("[1] Para Se Cadastrar");
        System.out.println("[2] Para Fazer o Login (broke - nullpointer)");
        System.out.println("[0] Para Sair da Loja");
        System.out.print("Digite sua opção: ");
        opção = scnr.nextInt();

        x = loginSwitch(opção, tree, scnr);
        return x;
    }
    
    // Tela Principal
    public static void mainScreen(Arvore<Usuario> tree, Lista<Produto> lista, Scanner scnr){
        try{
            Usuario x = loginScreen(tree, scnr);
            int aux;

            clrScreen();
            System.out.println("Bem Vindo " + x.getNome() + "!!");  
            if(x.getCode() == 0)
                aux = admimScreen(scnr);
            else
                aux = clientScreen(scnr);
                Menu.clientSwitch(aux, scnr, lista, x);

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    // Tela que aparece somente para Clientes
    private static int clientScreen(Scanner scnr){
        System.out.println("[1] Para Comprar Um Produto");
        System.out.println("[2] Para Listar Os Produtos Dispooníveis");
        System.out.println("[3] Para Vizualizar Histórico de Compras");
        System.out.println("[4] Para Verificar Lista de Espera");
        System.out.println("[0] Para Sair da Loja");
        System.out.print("Digite sua opção: ");
        int option = scnr.nextInt();
        
        return option;
    }   

    // BETA TEST
    // Tela que aparece somente para Admims
    private static int admimScreen(Scanner scnr){
        System.out.println("[1] Para Adicionar Um Novo Produto");
        System.out.println("[2] Para Remover Um Produto");
        System.out.println("[3] Para Adicionar Quantidade No Estoque");
        System.out.println("[4] Para Listar Os Produtos");
        System.out.println("[5] Para Listar Os Usuarios");
        System.out.println("[0] Para Sair da Loja");
        System.out.print("Digite sua opção: ");
        int option = scnr.nextInt();
        
        return option;
        
    }

    // Comando para Limpar a Tela
    public static void clrScreen() throws IOException, InterruptedException{
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    }

    // Limpa o buffer
    public static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    private static Usuario loginSwitch(int opção, Arvore<Usuario> tree, Scanner scnr) throws IOException, InterruptedException{
        Usuario aux = new Usuario(null, null, null, null, null);        
        switch (opção) {
            case 0: // Encerra o programa
                System.out.println("Volte Sempre!");
                System.exit(0);
                break;
            
            case 1: // Cadastra o Usuário
                clrScreen();
                aux = Cadastro.newUsuario(scnr);
                tree.inserir(aux);
                break;

            case 2: // Verifica se o usuario já é cadastrado
                clrScreen();
                System.out.print("Digite o Nome: ");
                scnr.nextLine();
                String nome = scnr.nextLine();
                System.out.print("Digite o CPF: ");
                String Cpf = scnr.nextLine();

                aux = Usuario.usuarioLogin(nome, Cpf, tree);
                break;
        
            default:
                System.out.println("Opção Inválida!");
                System.exit(-1);
                break;
        }

        return aux;
    }

    private static String clientSwitch(int option, Scanner scnr, Lista<Produto> lista, Usuario usu){
        String aux = null;
        switch (option) {
            case 0: // Encerra o programa
                System.out.println("Volte Sempre!");
                System.exit(0);
                break;
            
            case 1: // Compra um produto a partir do codigo
                System.out.println("Digite o Codigo do Produto a Ser Comprado: ");
                int code = scnr.nextInt();
                Produto x = Produto.searchProd(lista, code);
                System.out.println("Digite a Quantidade a Ser Comprada: ");
                code = scnr.nextInt();

                aux = usu.compraProduto(x, code);
                break;
            
            case 2: // lista todos os produtos disponiveis
                System.out.println("Lista De Produtos: \n");
                String txt = lista.imprimeLista();
                System.out.println(txt);
                break;
            
            case 3: // Mostra o Historico de compras do usuario
                System.out.println("Historico: \n");
                Historico hist = usu.getHist();
                String ax = hist.imprimeHist();
                
                System.out.println(ax);
                break;
            
            case 4: // Mostra a posição na lista de espera
                System.out.println("Posição na Lista de Espera: ");
                System.out.println(FilaEspera.getTam());
            
                break;
            
            default:
                System.out.println("Opção Inválida!");
                System.exit(-1);
                break;
        }


        return aux;
    }


}
