package Estruturas;

// Arvore Binária de tipo genérico
public class Arvore<Type extends Comparable<Type>> {
    
    private No<Type> raiz; // Raiz da arvore
    private int tam = 0; //Quantidade de elementos da arvore

    // No.anterior = filho esquerdo
    // No.proximo = filho direito

    // Inicializa a Arvore
    public Arvore(){
        this.raiz = null;
    }

    // Retorna a raiz
    public No<Type> getRaiz() {
        return raiz;
    }

    // Retorna o tamanho
    public int getTam(){
        return tam;
    }

    // Insere elementos na arvore
    public void inserir(Type info){
        No<Type> aux = new No<>(info); // Cria o nó a ser inserido

        if(raiz == null){
            this.raiz = aux;
            tam++;
        } 
        else{
            No<Type> current = this.raiz; // Marca o nó mais atual

            // Loop forçado, para percorrer a arvore
            while(true){
                // Compara as informaçoes, se for menor adiciona à esquerda
                if(aux.getInfo().compareTo(current.getInfo()) == -1){

                    // Se o filho esquerdo já tiver elemento, verifica a proxima esquerda
                    // Senão insere na esquerda
                    if(current.getAnterior() != null)
                        current = current.getAnterior();
                    else{
                        current.setAnterior(aux);
                        tam++;
                        break; // Sai do laço
                    }
                        
                }
                // Se for maior ou igual adiciona à direita
                else{

                    // Se o filho direito já tiver elemento, verifica a proxima direita
                    // Senão insere na direita
                    if(current.getProximo() != null)
                        current = current.getProximo();
                    else{
                        current.setProximo(aux);
                        tam++;
                        break; // Sai do laço
                    }
                        

                }

            }

        }
        
    }

    // Remove elementos da árvore
    public void remover(Type info){
        No<Type> current = this.raiz; // Marcador para o nó atual
        No<Type> father = null; // Marcador para o pai do nó atual

        // Percorre a arvore procurando o elemento a ser removido
        while(current != null){

            // Se o valor a ser retirado for a raiz
            if(current.getInfo().equals(info))
                break;
            else{

                // Se o valor a ser retirado for menor que o atual
                if(info.compareTo(current.getInfo()) == -1){
                    father = current; // Pai igual ao atual
                    current = current.getAnterior(); // Pega o fiho a esquerda
                }
                else{
                    father = current; // Pai igual ao atual
                    current = current.getProximo(); // Pega o filho a direita
                }
                    
            }

        }

        // Verifica o elemento a ser removido
        if(current != null){

            // Elemento tem 2 filhos ou só filho direito
            if(current.getProximo() != null){
                No<Type> aux = current.getProximo(); // Auxiliar igual ao filho direito do atual
                No<Type> fatherAux = current; // Pai do auxiliar igual ao atual

                // Procura o elemento mais a esquerda 
                while(aux.getAnterior() != null){
                    fatherAux = aux;
                    aux = aux.getAnterior();
                }
                // Para n perder o filho a esquerda do nó a ser removido
                aux.setAnterior(current.getAnterior());
                // Para n perder o filho a direita do nó a ser removido
                aux.setProximo(current.getProximo());
                
                this.subsElement(current, father, aux);
                this.removeElement(aux, fatherAux);

            }
            // Elemento só tem filho esquerdo
            else if(current.getAnterior() != null){
                No<Type> aux = current.getAnterior(); // Auxiliar igual ao filho esquerdo do atual
                No<Type> fatherAux = current; // Pai do auxiliar igual ao atual

                // Procura o elemento mais a direita 
                while(aux.getProximo() != null){
                    fatherAux = aux;
                    aux = aux.getProximo();
                }

                this.subsElement(current, father, aux);
                this.removeElement(aux, fatherAux);
            }
            // Elemento não tem filhos
            else
                this.removeElement(current, father); 

        }
        else{
            System.out.println("Elemento não encontrado, impossível remover!");
            System.exit(0);
        }

    }

    // Remove o elemento
    private void removeElement(No<Type> current, No<Type> father){
        // Verifica se o elemento não é a raiz
        if(father != null)
           // Se o atual for menor que o pai dele
            if(current.getInfo().compareTo(father.getInfo()) == -1)
                father.setAnterior(null); //Remove elemento a esquerda
            else
                father.setProximo(null); //Remove elemento a direita         
        else
            this.raiz = null;
         
    }

    // Substitui o elemento
    private void subsElement(No<Type> current, No<Type> father, No<Type> aux){
        //Verifica se o elemento não é a raiz
        if(father != null)
            // Se o atual for menor que o pai dele
            if(current.getInfo().compareTo(father.getInfo()) == -1)
                father.setAnterior(aux); //Substitui o elemento a esquerda
            else
            father.setProximo(aux); //Substitui elemento a direita          
        else
            this.raiz = aux;
        
    }

    // Retorna uma String com os elementos da arvore em-ordem
    public void emOrdem(No<Type> current){    
        if(current != null){
            emOrdem(current.getAnterior()); // Entra no filho a esquerda
            System.out.println(current.getInfo()); // Armazena o valor em uma lista
            emOrdem(current.getProximo()); // Entra no filho a direita
        }

    }

    // Mostra a raiz e o tamanho da arvore
    @Override
    public String toString() {
        String str = "Raiz: " + getRaiz();
        str += "\nTam: " + getTam();

        return str;
    }

}