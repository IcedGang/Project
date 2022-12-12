package Classes.Produtos;

// Subclasse de Produto
public class Mouse extends Produto {
    // Atributos da subclasse
    private String dpi;
    private String categoria;
    private String marca;
    
    // Construtor da subclasse, 
    // usando o construtor da classe Pai
    public Mouse(String nome, String preco, int qntEstoque, String categoria, String marca, int codigo, String dpi) {
        super(nome, preco, qntEstoque, codigo);
        this.categoria = categoria;
        this.marca = marca;
        this.dpi = dpi;
    }

    // Construtor vazio
    public Mouse(){
        this(null, null, 0, null, null, 0, null);
    }

    // Getters
    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getDpi() {
        return dpi;
    }

    // Setters
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        String str = "Categoria: " + getCategoria() + ";\n";
        str += "Marca: " + getMarca() + ";  " + "DPI: " + getDpi() + ";\n";

        return super.toString() + str;
    }
    


}
