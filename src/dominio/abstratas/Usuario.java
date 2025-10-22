package dominio.abstratas;

import dominio.concretas.Leitor;
import dominio.enumeracao.NivelUsuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.ControlaAtraso;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

import static dominio.enumeracao.StatusItem.ATRASADO;

public abstract class Usuario implements Imprivel {
    private String nome;
    private NivelUsuario nivelUsuario;

    public Usuario(String nome, NivelUsuario nivelUsuario) {
        this.nome = nome;
        this.nivelUsuario = nivelUsuario;
    }

    public boolean podeGerenciar(){
        if (getNivelUsuario().equals(NivelUsuario.ADMIN) ||getNivelUsuario().equals(NivelUsuario.BIBLIOTECARIO)){
            return true;
        } else {
            System.out.println("Acesso negado!");
            return false;
        }
    }

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

}
