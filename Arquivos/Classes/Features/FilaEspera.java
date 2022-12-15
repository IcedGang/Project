package Classes.Features;

import Arquivos.Arquivos;
import Classes.Usuarios.Usuario;
import Estruturas.Fila;

public class FilaEspera {
    // Uma Fila de espera por um produto em falta
    private static Fila<Usuario> usuarios = new Fila<>();
    private static String file = "FilaEspera.txt";

    // Adiciona à fila de espera
    public static int addFila(Usuario x){
        if(usuarios.getTam() > 0){
            removeFila();
            usuarios.enfileirar(x);

            // Salva no arquivo
            Arquivos.Write(usuarios, file);
            return usuarios.getTam();
        }
        else{
            // Salva no arquivo
            Arquivos.Write(usuarios, file);
            usuarios.enfileirar(x);
            return usuarios.getTam();

        }

    }

    // Remove da fila de espera
    public static void removeFila(){
        usuarios.desenfileirar();
    }

    public static int getTam(){
        return usuarios.getTam();
    }

}
