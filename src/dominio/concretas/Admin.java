package dominio.concretas;

import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;
import dominio.enumeracao.StatusItem;

import java.util.concurrent.ThreadPoolExecutor;

import static dominio.enumeracao.StatusItem.*;

public class Admin extends Usuario {

    public Admin(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }

    @Override
    public boolean podeGerenciar() {
        return true;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.print("Nome: " + getNome()+
                " | Nivel: " + getNivelUsuario());
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
        } else if (livro.getStatusItem().equals(DISPONIVEL)) {
            livro.setStatusItem(RESERVADO);
            leitor.getLivros().add(livro);
            return true;
        } else
            return false;
    }

    public boolean atrasado(Livro livro, Leitor leitor){
        livro.setStatusItem(ATRASADO);
        return true;
    }

    public void devolver(Livro livroDevolvido, Leitor leitor){
        livroDevolvido.setStatusItem(DISPONIVEL);
        for (Livro leitorLivro : leitor.getLivros()) {
            if (leitorLivro.equals(livroDevolvido)){
                leitor.getLivros().remove(livroDevolvido);
            }
        }
        System.out.println(livroDevolvido.getTitulo() + " Devolvido");
    }

    //Função exclusiva do Adm
    public boolean alteraStatus(Livro livro, StatusItem statusItemDesejado) {
        livro.setStatusItem(statusItemDesejado);
        return true;
    }
}
