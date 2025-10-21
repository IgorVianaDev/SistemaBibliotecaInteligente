package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

import java.util.ArrayList;

import static dominio.enumeracao.StatusItem.*;

public class Periodico extends ItemBiblioteca{
    public Periodico(String titulo, int codigo, StatusItem statusItem) {
        super(titulo, codigo, statusItem);
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Periódico: -> " +
                "titulo: " + titulo + '\'' +
                ", codigo: " + codigo +
                ", statusItem: " + statusItem);
    }
}
