package Main;

import java.io.IOException;
import java.util.Scanner;
import Classes.Features.Cadastro;
import Classes.Features.Menu;
import Classes.Usuarios.Admim;

/* 
 * Universidade Estadual de Santa Cruz
 * Discente: Vítor Coutinho Lima  
 * 
 * Matrícula: 202121119
 * 
 * Projeto Para As Disciplinas De Estrutura
 * De Dados e Linguagem de Programação III
 * 
 * Professores: Helder Conceicao Almeida 
 *              Dany Sanchez Dominguez
 * 
*/

// Classe Principal
public class Shop extends ShopSys {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Admim Adm = new Admim(); // Criar Primeiros Produtos
        // Adm.newProduct(1); // Mouse
        // Adm.newProduct(2); // Teclado
        // Adm.newProduct(3); // Fone

        Scanner scnr = new Scanner(System.in);
        // Cadastro.newUsuario(scnr); // Criar Primeiro Usuario

        // vetToSendQueue();
        // vetToWaitList();
        
        // Roda a loja
        Menu.mainScreen(vetToTree(), vetToList(), scnr);
        scnr.close();
    } 
    
}
