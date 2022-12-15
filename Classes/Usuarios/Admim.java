package Classes.Usuarios;

import java.util.Scanner;

import Arquivos.Arquivos;
import Classes.Produtos.Fone;
import Classes.Produtos.Mouse;
import Classes.Produtos.Produto;
import Classes.Produtos.Teclado;
import Estruturas.Lista;
import Estruturas.No;

// Subclasse de usuario e implementa a interfacce AdminSys
public class Admim extends Usuario implements AdminSys{
    // 1 = Mouse 
    // 2 = Teclado
    // 3 = Fone

    // Key do produto a ser mexido
    // Por default Mouse
    private static int keyProduct = 1; 
    public static int numberProd = 0;

    // Atributo da classe Admim
    private boolean isAdmin = false;

    // Cria um Admim a partir de um Usuario Fantasma
    public Admim(){
        super();
        isAdmin = true;
    }

    // Get isAdmin
    public boolean getIsAdmin(){
        return this.isAdmin;
    }

    // troca a key
    private static void changeKey(int key){
        Admim.keyProduct = key;
    }
    
    // Pega a key atual
    public int getkey(){
        return Admim.keyProduct;
    }
    
    // Sobreecrevento os metdos da interface
    @Override
    public Lista<Produto> newProduct(int key){
        
        String file = "Produtos.txt";
        Admim.changeKey(key);
        
        // Cria um produto no sistema e salva no arquivo
        No<Produto> x = criarProduto(key);
        Arquivos.Write(x, file);
        numberProd += 1;
        
        Lista<Produto> lista = new Lista<>();
        lista.inserirFinal(x);

        return lista;
    }

    // ERROR!
    @Override
    public Lista<Produto> addQntProduct(Lista<Produto> lista, int codigo, int quantidade) {
        lista = procuraProduto(lista, codigo, quantidade);
        return lista;
    }

    @Override
    public Lista<Produto> removeProduct(Lista<Produto> lista, No<Produto> x3) {
       lista = remover(lista, x3.getInfo().getCodigo());
       return lista;
    }

    // Remove um nó específico
    public static Lista<Produto> remover(Lista<Produto> lista, int info){
        // Se a lista não estiver vazia
        if(!lista.isEmpty()){
            No<Produto> node = new No<>();
            node = lista.getInicio();


            // Procura o nó
            while(node != null && node.getInfo().getCodigo() != info){
                node = node.getProximo();
            }

            // Não encontrou o nó
            if(node == null){
                System.out.println("Nó não encontrado!");
                System.exit(0);
            }
                
            // Remove o nó
            if(node.getAnterior() != null)
                node.getAnterior().setProximo(node.getProximo());
            
            if(node.getProximo() != null)
                node.getProximo().setAnterior(node.getAnterior());

        }   
        // Lista está vazia
        else{
            System.out.println("Estrutura Vazia, impossível remover!!");
            System.exit(0);
            
        }

        return lista;
    }

    // Procura e Adiciona uma quantidade no estoque e retorna a lista modificada
    public static Lista<Produto> procuraProduto(Lista<Produto> lista, int info, int quantidade){
        No<Produto> node = lista.getInicio();

        while(node != null){
            // Quando acha o nó procurado
            if(node.getInfo().getCodigo() == info){
                // Remove o nó da lista
                lista = remover(lista, node.getInfo().getCodigo());
                // Altera a quantidade
                node.getInfo().addQntEstoque(quantidade);
                break;
            }
            // Se não achar passa para o proximo
            else
                node = node.getProximo();
        }
        
        // Se o nó não existir
        if(node == null){
            System.out.println("Produto não encontrado!");
            System.exit(0);
        }
        
        // Insere o nó alterado no inicio da lista
        lista.inserirInicio(node);
        return lista; 
    }

    // Cria um produto
    private No<Produto> criarProduto(int key){
        Scanner scanner = new Scanner(System.in);
        Produto aux = null;
        switch (key) {
            // Cria um Mouse
            case 1:
                aux = insereDados(new Mouse(), scanner);
                
                System.out.println("Categoria: ");
                ((Mouse) aux).setCategoria(scanner.next());
                System.out.println("Marca: ");
                ((Mouse) aux).setMarca(scanner.next());
                System.out.println("Código do Produto: ");
                ((Mouse) aux).setCodigo(scanner.nextInt());
                System.out.println("DPI: ");
                ((Mouse) aux).setDpi(scanner.next());

                break;
            
            // Cria um Teclado
            case 2:
                aux = insereDados(new Teclado(), scanner);
                
                System.out.println("Categoria: ");
                ((Teclado) aux).setCategoria(scanner.next());
                System.out.println("Marca: ");
                ((Teclado) aux).setMarca(scanner.next());
                System.out.println("Código do Produto: ");
                ((Teclado) aux).setCodigo(scanner.nextInt());
                System.out.println("Mecânico: ");
                ((Teclado) aux).setIsMecanico(scanner.nextBoolean());

                break;

            // Cria um Fone
            case 3:
                aux = insereDados(new Fone(), scanner);

                System.out.println("Categoria: ");
                ((Fone) aux).setCategoria(scanner.next());
                System.out.println("Marca: ");
                ((Fone) aux).setMarca(scanner.next());
                System.out.println("Código do Produto: ");
                ((Fone) aux).setCodigo(scanner.nextInt());

                break;

            default:
                System.out.println("Invalid Key!");
                break;
        
        }

        No<Produto> x = new No<Produto>(aux);
        return x;
    }

    private Produto insereDados(Produto aux, Scanner scanner){
        System.out.println(aux.getClass());
        System.out.println("Produto: ");
        aux.setNome(scanner.nextLine());
        System.out.println("Preço: ");
        aux.setPreco(scanner.nextDouble());
        System.out.println("Quantidade em Estoque: ");
        aux.setQntEstoque(scanner.nextInt());

        return aux;
    }

}
