package Classes.Features;

import Arquivos.Arquivos;
import Classes.Usuarios.Usuario;
import Estruturas.Fila;

public class FilaEnvio {
    // Fila de envio do produto para o usuário
    private static Fila<Usuario> envio = new Fila<>();
    private static String file = "FilaEnvio.txt";

    public static void addFila(Usuario usu, String comprovante){
        usu.setComprovante(comprovante);
        envio.enfileirar(usu);
        
        // Salva no arquivo
        Arquivos.Write(envio, file);
    }

    public static void removeFila(){
        envio.desenfileirar();

        // Salva no arquivo
        Arquivos.Write(envio, file);
    }

    public static int getTam(){
        return envio.getTam();
    }
}
