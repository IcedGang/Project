package Classes.Features;

import Classes.Usuarios.Usuario;
import Estruturas.Fila;

public class FilaEnvio {
    // Fila de envio do produto para o usuário
    private static Fila<Usuario> envio = new Fila<>();

    public static void addFila(Usuario usu, String comprovante){
        usu.setComprovante(comprovante);
        envio.enfileirar(usu);
    }

    public static void removeFila(){
        envio.desenfileirar();
    }

}
