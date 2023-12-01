package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Aluno;

public class AtualizarAluno {
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Informe o id do Aluno: ");
			aluno.setId(sc.nextLong());
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
			EntityManager manager = factory.createEntityManager();
			
			aluno = manager.find(Aluno.class, aluno.getId());
			if (aluno != null) {
				
				System.out.println(aluno.toString());
				System.out.println("\n\nInforme as informações do aluno que serão atualizadas atualizado:\n(Deixe em branco para manter o valor atual)");
				
				sc.nextLine();
				System.out.println("\nNome: ");
				String nome = sc.nextLine();
				if (!nome.isBlank()) {
					aluno.setNome(nome);
				}

				System.out.println("CPF: ");
				String cpf = sc.nextLine();
				if (!cpf.isBlank()) {
					aluno.setCPF(cpf);
				}

				System.out.println("Email: ");
				String email = sc.nextLine();
				if (!email.isBlank()) {
					aluno.setEmail(email);
				}

				System.out.println("Endereço: ");
				String endereco = sc.nextLine();
				if (!endereco.isBlank()) {
					aluno.setEndereco(endereco);
				}

				System.out.println("Naturalidade: ");
				String naturalidade = sc.nextLine();
				if (!naturalidade.isBlank()) {
					aluno.setNaturalidade(naturalidade);
				}

				System.out.println("DataNascimento: ");
				String dataNascimento = sc.nextLine();
				if (!dataNascimento.isBlank()) {
					aluno.setDataNascimento(dataNascimento);
				}

				manager.getTransaction().begin();
				manager.merge(aluno);
				manager.getTransaction().commit();

				System.out.println("Informações atualizadas");
				
			} else {
				System.err.println("Id do aluno não encontrado");
			}
			sc.close();
			manager.close();
			factory.close();
		} catch (NumberFormatException e) {
			System.err.println("Valor Invalido");
		}
	}
}
