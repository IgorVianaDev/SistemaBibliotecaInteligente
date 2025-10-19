package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

import static dominio.enumeracao.StatusItem.*;

public class Periodico extends ItemBiblioteca{
    public Periodico(String titulo, int codigo, StatusItem statusItem) {
        super(titulo, codigo, statusItem);
    }

    @Override
    public boolean emprestar(Leitor leitor) {
        if (statusItem.equals(DISPONIVEL)){
            setStatusItem(EMPRESTADO);
            return true;
        } else {
            System.out.println("Periódico não disponível para empréstimo");
            return false;
        }
    }

    @Override
    public void devolver(Leitor leitor) {
        System.out.println(getTitulo() + " foi devolvido.");
        statusItem = StatusItem.DISPONIVEL;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Periódico: -> " +
                "titulo: " + titulo + '\'' +
                ", codigo: " + codigo +
                ", statusItem: " + statusItem);
    }

    public boolean reservar(Periodico periodico, Leitor leitor) {
        if (periodico.getStatusItem().equals(DISPONIVEL)) {
            periodico.setStatusItem(RESERVADO);
            leitor.getItem().add(periodico);
            System.out.println(periodico.getTitulo() + " reservado pelo " + leitor.getNome());
            return true;
        }
        return false;
    }
}
