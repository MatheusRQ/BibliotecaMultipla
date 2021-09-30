# BibliotecaMultipla

Arquivos do projeto "BibliotecaMultipla".

### Versão 0.1
Criação das classes "Animes", "GerenciadorDeListas";
criado teste automatizado por método main da serialização e deserialização da classe "Animes";
criação da classe "ColecoesTester", com um teste em JUnit para testar o retorno de uma Unmudifiablecollection e ver se ela soltaria uma Exception ao tentar adicionar itens nela.

### Versão 0.2
Mudança do nome da classe "Animes" para "AnimaçãoOriental";
criação da classe "AudioVisual" como o topo da hierarquia de classes;
criação da classe "ExportacaoTest", com métodos em JUnit para assegurar a serialização e deserialização das classes do projeto.

## Pós 17-09

### Versão 0.1
Recriação de todo o projeto, com base na utilização do JDBC;
criação da classe "FactoryConnection".

### Versão 0.2
Criação da classe "Categoria";
Criação e testagem da classe "CategoriaDAO".

### Versão 0.3
Criação do pacote "Pessoa";
criação da classe "Personagem;
criação da classe "Dublador";
atualização no banco de dados para ter a tabela mãe "Animacao" e as tabelas filhas "Animacao_N_Assistido" e "Animacao_Assistido";
criação do pacote "Identificador", com a interface "Identificacao" e a classe "Identificador", para englobar as regras de negocio referentes aos atributos "ID" e "Nome".

### Versão 0.4
Criação das classes "DubladorDAO" e "PersonagemDAO";
Criação da tabela "Dublagens" no BD;
Criação do método "FinalizarAnimação", que troca uma animação de "Não assistido" para "assistido", possibilitando a inserção de uma nota.

### Versão 0.5
Criação de uma tela interativa baseado no modelo MVC;
criação de um javadoc para o projeto;
criação de um documento explicativo sobre o projeto.
