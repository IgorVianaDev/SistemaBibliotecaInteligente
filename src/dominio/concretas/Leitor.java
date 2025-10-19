package dominio.concretas;

import dominio.abstratas.ItemBiblioteca;
import dominio.abstratas.Usuario;
import dominio.enumeracao.NivelUsuario;
import dominio.enumeracao.StatusItem;
import dominio.interfaces.Emprestavel;

import java.util.ArrayList;

import static dominio.enumeracao.StatusItem.DISPONIVEL;
import static dominio.enumeracao.StatusItem.EMPRESTADO;

public class Leitor extends Usuario {
    private ArrayList<ItemBiblioteca> item = new ArrayList<>();

    public Leitor(String nome, NivelUsuario nivelUsuario) {
        super(nome, nivelUsuario);
    }

    public Leitor(String nome, NivelUsuario nivelUsuario, ArrayList<ItemBiblioteca> item) {
        super(nome, nivelUsuario);
    }

    @Override
    public boolean podeGerenciar() {
        return false;
    }

    @Override
    public void imprimirDetalhes() {
        System.out.print("Nome: " + getNome() +
                " | Nivel: " + getNivelUsuario());
        if (item.isEmpty()) {
            System.out.print(" Nenhum item!");
        } else {
            System.out.print(" | ");
            for (ItemBiblioteca itens : item) {
                System.out.print(itens.getTitulo() + " | ");
            }
        }
        System.out.println();
    }

    public ArrayList<ItemBiblioteca> getItem() {
        return item;
    }

    public void setItem(ArrayList<ItemBiblioteca> item) {
        this.item = item;
    }
}

