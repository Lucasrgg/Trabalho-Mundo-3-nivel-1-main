package model;

import java.io.IOException;

/**
 *
 * @author LucasRodrigues
 */

public class Main_01 {

    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1, "Fulano Ciclano", "123.456.789-00", 49));
        repo1.inserir(new PessoaFisica(2, "Beltrano da Silva", "987.654.321.11", 21));

        try {
            repo1.persistir("lukinha.fisica.bin");
            System.out.println("⁕Dados de Pessoa Física Armazenados.⁕");
        } catch (IOException e) {
            System.out.println("Erro ao persistir dados de pessoas físicas: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = null;
        try {
            repo2 = PessoaFisicaRepo.recuperar("lukinha.fisica.bin");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados de pessoas físicas: " + e.getMessage());
        }

        if (repo2 != null) {
            System.out.println("⁕Dados de pessoa física recuperada.⁕");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
            }
        }

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(3, "ronaldinho empreendedor", "32.632.644/0001-55"));
        repo3.inserir(new PessoaJuridica(4, "developers", "88.835.732/0001-66"));

        try {
            repo3.persistir("lukinha.juridica.bin");
            System.out.println("⁕Dados de Pessoa Jurídica Armazenados.⁕");
        } catch (IOException e) {
            System.out.println("Erro ao persistir dados de pessoas jurídicas: " + e.getMessage());
        }

        PessoaJuridicaRepo repo4 = null;
        try {
            repo4 = PessoaJuridicaRepo.recuperar("lukinha.juridica.bin");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados de pessoas jurídicas: " + e.getMessage());
        }

        if (repo4 != null) {
            System.out.println("⁕Pessoas Jurídicas Recuperadas.⁕");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                pessoa.exibir();

            }
        }
    }
}
