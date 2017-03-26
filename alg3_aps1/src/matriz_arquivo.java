
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class matriz_arquivo {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            Scanner ler = new Scanner(System.in);
            System.out.println("Infome somente o nome do arquivo");
            String nomeArquivo = ler.next();
            br = new BufferedReader(new FileReader(nomeArquivo + ".txt"));

            String primeiraLinha = br.readLine();
            String[] basesDaMatriz = primeiraLinha.split(" ");  // pega o tamanho da matriz
            int y = Integer.parseInt(basesDaMatriz[0]);         // coluna
            int x = Integer.parseInt(basesDaMatriz[1]);         // linha
            String[][] matriz = new String[x][y]; 

            int eixoY = 0;
            while ((primeiraLinha = br.readLine()) != null) {//enquanto tiver linhas le o arquivo
                String[] array = primeiraLinha.split("");
                for (int eixoX = 0; eixoX < array.length; eixoX++) {
                    matriz[eixoY][eixoX] = array[eixoX];
                }
                eixoY++;
            }
            
            System.out.println("Matriz original");
            imprimeMatriz(matriz);
            
            System.out.println("Matriz 0 para 2");
            trocaValoresPara1Matriz(matriz);
            
            System.out.println("Matriz 1 para 2");
            trocaValoresPara2Matriz(matriz);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(matriz_arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(matriz_arquivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(matriz_arquivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void imprimeMatriz(String[][] matriz) {   // matriz original
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println("");
        }
    }

    private static void trocaValoresPara1Matriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print((matriz[i][j].equals("0") ? 2 : matriz[i][j]) + "|");
            }
            System.out.println("");
        }
    }
    
    
    
    private static void trocaValoresPara2Matriz(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print((matriz[i][j].equals("1") ? 2 : matriz[i][j]) + "|");
            }
            System.out.println("");
        }
    }
    
    
    
    
    
}
