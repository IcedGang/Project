package Classes.Usuarios;

import Classes.Produtos.Produto;
import Estruturas.Lista;
import Estruturas.No;

public interface AdminSys {
    
    // Cria um novo Produto
    public No<Produto> newProduct(int key);
    
    // Adiciona mais quantidade ao estoque do produto
    public Lista<Produto> addQntProduct(Lista<Produto> lista, int codigo, int qntEstoque);
    
    // Retira um produto do sistema
    public Lista<Produto> removeProduct(Lista<Produto> lista, No<Produto> produto);

}
