# Modelo de Domínio — MinhaVaga

**Versão:** 1.0  
**Status:** Proposta para aprovação antes do código  
**Data:** 17/11/2026  
**Fase:** Núcleo em Java puro, com migração posterior para Spring Boot  
**Documento relacionado:** `docs/PRD.md`, versão 1.1

---

## 1. Objetivo

Este documento traduz as regras do PRD para um modelo de domínio que possa ser implementado primeiro em Java puro e, posteriormente, migrado para Spring Boot sem reescrever as regras principais.

O modelo deve permitir, na versão 0.1:

- cadastrar uma oportunidade;
- listar oportunidades;
- pesquisar por empresa ou cargo;
- consultar detalhes;
- editar dados;
- alterar o status;
- criar e consultar o histórico de status;
- excluir uma oportunidade;
- validar as principais regras de negócio.

A primeira implementação armazenará os dados em memória com `ArrayList`. Persistência em PostgreSQL, API REST e interface React serão adicionadas em fases posteriores.

---

## 2. Princípios de modelagem

1. A classe `Oportunidade` protege o próprio estado e suas invariantes.
2. O histórico não pode depender da interface ou da classe `Main`.
3. A classe `Main` recebe entradas e apresenta saídas, mas não concentra regras de negócio.
4. O gerenciador coordena a coleção de oportunidades, buscas e exclusões.
5. Os valores fechados são representados por `enum`.
6. Datas de negócio usam `LocalDate`; registros de momento usam `LocalDateTime`.
7. Nenhuma classe da fase Java puro deve depender do Spring.
8. Métodos devem representar ações do domínio, evitando setters públicos indiscriminados.
9. O código deve permanecer simples o suficiente para ser explicado e testado pelo mantenedor.

---

## 3. Visão geral

```text
Main
  |
  v
GerenciadorOportunidades
  |
  +---- mantém ----> List<Oportunidade>
                          |
                          +---- possui ----> List<HistoricoStatus>

Oportunidade usa:
- StatusOportunidade
- OrigemVaga
- PlataformaCandidatura
- ModalidadeTrabalho
```

### Relações

- Um `GerenciadorOportunidades` mantém zero ou várias oportunidades.
- Uma `Oportunidade` possui zero ou vários registros de histórico.
- Um `HistoricoStatus` pertence a exatamente uma oportunidade conceitualmente.
- Na fase Java puro, o histórico não precisa guardar uma referência de volta para a oportunidade, pois já ficará dentro dela.
- Na migração para JPA, a relação será modelada como `Oportunidade 1:N HistoricoStatus`.

---

## 4. Entidade `Oportunidade`

### 4.1 Responsabilidade

Representar uma vaga encontrada e proteger as regras relacionadas aos seus dados e ao seu estado atual.

### 4.2 Atributos

```java
private Long id;
private String empresa;
private String cargo;
private String link;
private OrigemVaga origemVaga;
private PlataformaCandidatura plataformaCandidatura;
private ModalidadeTrabalho modalidade;
private String localidade;
private LocalDate dataEncontrada;
private LocalDate dataCandidatura;
private StatusOportunidade status;
private String descricao;
private String observacoes;
private LocalDateTime criadaEm;
private LocalDateTime atualizadaEm;
private List<HistoricoStatus> historicos;
```

### 4.3 Obrigatoriedade

| Atributo | Regra |
|---|---|
| `id` | Gerado pelo `GerenciadorOportunidades` na fase Java puro. |
| `empresa` | Obrigatório; não aceita `null`, vazio ou somente espaços. |
| `cargo` | Obrigatório; não aceita `null`, vazio ou somente espaços. |
| `status` | Obrigatório; começa como `SALVA` quando não informado na criação simples. |
| `dataCandidatura` | Obrigatória a partir de `CANDIDATURA_ENVIADA`, exceto `ENCERRADA` quando a vaga nunca recebeu candidatura. |
| `plataformaCandidatura` | Obrigatória a partir de `CANDIDATURA_ENVIADA`; `NAO_SEI` é um valor válido. |
| demais campos | Opcionais na versão 0.1. |

`Empresa confidencial` será um texto válido para vagas em que a organização contratante não foi revelada.

### 4.4 Construtor inicial recomendado

A primeira etapa didática utilizará um construtor pequeno:

```java
public Oportunidade(Long id, String empresa, String cargo)
```

Comportamento esperado:

- valida `id`, `empresa` e `cargo`;
- remove espaços externos de empresa e cargo;
- define `status` como `SALVA`;
- define `modalidade` como `NAO_INFORMADO`;
- inicializa `historicos` como lista vazia;
- preenche `criadaEm` e `atualizadaEm` com o horário atual;
- registra a criação inicial no histórico como `SALVA`.

Quando avançarmos, os demais dados serão recebidos por métodos de atualização ou por um objeto de entrada específico. Não criaremos agora um construtor com quinze parâmetros.

### 4.5 Comportamentos públicos planejados

```java
public void atualizarInformacoes(...)
public void registrarCandidatura(
    LocalDate dataCandidatura,
    PlataformaCandidatura plataforma,
    String observacao
)
public boolean alterarStatus(
    StatusOportunidade novoStatus,
    String observacao
)
public boolean estaFinalizada()
public boolean correspondePesquisa(String termo)
public List<HistoricoStatus> consultarHistorico()
```

### 4.6 Comportamentos privados planejados

```java
private void validarTextoObrigatorio(String valor, String nomeCampo)
private void validarDataCandidatura(LocalDate data)
private void validarDadosParaStatus(StatusOportunidade status)
private void registrarHistorico(
    StatusOportunidade statusAnterior,
    StatusOportunidade statusNovo,
    String observacao
)
private void marcarComoAtualizada()
```

### 4.7 Encapsulamento

Não serão criados setters públicos para todos os atributos. Alterações devem passar por métodos que expressem intenção.

Exemplos:

```java
oportunidade.registrarCandidatura(data, plataforma, observacao);
oportunidade.alterarStatus(StatusOportunidade.ENTREVISTA, observacao);
oportunidade.atualizarInformacoes(...);
```

Isso evita estados inválidos como `ENTREVISTA` sem data de candidatura.

### 4.8 Exposição do histórico

`consultarHistorico()` não deve permitir que código externo adicione ou remova registros diretamente.

Opção inicial recomendada:

```java
return List.copyOf(historicos);
```

---

## 5. Entidade `HistoricoStatus`

### 5.1 Responsabilidade

Representar um fato imutável: a criação de uma oportunidade ou uma mudança de status.

### 5.2 Atributos

```java
private Long id;
private StatusOportunidade statusAnterior;
private StatusOportunidade statusNovo;
private String observacao;
private LocalDateTime alteradoEm;
```

Na fase Java puro, `id` pode ser dispensado inicialmente ou gerado internamente pela oportunidade. Para facilitar a futura migração ao banco, manteremos o campo previsto, mas não deixaremos a geração do identificador bloquear a primeira entrega.

### 5.3 Imutabilidade

Depois de criado, um histórico não deve ser editado. Por isso:

- atributos privados;
- construtor com os dados necessários;
- apenas métodos de leitura;
- nenhum setter público.

### 5.4 Registro inicial

Na criação de uma oportunidade:

```text
statusAnterior: null
statusNovo: SALVA
observacao: "Oportunidade criada"
```

A interface deverá apresentar esse registro de forma amigável, como `Vaga salva`, sem mostrar `null` ao usuário.

---

## 6. Enum `StatusOportunidade`

```java
public enum StatusOportunidade {
    SALVA,
    CANDIDATURA_ENVIADA,
    EM_ANALISE,
    TESTE,
    ENTREVISTA,
    PROPOSTA,
    CONTRATADO,
    REJEITADA,
    ENCERRADA
}
```

### 6.1 Significados

| Status | Significado |
|---|---|
| `SALVA` | Vaga encontrada, mas candidatura ainda não confirmada. |
| `CANDIDATURA_ENVIADA` | Candidatura enviada. |
| `EM_ANALISE` | Processo aparentemente ou oficialmente em análise. |
| `TESTE` | Candidato está em uma etapa de teste. |
| `ENTREVISTA` | Candidato chegou à etapa de entrevista. |
| `PROPOSTA` | Proposta recebida ou em avaliação. |
| `CONTRATADO` | Processo terminou com contratação. |
| `REJEITADA` | Empresa informou ou indicou que o candidato não seguirá. |
| `ENCERRADA` | Desistência, cancelamento, vaga removida ou processo sem continuidade. |

### 6.2 Estados finalizados

```java
public boolean estaFinalizado() {
    return this == CONTRATADO
        || this == REJEITADA
        || this == ENCERRADA;
}
```

Esse comportamento pode permanecer no próprio enum para evitar repetição de comparações pela aplicação.

### 6.3 Status que exigem candidatura

Todos os estados abaixo exigem data e plataforma de candidatura:

```text
CANDIDATURA_ENVIADA
EM_ANALISE
TESTE
ENTREVISTA
PROPOSTA
CONTRATADO
REJEITADA
```

`SALVA` não exige candidatura. `ENCERRADA` pode representar uma vaga salva que foi descartada e, por isso, não exige candidatura em todos os casos.

### 6.4 Transições

Na versão 0.1 não haverá bloqueio rígido de sequência. O sistema permitirá, por exemplo:

```text
CANDIDATURA_ENVIADA -> ENTREVISTA
ENTREVISTA -> REJEITADA
ENCERRADA -> SALVA
```

Toda mudança válida será registrada. Essa flexibilidade é necessária porque processos reais pulam etapas e o usuário pode corrigir registros.

---

## 7. Enum `OrigemVaga`

```java
public enum OrigemVaga {
    LINKEDIN,
    GUPY,
    INDEED,
    VAGAS_COM_BR,
    CATHO,
    SITE_DA_EMPRESA,
    INDICACAO,
    WHATSAPP,
    TELEGRAM,
    OUTRA,
    NAO_SEI
}
```

Representa onde a oportunidade foi encontrada, não onde a candidatura foi enviada.

Exemplo:

```text
origemVaga: LINKEDIN
plataformaCandidatura: GUPY
```

---

## 8. Enum `PlataformaCandidatura`

```java
public enum PlataformaCandidatura {
    GUPY,
    LINKEDIN,
    INDEED,
    SITE_DA_EMPRESA,
    EMAIL,
    WHATSAPP,
    PRESENCIAL,
    OUTRA,
    NAO_SEI
}
```

Representa o local ou o meio em que a candidatura foi efetivamente enviada.

`NAO_SEI` satisfaz a obrigatoriedade sem obrigar o usuário a fornecer uma informação que não possui. `OUTRA` significa que o usuário conhece a plataforma ou o meio, mas a opção não está listada.

---

## 9. Enum `ModalidadeTrabalho`

```java
public enum ModalidadeTrabalho {
    REMOTO,
    HIBRIDO,
    PRESENCIAL,
    NAO_INFORMADO
}
```

O valor padrão recomendado é `NAO_INFORMADO`.

---

## 10. Classe `GerenciadorOportunidades`

### 10.1 Responsabilidade

Administrar a coleção de oportunidades na fase Java puro. A classe não deve controlar menus do terminal nem ler dados com `Scanner`.

### 10.2 Atributos

```java
private List<Oportunidade> oportunidades;
private long proximoId;
```

### 10.3 Inicialização

```java
public GerenciadorOportunidades() {
    this.oportunidades = new ArrayList<>();
    this.proximoId = 1L;
}
```

### 10.4 Métodos planejados

```java
public Oportunidade cadastrar(String empresa, String cargo)
public List<Oportunidade> listar()
public Optional<Oportunidade> buscarPorId(Long id)
public List<Oportunidade> pesquisar(String termo)
public boolean excluir(Long id)
public int quantidade()
```

### 10.5 Regras

- `cadastrar` cria o identificador e incrementa `proximoId`.
- `listar` não expõe a lista mutável original.
- `buscarPorId` retorna `Optional<Oportunidade>`.
- `pesquisar` ignora diferenças entre maiúsculas e minúsculas.
- `pesquisar` consulta empresa e cargo.
- termo `null`, vazio ou somente espaços pode retornar a listagem completa.
- `excluir` retorna `false` quando o identificador não existe.
- alterar status e editar podem inicialmente buscar a oportunidade e chamar seus métodos de domínio.

### 10.6 Equivalência futura no Spring

| Java puro | Spring Boot |
|---|---|
| `GerenciadorOportunidades` | `OportunidadeService` |
| `ArrayList<Oportunidade>` | `OportunidadeRepository` + PostgreSQL |
| `proximoId` | identificador gerado pelo banco |
| `buscarPorId` manual | `repository.findById` |
| `pesquisar` manual | consulta derivada ou JPQL |

---

## 11. Classe `Main`

### 11.1 Responsabilidade

Fornecer a interface temporária de terminal para testar o domínio.

### 11.2 Pode fazer

- criar o `Scanner`;
- exibir o menu;
- ler opções;
- solicitar os dados;
- chamar métodos do gerenciador e das oportunidades;
- apresentar resultados e mensagens de erro.

### 11.3 Não pode fazer

- validar regras internas da oportunidade;
- alterar atributos diretamente;
- criar manualmente itens de histórico;
- guardar uma segunda lista de oportunidades;
- decidir se determinado status exige candidatura;
- concentrar toda a lógica em um único `switch` gigantesco.

### 11.4 Menu planejado

```text
1. Cadastrar oportunidade
2. Listar oportunidades
3. Pesquisar oportunidade
4. Ver detalhes
5. Editar oportunidade
6. Alterar status
7. Excluir oportunidade
0. Sair
```

O menu será implementado gradualmente. A primeira entrega terá apenas cadastro, listagem e saída.

---

## 12. Invariantes do domínio

Uma invariante é uma condição que deve permanecer verdadeira enquanto o objeto existir.

### INV-001 — Identidade

Uma oportunidade cadastrada deve possuir identificador positivo e não nulo.

### INV-002 — Empresa

Empresa não pode ser nula, vazia ou composta somente por espaços.

### INV-003 — Cargo

Cargo não pode ser nulo, vazio ou composto somente por espaços.

### INV-004 — Status

Status nunca pode ser nulo.

### INV-005 — Data futura

A data da candidatura não pode ser posterior à data atual.

### INV-006 — Dados de candidatura

Um status que pressupõe candidatura exige `dataCandidatura` e `plataformaCandidatura`.

### INV-007 — Histórico consistente

Quando o status realmente muda, o status atual e o último histórico devem representar a mesma mudança.

### INV-008 — Histórico protegido

Código externo não pode remover ou adicionar históricos diretamente.

### INV-009 — Datas de controle

`atualizadaEm` não pode ser anterior a `criadaEm`.

### INV-010 — Textos normalizados

Empresa e cargo são armazenados sem espaços externos.

---

## 13. Fluxos do domínio

### 13.1 Cadastrar vaga salva

```text
Gerenciador recebe empresa e cargo
-> gera ID
-> cria Oportunidade
-> Oportunidade valida os dados
-> define SALVA
-> cria histórico inicial
-> Gerenciador adiciona à lista
-> retorna a oportunidade criada
```

### 13.2 Registrar candidatura

```text
Localizar oportunidade
-> receber data e plataforma
-> validar data não futura
-> validar plataforma não nula
-> guardar status anterior
-> preencher dados de candidatura
-> mudar status para CANDIDATURA_ENVIADA
-> criar histórico
-> atualizar atualizadaEm
```

### 13.3 Alterar status

```text
Receber novo status
-> rejeitar status nulo
-> se for igual ao atual, retornar false
-> validar dados exigidos pelo novo status
-> guardar status anterior
-> atualizar status
-> criar histórico
-> atualizar atualizadaEm
-> retornar true
```

### 13.4 Reabrir processo finalizado

```text
Status atual finalizado
-> receber novo status
-> executar as mesmas validações
-> alterar status
-> registrar a reabertura no histórico
```

Não será solicitada autorização adicional na fase local. A interface futura poderá exibir confirmação.

### 13.5 Pesquisar

```text
Receber termo
-> remover espaços externos
-> converter termo para minúsculas
-> comparar com empresa e cargo em minúsculas
-> retornar todos os resultados correspondentes
```

---

## 14. Tratamento de erros

Na fase inicial, usaremos exceções de argumento para impedir a criação de estados inválidos.

Exemplos:

```java
throw new IllegalArgumentException("A empresa é obrigatória.");
throw new IllegalArgumentException("O cargo é obrigatório.");
throw new IllegalArgumentException("A data da candidatura não pode estar no futuro.");
throw new IllegalArgumentException(
    "A plataforma da candidatura é obrigatória para este status."
);
```

A `Main` captura essas exceções e exibe a mensagem, sem encerrar o programa.

Exceções personalizadas poderão ser introduzidas depois que houver benefício concreto. Não criaremos uma hierarquia de exceções antes da necessidade.

---

## 15. Igualdade e representação textual

### 15.1 `equals` e `hashCode`

Na primeira entrega, não serão necessários para o fluxo principal. Antes de usar conjuntos, comparação entre instâncias ou JPA, a estratégia será definida com cuidado para não depender de ID nulo.

### 15.2 `toString`

Pode ser implementado para facilitar a listagem no terminal, mas não deve conter regras de apresentação elaboradas.

Exemplo inicial:

```text
[1] Empresa Aurora — Estágio Java — SALVA
```

A interface React não dependerá do `toString`.

---

## 16. Pacotes na fase Java puro

Estrutura sugerida:

```text
src/
└── br/
    └── com/
        └── minhavaga/
            ├── Main.java
            ├── dominio/
            │   ├── Oportunidade.java
            │   ├── HistoricoStatus.java
            │   ├── StatusOportunidade.java
            │   ├── OrigemVaga.java
            │   ├── PlataformaCandidatura.java
            │   └── ModalidadeTrabalho.java
            └── aplicacao/
                └── GerenciadorOportunidades.java
```

Se a criação de pacotes atrapalhar a primeira aula prática, podemos iniciar com menos pastas e reorganizar assim que as classes básicas funcionarem. A estrutura acima é o destino, não uma obrigação de criar tudo no primeiro commit.

---

## 17. Testes do domínio

### 17.1 Testes mínimos de `Oportunidade`

1. Criar oportunidade válida como `SALVA`.
2. Rejeitar empresa nula.
3. Rejeitar empresa vazia.
4. Rejeitar empresa formada por espaços.
5. Rejeitar cargo inválido.
6. Remover espaços externos de empresa e cargo.
7. Inicializar modalidade como `NAO_INFORMADO`.
8. Criar histórico inicial.
9. Registrar candidatura válida.
10. Rejeitar candidatura com data futura.
11. Rejeitar status de candidatura sem plataforma.
12. Não criar histórico ao repetir o mesmo status.
13. Criar histórico ao alterar de fato o status.
14. Reconhecer estados finalizados.
15. Reabrir processo e registrar histórico.
16. Proteger a lista de históricos contra alteração externa.

### 17.2 Testes mínimos de `GerenciadorOportunidades`

1. Gerar IDs incrementais.
2. Cadastrar e listar oportunidades.
3. Buscar ID existente.
4. Retornar vazio para ID inexistente.
5. Pesquisar por empresa sem diferenciar maiúsculas.
6. Pesquisar por cargo.
7. Excluir ID existente.
8. Não excluir item incorreto quando o ID não existir.
9. Não permitir alteração externa da lista retornada.

### 17.3 Estratégia de testes

- Primeiro, executar testes manuais pelo terminal para compreender o fluxo.
- Depois, introduzir JUnit 5 sem depender do Spring.
- Na migração, manter os testes de domínio e adicionar testes de serviço, repositório e API.

---

## 18. Plano incremental de implementação

### Entrega 1 — criação básica

- `StatusOportunidade`;
- `ModalidadeTrabalho`;
- `Oportunidade` com ID, empresa, cargo, status e datas de controle;
- validação de empresa e cargo;
- `GerenciadorOportunidades` com cadastro e listagem;
- `Main` com cadastrar, listar e sair.

### Entrega 2 — histórico e status

- `HistoricoStatus`;
- histórico inicial;
- alteração de status;
- prevenção de histórico duplicado;
- consulta do histórico.

### Entrega 3 — candidatura

- `OrigemVaga`;
- `PlataformaCandidatura`;
- data de candidatura;
- registro da candidatura;
- validações por status.

### Entrega 4 — informações e busca

- modalidade;
- link;
- localidade;
- descrição;
- observações;
- pesquisa por empresa ou cargo;
- visualização dos detalhes.

### Entrega 5 — edição e exclusão

- atualização de informações;
- exclusão por ID;
- confirmação na `Main`;
- testes manuais completos.

### Entrega 6 — testes automatizados e refatoração

- JUnit 5;
- remoção de duplicações;
- revisão dos nomes e responsabilidades;
- confirmação das invariantes.

---

## 19. Migração futura para Spring Boot

A migração só ocorrerá quando o núcleo Java puro estiver funcionando e compreendido.

### 19.1 O que deverá permanecer

- enums;
- significados dos status;
- validações do domínio;
- métodos de mudança de estado;
- criação do histórico;
- comportamento de pesquisa, ainda que a execução vá para o banco;
- testes das regras puras.

### 19.2 O que será substituído ou adaptado

| Fase Java puro | Fase Spring Boot |
|---|---|
| `ArrayList` | PostgreSQL |
| ID incremental manual | geração pelo banco/JPA |
| `GerenciadorOportunidades` | service + repository |
| menu com `Scanner` | controller REST |
| saída no terminal | JSON |
| validação de entrada manual | DTOs + Bean Validation, sem remover regras do domínio |
| criação automática em memória | transação com JPA |

### 19.3 Cuidados na migração

- armazenar enums com `EnumType.STRING`;
- não colocar regras de negócio nos controllers;
- garantir transação na mudança de status e criação do histórico;
- evitar expor entidades JPA diretamente na API;
- introduzir DTOs quando a API for criada;
- preservar testes do Java puro.

---

## 20. Fora do modelo da versão 0.1

Não serão modelados agora:

- `Usuario`;
- login e senha;
- `Acao`;
- Central do Dia;
- eventos separados de teste e entrevista;
- notificações;
- currículo ou upload;
- indicadores;
- pagamentos;
- inteligência artificial;
- candidatura automática;
- integrações externas.

Na versão 0.2, `TESTE` e `ENTREVISTA` poderão também ser representados por uma entidade `EventoProcesso`, permitindo várias entrevistas e testes sem perder o status geral.

---

## 21. Questões resolvidas

| Questão | Decisão |
|---|---|
| Começar em Spring Boot? | Não. Primeiro Java puro. |
| Armazenamento inicial | `ArrayList<Oportunidade>`. |
| Identificador inicial | `Long`, gerado pelo gerenciador. |
| Empresa e cargo | Obrigatórios. |
| Empresa não revelada | Texto `Empresa confidencial` é permitido. |
| Origem e plataforma | Campos separados. |
| Origem desconhecida | `OrigemVaga.NAO_SEI`. |
| Plataforma desconhecida | `PlataformaCandidatura.NAO_SEI`. |
| Status repetido | Não altera nem cria histórico. |
| Reabertura | Permitida e registrada. |
| `TESTE` e `ENTREVISTA` | Status simples na versão 0.1. |
| Histórico | Mantido dentro da oportunidade e protegido contra alteração externa. |
| Persistência | Apenas depois do domínio em memória. |

---

## 22. Questões para confirmar durante a implementação

1. O histórico inicial `null -> SALVA` é útil no terminal ou deve ser criado apenas na futura persistência?
2. Ao registrar candidatura a partir de `SALVA`, a origem da vaga continuará opcional ou a interface deverá solicitá-la com possibilidade de `NAO_SEI`?
3. `EM_ANALISE` será usado apenas quando houver confirmação da plataforma ou também como interpretação do usuário?
4. Ao editar empresa ou cargo, devemos registrar um histórico geral de edição no futuro?
5. A observação da alteração de status deve aceitar texto vazio como `null` ou como string vazia?

Essas questões não impedem a primeira entrega. Devem ser respondidas com testes práticos e registradas no PRD caso alterem regras de negócio.

---

## 23. Critérios de aprovação do modelo

O modelo estará aprovado quando confirmarmos:

- classes e responsabilidades;
- atributos essenciais;
- enums;
- invariantes;
- comportamento da mudança de status;
- responsabilidade do gerenciador;
- escopo das seis entregas;
- migração planejada para Spring Boot.

Após a aprovação, a implementação começa pela **Entrega 1 — criação básica**, sem Spring, banco ou front-end.

---

## 24. Histórico do documento

| Versão | Data | Alteração |
|---|---|---|
| 1.0 | 17/11/2026 | Criação do modelo de domínio para a fase Java puro e migração posterior ao Spring Boot. |
