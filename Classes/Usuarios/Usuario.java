package Classes.Usuarios;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import Classes.Features.FilaEnvio;
import Classes.Features.FilaEspera;
import Classes.Features.Historico;
import Classes.Produtos.Produto;
import Estruturas.Arvore;
import Estruturas.No;

public class Usuario implements Serializable, Comparable<Usuario>{
    //Atributos da classe
    private String nome;
    private String cpf;
    private String endereco;
    private String cep;
    private String email;

    // Historico de compras
    private Historico hist;
    
    // Comprovante da compra mais atual
    private String comprovante = "";

    // Codigo de identificação do usuário
    private static int seed = 2022;
    private Random count = new Random(seed);
    private int code = 0;
    
    //Construtor
    //Cadastro de Usuário
    public Usuario(String nome, String cpf, String endereco, String cep, String email) {
        hist = new Historico();
        
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
        this.code = count.nextInt(1000);
        increseSeed();
    }

    private void increseSeed(){
        seed = seed + 1;
    }

    // Usuario Fantasma
    protected Usuario(){
        this(null,null,null,null,null);
        this.code = 0;
    }

    //Login do usuário
    public static Usuario usuarioLogin(String nome, String cpf, Arvore<Usuario> tree){
        Usuario aux = new Usuario(null, null, null, null, null); 
        aux = aux.searchTree(nome, cpf, tree); 

        return aux;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        // return cpfFormat(cpf);
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        // return cepFormat(cep);
        return cep;
    }

    public String getEmail() {
        return email;
    }

    public Historico getHist(){
        return hist;
    }  

    public String getComprovante(){
        return comprovante;
    }

    public int getCode(){
        return code;
    }

    // Mostra o comprovante mais atual
    public void setComprovante(String str){
        this.comprovante = str;
    }
    
    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHist(Historico hist) {
        this.hist = hist;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // Gera o comprovante de compra
    private String geraComprovante(Produto p){
        String aux = "\nCOMPROVANTE DE COMPRA\n";
        
        String str = aux + "Comprador: " + getNome() + "\n" 
        + "CPF Comprador: " + getCpf() + "\n" 
        + "Produto comprado: " + p.getNome() + "\n" 
        + "Preço: " + p.getPreco() 
        + ", Quantidade: ";
        
        return str;
    }

    // Método para a compra de um Produto
    public String compraProduto(Produto p, int quantidade){
        String str = geraComprovante(p);
        
        if(p.verEstoque(quantidade)){
            System.out.println("Compra não pode ser realizada, quantidade em estoque insuficiente!");
            if(respUsu())
                FilaEspera.addFila(this);
            else
                System.exit(0);
        }
        
        System.out.println("Compra realizada com sucesso!");
        hist.addHist(p); // Adiciona ao historico de compra

        p.remQntEstoque(quantidade);
        str += quantidade + "\n";

        // Coloca o usuario na fila de envio do produto
        FilaEnvio.addFila(this, str);
        System.out.println("Posição da fila de envio: " + FilaEnvio.getTam());

        return str;
    }

    // Busca Usuario em uma Arvore
    public Usuario searchTree(String nome, String cpf, Arvore<Usuario> tree){
        No<Usuario> node = tree.getRaiz();
        Usuario x = new Usuario(null, null, null, null, null);
        
        // Loop para percorrer a arvore
        while(tree != null){
            // Se for igual retorna o Usuario
            if(this.getNome().equals(nome) && this.getCpf().equals(cpf))
                x = node.getInfo(); 
            
            else if(this.getCode() < node.getInfo().getCode())
                node = node.getAnterior(); // Vai para esquerda
            
            else
                node = node.getProximo(); // Vai para a direita
            
        }

        return x;
    }


    // Pergunta ao usuario se deseja entrar na fila de espera
    private boolean respUsu(){
        try (Scanner scnr = new Scanner(System.in)) {
            String resp = "";

            System.out.println("Deseja entrar na fila de espera? (s ou n): ");
            resp = scnr.nextLine().toLowerCase();

            if(resp == "s")
                return true;
            else
                return false;
        }
    }

    // Foramata o CPF
    public String cpfFormat(String cpf){
        String x1 = cpf.substring(0,3); 
        String x2 = cpf.substring(3,6); 
        String x3 = cpf.substring(6,9);
        String x4 = cpf.substring(9,11);
        
        return cpf = String.format("%s.%s.%s-%s",x1,x2,x3,x4);
    }

    // Formata o CEP
    public String cepFormat(String cep){
        String x1 = cpf.substring(0,2); 
        String x2 = cpf.substring(2,5); 
        String x3 = cpf.substring(5,8);
        
        
        return cpf = String.format("%s.%s-%s",x1,x2,x3);
    }


    @Override
    public String toString() {
        return "\nUsuario " + code + ":\nNome = " + nome + ",\nCPF = " + getCpf() + ",\nEndereco = " + endereco + ",\nCEP = " + getCep() + ",\nEmail = " + email;
    }

    @Override
    public int compareTo(Usuario usuario) {
        // Caso o Codigo do usuario seja igual
        if(usuario.getCode() == this.code)
            return 0;
        else if (usuario.getCode() < this.code)
            return 1;
        else
            return -1;

    }

    
}
