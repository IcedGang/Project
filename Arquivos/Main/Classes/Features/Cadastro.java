package Classes.Features;

import java.util.Scanner;

import Arquivos.Arquivos;
import Classes.Usuarios.Usuario;
import Estruturas.Arvore;

public class Cadastro {
    
    public static int numberUsuario = 0;

    public static Usuario newUsuario(Scanner scnr){
        Usuario aux = new Usuario(null, null, null, null, null);
        Arvore<Usuario> tree = new Arvore<>();
        String file = "Usuarios.txt";

        scnr.nextLine();
        System.out.print("Nome: ");
        aux.setNome(scnr.nextLine());        

        System.out.print("CPF: ");
        aux.setCpf(scnr.nextLine());

        System.out.println("Endereço (Cidade, Estado, Rua, Número da casa): ");
        aux.setEndereco(scnr.nextLine());

        System.out.print("CEP: ");
        aux.setCep(scnr.nextLine());

        System.out.print("Email: ");
        aux.setEmail(scnr.nextLine());

        // Insere na arvore e salva no arquivo
        tree.inserir(aux);
        Arquivos.Write(aux, file);
        numberUsuario += 1;

        return aux;
    }


}
