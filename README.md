![image](https://user-images.githubusercontent.com/38586541/170346215-9c8b6a24-1324-4a72-a05f-026d2353808c.png)
# Desafio Mobile2You
Utilizando a [API do The Movie DB](https://developers.themoviedb.org/3/getting-started/introduction), você deverá implementar o fluxo de exibição de alguns filmes e a tela de detalhe.

## Escopo

O desafio consiste em fazer 3 telas de um app de catálogo de filmes:
- A primeira é uma splash screen;
- A segunda é uma tela que apresentará 4 listas com os seguintes tipos de filmes: em exibição,
melhores avaliados, em breve, e mais populares;
- A terceira tela é a tela de detalhes do filme.
Para a navegação, deverá ser da seguinte forma:
- Da splash para a tela de listas: será automático depois de um tempo exibindo o logo;
- Da tela de listas para a tela de detalhes: será após um item (filme) ser clicado;
- Botão voltar: Quando na tela de detalhe, deve voltar para a tela de lista, e quando na tela de
lista, o app deve fechar

## Layout

Você encontrará o design no [Figma](https://www.figma.com/file/lcEPPAV3Caq0AhtDMZJ8Kq/Processos-Seletivos?node-id=2%3A2). Mais para o final deste documento tem algumas dicas de como usar o
Figma como consulta.

## Requisitos
Aqui está a lista de requisitos. A lista está na ordem do mais fácil ao mais difícil. Os items de 1 a 11 são
obrigatórios. Os Requisitos são:
- [x] O projeto deve ser desenvolvido na versão estável mais atual do Android Studio (NÃO use
versões Canary);
- [x] O projeto deve ser versionado usando Git;
- [x] Disponibilize o desafio no Github e envie o link do repositório para o recrutador ao final do
desenvolvimento;
- [x] A versão final deve estar na branch master ou main;
- [x] Use Kotlin como principal linguagem;
- [x] A splash screen deve durar de 1,5s à 3s;
- [x] Para a tela de listas use os endpoints:
  - Get Now Playing;
  - Get Top Rated;
  - Get Upcoming;
  - Get Popular.
- [ ] Para a tela de detalhes use os endpoints:
  - Get Details;
  - Get Similar Movies;
  - Get Reviews.
- [ ] Também para a tela de detalhes:
  - O Get Details retorna a duração (atributo “runtime”) em minutos, converta para o padrão “X horas(s) Y minuto(s)”;
  - Nas reviews, faça com que a review tenha no máximo 3 linhas;
- [ ] Os possíveis erros de api devem ser tratados e exibidos ao usuário, por toast, modal, tela dedicada a erro, etc...
- [ ] Deve utilizar alguma arquitetura, como por exemplo: MVP, MVVM, Clean Architecture ou afins;
- [x] Se possível, use ViewBinding/DataBinding;
- [x] Se possível, use Repository Pattern;
- [x] Se possível, utilize programação reativa para consumo de API (Coroutines ou RxJava);
- [x] Se possível, use injeção de dependências, como por exemplo: Hilt, Koin ou Dagger
- [ ] Se possível, escreva testes unitários.


## Dicas

- Não se preocupe caso não consiga concluir todos os requisitos. Nos mande o que você conseguir, visto que a ideia é que todos os requisitos sejam alcançados por candidatos de nível Pleno;
- Avaliaremos o quão próximo as telas do app estão do design;
- Olharemos os seus commits, escreva-os bem;
- Também avaliamos a organização de diretórios e pacotes do seu projeto. Separe bem as responsabilidades;
- Somos muito criteriosos em relação a nomes de variáveis, classes, métodos, arquivos e afins.
- Fique livre caso queira acrescentar algo ao projeto, como animações, transições de telas estilizadas e afins. Porém não mude o escopo ou o design;
- BuildSrc é bem vindo;
- Você será melhor avaliado se aplicar bastante os fundamentos de Orientação a Objeto e Programação Funcional;
- Tente usar os frameworks do Android Jetpack;
- Pode usar Compose para os layouts se achar mais conveniente. Caso opte por essa opção, o
requisito ViewBinding/DataBinding não é necessário;
- Não há necessidade de mudar o appicon, mas se quiser será bem vindo;
- Dê o nome que quiser ao app;
- As responses dos endpoints Get Now Playing, Get Top Rated, Get Upcoming, Get Popular e Get Similar Movies são as mesmas, com isso é possível reutilizar o mesmo modelo e o mesmo adapter poupando tempo e esforço.
