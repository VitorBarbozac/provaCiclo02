package orm.ddl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarTabela {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		factory.close();
	}
}
