package action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Aluno;

public class BuscarTodosAlunos {

	public static void main(String[] args) {
		EntityManagerFactory factory  = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		
		String sqlHibernate = "select a from Aluno as a";
		Query query  = manager.createQuery(sqlHibernate);
		
		@SuppressWarnings("unchecked")
		List<Aluno> listaAlunos = query.getResultList();
		
		System.out.println("Alunos cadastrados");
		for (Aluno a : listaAlunos) {
			System.out.println("Aluno: "+a.getnome());
		}
		
		manager.close();
		factory.close();

	}

}
