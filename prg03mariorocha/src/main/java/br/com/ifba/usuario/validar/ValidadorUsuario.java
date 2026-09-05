package br.com.ifba.usuario.validar;

import java.util.ArrayList;

/**
 *
 * @author mariorocha
 */
public class ValidadorUsuario {
    // Criando classe para validar palavra
    public static boolean contemPalavraProibida(String texto){
        // Criando o array string para receber palavras proibídas
        ArrayList<String> palavrasProibidas = new ArrayList<>();
        // Adicionando palavras proíbidas
        palavrasProibidas.add("Teste");
        palavrasProibidas.add("Main");
        palavrasProibidas.add("admin");
        palavrasProibidas.add("root");
        palavrasProibidas.add("senha123");
        palavrasProibidas.add("palmeiras");
        palavrasProibidas.add("gato");
        palavrasProibidas.add("acerola");
        // For para verificar palavras
        for(String palavra: palavrasProibidas){
            // Se tiver uma igual, retorna true
            if(palavra.equals(texto)){
                return true;
            }
        }
        // Se sair do For é porque não tem palavra proíbida
        return false;
    }
}
