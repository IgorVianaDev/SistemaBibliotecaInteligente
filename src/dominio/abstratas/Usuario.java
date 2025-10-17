package dominio.abstratas;

import dominio.enumeracao.NivelUsuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

public abstract class Usuario implements Imprivel {
    private String nome;
    private NivelUsuario nivelUsuario;
    private StatusItem statusItem;

    public Usuario(String nome, NivelUsuario nivelUsuario) {
        this.nome = nome;
        this.nivelUsuario = nivelUsuario;
    }

    public abstract boolean podeGerenciar();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NivelUsuario getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(NivelUsuario nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
    }

    public StatusItem getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }
}
