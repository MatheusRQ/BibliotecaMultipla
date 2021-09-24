package br.com.BibliotecaMultipla.Categoria;

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
	};

	public abstract Integer categoriaId();

	public abstract String categoriaNome();

}
