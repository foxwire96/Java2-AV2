package action;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;

public class AlterarAluno {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setId(3);
		aluno.setCpf("159.458.789.85");
		aluno.setEmail("Joana@email.com");
		aluno.setnascimento("Rio de Janeiro");
		aluno.setNaturalidade("Brasileira");
		aluno.setnome("Joana");
		aluno.setEndereco("Avenida Brasil");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(aluno);
		manager.getTransaction().commit();
		
		System.out.println("Aluno alterado");
		
		manager.close();
		factory.close();

	}

}
