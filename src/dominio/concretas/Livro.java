package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

import static dominio.enumeracao.StatusItem.*;

public class Livro extends ItemBiblioteca{

    public Livro(String titulo, int codigo, StatusItem statusItem) {
        super(titulo, codigo, statusItem);
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
