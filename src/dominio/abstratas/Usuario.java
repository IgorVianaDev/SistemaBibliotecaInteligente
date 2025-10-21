package dominio.abstratas;

import dominio.concretas.Leitor;
import dominio.enumeracao.NivelUsuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.ControlaAtraso;
import dominio.interfaces.Emprestavel;
import dominio.interfaces.Imprivel;

import static dominio.enumeracao.StatusItem.ATRASADO;

public abstract class Usuario implements Imprivel , ControlaAtraso {
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

    @Override
    public void marcarAtraso(ItemBiblioteca itemBiblioteca, Leitor leitor){
        if (podeGerenciar()) {
            itemBiblioteca.setStatusItem(ATRASADO);
            System.out.println(leitor.getNome() + ", " + itemBiblioteca.getTitulo() + " está atrasado, por favor fazer a devolução.");
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
