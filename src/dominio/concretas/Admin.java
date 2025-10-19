package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;
import dominio.enumeracao.StatusItem;

import java.util.concurrent.ThreadPoolExecutor;

import static dominio.enumeracao.StatusItem.*;

public class Admin extends Usuario {

    public Admin(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }

    @Override
    public boolean podeGerenciar() {
        return true;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.print("Nome: " + getNome()+
                " | Nivel: " + getNivelUsuario());
    }

    public boolean emprestar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        if (itemBiblioteca == null || leitor == null) {
            return false;
        } else if (itemBiblioteca.getStatusItem().equals(DISPONIVEL)) {
            itemBiblioteca.setStatusItem(EMPRESTADO);
            leitor.getItem().add(itemBiblioteca);
            return true;
        }
        return false;
    }

    public boolean reservar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        if (itemBiblioteca == null || leitor == null) {
            return false;
        } else if (itemBiblioteca.getStatusItem().equals(DISPONIVEL)) {
            itemBiblioteca.setStatusItem(RESERVADO);
            leitor.getItem().add(itemBiblioteca);
            return true;
        } else
            return false;
    }

    public boolean atrasado(ItemBiblioteca itemBiblioteca, Leitor leitor){
        itemBiblioteca.setStatusItem(ATRASADO);
        return true;
    }

    public void devolver(ItemBiblioteca itemBiblioteca, Leitor leitor){
        itemBiblioteca.setStatusItem(DISPONIVEL);
        leitor.getItem().remove(itemBiblioteca);
        System.out.println(itemBiblioteca.getTitulo() + " Devolvido");
    }
}
