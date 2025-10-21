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
        return itemBiblioteca.emprestar(leitor);
    }

    public boolean reservar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        return itemBiblioteca.reservar(leitor);
    }

    /*public boolean marcarAtraso(ItemBiblioteca itemBiblioteca, Leitor leitor){
        itemBiblioteca.setStatusItem(ATRASADO);
        return true;
    }
*/
    public void devolver(ItemBiblioteca itemBiblioteca, Leitor leitor){
        itemBiblioteca.setStatusItem(DISPONIVEL);
        leitor.getItensBiblioteca().remove(itemBiblioteca);
        System.out.println(itemBiblioteca.getTitulo() + " Devolvido");
    }
}
