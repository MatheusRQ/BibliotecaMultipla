package br.com.BibliotecaMultipla.Pessoa;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.BibliotecaMultipla.AudioVisual.AudioVisual;
import br.com.BibliotecaMultipla.Identificador.Identificacao;
import br.com.BibliotecaMultipla.Identificador.Identificador;

/**
 * Represeta um Dublador
 * 
 * @author Matheus
 * @version 0.2
 **/
public class Dublador implements Identificacao {

	Identificador identificador;
	private Date dataDeNascimento;
	private Map<Personagem, AudioVisual> dublagens = new HashMap<>();

	public Dublador(Integer id, String nome, Date dataDeNascimento) {
		this.identificador = new Identificador(id, nome);
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setDublagens(Map<Personagem, AudioVisual> dublagens) {
		this.dublagens = dublagens;
	}

	@Override
	public String getNome() {
		return this.identificador.getNome();
	}

	@Override
	public Integer getId() {
		return this.identificador.getId();
	}

	@Override
	public void setID(Integer id) {
		this.identificador.setId(id);

	}

	@Override
	public void setNome(String nome) {
		this.identificador.setNome(nome);

	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	

}
