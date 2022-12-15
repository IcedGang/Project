package Arquivos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Classes.Produtos.Produto;
import Classes.Usuarios.Usuario;
import Estruturas.Fila;
import Estruturas.No;

public class Arquivos {
    
    // Função para escrever em um arquivo (Produto)
    public static Boolean Write(No<Produto> x, String file){
        
        try {
            FileOutputStream arq = new FileOutputStream("Arquivos/" + file);
            ObjectOutputStream scn = new ObjectOutputStream(arq);
            
            scn.writeObject(x);
            scn.close();

            return true;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }        
    }   

    // Função para ler de um arquivo (Produto)
    public static Produto Read(Produto x, String path){

        try{
            FileInputStream arq = new FileInputStream("Arquivos/" + path);
            ObjectInputStream obj = new ObjectInputStream(arq);

            x = (Produto) obj.readObject();
            obj.close();

            return x;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    // Função para escrever em um arquivo (Usuário)
    public static Boolean Write(Usuario x, String file){
        
        try {
            FileOutputStream arq = new FileOutputStream("Arquivos/" + file);
            ObjectOutputStream scn = new ObjectOutputStream(arq);
            
            scn.writeObject(x);
            scn.close();

            return true;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }        
    }   

    // Função para ler de um arquivo (Usuário)
    public static Usuario Read(Usuario x, String path){

        try{
            FileInputStream arq = new FileInputStream("Arquivos/" + path);
            ObjectInputStream obj = new ObjectInputStream(arq);

            x = (Usuario) obj.readObject();
            obj.close();

            return x;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return x;
        }

    }

    // Função para escrever em um arquivo (Produto)
    public static Boolean Write(Fila<Usuario> x, String file){
        
        try {
            FileOutputStream arq = new FileOutputStream("Arquivos/" + file);
            ObjectOutputStream scn = new ObjectOutputStream(arq);
            
            scn.writeObject(x);
            scn.close();

            return true;
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }        
    }   

    // Função para ler de um arquivo (Produto)
    public static Fila<Usuario> Read(Fila<Usuario> x, String path){

        try{
            FileInputStream arq = new FileInputStream("Arquivos/" + path);
            ObjectInputStream obj = new ObjectInputStream(arq);

            x = (Fila<Usuario>) obj.readObject();
            obj.close();

            return x;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    // Le para um vetor de Usuários
    public static Usuario[] readFiles(String path, Usuario[] vet){
        Usuario x = null;
        for(int i = 0; i < vet.length; i++)
            vet[i] = Arquivos.Read(x, path);

        return vet;
    }
    
    // Le para um vetor de Produtos
    public static Produto[] readFiles(String path, Produto[] vet){
        Produto x = null;
        for(int i = 0; i < vet.length; i++)
            vet[i] = Arquivos.Read(x, path);

        return vet;
    }

}
