package Classes.Produtos;

import Estruturas.Lista;
import Estruturas.No;

// Classe Pai
public abstract class Produto {
    
    // Atributos da classe
    protected String nome;
    protected String preco;
    protected int qntEstoque;
    protected int codigo;

    // Construtor 
    public Produto(String nome, String preco, int qntEstoque, int codigo){
        this.nome = nome;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.codigo = codigo;
    }

    // Getters
    public String getNome(){
        return nome;
    }
    
    public String getPreco(){
        return preco;
    }

    public int getQntEstoque(){
        return qntEstoque;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPreco(String preco) {
        this.preco = preco;
    }
    
    public void setQntEstoque(int qntEstoque) {
        this.qntEstoque = qntEstoque;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Procura e Adiciona uma quantidade no estoque e retorna a lista modificada
    public static Lista<Produto> procuraProduto(Lista<Produto> lista, int info, int quantidade){
        No<Produto> node = lista.getInicio();
        No<Produto> aux = null;

        while(node != null){
            // Quando acha o nó procurado
            if(node.getInfo().getCodigo() == info){
                // Remove o nó da lista
                aux = lista.remover(node.getInfo().getCodigo());
                // Altera a quantidade
                aux.getInfo().addQntEstoque(quantidade);
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
        lista.inserirInicio(aux);
        return lista; 
    }


    // Adiciona quantidade no estoque
    public void addQntEstoque(int quantidade){
        System.out.println("FOI ADICIONADO " + quantidade + " PRODUTOS NO ESTOQUE!");
        qntEstoque += quantidade;
    }

    // Remove quantidade no estoque, 
    // operação só será feita a partir da compra de um produto
    public void remQntEstoque(int quantidade){
        qntEstoque -= quantidade;
    }

    // Verifica se a quantidade desejada está disponivel no estoque 
    public boolean verEstoque(int quantidade){
        if(getQntEstoque() < quantidade)
            return true;
        
        return false;
    }

    @Override
    public String toString() {
        String str = "Produto: " + getNome() + ";\n";
        str += "Preço: " + getPreco() + ";  " + "Quantidade em Estoque: " + getQntEstoque() + ";\n";
        str += "Código do Produto: " + getCodigo() + ";\n";

        return str;
    }

    
}
