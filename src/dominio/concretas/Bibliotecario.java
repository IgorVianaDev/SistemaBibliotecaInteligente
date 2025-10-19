package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;

import static dominio.enumeracao.StatusItem.*;
import static dominio.enumeracao.StatusItem.ATRASADO;

public class Bibliotecario extends Usuario {
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
        return true;
    }

    public boolean emprestar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        if (itemBiblioteca == null || leitor == null) {
            return false;
        }
        return itemBiblioteca.emprestar(leitor);
    }

    public boolean reservar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        if (itemBiblioteca == null || leitor == null) {
            return false;
        } else if (itemBiblioteca.equals(DISPONIVEL)) {
            itemBiblioteca.setStatusItem(RESERVADO);
            leitor.getItem().add(itemBiblioteca);
            return true;
        }
        return false;
    }

    public boolean atrasado(ItemBiblioteca itemBiblioteca) {
        itemBiblioteca.setStatusItem(ATRASADO);
        return true;
    }

    public void devolver(ItemBiblioteca itemBiblioteca, Leitor leitor){
        itemBiblioteca.setStatusItem(DISPONIVEL);
        leitor.getItem().remove(itemBiblioteca);
        System.out.println(itemBiblioteca.getTitulo() + " Devolvido");
    }
}
