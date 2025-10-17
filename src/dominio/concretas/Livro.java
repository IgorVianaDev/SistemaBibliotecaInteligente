package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

import static dominio.enumeracao.StatusItem.*;

public class Livro extends ItemBiblioteca implements Emprestavel, Imprivel {

    public Livro(String titulo, int codigo, StatusItem statusItem) {
        super(titulo, codigo, statusItem);
    }

    @Override
    public boolean emprestar(Usuario usuario) {
        if (getStatusItem().equals(DISPONIVEL)){
            setStatusItem(EMPRESTADO);
            return true;
        } else {
            System.out.println("Livro não disponível para empréstimo");
            return false;
        }
    }

    public boolean reservar(Livro livro, Leitor leitor) {
        if (livro.getStatusItem().equals(DISPONIVEL)) {
            livro.setStatusItem(RESERVADO);
            return true;
        }
        return false;
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

    @Override
    public StatusItem getStatusItem() {
        return statusItem;
    }

    @Override
    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }
}
