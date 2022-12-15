package Estruturas;

// Nó tipo genérico
public class No<Type> {
    
    private Type info; // informação contida no nó
    private No<Type> anterior; // aponta para o nó anterior
    private No<Type> proximo; // aponta para o proximo nó
    
    // Cria um nó com informação
    public No(Type info) {
        this.info = info;
        this.anterior = null;
        this.proximo = null;
    }
    
    // Cria um nó vazio
    public No() {
        this(null);
    }

    // Getters e Setters
    public Type getInfo() {
        return info;
    }

    public void setInfo(Type info) {
        this.info = info;
    }
    
    public No<Type> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<Type> anterior) {
        this.anterior = anterior;
    } 

    public No<Type> getProximo() {
        return proximo;
    }

    public void setProximo(No<Type> proximo) {
        this.proximo = proximo;
    }

    // Mostra a informação contida no Nó
    @Override
    public String toString() {
        return info + "\n";
    }


}
