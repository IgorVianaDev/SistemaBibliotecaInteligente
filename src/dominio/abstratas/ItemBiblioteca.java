package dominio.abstratas;

import dominio.enumeracao.StatusItem;
import dominio.interfaces.Imprivel;

public abstract class ItemBiblioteca implements Imprivel {
    protected String titulo;
    protected int codigo;
    protected StatusItem statusItem;

    public ItemBiblioteca(String titulo, int codigo, StatusItem statusItem) {
        this.titulo = titulo;
        this.codigo = codigo;
        this.statusItem = statusItem;
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
