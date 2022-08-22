package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.AdministerEvent;
import entities.Apprentice;
import entities.Course;
import entities.Event;
import entities.Mentor;
import entities.Organizer;
import entities.enums.CourseStatus;
import exceptions.DateException;
import utils.Util;

public class Program {

	static Scanner input = new Scanner(System.in);
	static List<Apprentice> apprentices;
	static List<Mentor> mentors;
	static List<Organizer> organizers;
	static SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		apprentices = new ArrayList<>();
		mentors = new ArrayList<>();
		organizers = new ArrayList<>();
		
		List<Course> listOne = new ArrayList<>();
		listOne.add(new Course("HTML e Css básico", "Rafael", CourseStatus.FINISHED));
		listOne.add(new Course("Loógica de programação", "Guilherme", CourseStatus.FINISHED));
		listOne.add(new Course("Java JRE e JDK", "Paulo", CourseStatus.IN_PROGRESS));
		listOne.add(new Course("JavaScript", "Vanessa", CourseStatus.NOT_STARTED));

		/* === Dados ficticios de Aprendizes === */
		apprentices.add(new Apprentice("Guilherme Mantz", "gui@gmail.com", "(19)123456789", "bolinho123", 600, listOne));
		/*apprentices.add(new Apprentice("Gustavo Silva", "gustavo@gmail.com", "(19)123456789", "macarrao234", 1200));
		apprentices.add(new Apprentice("Carlos Montes", "carlos@gmail.com", "(19)123456789", "cr230", 900));*/
		
		/* === Dados ficticios de mentores === */
		mentors.add(new Mentor("Vinicius Vueda", "vinicius@gmail.com", "(19)123456789", "blue2022"));
		mentors.add(new Mentor("Gabriel Cestaro", "gabriel@gmail.com", "(19)123456789", "cestaro404"));
		
		/* === Dados ficticios de Organizadores ===*/
		organizers.add(new Organizer("RH Bluesoft", "rh@gmail.com", "(19)123456789", "rhblue202"));
		
		operations();
	}

	public static void operations() {
		System.out.println("------------------------------------------------------");
		System.out.println("------Bem vindo ao Portal Movimento Codar 2022--------");
		System.out.println("------------------------------------------------------");
		System.out.println("***** Selecione uma opção de login *****");
		System.out.println("------------------------------------------------------");
		System.out.println("|  Opção 1 - Aprendiz    |");
		System.out.println("|  Opção 2 - Mentor      |");
		System.out.println("|  Opção 3 - Organizador |");
		System.out.println("|  Opção 4 - Sair        |");

		System.out.println();
		System.out.print("Opção: ");
		int selectedOption = input.nextInt();

		switch (selectedOption) {
		case 1:
			loginApprentice();
			break;
		case 2:
			loginMaster();
			break;
		case 3:
			loginMaster();
			break;
		case 4:
			System.out.println("Programa Finalizado!");
			System.exit(0);
		default:
			System.out.println("Opção inválida!");
			operations();
			break;
		}

	}

	private static void loginApprentice() {
		input.nextLine();
		System.out.println();
		System.out.println("------Bem vindo Aluno--------");
		System.out.println("Por favor informe seu email e senha para efetuar login");

		System.out.print("Email: ");
		String email = input.nextLine();
		
		while(Util.findEmail(apprentices, email) == false) {
			System.out.println("Email invalido ou não cadastrado");
			System.out.print("Digite novamente o email: ");
			email = input.nextLine();
		}
		
		Apprentice apprentice = (Apprentice) Util.getPeople(apprentices, email);
		
		System.out.print("Senha: ");
		String password = input.nextLine();

		while(apprentice.checkPassword(password) == false) {
			System.out.println("Senha invalida");
			System.out.print("Digite novamente a senha: ");
			password = input.nextLine();
		}
		System.out.println("Login Realizado com sucesso!");
		System.out.println();
		System.out.println("O que irá fazer?");
	
		optionsApprentice(apprentice);
		
	}
	
	private static void optionsApprentice(Apprentice apprentice) {
		System.out.println();
		System.out.println("|  Opção 1 - Ver todos os cursos      |");
		System.out.println("|  Opção 2 - Ver cursos Não iniciados |");
		System.out.println("|  Opção 3 - Ver cursos Em progresso  |");
		System.out.println("|  Opção 4 - Ver cursos concluidos    |");
		System.out.println("|  Opção 5 - Finalizar um curso       |");
		System.out.println("|  Opção 6 - Ver meu perfil        	  |");
		System.out.println("|  Opção 7 - Acessar chat             |");
		System.out.println("|  Opção 8 - Sair                     |");
		
		System.out.println();
		System.out.print("Opção: ");
		int selectedOption = input.nextInt();
		
		switch (selectedOption) {
		case 1:
			System.out.println(apprentice.getCourses());
			optionsApprentice(apprentice);
			break;
		case 2:
			System.out.println(apprentice.getNotStartedCourses());
			optionsApprentice(apprentice);
			break;
		case 3:
			System.out.println(apprentice.getInProgressCourses());
			optionsApprentice(apprentice);
			break;
		case 4:
			System.out.println(apprentice.getFinishedCourses());
			optionsApprentice(apprentice);
			break;
		case 5:
			System.out.print("Informe o número do curso: ");
			int numberCourse = input.nextInt();
			apprentice.finishCourse(numberCourse);
			
			optionsApprentice(apprentice);
			break;
		case 6:
			System.out.println(apprentice);
			optionsApprentice(apprentice);
			break;
		case 7:
			/* FAKE chat */
			input.nextLine();
			System.out.print("Digite sua duvida: ");
			String question = input.nextLine();
			
			System.out.println("Sua duvida: " + question + " foi postada");
			optionsApprentice(apprentice);
			
			break;
		case 8:
			System.out.println("Sessão Finalizada!");
			operations();
		default:
			System.out.println("Opção inválida!");
			optionsApprentice(apprentice);
			break;
		}
	}
	
	private static void loginMaster() {
		input.nextLine();
		System.out.println();
		System.out.println("------Bem vindo Mentor/Organizador --------");
		System.out.println("Por favor informe seu email e senha para efetuar login");

		System.out.print("Email: ");
		String email = input.nextLine();
		
		while(Util.findEmail(mentors, email) == false && Util.findEmail(organizers, email) == false) {
			System.out.println("Email invalido ou não cadastrado");
			System.out.print("Digite novamente o email: ");
			email = input.nextLine();
		}
		
		Organizer organizer = null;
		if(Util.findEmail(organizers, email)) {
			organizer = (Organizer) Util.getPeople(organizers, email);
		}
		
		Mentor mentor = (Mentor) Util.getPeople(mentors, email);
		
		System.out.print("Senha: ");
		String password = input.nextLine();
		
		if(organizer != null) {
			while(organizer.checkPassword(password) == false) {
				System.out.println("Senha invalida");
				System.out.print("Digite novamente a senha: ");
				password = input.nextLine();
			}
		} 
		else {
			while(mentor.checkPassword(password) == false) {
				System.out.println("Senha invalida");
				System.out.print("Digite novamente a senha: ");
				password = input.nextLine();
			}
		}
		
		System.out.println("Login Realizado com sucesso!");
		System.out.println();
		System.out.println("O que irá fazer?");
		
		if(organizer != null) {
			optionsMaster(organizer);
		}
		optionsMaster(mentor);
	}
	
	private static void optionsMaster(AdministerEvent people) {
		System.out.println();
		System.out.println("|  Opção 1 - Ver  eventos criados |");
		System.out.println("|  Opção 2 - Criar evento         |");
		System.out.println("|  Opção 3 - Editar evento        |");
		System.out.println("|  Opção 4 - Excluir evento  	  |");
		System.out.println("|  Opção 5 - Ver perguntas  	  |");
		System.out.println("|  Opção 6 - Ver meu perfil 	  |");
		System.out.println("|  Opção 7 - Sair           	  |");
		
		System.out.println();
		System.out.print("Opção: ");
		int selectedOption = input.nextInt();
		
		switch (selectedOption) {
		case 1:
			if(people.getListEvents().size() == 0) {
				System.out.println("Nenhum evento foi criado");
			}
			
			System.out.println(people.getListEvents());
			optionsMaster(people);
			
			break;
		case 2: 
			Event event = createEvent();
			people.addEvent(event);
			optionsMaster(people);
			
			break;
		case 3:
			System.out.print("Informe o número do evento: ");
			int numberEvent = input.nextInt();
			
			Event editEvent = people.getEventByNumber(numberEvent);

			while(editEvent == null) {
				System.out.println("Evento não encontrado!");
				numberEvent = input.nextInt();
				editEvent = people.getEventByNumber(numberEvent);
			}
			input.nextLine();
			System.out.print("Informe um novo nome para o evento: ");
			String newEventName = input.nextLine();
			
			System.out.print("Informe a data do evento (Dia/Mes/Ano): ");
			
			try {
				Date newDateEvent = formatDate.parse(input.next());
				people.editEvent(editEvent, newEventName, newDateEvent);
				System.out.println("Evento atualizado!");
				
				optionsMaster(people);
			}
			catch(ParseException ex) {
				throw new DateException("Formato de data invalido!");
			}
			
			break;
		case 4:
			input.nextLine();
			System.out.print("Informe o número do evento: ");
			numberEvent = input.nextInt();
			
			Event deleteEvent = people.getEventByNumber(numberEvent);

			while(deleteEvent == null) {
				System.out.println("Evento não encontrado!");
				numberEvent = input.nextInt();
				deleteEvent = people.getEventByNumber(numberEvent);
			}
			
			people.deleteEvent(deleteEvent);			
			optionsMaster(people);
			
			break;
		case 5:
			/*Exemplo de chat de perguntas*/
			System.out.println("Alguem pode me ajudar, estou com duvida em uma classe?");
			System.out.println();
			System.out.println("Qual a diferença de Exception e RuntimeException?");
			System.out.println();
			System.out.println("Quando vamos ver Java com Banco de dados?");
			
			optionsMaster(people);
			break;
		case 6:
			System.out.println(people);
			optionsMaster(people);
			break;
		case 7:
			System.out.println("Sessão Finalizada!");
			operations();
		default:
			System.out.println("Opção inválida!");
			optionsMaster(people);
			break;
		}
	}

	private static Event createEvent() {
		input.nextLine();
		
		System.out.println("Digite os dados do evento:");
		System.out.print("Nome: ");
		String name = input.nextLine();
		
		try {
			System.out.print("Data (Dia/Mes/Ano): ");
			Date data = formatDate.parse(input.next());
			Event event = new Event(name, data);
			
			System.out.println("Evento criado com sucesso!");
			return event;
		}
		catch(ParseException ex) {
			throw new DateException("Formato de data invalido!");
		}
		
	}

}
