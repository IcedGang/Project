package Estruturas;

// Fila de tipo genérico 
public class Fila<Type> {
    
    private Lista<Type> fila; // Usando uma lista para representar uma Fila 
    
    private No<Type> primeiro; // Primeiro da fila
    private No<Type> ultimo; // Ultimo da fila

    // Inicia a fila
    public Fila(){
        this.fila = new Lista<>();
        this.primeiro = null;
        this.ultimo = null;
    }

    // Adiciona elementos na fila
    public void enfileirar(Type info){
        No<Type> x = new No<Type>(info);
        
        fila.inserirFinal(x);
        this.primeiro = fila.getInicio();
        this.ultimo = fila.getFim();
    }

    // Remove elementos da fila
    public void desenfileirar(){
        fila.removerInicio();
        this.primeiro = fila.getInicio();
        this.ultimo = fila.getFim();

    }

    // Imprime a fila inteira
    public String imprimeFila(){
        return fila.imprimeLista();
    }

    // Retorna o primeiro da fila
    public No<Type> getPrimeiro(){
        return this.primeiro;
    }

    // Retorna o ultimo da fila
    public No<Type> getUltimo(){
        return this.ultimo;
    }   

    // Mostra o inicio, o final e o tamanho da fila
    @Override
    public String toString() {
        String str = "Fila: \n" + fila.toString();

        return str;
    }


}
