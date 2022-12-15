package Classes.Produtos;

import java.io.Serializable;

import Estruturas.Lista;
import Estruturas.No;

// Classe Pai
public abstract class Produto implements Serializable {
    
    // Atributos da classe
    protected String nome;
    protected double preco;
    protected int qntEstoque;
    protected int codigo;

    // Construtor 
    public Produto(String nome, double preco, int qntEstoque, int codigo){
        this.nome = nome;
        this.preco = preco;
        this.qntEstoque = qntEstoque;
        this.codigo = codigo;
    }

    // Getters
    public String getNome(){
        return nome;
    }
    
    public double getPreco(){
        return preco;
    }

    public int getQntEstoque(){
        return qntEstoque;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPreco(double preco) {
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

    // Procura o Produto em uma lista
    public static Produto searchProd(Lista<Produto> lista, int codigo){
        No<Produto> node = lista.getInicio();
        Produto x = null;

        // Loop Forçado
        while(node != null){

            if(node.getInfo().getCodigo() == codigo)
                x = node.getInfo();
            else
                node = node.getProximo();

        }

        if(node == null){
            System.out.println("Produto não encontrado!");
            System.exit(0);
        }

        return x;
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
        String str = getNome() + ";\n"; 
        str += getPreco() + ";\n" + getQntEstoque() + ";\n";
        str += getCodigo() + ";\n";

        return str;
    }

    
}
