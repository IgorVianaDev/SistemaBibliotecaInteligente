package test;

import dominio.concretas.*;

import java.util.ArrayList;

import static dominio.enumeracao.NivelUsuario.*;
import static dominio.enumeracao.StatusItem.*;

public class SistemaBibliotecarioTest01 {
    public static void main(String[] args) {
//        ArrayList<Livro> livrosDevolvidos = new ArrayList<>();
        ArrayList<Livro> livrosEmprestados = new ArrayList<>();
        Livro livro1 = new Livro("Cronicas de Narnia", 01, DISPONIVEL);
        Livro livro2 = new Livro("Cronicas de Jorde", 02, EMPRESTADO);
        Livro livro3 = new Livro("Harry Potter", 03, RESERVADO);
        Livro livro4 = new Livro("Código Limpo", 04, ATRASADO);

        Periodico periodico1 = new Periodico("p1",5,DISPONIVEL);
        Periodico periodico2 = new Periodico("p2",6,EMPRESTADO);
        Periodico periodico3 = new Periodico("p3",7,RESERVADO);
        Periodico periodico4 = new Periodico("p4",8,ATRASADO);

        Leitor leitor = new Leitor("Igor", LEITOR);
        Bibliotecario bibliotecario = new Bibliotecario("Vitor",BIBLIOTECARIO);
        Admin admin = new Admin("Micael",ADMIN);

        admin.emprestar(livro1, leitor);
        bibliotecario.devolver(livro1, leitor);
        /*livro1.emprestar(leitor);*/

        leitor.imprimirDetalhes();
        livro1.imprimirDetalhes();
    }
}
