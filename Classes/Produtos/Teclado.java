package Classes.Produtos;

// Subclasse de Produto
public class Teclado extends Produto{
    // Atributos da classe
    private Boolean isMecanico;
    private String categoria;
    private String marca;

    // Construtor
    public Teclado(String nome, String preco, int qntEstoque, String categoria, String marca, int codigo, boolean isMecanico){
        super(nome, preco, qntEstoque, codigo);
        this.categoria = categoria;
        this.marca = marca;
        this.isMecanico = isMecanico;
    }

    // Construtor Vazio
    public Teclado(){
        this(null, null, 0, null, null, 0, false);
    }

    // Getters
    public Boolean getIsMecanico() {
        return isMecanico;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    // Setters
    public void setIsMecanico(Boolean isMecanico) {
        this.isMecanico = isMecanico;
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
        str += "Marca: " + getMarca() + ";  " + "Mecanico: " + getIsMecanico() + ";\n";

        return super.toString() + str;
    }


}
