package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;
import dominio.interfaces.Emprestavel;

import java.security.spec.ECField;

import static dominio.enumeracao.StatusItem.*;
import static dominio.enumeracao.StatusItem.ATRASADO;

public class Bibliotecario extends Usuario{
    public Bibliotecario(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Nivel Usuário: " + getNivelUsuario());
    }
    @Override
    public boolean podeGerenciar() {
        return false;
    }


    public boolean emprestar(ItemBiblioteca itemBiblioteca,Leitor leitor) {
        return itemBiblioteca.emprestar(leitor);
    }

    public boolean reservar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        return itemBiblioteca.reservar(leitor);
    }

    public boolean atrasado(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        itemBiblioteca.marcarAtraso(leitor);
        return true;
    }

    public void devolver(ItemBiblioteca itemBiblioteca, Leitor leitor){
        itemBiblioteca.setStatusItem(DISPONIVEL);
        leitor.getItensBiblioteca().remove(itemBiblioteca);
        System.out.println(itemBiblioteca.getTitulo() + " Devolvido");
    }
}
