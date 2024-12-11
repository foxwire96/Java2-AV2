package action;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Aluno;

public class InserirAlunoTeste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Seja bem vindo");
        System.out.print("Insira seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Insira seu email: ");
        String email = sc.nextLine();
        System.out.print("Insira seu CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Insira sua data de nascimento: ");
        String nascimento = sc.nextLine();
        System.out.print("Insira sua naturalidade: ");
        String naturalidade = sc.nextLine();
        System.out.println("Insira seu endereço: ");
        String endereco = sc.nextLine();
        Aluno aluno = new Aluno();
        
        aluno.setnome(nome);
        aluno.setEmail(email);
        aluno.setCpf(cpf);
        aluno.setnascimento(nascimento);
        aluno.setNaturalidade(naturalidade);
        aluno.setEndereco(endereco);
        
        System.out.println("Aluno registrado com sucesso");
        sc.close();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
		EntityManager manager = factory.createEntityManager();
		

		manager.getTransaction().begin();
		manager.persist(aluno);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
		
		System.out.println("Aluno inserido, ID: "+aluno.getId());
    }

}