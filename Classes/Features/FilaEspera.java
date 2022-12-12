package Classes.Features;

import Classes.Usuarios.Usuario;
import Estruturas.Fila;

public class FilaEspera {
    // Uma Fila de espera por um produto em falta
    private static Fila<Usuario> usuarios = new Fila<>();

    // Adiciona à fila de espera
    public static void addFila(Usuario x){
        usuarios.enfileirar(x);
    }

    // Remove da fila de espera
    public static void removeFila(){
        usuarios.desenfileirar();
    }
}
