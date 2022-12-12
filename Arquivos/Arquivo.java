package Arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
    
    // Lê de um arquivo
    // Recebe o caminho para o arquivo
    // Retorna uma string do que foi lido no arquivo
    public static String read(String path){
        // Armazena o texto lido do arquivo
        String texto = ""; 

        try{
            // Leem o arquivo
            FileReader arquivo = new FileReader(path);
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            
            // Armazena linhas do arquivo
            String line = "";
            try{
                // Lê o arquivo linha a linha
                line = lerArquivo.readLine();
                while(line != null){
                    texto += line + "\n";
                    line = lerArquivo.readLine();
                }
                
                // Fecha o arquivo e retorna o uqe foi lido
                arquivo.close();
                return texto;
            }
            // Caso não seja possivel ler o arquivo
            catch(IOException error){
                System.out.println("Não foi possível ler o arquivo!");
                return "";
            }


        }
        // Caso não encontre o arquivo
        catch(FileNotFoundException error){
            System.out.println("Não foi possível achar o arquivo!");
            return "";
        }

    }

    // Escreve em um arquivo
    // Recebe o caminho para o arquivo e o texto a ser escrito
    // Retorna uma confirmação se foi possivel escrever no arquivo
    public static boolean write(String path, String texto){
        try{
            FileWriter arquivo = new FileWriter(path);
            PrintWriter prntArquivo = new PrintWriter(arquivo);

            // Escreve no arquivo e fecha
            prntArquivo.println(texto);
            prntArquivo.close();

            return true;
        }
        catch(IOException error){
            System.out.println(error.getMessage());
            return false;
        }

    }

}
