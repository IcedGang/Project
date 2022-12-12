package Classes.Usuarios;

import java.util.Scanner;

import Classes.Features.FilaEnvio;
import Classes.Features.FilaEspera;
import Classes.Features.Historico;
import Classes.Produtos.Produto;

public class Usuario{
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
        this.code += 1;
    }

    // Usuario Fantasma
    protected Usuario(){
        this(null,null,null,null,null);
    }

    //Login do usuário
    public void usuarioLogin(String nome, String cpf){

    }

    //Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
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

    // Mostra o comprovante mais atual
    public void setComprovante(String str){
        this.comprovante = str;
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

        return str;
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

    @Override
    public String toString() {
        return "Usuario " + code + ": [nome = " + nome + ", cpf = " + cpf + ", endereco = " + endereco + ", cep = " + cep + ", email = " + email
                + "]";
    }
    
}
