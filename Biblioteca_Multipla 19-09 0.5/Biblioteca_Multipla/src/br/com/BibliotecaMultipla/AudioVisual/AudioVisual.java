package br.com.BibliotecaMultipla.AudioVisual;

import java.sql.Timestamp;

import br.com.BibliotecaMultipla.Identificador.Identificacao;
import br.com.BibliotecaMultipla.Identificador.Identificador;

/**
 * Representa o corpo de um item Áudio visual
 * 
 * @author Matheus
 * @version 0.3
 */

public class AudioVisual implements Identificacao {

	private Identificador identificador;
	private Integer ano_de_lancamento;
	private String genero;
	private Timestamp data_de_registro;
	private Integer categoria;
	private String categoriaNome;

	/**
	 * Construtor para inicializar um objeto Audio visual a partir do id, nome, ano
	 * de lancamento, genero, data de registro e o nome da categoria. Somente é usado para
	 * pegar informacoes do Banco de Dados.
	 */
	public AudioVisual(Integer id, String nome, Integer ano_de_lancamento, String genero, Timestamp data_de_registro,
			String categoriaNome) {
		Identificador identificador = new Identificador(id, nome);
		this.identificador = identificador;
		this.ano_de_lancamento = ano_de_lancamento;
		this.genero = genero;
		this.data_de_registro = data_de_registro;
		this.categoriaNome = categoriaNome;
	}

	/**
	 * Construtor para inicializar um objeto Audio visual a partir do nome, ano de
	 * lancamento, genero, data de registro e categoria. Usado para inserir
	 * informacoes no Banco de Dados.
	 */
	public AudioVisual(String nome, Integer ano_de_lancamento, String genero, Integer categoria) {
		Identificador identificador = new Identificador(nome);
		this.identificador = identificador;
		this.ano_de_lancamento = ano_de_lancamento;
		this.genero = genero;
		this.categoria = categoria;
	}

	/**
	 * Construtor para inicializar um objeto Audio visual a partir do nome. Usado
	 * para pesquisas no Banco de Dados.
	 */
	public AudioVisual(String nome) {
		this.identificador = new Identificador(nome);
	}

	/**
	 * Construtor para inicializar um objeto Audio visual a partir do nome. Usado
	 * para pesquisas no Banco de Dados.
	 */
	public AudioVisual(Integer id) {
		this.identificador = new Identificador(id);
	}

	/**
	 * Metodo que retorna o id baseado na classe Identificador.
	 */
	@Override
	public Integer getId() {
		return this.identificador.getId();
	}

	/**
	 * Metodo que define o id baseado na classe Identificador.
	 */
	@Override
	public void setID(Integer id) {
		this.identificador.setId(id);
	}

	/**
	 * Metodo que retorna o nome baseado na classe Identificador.
	 */
	@Override
	public String getNome() {
		return this.identificador.getNome();
	}

	/**
	 * Metodo que define o nome baseado na classe Identificador.
	 */
	@Override
	public void setNome(String nome) {
		this.identificador.setNome(nome);
	}

	/**
	 * @return o ano de lancamento da animacao.
	 */
	public int getAno_de_lancamento() {
		return ano_de_lancamento;
	}

	/**
	 * @return o genero da animacao.
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * 
	 * @return a data e hora em que foi registrada o audio visual no banco de dados.
	 */
	public Timestamp getData_de_registro() {
		return data_de_registro;
	}

	public Integer getCategoria() {
		return categoria;
	}

	/**
	 * toString que busca o id, nome, ano de lancamento, genero, data de registro e
	 * categoria do audio visual
	 */
	@Override
	public String toString() {
		return "ID: " + this.getId() + ", nome: " + this.getNome() + ", Ano de Lançamento: " + this.ano_de_lancamento
				+ ", Generos: " + this.genero + ", Data de Registro: " + this.data_de_registro + ", Categoria: "
				+ this.categoriaNome;
	}

//	/**
//	 * Funcao usada para, a partir do nome de uma categoria, retornar seu respectivo
//	 * ID.
//	 * 
//	 * @param categoriaNome
//	 * @return
//	 */
//	public Integer retornaCategoriaID(String categoriaNome) {
//		List<CategoriaEnum> enums = new ArrayList<>(Arrays.asList(CategoriaEnum.values()));
//		Integer dado = 0;
//		for (CategoriaEnum categoriaEnum : enums) {
//			if (categoriaNome == categoriaEnum.categoriaNome())
//				dado = categoriaEnum.categoriaId();
//		}
//		return dado;
//	}
//	public String retornaCategoriaNome(Integer categoriaID) {
//		List<CategoriaEnum> enums = new ArrayList<>(Arrays.asList(CategoriaEnum.values()));
//		String nome = null;
//		for (CategoriaEnum categoriaEnum : enums) {
//			if(categoriaID == categoriaEnum.categoriaId())
//				nome = categoriaEnum.categoriaNome();
//			return nome;
//		}
//		return nome;
//	}

}
