import Arquivos.Arquivo;
import Classes.Produtos.Produto;
import Classes.Usuarios.Admim;
import Estruturas.*;

public class Teste {
    public static void main(String[] args) {
        Admim admin = new Admim();
        
        String arqv = "teste.txt";

        /*
        Ordem de inserir os dados dos produtos:

        Produto; Preço; QntEstoque; CódigoProduto 
        Categoria; Marca; Especificidade: Mouse - DPI
                                          Teclado - isMecanico
                                          Fone --
        */

        No<Produto> x1 = admin.newProduct(1);
        No<Produto> x2 = admin.newProduct(2);
        No<Produto> x3 = admin.newProduct(3);

        // String texto = Arquivo.read(arqv);

        String aux = x1.toString();
        aux += x2.toString();
        aux += x3.toString();

        if(Arquivo.write(arqv, aux))
            System.out.println("Sucess!");
        else
            System.out.println("Error!");


        Lista<Produto> lista = new Lista<>();
        lista.inserirFinal(x1);
        lista.inserirFinal(x2);
        lista.inserirFinal(x3);

        System.out.println(lista.imprimeLista());

        admin.addQntProduct(lista, 35, 4);
        lista = admin.removeProduct(lista, x3);

        System.out.println(lista.imprimeLista());
        
        aux = lista.imprimeLista();
        if(Arquivo.write(arqv, aux))
            System.out.println("Sucess!");
        else
            System.out.println("Error!");


    }
}
