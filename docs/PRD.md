# PRD — Organizador de Candidaturas

**Nome provisório:** MinhaVaga  
**Versão do documento:** 1.1  
**Status:** Seções 2 a 14 aprovadas; escopo funcional da versão 0.1 confirmado  
**Data:** 17/11/2026  
**Responsável pelo produto:** Luiz Fernando dos Santos Filho

---

## 1. Resumo executivo

O MinhaVaga será uma aplicação web responsiva para organizar oportunidades de emprego e acompanhar candidaturas realizadas em diferentes plataformas. O produto permitirá registrar vagas, atualizar etapas do processo seletivo, consultar o histórico e, em versões posteriores, visualizar as próximas ações importantes em uma Central do Dia.

A primeira versão será local, de usuário único e sem autenticação. Seu objetivo é validar o núcleo do produto e servir como projeto prático para o aprendizado de Java e Spring Boot. O front-end poderá ser acelerado com o OpenCode, mas o domínio, as regras de negócio e o back-end deverão permanecer compreensíveis e mantidos pelo responsável pelo projeto.

---

## 2. Visão do produto

### 2.1 Visão

Ajudar candidatos brasileiros a manter suas oportunidades e processos seletivos organizados em um único lugar, reduzindo esquecimentos e tornando claro o estado de cada candidatura.

### 2.2 Descrição curta

Uma plataforma web para registrar oportunidades, acompanhar etapas de processos seletivos e organizar a busca por emprego.

### 2.3 Proposta de valor

> Suas candidaturas organizadas. Seu próximo passo claro.

### 2.4 Hipótese principal

Candidatos que utilizam LinkedIn, Gupy, Indeed, sites de empresas e outros canais perdem informações ou têm dificuldade para lembrar onde se candidataram, qual é a situação de cada processo e o que precisam fazer em seguida.

### 2.5 Diferencial planejado

O diferencial principal será a **Central do Dia**, que destacará ações vencidas, compromissos atuais, próximos passos e candidaturas sem atualização. Esse diferencial será desenvolvido depois que o núcleo da versão 0.1 estiver funcional.

---

## 3. Contexto e problema

Durante a busca por emprego, uma pessoa pode encontrar vagas e realizar candidaturas em várias plataformas. As informações ficam fragmentadas entre páginas salvas, e-mails, mensagens, anotações, planilhas e a própria memória.

Problemas que o produto pretende reduzir:

- esquecer se uma candidatura já foi enviada;
- perder o link ou a descrição de uma vaga;
- não lembrar a plataforma de origem;
- não saber em qual etapa está o processo;
- esquecer testes, entrevistas ou prazos;
- não saber qual currículo foi utilizado;
- não possuir um histórico das mudanças;
- não identificar quais canais geram melhores resultados;
- gastar tempo procurando informações espalhadas.

---

## 4. Público-alvo

### 4.1 Público prioritário

- pessoas buscando estágio;
- candidatos à primeira vaga na área;
- candidatos a posições de nível júnior;
- brasileiros que se candidatam por mais de uma plataforma;
- pessoas que atualmente usam memória, favoritos, planilha, Notion ou anotações para se organizar.

### 4.2 Público secundário

- profissionais retornando ao mercado de trabalho;
- profissionais em transição de carreira;
- pessoas que utilizam versões diferentes do currículo;
- candidatos que acompanham processos seletivos longos.

### 4.3 Antipersona inicial

Recrutadores e empresas não serão usuários-alvo da primeira fase. O produto não oferecerá publicação de vagas, busca de candidatos, avaliação de currículos ou painel empresarial.

---

## 5. Personas

### 5.1 Persona principal — candidato à primeira oportunidade

**Perfil:** pessoa entre 18 e 30 anos buscando estágio ou vaga júnior. Estuda, desenvolve portfólio e se candidata por LinkedIn, Gupy, Indeed e sites de empresas.

**Comportamentos:**

- encontra vagas pelo celular e realiza candidaturas mais longas no computador;
- candidata-se a várias oportunidades por semana;
- guarda links em abas, favoritos, mensagens ou anotações;
- nem sempre registra a candidatura imediatamente.

**Dificuldades:**

- não lembrar todas as candidaturas;
- perder a descrição antes de uma entrevista;
- esquecer tarefas ou prazos;
- não enxergar progresso na busca;
- não saber quais fontes geram entrevistas.

**Necessidades principais:**

- cadastro rápido;
- pesquisa simples;
- status compreensíveis;
- histórico automático;
- visualização do próximo passo.

### 5.2 Persona secundária — profissional retornando ao mercado

**Perfil:** profissional com experiência anterior que está retomando a busca de emprego.

**Possíveis necessidades:**

- interface simples e direta;
- registro claro das etapas;
- consulta pelo celular;
- identificação do currículo utilizado;
- lembretes de entrevistas e testes.

Essa persona será considerada nos testes, mas não ampliará automaticamente o escopo da versão 0.1.

---

## 6. Objetivos

### 6.1 Objetivos do produto

1. Centralizar oportunidades e candidaturas.
2. Permitir o acompanhamento do status de cada processo.
3. Preservar um histórico das mudanças de status.
4. Facilitar a localização de candidaturas antigas.
5. Reduzir registros duplicados e informações perdidas.
6. Preparar a base para a futura Central do Dia.
7. Validar o produto com uso real antes de adicionar recursos avançados.

### 6.2 Objetivos de aprendizagem e portfólio

1. Aplicar fundamentos de Java em um problema real.
2. Evoluir para Spring Boot sem abandonar a compreensão do domínio.
3. Praticar API REST, persistência, validação e testes.
4. Produzir um projeto apresentável no GitHub.
5. Utilizar o OpenCode como acelerador, principalmente no front-end, e não como substituto da compreensão técnica.

### 6.3 Não objetivos

A primeira versão não pretende:

- encontrar vagas automaticamente;
- enviar candidaturas;
- gerar currículos;
- substituir LinkedIn, Gupy ou Indeed;
- oferecer inteligência artificial;
- atender recrutadores;
- cobrar assinatura;
- funcionar como aplicativo mobile nativo;
- avaliar a qualidade profissional do candidato.

---

## 7. Princípios do produto

1. **Cadastro rápido:** registrar o essencial deve exigir pouco esforço.
2. **Clareza:** o usuário deve entender os status sem treinamento.
3. **Progressão gradual:** informações adicionais podem ser preenchidas depois.
4. **Controle do usuário:** editar, excluir e futuramente exportar os próprios dados.
5. **Privacidade por padrão:** coletar apenas o necessário.
6. **Mobile first, web responsiva:** funcionar bem no celular e no computador.
7. **Sem complexidade antecipada:** recursos só entram quando houver necessidade validada.
8. **Código compreensível:** nenhuma funcionalidade deve depender de código que o mantenedor não consiga explicar ou testar.

---

## 8. Escopo das versões

### 8.1 Versão 0.1 — núcleo local

A versão 0.1 será executada localmente e atenderá somente um usuário. Deverá permitir:

- cadastrar oportunidade;
- listar oportunidades;
- visualizar os detalhes;
- editar informações;
- pesquisar por empresa ou cargo;
- alterar o status;
- registrar o histórico das mudanças de status;
- excluir oportunidade;
- persistir os dados após reiniciar a aplicação;
- utilizar a interface em computador e celular na rede/ambiente de desenvolvimento, quando aplicável.

### 8.2 Versão 0.2 — diferencial operacional

Planejada, mas não aprovada para desenvolvimento antes da conclusão e do uso real da versão 0.1:

- próximas ações;
- Central do Dia;
- ações vencidas;
- entrevistas e testes;
- processos sem atualização;
- prioridades;
- autenticação e separação entre usuários, caso a aplicação seja publicada para testes externos.

### 8.3 Versão 0.3 — aprendizado e análise

- indicadores básicos;
- resultados por origem;
- identificação do currículo utilizado;
- alerta de possível duplicidade;
- exportação CSV;
- filtros adicionais;
- importação de dados, se validada.

---

## 9. Glossário

| Termo | Definição |
|---|---|
| Oportunidade | Registro de uma vaga encontrada, mesmo antes do envio da candidatura. |
| Candidatura | Oportunidade para a qual o usuário confirmou o envio de currículo ou formulário. |
| Status | Etapa atual da oportunidade ou candidatura. |
| Histórico de status | Registro cronológico das mudanças de status. |
| Origem | Canal em que a oportunidade foi encontrada. |
| Processo ativo | Oportunidade que ainda pode exigir acompanhamento. |
| Processo finalizado | Oportunidade encerrada como contratação, rejeição ou encerramento. |
| Próxima ação | Tarefa futura relacionada a uma oportunidade. Recurso planejado para a versão 0.2. |
| Central do Dia | Tela futura com tarefas, prazos, entrevistas e pendências prioritárias. |

---

## 10. Modelo conceitual inicial

### 10.1 Oportunidade

Campos planejados para a versão 0.1:

| Campo | Tipo conceitual | Obrigatório | Observação |
|---|---|---:|---|
| id | identificador | sim | Gerado pelo sistema. |
| empresa | texto | sim | Nome da empresa. |
| cargo | texto | sim | Título da vaga. |
| link | URL/texto | não | Link original da vaga. |
| origemVaga | enum | não | Canal em que a oportunidade foi encontrada. Aceita `NAO_SEI`. |
| plataformaCandidatura | enum | condicional | Local em que a candidatura foi efetivamente enviada. Obrigatória a partir de `CANDIDATURA_ENVIADA`; aceita `NAO_SEI`. |
| modalidade | enum | não | Remoto, híbrido, presencial ou não informado. |
| localidade | texto | não | Cidade, estado, país ou descrição livre. |
| dataEncontrada | data | não | Data em que a vaga foi encontrada. |
| dataCandidatura | data | condicional | Obrigatória quando a candidatura foi enviada. |
| status | enum | sim | Situação atual. |
| descricao | texto longo | não | Cópia da descrição da vaga. |
| observacoes | texto longo | não | Anotações privadas. |
| criadaEm | data e hora | sim | Gerada pelo sistema. |
| atualizadaEm | data e hora | sim | Atualizada pelo sistema. |

### 10.2 Histórico de status

| Campo | Tipo conceitual | Obrigatório | Observação |
|---|---|---:|---|
| id | identificador | sim | Gerado pelo sistema. |
| oportunidadeId | referência | sim | Oportunidade relacionada. |
| statusAnterior | enum | não | Nulo no registro inicial, se aplicável. |
| statusNovo | enum | sim | Novo status. |
| alteradoEm | data e hora | sim | Gerada pelo sistema. |
| observacao | texto | não | Contexto opcional da mudança. |

### 10.3 Entidades futuras

Não fazem parte da versão 0.1, mas devem ser consideradas na evolução:

- Usuario;
- Acao;
- EventoProcesso;
- CurriculoUtilizado;
- Preferencias;
- Notificacao.

---

## 11. Enumerações iniciais

### 11.1 Status da oportunidade

```text
SALVA
CANDIDATURA_ENVIADA
EM_ANALISE
TESTE
ENTREVISTA
PROPOSTA
CONTRATADO
REJEITADA
ENCERRADA
```

### 11.2 Origem da vaga

Indica onde a oportunidade foi encontrada.

```text
LINKEDIN
GUPY
INDEED
VAGAS_COM_BR
CATHO
SITE_DA_EMPRESA
INDICACAO
WHATSAPP
TELEGRAM
OUTRA
NAO_SEI
```

### 11.3 Plataforma de candidatura

Indica onde a candidatura foi efetivamente enviada.

```text
GUPY
LINKEDIN
INDEED
SITE_DA_EMPRESA
EMAIL
WHATSAPP
PRESENCIAL
OUTRA
NAO_SEI
```

### 11.4 Modalidade de trabalho

```text
REMOTO
HIBRIDO
PRESENCIAL
NAO_INFORMADO
```

---

## 12. Fluxo de estados

### 12.1 Fluxo comum

```text
SALVA
  -> CANDIDATURA_ENVIADA
  -> EM_ANALISE
  -> TESTE
  -> ENTREVISTA
  -> PROPOSTA
  -> CONTRATADO
```

### 12.2 Encerramentos possíveis

- `REJEITADA` pode ocorrer depois de qualquer etapa a partir de `CANDIDATURA_ENVIADA`.
- `ENCERRADA` pode ser utilizada quando o processo foi cancelado, a vaga foi removida, não houve retorno ou o usuário desistiu.
- `CONTRATADO`, `REJEITADA` e `ENCERRADA` são estados finais para os indicadores, embora uma correção manual possa reabrir o registro com aviso e histórico.
- `SALVA` pode ir diretamente para `ENCERRADA` quando o usuário decide não se candidatar.
- Nem todo processo utilizará todas as etapas.

---

## 13. Requisitos funcionais da versão 0.1

### RF-001 — Cadastrar oportunidade

O sistema deve permitir o cadastro de uma oportunidade.

**Critérios de aceitação:**

1. Empresa é obrigatória.
2. Cargo é obrigatório.
3. Empresa e cargo não aceitam valor vazio ou somente espaços.
4. O status padrão é `SALVA` quando nenhuma candidatura foi enviada.
5. O usuário pode informar link, origem da vaga, plataforma de candidatura, modalidade, localidade, descrição e observações.
6. A empresa permanece obrigatória; quando não for revelada, o usuário pode registrar um texto identificável como `Empresa confidencial`.
7. Se o status inicial for `CANDIDATURA_ENVIADA` ou posterior, a data da candidatura e a plataforma de candidatura são obrigatórias.
8. A data da candidatura não pode estar no futuro.
9. Após o cadastro, a oportunidade aparece na listagem.
10. O sistema informa sucesso ou apresenta erros de validação compreensíveis.

### RF-002 — Listar oportunidades

O sistema deve apresentar as oportunidades cadastradas.

**Critérios de aceitação:**

1. Cada item mostra, no mínimo, empresa, cargo e status.
2. Quando existente, a data da candidatura é exibida.
3. A listagem permite acessar os detalhes.
4. O estado vazio apresenta orientação para cadastrar a primeira oportunidade.
5. A ordem padrão será da atualização mais recente para a mais antiga.

### RF-003 — Visualizar detalhes

O sistema deve permitir consultar todas as informações de uma oportunidade.

**Critérios de aceitação:**

1. Todos os campos cadastrados são apresentados.
2. Campos opcionais vazios não exibem valores como `null` ou `undefined`.
3. O histórico de status é exibido em ordem cronológica inversa, do mais recente para o mais antigo.
4. A tela oferece acesso às ações de editar, alterar status e excluir.

### RF-004 — Editar oportunidade

O sistema deve permitir alterar os dados de uma oportunidade.

**Critérios de aceitação:**

1. As mesmas validações do cadastro são aplicadas.
2. Alterar campos comuns não cria um evento de status.
3. Alterar o status pelo formulário deve utilizar a mesma regra de histórico da ação específica de status.
4. A data de atualização é renovada.
5. Após salvar, a tela apresenta os dados atualizados.

### RF-005 — Pesquisar por empresa ou cargo

O sistema deve permitir pesquisar oportunidades.

**Critérios de aceitação:**

1. A pesquisa considera empresa e cargo.
2. A pesquisa não diferencia letras maiúsculas de minúsculas.
3. Espaços extras no início e no fim são ignorados.
4. Ao limpar o termo, a listagem completa é restaurada.
5. Quando não houver resultados, o sistema apresenta uma mensagem clara.

### RF-006 — Alterar status

O sistema deve permitir atualizar o status de uma oportunidade.

**Critérios de aceitação:**

1. O usuário seleciona apenas valores previstos na enumeração de status.
2. Alterar para o mesmo status não grava um novo histórico.
3. A mudança para `CANDIDATURA_ENVIADA` ou etapa posterior exige data de candidatura.
4. Toda mudança válida registra o status anterior, o novo status e a data/hora.
5. O status atual da oportunidade é atualizado na mesma operação.
6. Em caso de falha no histórico, a mudança do status não deve ser parcialmente salva.

### RF-007 — Consultar histórico de status

O sistema deve registrar e apresentar as mudanças de status.

**Critérios de aceitação:**

1. O histórico pertence a uma única oportunidade.
2. Cada item apresenta status anterior, novo status e data/hora.
3. O histórico não pode ser editado silenciosamente.
4. A exclusão da oportunidade remove ou invalida adequadamente seus históricos, conforme a estratégia de persistência definida.

### RF-008 — Excluir oportunidade

O sistema deve permitir excluir uma oportunidade criada por engano.

**Critérios de aceitação:**

1. A interface solicita confirmação.
2. A confirmação informa que o histórico relacionado também será afetado.
3. Depois da exclusão, o item não aparece na listagem nem na pesquisa.
4. Solicitar a exclusão de identificador inexistente retorna erro compreensível.
5. A operação não pode excluir outra oportunidade por engano.

### RF-009 — Persistir dados

O sistema deve manter os registros após reiniciar a aplicação.

**Critérios de aceitação:**

1. O cadastro é armazenado em banco de dados.
2. Reiniciar a aplicação não remove oportunidades ou históricos.
3. Alterações e exclusões permanecem refletidas após reiniciar.
4. A configuração de desenvolvimento possui instruções reproduzíveis.

---

## 14. Regras de negócio

### RN-001 — Oportunidade antes da candidatura

Uma oportunidade pode existir como `SALVA` sem data de candidatura.

### RN-002 — Data obrigatória após candidatura

A data da candidatura é obrigatória quando o status for `CANDIDATURA_ENVIADA`, `EM_ANALISE`, `TESTE`, `ENTREVISTA`, `PROPOSTA`, `CONTRATADO` ou `REJEITADA`.

### RN-003 — Data futura proibida

A data da candidatura não pode ser posterior à data atual do sistema.

### RN-004 — Histórico obrigatório

Toda mudança real de status deve gerar um registro no histórico.

### RN-005 — Status repetido

Solicitar alteração para o status atual não altera a oportunidade e não cria histórico duplicado.

### RN-006 — Atomicidade

A atualização do status e a criação do histórico devem ocorrer na mesma transação.

### RN-007 — Estados finalizados

`CONTRATADO`, `REJEITADA` e `ENCERRADA` representam processos finalizados.

### RN-008 — Reabertura

Uma oportunidade finalizada poderá ser corrigida ou reaberta na versão 0.1, desde que a mudança gere histórico. Restrições mais rígidas serão avaliadas após o uso real.

### RN-009 — Normalização dos textos

Empresa e cargo devem ser armazenados sem espaços excedentes no início e no fim. O sistema não deve alterar arbitrariamente a capitalização digitada.

### RN-010 — Exclusão

Na versão local 0.1, a exclusão poderá ser física. Antes da publicação multiusuário, será reavaliada a adoção de exclusão lógica e período de recuperação.

### RN-011 — Origem da vaga e plataforma de candidatura

`origemVaga` registra onde a oportunidade foi encontrada. `plataformaCandidatura` registra onde o envio foi efetivamente realizado. São informações diferentes e não devem ser combinadas em um único campo.

A origem da vaga é opcional na versão 0.1 e aceita `NAO_SEI`. A plataforma de candidatura torna-se obrigatória a partir de `CANDIDATURA_ENVIADA`, mas também aceita `NAO_SEI` quando o usuário não conseguir identificá-la. `OUTRA` deve ser usada quando a origem ou plataforma é conhecida, mas não aparece na lista.

### RN-012 — Link

O link é opcional. Quando informado, deve possuir formato válido de URL HTTP ou HTTPS, salvo decisão técnica documentada que aceite texto temporariamente.

---

## 15. Requisitos não funcionais

### RNF-001 — Idioma e localização

- Interface em português brasileiro.
- Datas exibidas como `dd/MM/yyyy`.
- Data e hora do histórico exibidas como `dd/MM/yyyy HH:mm`.
- O domínio deve utilizar tipos de data adequados, sem armazenar datas como texto.

### RNF-002 — Responsividade

- A interface deve funcionar a partir de 320 px de largura.
- Não deve existir rolagem horizontal na página principal.
- Ações essenciais devem funcionar por toque e clique.

### RNF-003 — Usabilidade

- O cadastro básico deve ser concluído idealmente em até 60 segundos.
- Erros devem aparecer próximos ao campo relacionado.
- Botões devem utilizar verbos claros, como `Salvar`, `Editar`, `Alterar status` e `Excluir`.
- Estados vazios devem orientar a próxima ação.

### RNF-004 — Acessibilidade

- Campos devem possuir rótulos visíveis.
- A navegação essencial deve funcionar por teclado.
- O foco deve ser visível.
- Textos e controles devem possuir contraste adequado.
- Apenas cor não deve comunicar status ou erro.

### RNF-005 — Desempenho inicial

Para o ambiente local e volume inicial:

- operações comuns da API devem responder, idealmente, em menos de 500 ms;
- a listagem deve lidar com pelo menos 1.000 oportunidades sem falha funcional;
- paginação poderá ser adicionada antes da publicação caso o volume ou a interface exijam.

Esses valores são metas internas, não garantias contratuais.

### RNF-006 — Segurança

Na versão 0.1:

- nenhuma credencial deve ser incluída no repositório;
- configurações sensíveis devem usar variáveis de ambiente quando aplicável;
- descrições e observações exibidas na interface não devem executar HTML ou scripts;
- erros da API não devem expor stack traces ao usuário final.

Antes da publicação multiusuário:

- autenticação segura será obrigatória;
- senhas deverão utilizar hash forte e nunca texto puro;
- toda consulta deverá respeitar o proprietário do registro;
- HTTPS será obrigatório;
- exclusão e exportação de dados deverão estar disponíveis.

### RNF-007 — Privacidade

- Não coletar CPF, RG, endereço completo, data de nascimento ou dados desnecessários.
- Não armazenar dados pessoais de recrutadores na versão 0.1.
- Observações são privadas e não devem ser usadas para publicidade.
- Antes de testes externos, deverá existir aviso de privacidade compatível com o tratamento realizado.

### RNF-008 — Testabilidade

- Regras de negócio devem permanecer fora dos controllers.
- Validações críticas devem possuir testes automatizados.
- Mudança de status e histórico devem ter teste transacional.
- APIs devem possuir respostas de erro previsíveis.

### RNF-009 — Manutenibilidade

- Código em português ou inglês deverá seguir decisão única por camada e convenção registrada.
- Commits devem ser pequenos e descritivos.
- Código gerado pelo OpenCode só será aceito depois de revisão.
- Dependências devem ser justificadas e mantidas no mínimo necessário.

---

## 16. Histórias de usuário da versão 0.1

### US-001 — Salvar uma vaga

Como candidato, quero salvar uma oportunidade com poucos dados para não perder uma vaga que encontrei.

### US-002 — Registrar candidatura enviada

Como candidato, quero informar que enviei minha candidatura para acompanhar o processo a partir dessa data.

### US-003 — Consultar oportunidades

Como candidato, quero visualizar minhas oportunidades em uma lista para saber quais processos estão ativos.

### US-004 — Localizar candidatura

Como candidato, quero pesquisar por empresa ou cargo para encontrar rapidamente um registro.

### US-005 — Consultar detalhes

Como candidato, quero abrir uma oportunidade para consultar todas as informações e seu histórico.

### US-006 — Atualizar etapa

Como candidato, quero alterar o status para manter o andamento do processo atualizado.

### US-007 — Corrigir informações

Como candidato, quero editar uma oportunidade para corrigir ou completar dados.

### US-008 — Consultar histórico

Como candidato, quero visualizar as mudanças de status para lembrar o que aconteceu no processo.

### US-009 — Remover registro incorreto

Como candidato, quero excluir uma oportunidade criada por engano para manter meus dados organizados.

---

## 17. Fluxos principais da versão 0.1

### 17.1 Primeiro acesso

```text
Abrir aplicação
-> visualizar lista vazia
-> selecionar Nova oportunidade
-> preencher empresa e cargo
-> salvar
-> visualizar oportunidade na lista
```

### 17.2 Salvar oportunidade

```text
Lista
-> Nova oportunidade
-> preencher dados mínimos
-> manter status SALVA
-> salvar
-> abrir detalhes ou retornar à lista
```

### 17.3 Registrar candidatura já enviada

```text
Nova oportunidade ou edição
-> marcar status CANDIDATURA_ENVIADA
-> informar data da candidatura
-> informar origem da vaga
-> informar plataforma de candidatura
-> salvar
-> criar histórico
```

### 17.4 Atualizar processo

```text
Lista
-> detalhes
-> Alterar status
-> selecionar novo status
-> confirmar
-> atualizar oportunidade e histórico
```

### 17.5 Pesquisar

```text
Lista
-> digitar empresa ou cargo
-> exibir resultados
-> abrir oportunidade
```

### 17.6 Excluir

```text
Detalhes
-> Excluir
-> confirmar impacto
-> remover oportunidade e histórico relacionado
-> retornar à lista
```

---

## 18. Telas da versão 0.1

### 18.1 Lista de oportunidades

Deve conter:

- título da área;
- botão `Nova oportunidade`;
- campo de busca;
- estado vazio;
- lista com empresa, cargo, status e data relevante;
- acesso aos detalhes.

### 18.2 Formulário de oportunidade

Deve conter:

- empresa;
- cargo;
- status;
- data da candidatura quando aplicável;
- origem da vaga;
- plataforma de candidatura;
- link;
- modalidade;
- localidade;
- descrição;
- observações;
- ações `Salvar` e `Cancelar`.

O formulário deve priorizar empresa, cargo, situação e data. Campos complementares podem ficar em uma seção opcional.

### 18.3 Detalhes da oportunidade

Deve conter:

- empresa e cargo em destaque;
- status atual;
- dados da vaga;
- descrição e observações;
- histórico;
- ações de editar, alterar status e excluir.

### 18.4 Alteração de status

Pode ser um formulário, caixa de diálogo ou seção da tela de detalhes. Deve mostrar:

- status atual;
- novo status;
- data da candidatura, se exigida;
- observação opcional;
- confirmação.

---

## 19. API REST preliminar

O contrato final será definido após a modelagem do domínio. A referência inicial é:

```text
POST   /api/oportunidades
GET    /api/oportunidades
GET    /api/oportunidades/{id}
PUT    /api/oportunidades/{id}
PATCH  /api/oportunidades/{id}/status
DELETE /api/oportunidades/{id}
GET    /api/oportunidades/{id}/historico
```

### 19.1 Comportamentos HTTP esperados

- `200 OK`: consulta ou atualização realizada.
- `201 Created`: oportunidade criada.
- `204 No Content`: exclusão concluída.
- `400 Bad Request`: dados inválidos.
- `404 Not Found`: oportunidade inexistente.
- `409 Conflict`: conflito de regra de negócio, quando aplicável.
- `500 Internal Server Error`: falha não prevista, sem exposição de detalhes internos.

A especificação OpenAPI será produzida antes da integração definitiva com o front-end.

---

## 20. Arquitetura técnica preliminar

### 20.1 Back-end

- Java 21;
- Spring Boot;
- Maven;
- Spring Web;
- Bean Validation;
- Spring Data JPA;
- banco de desenvolvimento a decidir entre H2 e PostgreSQL local;
- migrations com Flyway quando o esquema deixar de ser descartável;
- JUnit 5;
- Mockito apenas onde isolamento por mock trouxer benefício real;
- springdoc-openapi para documentação da API, quando a API estiver estruturada.

### 20.2 Front-end

- aplicação web responsiva;
- React com Vite como opção preferencial inicial;
- OpenCode poderá auxiliar na geração e revisão da interface;
- integração por JSON via API REST;
- sem dependência obrigatória de biblioteca visual pesada na primeira versão.

### 20.3 Banco de dados

A decisão será registrada antes da implementação:

- **H2:** reduz configuração inicial, mas pode esconder diferenças em relação ao PostgreSQL.
- **PostgreSQL local:** aproxima o ambiente real, mas adiciona configuração.

Preferência prática: começar com PostgreSQL por Docker se o ambiente estiver estável; usar H2 temporariamente apenas se a infraestrutura bloquear o aprendizado do domínio.

### 20.4 Organização sugerida do repositório

```text
/
├── backend/
├── frontend/
├── docs/
│   └── PRD.md
├── README.md
└── .gitignore
```

A separação em dois diretórios poderá ser revista caso o repositório contenha inicialmente apenas o back-end.

---

## 21. Backlog priorizado — MoSCoW

### 21.1 Must have — versão 0.1

| ID | Item |
|---|---|
| M-001 | Cadastrar oportunidade |
| M-002 | Listar oportunidades |
| M-003 | Visualizar detalhes |
| M-004 | Editar oportunidade |
| M-005 | Pesquisar por empresa ou cargo |
| M-006 | Alterar status |
| M-007 | Registrar histórico automático |
| M-008 | Consultar histórico |
| M-009 | Excluir oportunidade com confirmação |
| M-010 | Persistir dados |
| M-011 | Validar campos e regras no back-end |
| M-012 | Interface responsiva básica |

### 21.2 Should have — após o núcleo

| ID | Item |
|---|---|
| S-001 | Próximas ações |
| S-002 | Central do Dia |
| S-003 | Registro de entrevistas e testes |
| S-004 | Filtro por status |
| S-005 | Identificação do currículo utilizado |
| S-006 | Indicadores básicos |
| S-007 | Exportação CSV |
| S-008 | Alerta de possível duplicidade |
| S-009 | Cadastro e login para testes externos |
| S-010 | Recuperação de senha antes da divulgação pública |

### 21.3 Could have

| ID | Item |
|---|---|
| C-001 | Kanban |
| C-002 | Modo escuro |
| C-003 | Importação CSV |
| C-004 | PWA instalável |
| C-005 | Modelos de próximas ações |
| C-006 | Contato do recrutador |
| C-007 | Salário e benefícios |
| C-008 | Nível de interesse |
| C-009 | Arquivamento |

### 21.4 Won’t have now

| ID | Item |
|---|---|
| W-001 | Inteligência artificial |
| W-002 | Geração ou análise automática de currículo |
| W-003 | Envio automático de candidaturas |
| W-004 | Busca ou agregação de vagas |
| W-005 | Extensão de navegador |
| W-006 | Integração com Gmail |
| W-007 | Integração com WhatsApp |
| W-008 | Aplicativo Android ou iOS nativo |
| W-009 | Pagamentos e assinaturas |
| W-010 | Painel para recrutadores |
| W-011 | Rede social |
| W-012 | Upload de currículo na versão 0.1 |

---

## 22. Critérios de conclusão da versão 0.1

A versão 0.1 será considerada funcionalmente concluída quando:

1. for possível cadastrar uma oportunidade válida;
2. empresa e cargo inválidos forem rejeitados;
3. uma candidatura enviada exigir data válida;
4. os registros aparecerem na listagem;
5. a pesquisa localizar empresa e cargo sem diferenciar maiúsculas;
6. os detalhes exibirem as informações cadastradas;
7. a edição persistir as mudanças;
8. toda mudança real de status criar histórico;
9. repetir o mesmo status não duplicar histórico;
10. a exclusão exigir confirmação e remover o registro correto;
11. reiniciar a aplicação não apagar os dados;
12. os fluxos essenciais funcionarem em tela de computador e celular;
13. testes automatizados cobrirem as regras críticas;
14. a API possuir tratamento consistente de validação e recurso inexistente;
15. o mantenedor conseguir explicar a arquitetura e as regras implementadas.

### 22.1 Critérios de uso real

Antes de iniciar a versão 0.2:

- cadastrar pelo menos 5 oportunidades reais;
- usar o sistema por pelo menos 7 dias;
- medir ao menos 5 cadastros, buscando concluir o fluxo básico em até 60 segundos;
- registrar campos desnecessários ou ausentes;
- identificar falhas de navegação;
- avaliar se o histórico é realmente consultado.

---

## 23. Métricas

### 23.1 Métricas da versão 0.1

- tempo mediano para cadastrar uma oportunidade;
- percentual de cadastros concluídos sem erro;
- número de oportunidades reais registradas;
- quantidade de retornos ao sistema por semana;
- quantidade de alterações de status;
- quantidade de pesquisas realizadas;
- erros encontrados no uso real;
- campos nunca utilizados.

### 23.2 Métricas futuras de produto

Quando houver múltiplos usuários:

- ativação: usuário cadastra a primeira oportunidade;
- retenção semanal: usuário retorna e realiza ação útil;
- oportunidades registradas por usuário ativo;
- ações concluídas na Central do Dia;
- entrevistas e testes registrados;
- taxa de exportação ou exclusão;
- conversão de candidatura para entrevista, com explicação clara da fórmula.

### 23.3 Critério de validação inicial

O produto demonstrará sinal inicial de utilidade quando:

- o responsável usar espontaneamente a aplicação durante a busca real;
- o cadastro não depender de disciplina excessiva;
- o histórico ajudar a recuperar contexto;
- ao menos o pai e o amigo conseguirem testar o protótipo posteriormente sem instrução detalhada;
- os testadores demonstrarem comportamento de uso, e não apenas opinião positiva.

---

## 24. Plano de validação

A validação externa não bloqueia a implementação da versão 0.1.

### 24.1 Etapa 1 — usuário zero

O responsável utilizará a aplicação com candidaturas reais e anotará:

- o que demorou;
- o que não utilizou;
- o que faltou;
- erros e dúvidas;
- frequência de retorno;
- utilidade do histórico.

### 24.2 Etapa 2 — testes próximos

Depois que houver uma versão utilizável:

- testar com uma pessoa retornando ao mercado;
- testar com uma pessoa procurando estágio;
- pedir a execução de tarefas concretas sem ensinar o caminho;
- observar onde ocorre dificuldade;
- evitar aceitar toda sugestão como requisito.

### 24.3 Tarefas de teste sugeridas

1. Cadastrar uma vaga encontrada no LinkedIn.
2. Registrar que a candidatura foi enviada ontem.
3. Encontrar uma candidatura por empresa.
4. Alterar o processo para entrevista.
5. Consultar o histórico.
6. Corrigir a modalidade.
7. Excluir um cadastro criado por engano.

### 24.4 Metas de usabilidade

- pelo menos 80% das tarefas principais concluídas sem ajuda;
- cadastro básico em até 60 segundos;
- localização de uma oportunidade em até 15 segundos;
- entendimento do status sem explicação externa.

---

## 25. Riscos e mitigação

| Risco | Impacto | Mitigação |
|---|---|---|
| Construir um CRUD sem diferencial | Produto pouco útil | Manter a Central do Dia como hipótese da 0.2 e validar o uso do núcleo. |
| Escopo crescer antes da primeira entrega | Projeto não é concluído | Aplicar o backlog MoSCoW e exigir atualização do PRD. |
| OpenCode gerar código incompreensível | Baixa capacidade de manutenção | Revisar cada alteração e limitar tarefas por prompt. |
| Autenticação consumir o início do projeto | Desvio do aprendizado do domínio | Versão 0.1 local e de usuário único. |
| Cadastro manual ser cansativo | Baixa adesão | Reduzir campos obrigatórios e medir tempo. |
| Dados sensíveis em observações | Risco de privacidade | Minimização, aviso e segurança antes da publicação. |
| H2 se comportar diferente do PostgreSQL | Erros na publicação | Preferir PostgreSQL local ou testar migração cedo. |
| Muitas enumerações rígidas | Dificuldade em refletir processos reais | Começar com conjunto pequeno e permitir encerramento genérico. |
| Usuários próximos elogiarem por apoio pessoal | Falso positivo | Observar tarefas realizadas e retorno espontâneo. |
| Abandono do foco em Java | Atraso no objetivo profissional | Tratar o produto como projeto de aprendizagem e limitar o front-end delegado. |

---

## 26. Dependências e restrições

### 26.1 Restrições

- orçamento inicial próximo de zero;
- desenvolvimento realizado no tempo livre;
- Java permanece como prioridade de aprendizagem;
- front-end pode receber mais auxílio do OpenCode;
- primeira versão não depende de serviços pagos;
- publicação pública só ocorrerá após segurança, autenticação e privacidade mínimas.

### 26.2 Dependências técnicas

- OpenJDK 21;
- Maven;
- Node.js para o front-end, quando iniciado;
- banco local;
- Git e GitHub;
- VS Code;
- Docker apenas se sua instalação e uso não bloquearem o avanço.

---

## 27. Estratégia de desenvolvimento

1. Aprovar este PRD.
2. Criar wireframes de baixa fidelidade.
3. Modelar o domínio sem depender da interface.
4. Definir decisões técnicas em registros curtos.
5. Criar o back-end em etapas pequenas.
6. Testar as regras antes de integrar o front-end.
7. Usar o OpenCode em tarefas delimitadas.
8. Integrar uma tela por vez.
9. Utilizar dados reais do responsável.
10. Revisar o PRD antes de iniciar a versão 0.2.

### 27.1 Regra para uso do OpenCode

Todo prompt deve informar:

- escopo exato da tarefa;
- arquivos permitidos;
- critérios de aceitação;
- tecnologias autorizadas;
- proibição de adicionar funcionalidades não solicitadas;
- exigência de explicar alterações relevantes.

Mudanças geradas devem ser revisadas antes do commit.

---

## 28. Roadmap preliminar

As durações abaixo são estimativas orientativas e não compromissos.

### Marco 1 — documentação e desenho

- PRD aprovado;
- wireframes;
- modelo de domínio;
- contrato inicial da API.

### Marco 2 — back-end 0.1

- projeto Spring Boot;
- oportunidade;
- histórico;
- persistência;
- validações;
- testes;
- endpoints.

### Marco 3 — front-end 0.1

- lista;
- formulário;
- detalhes;
- alteração de status;
- pesquisa;
- integração.

### Marco 4 — uso real

- 5 ou mais oportunidades reais;
- 7 dias de uso;
- correções;
- testes com pai e amigo quando possível.

### Marco 5 — decisão sobre 0.2

- revisar evidências;
- confirmar ou alterar a Central do Dia;
- decidir autenticação;
- priorizar próximas ações, eventos e indicadores.

---

## 29. Questões em aberto

Estas decisões não bloqueiam a aprovação do PRD, mas devem ser resolvidas antes da etapa correspondente:

1. Nome comercial definitivo.
2. H2 ou PostgreSQL desde o primeiro commit funcional.
3. Monorepo ou repositórios separados.
4. Uso de UUID ou identificador numérico.
5. Estratégia exata de exclusão antes da publicação.
6. Status `EM_ANALISE` representa informação confirmada ou percepção do usuário?
7. `TESTE` e `ENTREVISTA` serão status ou eventos na versão 0.2?
8. Como representar várias entrevistas sem distorcer o status atual?
9. A versão 0.1 aceita `NAO_SEI` tanto em origem da vaga quanto em plataforma de candidatura; reavaliar opções após o uso real.
10. Como calcular “dias sem atualização” na Central do Dia?
11. Qual provedor gratuito será usado quando houver publicação?
12. Qual mecanismo de autenticação será escolhido para testes externos?

### 29.1 Decisões provisórias recomendadas

- Na 0.1, `TESTE` e `ENTREVISTA` permanecem como status para simplificar.
- Processos finalizados podem ser reabertos ou corrigidos, sempre com registro no histórico.
- `REJEITADA` indica eliminação do candidato; `ENCERRADA` cobre desistência, cancelamento, vaga removida ou processo sem continuidade.
- Na 0.2, serão avaliados também como eventos, mantendo um status mais geral.
- Identificadores podem começar numéricos; UUID será reavaliado antes da exposição pública.
- Um único repositório com `backend`, `frontend` e `docs` facilita o projeto individual.

---

## 30. Gestão de mudanças

Este documento é a base do produto, mas poderá evoluir.

Uma mudança deve atualizar o PRD antes ou junto do código quando:

- adicionar requisito funcional;
- alterar regra de negócio;
- incluir novo status;
- mudar o escopo de uma versão;
- coletar novo dado pessoal;
- adicionar integração externa;
- modificar comportamento da API;
- afetar critérios de conclusão.

### 30.1 Registro de alterações

| Versão | Data | Alteração | Responsável |
|---|---|---|---|
| 1.0 | 17/11/2026 | Criação do PRD completo e definição da versão 0.1. | Luiz Fernando dos Santos Filho |
| 1.1 | 17/11/2026 | Aprovação das seções 2 a 14; separação entre origem da vaga e plataforma de candidatura; inclusão de `NAO_SEI`; confirmação da reabertura com histórico e dos estados finais. | Luiz Fernando dos Santos Filho |

---

## 31. Aprovação

### 31.1 Status de aprovação

Aprovado em 17/11/2026:

- visão, problema, público e proposta de valor;
- objetivos e princípios do produto;
- escopo das versões 0.1, 0.2 e 0.3;
- ausência de IA, pagamentos e candidatura automática no escopo atual;
- Central do Dia reservada para a versão 0.2;
- modelo conceitual, enumerações e fluxo de estados;
- requisitos funcionais e regras de negócio das seções 10 a 14;
- separação entre `origemVaga` e `plataformaCandidatura`;
- opção `NAO_SEI` em ambos os campos;
- reabertura de processo finalizado com histórico;
- manutenção de `REJEITADA` e `ENCERRADA` com significados distintos;
- manutenção de `TESTE` e `ENTREVISTA` como status simples na versão 0.1.

### 31.2 Próxima etapa

Criar os wireframes das quatro telas da versão 0.1 e, em seguida, modelar o domínio antes de iniciar o código.
