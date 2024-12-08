package action;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;

public class ExcluirAluno {

	public static void main(String[] args) {
		String alunos = null;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(alunos);
		EntityManager manager = factory.createEntityManager();
		
		Aluno a1 = new Aluno();
		
		a1.setId(2);
		a1 = manager.find(Aluno.class, a1.getId());
		
		manager.getTransaction().begin();
		manager.remove(a1);
		manager.getTransaction().commit();
		
		System.out.println("Aluno excluido");
		
		manager.close();
		factory.close();
	}

}
