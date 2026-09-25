package br.com.ifba.usuario.validar;

import br.com.ifba.usuario.entity.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mariorocha
 */
public class ValidadorUsuario extends Usuario {

    private String senhaDeConfirmacao;

    public ValidadorUsuario(String senhaDeConfirmacao, String nome, String cpf, String dataDeNascimento, String genero, String telefone, String email, String login, String senha) {
        super(nome, cpf, dataDeNascimento, genero, telefone, email, login, senha);
        this.senhaDeConfirmacao = senhaDeConfirmacao;
    }

    // Criando classe para validar palavra
    public boolean contemPalavraProibida() {
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
        for (String palavra : palavrasProibidas) {
            // Se tiver uma igual, retorna true
            if (this.getLogin().equals(palavra)) {
                return true;
            }
        }
        // Se sair do For é porque não tem palavra proíbida
        return false;
    }

    // Verifica se o cpf do usuario tem um tamanho válido
    public boolean isTamanhoValidoCpf() {
        return this.getCpf().length() == 11;
    }

    // verifica se as senhas são iguais
    public boolean isSenhasIguais() {
        return this.getSenha().equals(this.senhaDeConfirmacao);
    }

    //verifica se os campos estão vazios
    public boolean isCamposVazios() {
        return (this.getNome().isEmpty()
                || this.getCpf().isEmpty()
                || this.getDataDeNascimento().isEmpty()
                || this.getTelefone().isEmpty()
                || this.getEmail().isEmpty()
                || this.getLogin().isEmpty()
                || this.getSenha().isEmpty());
    }

    public void cadastrarUsuario() {
        if (isCamposVazios()) {
            JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!!", "Campos incompletos", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!isTamanhoValidoCpf()) {
                JOptionPane.showMessageDialog(null, "O CPF informado é inválido. Tente novamente!", "CPF Inválido", JOptionPane.ERROR_MESSAGE);
            } else {
                if (!isSenhasIguais()) {
                    JOptionPane.showMessageDialog(null, "Verifique as senhas!!", "Senhas não coincidem", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (contemPalavraProibida()) {
                        JOptionPane.showMessageDialog(null, "Você digitou um login inválido. Tente novamente", "Login inválido", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Usuario novoUsuario = new Usuario(
                                this.getNome(),
                                this.getCpf(),
                                this.getDataDeNascimento(),
                                this.getGenero(),
                                this.getTelefone(),
                                this.getEmail(),
                                this.getLogin(),
                                this.getSenha()
                        );
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado. O osuário: " + novoUsuario.getNome() + " foi cadastrado com sucesso!", "Confirmacao de cadastro", JOptionPane.INFORMATION_MESSAGE);
                    }

                }
            }
        }
    }
}
