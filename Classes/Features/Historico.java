package Classes.Features;

import Classes.Produtos.Produto;
import Estruturas.Pilha;

public class Historico {
    // Representa o historico de compras do usuario
    private Pilha<Produto> hist;

    // Cria um historico
    public Historico(){
        this.hist = new Pilha<>();
    }

    // Adiciona uma compra ao historico
    public void addHist(Produto prod){
        hist.empilhar(prod);
    }


}
