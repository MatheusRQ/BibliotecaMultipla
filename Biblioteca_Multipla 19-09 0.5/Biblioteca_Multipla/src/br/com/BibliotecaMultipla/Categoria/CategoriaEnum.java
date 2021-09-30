package br.com.BibliotecaMultipla.Categoria;

/**
 * Classe que representa as categorias presentes no banco de dados em forma de
 * Enums.
 * 
 * @author Matheus
 * @version 0.3
 */
public enum CategoriaEnum {

	ANIMACAO_ORIENTAL {
		@Override
		public Integer categoriaId() {
			return 1;
		}

		@Override
		public String categoriaNome() {
			return "ANIMACAO_ORIENTAL";
		}
	},

	ANIMACAO_OCIDENTAL {

		@Override
		public Integer categoriaId() {
			return 1;
		}

		@Override
		public String categoriaNome() {
			return "ANIMACAO_OCIDENTAL";
		}

	},
	SERIADO {
		@Override
		public Integer categoriaId() {
			return 3;
		}

		@Override
		public String categoriaNome() {
			return "SERIADO";
		}
	},
	FILME {
		@Override
		public Integer categoriaId() {
			return 4;
		}

		@Override
		public String categoriaNome() {
			return "FILME";
		}
	},
	JOGO_ELETRONICO {
		@Override
		public Integer categoriaId() {
			return 5;
		}

		@Override
		public String categoriaNome() {
			return "JOGO_ELETRONICO";
		}
	};

	public abstract Integer categoriaId();

	public abstract String categoriaNome();

}
