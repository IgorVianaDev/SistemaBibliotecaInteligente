package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;
import dominio.interfaces.ControlaAtraso;

import static dominio.enumeracao.StatusItem.*;

public class Bibliotecario extends Usuario implements ControlaAtraso {
    public Bibliotecario(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }

    @Override
    public void imprimirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Nivel Usuário: " + getNivelUsuario());
    }


    public boolean emprestar(ItemBiblioteca itemBiblioteca,Leitor leitor) {
        if (podeGerenciar()){
            return itemBiblioteca.emprestar(leitor);
        }
        return false;
    }

    public boolean reservar(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        if (podeGerenciar()){
            return itemBiblioteca.reservar(leitor);
        }
        return false;
    }

    @Override
    public void marcarAtraso(ItemBiblioteca itemBiblioteca, Leitor leitor) {
        if (podeGerenciar()){
            itemBiblioteca.setStatusItem(ATRASADO);
        }
    }

    public void devolver(ItemBiblioteca itemBiblioteca, Leitor leitor){
        itemBiblioteca.devolver(leitor);
    }
}
