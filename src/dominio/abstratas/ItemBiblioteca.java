package dominio.abstratas;

import dominio.concretas.Leitor;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.ControlaAtraso;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

import static dominio.enumeracao.StatusItem.*;

public abstract class ItemBiblioteca implements Imprivel, Emprestavel, ControlaAtraso {
    protected String titulo;
    protected int codigo;
    protected StatusItem statusItem;

    public ItemBiblioteca(String titulo, int codigo, StatusItem statusItem) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.statusItem = statusItem;
    }

    @Override
    public void devolver(Leitor leitor){
        setStatusItem(DISPONIVEL);
        leitor.getItensBiblioteca().remove(this);
        System.out.println(getTitulo() + " Devolvido");
    }
    @Override
    public boolean emprestar(Leitor leitor){
        if (leitor == null) {
            return false;
        } else if (getStatusItem().equals(DISPONIVEL)) {
            setStatusItem(EMPRESTADO);
            leitor.getItensBiblioteca().add(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean reservar(Leitor leitor) {
        if (leitor == null) {
            return false;
        } else if (getStatusItem().equals(DISPONIVEL)) {
            setStatusItem(RESERVADO);
            leitor.getItensBiblioteca().add(this);
            return true;
        } else
            return false;
    }

    @Override
    public void marcarAtraso(Leitor leitor) {
        setStatusItem(ATRASADO);
        System.out.println(getTitulo() + " está atrasado");
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public StatusItem getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }
}
