package Classes.Produtos;

// Subclasse de Produto
public class Fone extends Produto{
    //Atributos da subclasse
    private String categoria;
    private String marca;
    
    // Construtor
    public Fone(String nome, String preco, int qntEstoque, String categoria, String marca, int codigo){
        super(nome, preco, qntEstoque, codigo);
        this.categoria = categoria;
        this.marca = marca;
    }

    // Construtor Vazio
    public Fone(){
        this(null, null, 0, null, null, 0);
    }

    // Getters
    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    // Setters
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        String str = "Categoria: " + getCategoria() + ";\n";
        str += "Marca: " + getMarca() + ";\n";
        
        return super.toString() + str;
    }

}
