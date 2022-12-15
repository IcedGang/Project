package Estruturas;

import java.io.Serializable;

// Lista de tipo genérico
public class Lista<Type> implements Serializable{
    
    private No<Type> inicio; // Nó inicial
    private No<Type> fim; // Nó final
    
    private int tam = 0; // quantidade de elementos na lista

    // Inicia a lista
    public Lista(){
        this.inicio = null;
        this.fim = null;
    }

    public void inserirInicio(No<Type> info){
        No<Type> node = info;
        
        // Se a lista estiver vazia insere o primeiro elemento
        if(isEmpty())
            this.fim = node;

        // Se a lista já tiver elementos
        else{
            node.setProximo(inicio);
            inicio.setAnterior(node);
              
        }
        
        this.inicio = node;
        this.tam += 1;
    }

    public void inserirFinal(No<Type> info){
        No<Type> node = info;
        
        // Se a lista estiver vazia insere o primeiro elemento;
        if(isEmpty())
            this.inicio = node;

        // Se a lista já tiver elementos
        else{
            fim.setProximo(node);
            node.setAnterior(fim);
        
        }

        this.fim = node;
        this.tam += 1;
    }

    // Remove primeiro elemento
    public void removerInicio(){
        // Se a lista não estiver vazia
        if(!isEmpty()){
            No<Type> node = new No<>();
            node = this.inicio;

            // Lista possui um único elemento
            if(this.inicio == this.fim)
                this.inicio = this.fim = null;
                
            else{
                inicio = node.getProximo();
                inicio.setAnterior(null);

            }           
            
            this.tam--;
        }
        // Lista está vazia
        else{
            System.out.println("Estrutura Vazia, impossível remover!!");
            System.exit(0);
            
        }
    }

    // Remove último elemento da lista
    public void removerFinal(){
        // Se a lista não estiver vazia
        if(!isEmpty()){
            No<Type> node = new No<>();
            node = this.fim;

            // Lista possui um único elemento
            if(this.inicio == this.fim)
                this.inicio = this.fim = null;
                
            else{
                fim = node.getAnterior();
                fim.setProximo(null);

            }           
            
            this.tam--;
        }
        // Lista está vazia
        else{
            System.out.println("Estrutura Vazia, impossível remover!!");
            System.exit(0);
            
        }
    }

    // Imprime a lista inteira
    public String imprimeLista(){
        No<Type> node = new No<>();
        node = this.inicio;
        String str = "";

        // Enquanto node != null
        while(node != null){
            str += node + "\n";
            node = node.getProximo();
        }

        return str;
    }

    // Retorna o tam
    public int getTam(){
        return this.tam;
    }

    // Retorna o inicio
    public No<Type> getInicio(){
        return this.inicio;
    }

    // Retorna o fim
    public No<Type> getFim(){
        return this.fim;
    }

    // Verifica se a lista tá vazia
    public boolean isEmpty(){
        if(getTam() == 0)
            return true;
        
        return false;
    }
    
    // Mostra o inicio, o fim e o tamanho da lista
    @Override
    public String toString() {
        String str = "Tam: " + this.getTam() + "\n[inicio: " + inicio.toString() + ", final: " + fim.toString() + "]";
        
        return str;
    }

}