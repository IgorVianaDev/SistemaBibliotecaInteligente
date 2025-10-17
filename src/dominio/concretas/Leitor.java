package dominio.concretas;

import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.Emprestavel;

import java.util.ArrayList;

import static dominio.enumeracao.StatusItem.DISPONIVEL;
import static dominio.enumeracao.StatusItem.EMPRESTADO;

public class Leitor extends Usuario{
    private ArrayList<Livro> livros = new ArrayList<>();

    public Leitor(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }

    public Leitor(String nome, NivelUsuario nivelUsuario, ArrayList<Livro> livros) {
        super(nome, nivelUsuario);
    }

    @Override
    public boolean podeGerenciar() {
        return false;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.print("Nome: " + getNome()+
                " | Nivel: " + getNivelUsuario());
        if (livros == null){
            System.out.print(" Nenhum livro!");
        } else {
            System.out.print(" | Livro: ");
            for (Livro livro : livros) {
                System.out.print(livro.getTitulo() + " | ");
            }
        }
        System.out.println();
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }
}
