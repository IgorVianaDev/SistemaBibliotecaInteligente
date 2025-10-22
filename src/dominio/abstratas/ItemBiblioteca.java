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
        boolean removido = leitor.getItensBiblioteca().removeIf(itemBiblioteca -> itemBiblioteca.equals(itemBiblioteca));
        if (removido){
            setStatusItem(DISPONIVEL);
            System.out.println(getTitulo() + " Devolvido");
        } else{
            System.out.println("Você não possui esse livro!");
        }
    }
    @Override
    public boolean emprestar(Leitor leitor){
        if (leitor == null) {
            return false;
        } else if (getStatusItem().equals(DISPONIVEL)) {
            setStatusItem(EMPRESTADO);
            leitor.getItensBiblioteca().add(this);
            return true;
        } else if (getStatusItem().equals(EMPRESTADO)) {
            System.out.println("Livro já está emprestado!");
            return false;
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
    public void marcarAtraso(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        setStatusItem(ATRASADO);
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
