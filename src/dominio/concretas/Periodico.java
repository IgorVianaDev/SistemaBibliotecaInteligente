package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

import static dominio.enumeracao.StatusItem.DISPONIVEL;
import static dominio.enumeracao.StatusItem.EMPRESTADO;

public class Periodico extends ItemBiblioteca implements Emprestavel, Imprivel {
    public Periodico(String titulo, int codigo, StatusItem statusItem) {
        super(titulo, codigo, statusItem);
    }

    @Override
    public boolean emprestar(Usuario usuario) {
        if (statusItem.equals(DISPONIVEL)){
            setStatusItem(EMPRESTADO);
            return true;
        } else {
            System.out.println("Livro não disponível para empréstimo");
            return false;
        }
    }

    @Override
    public void devolver() {
        System.out.println(getTitulo() + " foi devolvido.");
        statusItem = StatusItem.DISPONIVEL;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Livro -> " +
                "titulo: " + titulo + '\'' +
                ", codigo: " + codigo +
                ", statusItem: " + statusItem);
    }
}
