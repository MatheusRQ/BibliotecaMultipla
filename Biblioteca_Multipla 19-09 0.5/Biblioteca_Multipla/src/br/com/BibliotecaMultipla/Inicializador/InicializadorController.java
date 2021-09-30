package br.com.BibliotecaMultipla.Inicializador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import br.com.BibliotecaMultipla.AudioVisual.Animacao;
import br.com.BibliotecaMultipla.AudioVisual.Animacao_Assistido;
import br.com.BibliotecaMultipla.AudioVisual.Animacao_N_Assistido;
import br.com.BibliotecaMultipla.AudioVisual.AudioVisual;
import br.com.BibliotecaMultipla.Categoria.CategoriaEnum;
import br.com.BibliotecaMultipla.Controller.AnimacaoController;
import br.com.BibliotecaMultipla.Controller.DubladorController;
import br.com.BibliotecaMultipla.Controller.PersonagemController;
import br.com.BibliotecaMultipla.Pessoa.Dublador;
import br.com.BibliotecaMultipla.Pessoa.Dublagens;
import br.com.BibliotecaMultipla.Pessoa.Personagem;

/**
 * Classe responsavel por, a partir dos controladores, rodar o programa. Ela e
 * basiada na ideia de uma View, e funciona como a tela do programa.
 * 
 * @author Matheus
 *
 */
public class InicializadorController {

	private Scanner sc;
	private Integer escolha;
	private Double nota;
	private String nome;
	private String genero;
	private String linhaVazia; // String usada no comando para evitar o bug do scanner que pula o nextLine
	private List<CategoriaEnum> enums = new ArrayList<>(Arrays.asList(CategoriaEnum.values()));
	private Integer categoria;
	private Integer ano;
	private Integer episodios;
	private Integer id;

	/**
	 * Construtor do objeto que iniciara o programa, setara a nacionalidade
	 * escolhida para a pontuacao (US) e iniciara o scanner.
	 */
	public InicializadorController() {
		sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		this.Inicio();
	}

	/**
	 * Metodo que comeca o programa. Ele dara as opcoes sobre qual tipo de tabela se
	 * quer trabalhar: Animacoes, Dubladores ou Personagens.
	 */
	private void Inicio() {
		System.out.println("Bem vindo a Biblioteca Multipla");
		System.out.println("Por favor, selecione a categoria com que quer interagir: ");
		System.out.println("1 - Animacoes, 2 - Dubladores, 3 - Personagens");
		try {
			this.escolha = this.sc.nextInt();

			switch (this.escolha) {
			case 1:
				this.escolhaAnimacoes();
				break;

			case 2:
				this.escolhaDubladores();
				break;

			case 3:
				this.escolhaPersonagens();
				break;

			default:
				System.out.println("Opcao invalida!");
				break;
			}

		} catch (InputMismatchException e) {
			System.out.println("Opcao ou informacao invalida!");
		}

		System.out.println("Fim do programa!");
		sc.close();
	}

	/**
	 * Metodo iniciado ao se escolher trabalhar com animacoes. Ele perguntara qual
	 * tipo de animacao se quer trabalhar: Animacoes assistidas ou Nao assistidas.
	 * Ele tambem dara a opcao de voltar.
	 */
	private void escolhaAnimacoes() {
		System.out.println("Escolha o tipo:");
		System.out.println("1 - Animacoes Assistidas; 2 - Animacoes nao assistidas; 3 - voltar");
		this.escolha = this.sc.nextInt();
		switch (escolha) {
		case 1:
			this.escolhaAnimacoesAssistidos();
			break;

		case 2:
			this.escolhaAnimacoesNaoAssistidas();
			break;

		case 3:
			this.Inicio();
			break;

		default:
			System.out.println("Opção invalida!");
			break;
		}
	}

	/**
	 * Metodo iniciado ao se escolher tabalhar com animacoes nao assistas pelo
	 * usuario. Ele dara a opcao de lista-las, registra-las ou de voltar.
	 */
	private void escolhaAnimacoesAssistidos() {
		System.out.println("1 - Listar animacoes; 2 - Registrar animacao; 3 - voltar");
		this.escolha = this.sc.nextInt();
		switch (escolha) {
		case 1:
			Collection<Animacao_Assistido> colecao = new AnimacaoController().listarAssistidos();
			colecao.forEach(System.out::println);
			break;

		case 2:
			System.out.print("Insira o nome do anime: ");
			linhaVazia = this.sc.nextLine(); 
			this.nome = this.sc.nextLine();
			System.out.print("Insira o ano de lancamento: ");
			this.ano = this.sc.nextInt();
			System.out.print("Insira o(s) genero(s): ");
			this.linhaVazia = this.sc.nextLine();
			this.genero = this.sc.nextLine();
			System.out.println("Insira a categoria que deseja: ");
			for (CategoriaEnum categoriaEnum : this.enums) {
				System.out.println(categoriaEnum.categoriaId() + " - " + categoriaEnum.categoriaNome());
			}
			this.categoria = this.sc.nextInt();
			System.out.print("Insira o numero de episodios: ");
			this.episodios = this.sc.nextInt();
			System.out.print(
					"Insira sua nota entre 0 e 10 (Pode-se usar numeros quebrados, desde que separados por “.”): ");
			this.nota = sc.nextDouble();
			Animacao_Assistido assistido = new Animacao_Assistido(nome, ano, genero, categoria, episodios, nota);
			new AnimacaoController().salvarAssistido(assistido);
			break;

		case 3:
			this.escolhaAnimacoes();
			break;

		default:
			System.out.println("Opção invalida!");
			break;
		}

	}

	/**
	 * Metodo iniciado ao se escolher tabalhar com animacoes assistas pelo usuario.
	 * Ele dara a opcao de lista-las, registra-las, termina-las ou de voltar.
	 */
	private void escolhaAnimacoesNaoAssistidas() {
		Collection<Animacao_N_Assistido> colecao;

		System.out.println("1 - Listar animacoes; 2 - Registrar animacao; 3 - Finalizar animacao; 4 - voltar");
		this.escolha = this.sc.nextInt();
		switch (escolha) {
		case 1:
			colecao = new AnimacaoController().listarNaoAssistidos();
			colecao.forEach(System.out::println);
			break;

		case 2:
			System.out.print("Insira o nome do anime: ");
			this.linhaVazia = this.sc.nextLine(); // Comando para evitar o bug do scanner que pula o nextLine
			this.nome = this.sc.nextLine();
			System.out.print("Insira o ano de lancamento: ");
			this.ano = this.sc.nextInt();
			System.out.print("Insira o(s) genero(s): ");
			this.linhaVazia = this.sc.nextLine(); // Comando para evitar o bug do scanner que pula o nextLine
			this.genero = this.sc.nextLine();
			System.out.println("Insira a categoria que deseja: ");
			for (CategoriaEnum categoriaEnum : this.enums) {
				System.out.println(categoriaEnum.categoriaId() + " - " + categoriaEnum.categoriaNome());
			}
			this.categoria = this.sc.nextInt();
			System.out.print("Insira o numero de episodios: ");
			this.episodios = this.sc.nextInt();
			System.out.println("Insira a prioridade:");
			System.out.println(
					"1 - “++” (Elevada); 2 - “+” (Alta); 3 - “=” (neutra); 4 - “-” (baixa); 5 - “--” (Muito baixa)");
			this.escolha = this.sc.nextInt();
			String prioridade = null;
			switch (escolha) {
			case 1:
				prioridade = "++";
				break;

			case 2:
				prioridade = "+";
				break;

			case 3:
				prioridade = "=";
				break;

			case 4:
				prioridade = "-";
				break;

			case 5:
				prioridade = "--";
				break;

			default:
				System.out.println("Opção invalida!");
				break;
			}

			System.out.println("Insira a relevancia: “S”, “A”, “B”, “C”, “D”");
			this.linhaVazia = this.sc.nextLine();
			String relevancia = this.sc.nextLine();

			Animacao_N_Assistido animacao_N_Assistido = new Animacao_N_Assistido(nome, ano, genero, categoria,
					episodios, prioridade, relevancia);
			new AnimacaoController().salvarNaoAssistido(animacao_N_Assistido);
			break;

		case 3:
			colecao = new AnimacaoController().listarNaoAssistidos();
			colecao.forEach(System.out::println);
			System.out.print("Insira o ID da animacao: ");
			this.id = this.sc.nextInt();
			System.out.print(
					"Insira a nota que quer dar para a animacao entre 0 e 10 (numeros quebrados sao permitidos usando “.”): ");
			this.nota = this.sc.nextDouble();
			new AnimacaoController().finalizacaoDeAnimacao(id, nota);
			break;

		case 4:
			this.escolhaAnimacoes();
			break;

		default:
			System.out.println("Opção invalida!");
			break;
		}

	}

	/**
	 * Metodo iniciado ao se escolher tabalhar a tabela de dubladores. Ele dara a
	 * opcao de lista-los, registra-los, listar as dublagens de um dublador em
	 * particular ou de voltar.
	 */
	private void escolhaDubladores() {
		Collection<Dublador> dubladores;
		System.out.println("1 - Listar dubladores; 2 - Registrar dublador; 3 - Listar Dublagens ; 4 - voltar");
		this.escolha = this.sc.nextInt();

		switch (escolha) {
		case 1:
			dubladores = new DubladorController().listarDubladores();
			dubladores.forEach(System.out::println);
			break;

		case 2:
			System.out.print("Insira o nome do dublador: ");
			this.linhaVazia = this.sc.nextLine();
			this.nome = this.sc.nextLine();
			System.out.println("Insira a data de nascimento: ");
			System.out.print("dia: ");
			Integer dia = this.sc.nextInt();
			System.out.print("mes: ");
			Integer mes = this.sc.nextInt();
			System.out.print("ano: ");
			Integer ano = this.sc.nextInt();
			Date date = Date.valueOf(String.format("%04d-%02d-%02d", ano, mes, dia));
			Dublador dublador = new Dublador(nome, date);
			new DubladorController().registrarDublador(dublador);
			break;

		case 3:

			DubladorController controller = new DubladorController();
			dubladores = controller.listarDubladores();
			dubladores.forEach(System.out::println);
			System.out.print("Selecione o ID do dublador que quer pesquisar: ");
			this.id = this.sc.nextInt();
			Map<Personagem, AudioVisual> mapa = new HashMap<>(controller.listarDublagens(id));

			for (Entry<Personagem, AudioVisual> entry : mapa.entrySet()) {
				System.out.println(
						"Personagem: " + entry.getKey().getNome() + ", Audio Visual: " + entry.getValue().getNome());
			}

			break;

		case 4:
			this.Inicio();
			break;

		default:
			System.out.println("Opção invalida!");
			break;
		}

	}

	/**
	 * Metodo iniciado ao se escolher tabalhar a tabela de personagens. Ele dara a
	 * opcao de lista-los, registra-los ou de voltar. Note-se que, ao se registrar
	 * um personagem, uma lista de audio-visuais e dubladores/atores sera mostrada,
	 * para que o usuario insira os que tiverem relacao com o personagem.
	 */
	private void escolhaPersonagens() {
		System.out.println("1 - Listar personagens; 2 - Registrar personagem; 3 - voltar");
		this.escolha = this.sc.nextInt();
		switch (escolha) {
		case 1:
			Collection<Personagem> personagens = new PersonagemController().listarPersonagens();
			personagens.forEach(System.out::println);
			break;

		case 2:
			PersonagemController controller = new PersonagemController();
			System.out.print("Insira o nome: ");
			this.linhaVazia = this.sc.nextLine();
			this.nome = this.sc.nextLine();
			Dublagens dublagens = controller.devolveDublagem();
			Collection<Animacao> animacoes = dublagens.getAnimacoes();
			animacoes.forEach(System.out::println);
			System.out.print("Selecione o id da origem do personagem: ");
			Integer origem = this.sc.nextInt();
			Collection<Dublador> dubladores = dublagens.getDubladores();
			dubladores.forEach(System.out::println);
			System.out.print("Selecione o id do dublador do personagem: ");
			Integer dubladorPersonagem = this.sc.nextInt();

			Personagem personagem = new Personagem(nome, dubladorPersonagem, origem);
			controller.registrarPersonagem(personagem);
			break;

		case 3:
			this.Inicio();
			break;

		default:
			System.out.println("Opção invalida!");
			break;
		}

	}
}
