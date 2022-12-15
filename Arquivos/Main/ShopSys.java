package Main;

import Arquivos.Arquivos;

import Classes.Features.Cadastro;
import Classes.Features.FilaEnvio;
import Classes.Features.FilaEspera;

import Classes.Produtos.Produto;
import Classes.Usuarios.Admim;
import Classes.Usuarios.Usuario;

import Estruturas.Arvore;
import Estruturas.Lista;
import Estruturas.No;

// Classe Responsável pelos Metodos de Carregar os Arquivos
// Maneira Usando Vetores
public abstract class ShopSys {
        
    // Carregando do Arquivo para Arvore
    protected static Arvore<Usuario> vetToTree(){
        Arvore<Usuario> tree = new Arvore<>();
        String pathTree = "Usuarios.txt";
        Usuario[] temp1 = new Usuario[Cadastro.numberUsuario + 1];
        temp1 = Arquivos.readFiles(pathTree, temp1);

        for(int i = 0; i < temp1.length; i++)
            tree.inserir(temp1[i]);

        return tree;
    }

    // Carregando do Arquivo para Fila de Envio
    protected static void vetToSendQueue(){
        String pathSendQueue = "FilaEnvio.txt";
        Usuario[] temp3 = new Usuario[FilaEnvio.getTam() + 1];
        temp3 = Arquivos.readFiles(pathSendQueue, temp3);

        for(int i = 0; i < temp3.length; i++)
            FilaEnvio.addFila(temp3[i], temp3[i].getComprovante());

    }
    
    // Carregando do Arquivo para Fila de Espera
    protected static void vetToWaitList(){
        String pathWaitQueue = "FilaEspera.txt";
        Usuario[] temp4 = new Usuario[FilaEspera.getTam() + 1];
        temp4 = Arquivos.readFiles(pathWaitQueue, temp4);

        for(int i = 0; i < temp4.length; i++)
            FilaEspera.addFila(temp4[i]);

    }
    
    // Carregando do Arquivo para Lista
    protected static Lista<Produto> vetToList(){
        Lista<Produto> list = new Lista<>();
        No<Produto> node = new No<>();
        
        String pathList = "Produtos.txt";
        Produto[] temp2 = new Produto[Admim.numberProd + 1];
        temp2 = Arquivos.readFiles(pathList, temp2);

        for(int i = 0; i < temp2.length; i++){
            node.setInfo(temp2[i]);
            list.inserirFinal(node);
        }
            
        return list;
    }
}
