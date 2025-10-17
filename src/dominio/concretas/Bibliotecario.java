package dominio.concretas;

import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;
import dominio.enumeracao.StatusItem;

import static dominio.enumeracao.StatusItem.*;
import static dominio.enumeracao.StatusItem.ATRASADO;

public class Bibliotecario extends Usuario {
    public Bibliotecario(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Nivel Usuário: " + getNivelUsuario());
    }
    @Override
    public boolean podeGerenciar() {
        return true;
    }

    public boolean emprestar(Livro livro, Leitor leitor) {
        if (livro == null || leitor == null) {
            return false;
        } else if (livro.emprestar(leitor)) {
            leitor.getLivros().add(livro);
            return true;
        }
        return false;
    }

    public boolean reservar(Livro livro, Leitor leitor) {
        if (livro == null || leitor == null) {
            return false;
        } else if (livro.reservar(livro,leitor)) {
            livro.setStatusItem(RESERVADO);
            leitor.getLivros().add(livro);
            return true;
        }
        return false;
    }

    public boolean atrasado(Livro livro) {
        livro.setStatusItem(ATRASADO);
        return true;
    }

    public void devolver(Livro livroDevolvido, Leitor leitor){
        livroDevolvido.setStatusItem(DISPONIVEL);
        leitor.getLivros().remove(livroDevolvido);
        System.out.println(livroDevolvido.getTitulo() + " Devolvido");
    }
}
