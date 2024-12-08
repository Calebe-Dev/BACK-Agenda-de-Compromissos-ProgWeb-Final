# Agenda de Compromissos (Back-End)

Este projeto é a parte Back-End de uma Agenda de Compromissos, desenvolvido como projeto final para a disciplina de Programação Web.

# (OBS: Esse repositório é a revisão do repositório: https://github.com/Calebe-Dev/-Passo-a-passo--Java-Spring-.git , foi desenvolvido para apresentação limpa e funcional do projeto, contendo pequenas modificações)

## Pré-requisitos

Antes de começar, certifique-se de ter o seguinte instalado e configurado em sua máquina:

- **Java JDK** (Oracle ou OpenJDK)
- **Git**
- Configurar a variável de ambiente `JAVA_HOME` com o caminho para o JDK instalado

---

## 1. Criando o Projeto

### 1.1. Acesse o Spring Initializr

Visite o site: [https://start.spring.io/](https://start.spring.io/)

### 1.2. Configure as opções do projeto:

- **Projeto**: Maven
- **Linguagem**: Java
- **Versão do Spring Boot**: 3.3.5

### 1.3. Nome do projeto

- Configure o nome, descrição, pacote e outros detalhes conforme o seu projeto.

### 1.4. Configurações adicionais

- **Versão do Java**: Selecione a versão que corresponde ao JDK instalado em sua máquina ou uma versão anterior.
- **Empacotamento**: JAR

### 1.5. Dependências necessárias

Adicione as seguintes dependências:

1. **H2 Database**  
   Fornece um banco de dados rápido em memória que suporta a API JDBC e acesso R2DBC, com footprint pequeno (2 MB). Oferece modos embarcado e servidor, além de um console baseado em navegador.

2. **Spring Boot DevTools**  
   Ferramentas de desenvolvimento que fornecem reinícios rápidos da aplicação, LiveReload, e configurações para uma experiência de desenvolvimento aprimorada.

3. **Spring Web**  
   Construa aplicações web, incluindo RESTful, usando Spring MVC. Usa o Apache Tomcat como contêiner embutido padrão.

4. **Spring Data JPA**  
   Persista dados em lojas SQL com a API Java Persistence, usando Spring Data e Hibernate.

Clique em "Generate" para gerar o projeto.

---

## 2. Configurando o Projeto

### 2.1. Download e extração

Faça o download do arquivo gerado pelo Spring Initializr e extraia-o no diretório onde deseja armazenar seu projeto.

### 2.2. Executando o projeto

#### 2.2.1. Executando

- Clique em **Run** no seu projeto.
   local: src/java/br/AgendaAplication.java

#### 2.2.2. Testando

- Se não houver mensagens de erro no terminal, o projeto foi iniciado corretamente.
- Acesse o navegador em: [http://localhost:8080](http://localhost:8080)
- Você verá a mensagem padrão "Whitelabel Error Page" do Apache Tomcat.

---

## 3. Subindo o projeto para o GitHub

### 3.1. Criar um repositório no GitHub

- Acesse o [GitHub](https://github.com) e crie um novo repositório.

### 3.2. Inicializar o repositório Git localmente

No diretório do projeto, execute o comando:

```bash
git init
```

### 3.3. Configurar o repositório remoto

Siga as etapas fornecidas pelo GitHub para configurar o repositório remoto, adicionar arquivos e fazer o commit.

---

## 4. Criando Uma Entidade

### 4.1. Estrutura de Pastas

1. Navegue para a pasta padrão do seu projeto onde todas as classes e arquivos relacionados serão criados. No seu caso, o caminho é:  
   `src/main/java/br/fatec/agenda/Agenda/`

2. Dentro dessa pasta, crie uma nova pasta chamada `entities`.  
   Essa pasta servirá para organizar suas classes de entidade, facilitando a manutenção e o entendimento do projeto.

### 4.2. Criando a Classe da Entidade

3. Crie um novo arquivo Java na pasta `entities` e nomeie-o como `Compromisso.java`.  
   Isso representa a entidade `Compromisso` que armazenará as informações relacionadas a um compromisso em sua agenda.

---

### Explicações Teóricas

#### O que é uma Entidade?

- **Entidade**: Em programação, especialmente na arquitetura de banco de dados e no desenvolvimento de sistemas orientados a objetos, uma entidade é uma representação de um objeto real ou conceito no sistema que está sendo modelado. Cada entidade tem características (ou propriedades) que descrevem esse objeto. Em sistemas de agendamento, um exemplo de entidade seria `Compromisso`, que representa um evento ou reunião.

#### O que são Atributos?

- **Atributo**: Um atributo é uma característica ou propriedade que define a entidade. Cada atributo tem um tipo específico (por exemplo, `String`, `LocalDate`, `LocalTime`) que determina que tipo de dados ele pode armazenar. Por exemplo, um `Compromisso` pode ter atributos como `titulo` (o nome do evento), `data` (a data em que o evento ocorre), e `horaInicio` (o horário de início do evento).

---

### 4.3. Estrutura da Entidade `Compromisso`

4. Defina os atributos necessários para a entidade `Compromisso` e seus tipos de dados apropriados. Além disso, crie os métodos *getters* e *setters* para acessar e modificar os atributos da entidade.

```java
package br.fatec.agenda.Agenda.entities;

import java.io.Serializable; // Interface para permitir a serialização do objeto
import java.time.LocalDate; // Classe para trabalhar com datas (sem horário)
import java.time.LocalTime; // Classe para trabalhar com horários (sem data)

import jakarta.persistence.Entity; // Anotação para definir a classe como uma entidade JPA
import jakarta.persistence.GeneratedValue; // Anotação para a estratégia de geração automática de ID
import jakarta.persistence.GenerationType; // Tipos de estratégia de geração de ID
import jakarta.persistence.Id; // Anotação para definir a chave primária da entidade

/**
 * A classe Compromisso representa um compromisso ou evento na agenda.
 * É anotada com @Entity para que o JPA a reconheça como uma entidade mapeada
 * para uma tabela no banco de dados.
 */
@Entity
public class Compromisso implements Serializable {

    private static final long serialVersionUID = 1L; // Número de versão para a serialização

    @Id // Define o campo 'id' como a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automaticamente o ID usando auto-incremento
    private long id;

    // Atributo que armazena o título do compromisso
    private String title;

    // Atributo que armazena a descrição do compromisso
    private String description;

    // Data do compromisso (sem horário)
    private LocalDate compromissoDate;

    // Hora de início do compromisso
    private LocalTime startTime;

    // Hora de término do compromisso
    private LocalTime endTime;

    // Local onde o compromisso ocorrerá
    private String local;

    // Nível de prioridade do compromisso (ex.: 1 = baixa, 2 = média, 3 = alta)
    private long priority;

    // Getters para acessar os atributos da classe

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCompromissoDate() {
        return compromissoDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public String getLocal() {
        return local;
    }

    public long getPriority() {
        return priority;
    }

    /**
     * Sobrescrevendo o método hashCode para garantir que o código hash
     * seja consistente com o método equals. Isso é importante para
     * armazenar objetos corretamente em coleções baseadas em hash.
     */
    @Override
    public int hashCode() {
        final int prime = 31; // Número primo para gerar o hash code
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32)); // Gera o hash code usando o ID
        return result;
    }

    /**
     * Sobrescrevendo o método equals para comparar objetos Compromisso
     * com base no valor do atributo 'id'. Isso garante que dois objetos
     * com o mesmo ID sejam considerados iguais.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) // Verifica se é a mesma instância
            return true;
        if (obj == null) // Verifica se o objeto comparado é nulo
            return false;
        if (getClass() != obj.getClass()) // Verifica se as classes são diferentes
            return false;
        Compromisso other = (Compromisso) obj; // Faz o casting para o tipo Compromisso
        if (id != other.id) // Compara os IDs dos objetos
            return false;
        return true;
    }
}

```

## Correção, Os setters não foram definidos a cima, 

Getters and setters corrigidos:
```java
//codigo acima l24

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCompromissoDate() {
        return compromissoDate;
    }

    public void setCompromissoDate(LocalDate compromissoDate){
        this.compromissoDate = compromissoDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime){
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime){
        this.endTime = endTime;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(Long priority){
        this.priority = priority;
    }

//codigo a baixo l89
```




### Explicação das Etapas

1. **Criando a Classe**
   - Você define uma nova classe que representa a entidade no seu sistema. Aqui, a classe `Compromisso` representa um evento ou compromisso na sua agenda.

2. **Definindo Atributos**
   - A classe `Compromisso` possui vários atributos que descrevem as propriedades do compromisso, como:
     - `data`: Representa o dia em que o compromisso ocorre.
     - `titulo`, `descricao`, `horaInicio`, etc., para descrever o evento.

3. **Getters e Setters**
   - **Getters**: Métodos que retornam o valor de um atributo da classe.
   - **Setters**: Métodos que atribuem um novo valor a um atributo. Esses métodos mantêm o princípio de **encapsulamento** em Java, garantindo que os atributos sejam acessados e alterados de maneira controlada, além de permitir validações ou transformações, se necessário.

---

4. **Transformando a Classe em uma Entidade JPA**
   - **O que `@Entity` faz?**
     - A anotação `@Entity` transforma a classe em uma entidade gerenciada pelo JPA. Isso significa que o JPA cria automaticamente uma tabela correspondente no banco de dados (se configurada para isso) e permite operações de persistência simples, como salvar ou recuperar dados.
     - Ela funciona junto com outras anotações do JPA, como:
       - **`@Id`**: Define o atributo `id` como a chave primária da entidade.
       - **`@Column`**: Personaliza as colunas no banco de dados.
       - **`@Table`**: Configura o nome da tabela no banco de dados.

   - **Benefícios de Usar `@Entity`**
     1. **Facilidade no Mapeamento ORM**: A JPA simplifica o mapeamento entre classes Java e tabelas no banco de dados, eliminando a necessidade de escrever SQL manual.
     2. **Redução de Código Boilerplate**: Ao invés de escrever consultas SQL complexas, você pode usar operações de persistência de alto nível, como `EntityManager.persist()` e `EntityManager.find()`.
     3. **Facilidade de Manutenção e Escalabilidade**: O código fica mais limpo, fácil de manter e escalável para aplicações grandes.

---

5. **Gerando o ID Automaticamente**
   - **`@Id`**: Define o campo `id` como a chave primária da entidade.
   - **`@GeneratedValue(strategy = GenerationType.IDENTITY)`**: Instrui o JPA a usar uma coluna auto-incrementada no banco de dados para gerar automaticamente os valores de `id`.

---

6. **Serializando a Entidade**
   - **Por que usar `Serializable` em uma Entidade JPA?**
     - **Requisitos de Frameworks**: Frameworks como JPA, Hibernate e bibliotecas de cache exigem que as entidades sejam serializáveis para permitir o armazenamento de objetos em cache ou a transmissão de objetos em sessões distribuídas.
     - **Armazenamento em Cache**: Se sua aplicação usa sistemas de cache distribuído (como `Ehcache` ou `Hazelcast`), a serialização permite transmitir objetos entre diferentes instâncias da aplicação.
     - **Transmissão em Rede**: Se a entidade precisar ser enviada pela rede (ex.: de um servidor para um cliente), a serialização é essencial para que o objeto seja convertido corretamente em bytes e transmitido.

---

7. **Adicionando `hashCode` e `equals`**
   - **`equals`**:
     - **O que faz**: O método `equals` é usado para comparar se dois objetos são "iguais". Por padrão, o método `equals` da classe `Object` verifica se as duas instâncias são exatamente a mesma na memória. No entanto, para entidades como `Compromisso`, queremos comparar com base no valor do `id`.
     - **Por que sobrescrever**: Ao sobrescrever `equals`, você pode definir uma lógica personalizada para determinar a igualdade. Por exemplo, se dois objetos `Compromisso` têm o mesmo `id`, eles podem ser considerados iguais.

   - **`hashCode`**:
     - **O que faz**: O método `hashCode` retorna um número inteiro que representa o objeto em estruturas de dados baseadas em hash, como `HashMap` e `HashSet`. Se dois objetos são iguais de acordo com `equals`, eles **devem** ter o mesmo valor de `hashCode`.
     - **Por que sobrescrever**: Para garantir a consistência com `equals`. Se `equals` é sobrescrito, `hashCode` também deve ser sobrescrito para garantir que objetos iguais sejam tratados corretamente em coleções baseadas em hash.

---

### 5. Criando um Repositório Padrão para o Spring Data JPA

1. **Estrutura de Pastas**
   - Navegue para o diretório: `src/main/java/br/fatec/agenda/Agenda/`.
   - Crie uma nova pasta chamada `repositories`. Essa pasta será usada para armazenar todas as interfaces de repositórios da aplicação, facilitando o acesso e a organização.

2. **Criando o Repositório `AgendaRepository`**
   - Dentro da pasta `repositories`, crie um novo arquivo chamado `AgendaRepository.java` e defina-o como uma **interface**.
   - O código da interface ficará assim:
     ```java
     package br.fatec.agenda.Agenda.repositories;

     import org.springframework.data.jpa.repository.JpaRepository;
     import br.fatec.agenda.Agenda.entities.compromisso;

     // Interface que estende JpaRepository, fornecendo métodos CRUD
     public interface AgendaRepository extends JpaRepository<compromisso, Long> {
     }
     ```
   
3. **Explicação do Código**
   - **`JpaRepository`**: O Spring Data JPA oferece a interface `JpaRepository`, que fornece métodos padrão para operações de banco de dados, como salvar, deletar, atualizar e buscar entidades. Ao estender `JpaRepository`, o `AgendaRepository` herda automaticamente esses métodos.
   - **`<compromisso, Long>`**: Os parâmetros indicam que o repositório gerencia a entidade `compromisso` e que o tipo do identificador (chave primária) é `Long`.
   - **Benefícios**:
     - **Reduz código boilerplate**: Você não precisa escrever consultas SQL complexas para operações básicas.
     - **Integração com o JPA**: O `JpaRepository` facilita a comunicação com o banco de dados, abstraindo os detalhes da persistência.

---

### 6. Configurando as Propriedades do Banco de Dados

1. **Arquivo de Configuração**
   - Navegue até o diretório: `src/main/resources/`.
   - Abra ou crie o arquivo `application.properties`. Este arquivo é usado para definir configurações importantes para a sua aplicação Spring Boot, como propriedades de conexão com o banco de dados.

2. **Definindo as Propriedades do Banco de Dados H2**
   - Adicione as seguintes configurações:
     ```properties
     spring.application.name=Agenda

     # URL do console H2 para acesso pelo navegador
     # Exemplo: http://localhost:8080/h2-console
     spring.datasource.url=jdbc:h2:mem:testdb
     spring.datasource.username=sa
     spring.datasource.password=

     # Configurações adicionais do JPA
     spring.jpa.defer-datasource-initialization=true
     spring.sql.init.encoding=UTF-8
     ```
   
3. **Explicação das Configurações**
   - **`spring.application.name`**: Define o nome da aplicação, que pode ser usado em logs ou para outras identificações.
   - **Banco de Dados H2**:
     - **`spring.datasource.url`**: Define a URL de conexão com o banco de dados H2. Neste caso, um banco de dados em memória chamado `testdb` é usado. O banco H2 é útil para desenvolvimento e testes rápidos.
     - **`spring.datasource.username` e `spring.datasource.password`**: Credenciais padrão para acessar o banco H2 (`sa` sem senha).
   - **Configurações de Inicialização**:
     - **`spring.jpa.defer-datasource-initialization=true`**: Adia a inicialização da fonte de dados até que a configuração do JPA esteja completa. Isso garante que a configuração do banco de dados ocorra corretamente.
     - **`spring.sql.init.encoding=UTF-8`**: Define a codificação de arquivos SQL para `UTF-8`. Isso é importante para garantir que caracteres especiais sejam interpretados corretamente.

4. **Console H2**
   - **URL do Console**: O H2 oferece um console baseado na web para interagir com o banco de dados. Acesse o console em: `http://localhost:8080/h2-console`. Esta é uma ferramenta útil para executar consultas SQL e verificar os dados na sua base em memória.

---

### Benefícios de Usar o H2 no Desenvolvimento

1. **Banco de Dados em Memória**: O H2 é um banco leve e fácil de configurar, perfeito para desenvolvimento e testes. Ele armazena dados na memória, o que significa que eles são descartados quando a aplicação é encerrada.
2. **Console Web**: O console H2 facilita a visualização e a depuração de dados sem a necessidade de uma ferramenta externa de banco de dados.
3. **Configuração Simples**: Usar o H2 com o Spring Boot é simples e direto, permitindo que você comece a trabalhar rapidamente com persistência de dados.

---

### 7. `Criando o Arquivo para Seeding do Banco de Dados`

1. **Arquivo de Configuração**
   - Navegue até o diretório: `src/main/resources/`.
   - Abra ou crie um novo arquivo chamado `data.sql`. Este arquivo é utilizado para inserir dados iniciais no banco de dados automaticamente quando a aplicação é iniciada. Isso é útil para garantir que você tenha alguns dados de exemplo para testes e desenvolvimento.

2. **Estruturando o Arquivo `data.sql`**
   - No arquivo `data.sql`, você pode adicionar instruções SQL para inserir registros na tabela `compromisso`. Aqui está um exemplo com 3 inserts:

     ```sql
     -- Inserindo dados de exemplo na tabela 'compromisso'
     INSERT INTO compromisso (id, title, description, compromisso_date, start_time, end_time, local, priority) 
     VALUES (1, 'Reunião de Projeto', 'Discussão sobre o andamento do projeto X', '2024-11-20', '10:00:00', '11:00:00', 'Sala de Reuniões 1', 2);

     INSERT INTO compromisso (id, title, description, compromisso_date, start_time, end_time, local, priority) 
     VALUES (2, 'Consulta Médica', 'Consulta de rotina com o Dr. Silva', '2024-11-21', '15:00:00', '16:00:00', 'Clínica São José', 1);

     INSERT INTO compromisso (id, title, description, compromisso_date, start_time, end_time, local, priority) 
     VALUES (3, 'Aula de Yoga', 'Sessão de yoga para relaxamento', '2024-11-22', '18:00:00', '19:00:00', 'Academia Zen', 3);
     ```

---

### Explicação dos Inserts

- **Estrutura da Tabela `compromisso`**:
  - `id`: Identificador único do compromisso (número inteiro).
  - `title`: O título ou nome do compromisso.
  - `description`: Uma descrição detalhada do compromisso.
  - `compromisso_date`: A data do compromisso, no formato `YYYY-MM-DD`.
  - `start_time`: Hora de início do compromisso, no formato `HH:MM:SS`.
  - `end_time`: Hora de término do compromisso, no mesmo formato.
  - `local`: O local onde o compromisso será realizado.
  - `priority`: Um número que representa a prioridade do compromisso (ex.: 1 = baixa, 2 = média, 3 = alta).

- **Detalhes dos Exemplos**:
  - **1. Reunião de Projeto**:
    - Data: 20 de novembro de 2024
    - Hora: Das 10:00 às 11:00
    - Local: Sala de Reuniões 1
    - Prioridade: Média (2)
  - **2. Consulta Médica**:
    - Data: 21 de novembro de 2024
    - Hora: Das 15:00 às 16:00
    - Local: Clínica São José
    - Prioridade: Baixa (1)
  - **3. Aula de Yoga**:
    - Data: 22 de novembro de 2024
    - Hora: Das 18:00 às 19:00
    - Local: Academia Zen
    - Prioridade: Alta (3)

---

### Observações

- **Uso em Desenvolvimento**: O arquivo `data.sql` é executado automaticamente pelo Spring Boot ao iniciar a aplicação. Isso garante que o banco de dados seja populado com dados de exemplo, facilitando os testes e o desenvolvimento.
- **Modificação de Dados**: Sinta-se à vontade para modificar ou adicionar mais inserts conforme necessário para atender aos requisitos do seu projeto.

---
### 8. Criando um Serviço e Entendendo Injeção de Dependência**

8.1. **Estrutura de Pastas**
   - Navegue para `src/main/java/br/fatec/agenda/Agenda/`.
   - Crie uma pasta chamada `services` para armazenar os serviços da aplicação.

8.2. **Criando a Classe de Serviço**
   - Dentro da pasta `services`, crie um arquivo chamado `AgendaServices.java`. A classe será responsável pela lógica de negócios relacionada aos compromissos.

8.3. **Código do Serviço**
   ```java

      package br.fatec.agenda.Agenda.services;

         import java.util.List; // Importa a classe List para retornar listas de compromissos

         import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependência
         import org.springframework.stereotype.Service; // Importa a anotação que define a classe como um serviço

         import br.fatec.agenda.Agenda.entities.Compromisso; // Importa a entidade Compromisso
         import br.fatec.agenda.Agenda.repositories.AgendaRepository; // Importa o repositório relacionado

         /**
         * A classe AgendaServices representa a camada de serviço para a aplicação.
         * Ela encapsula a lógica de negócios e interage com o repositório para acessar os dados.
         */
         @Service // Marca esta classe como um componente de serviço gerenciado pelo Spring
         public class AgendaServices {

            // Injeta automaticamente uma instância do repositório
            @Autowired 
            private AgendaRepository repository;

            /**
            * Método que busca todos os compromissos no banco de dados.
            * 
            * @return List<Compromisso> - Lista contendo todos os compromissos.
            */
            public List<Compromisso> GetAllCompromissos() {
               // Utiliza o método findAll() do JpaRepository para buscar todos os registros
               return repository.findAll();
            }
         }
 
   ```

8.4. **O Que é Injeção de Dependência?**
   - **Definição**: Um padrão em que dependências (objetos necessários para uma classe funcionar) são fornecidas externamente, em vez de serem criadas dentro da classe.
   - **Como o Spring Usa DI**:
     - O Spring gerencia as instâncias de objetos (beans) no contexto da aplicação.
     - Dependências são injetadas automaticamente nas classes anotadas com `@Autowired`.
   - **Benefícios**:
     - Reduz o acoplamento entre as classes.
     - Facilita a substituição de dependências em testes (ex.: usando mocks).
     - Centraliza o gerenciamento de dependências, tornando o código mais limpo e organizado.

8.5. **Exemplo no Código**:
   - No exemplo acima:
     - `AgendaRepository` é uma dependência de `AgendaServices`.
     - O Spring injeta automaticamente uma instância de `AgendaRepository` em `AgendaServices` por meio da anotação `@Autowired`.
---

### 9. Criando um Controlador

1. **Estrutura de Pastas**
   - Navegue para o diretório: `src/main/java/br/fatec/agenda/Agenda/`.
   - Crie uma nova pasta chamada `controllers`. Essa pasta será usada para armazenar os controladores da aplicação.

2. **Criando o Controlador `AgendaController`**
   - Dentro da pasta `controllers`, crie um arquivo Java chamado `AgendaController.java`.
   - O controlador é responsável por receber requisições HTTP e retornar respostas adequadas, conectando a camada de apresentação (API) à camada de serviço.

---

### O Que São Endpoints?

- **Definição**: Um **endpoint** é uma URL que representa um recurso ou uma ação específica em uma aplicação web. Ele define como o cliente (por exemplo, um navegador ou uma aplicação frontend) pode interagir com a aplicação backend.
- **Funcionamento**:
  - Cada endpoint corresponde a uma rota na aplicação (ex.: `/Compromisso`).
  - A rota é associada a um método HTTP (GET, POST, PUT, DELETE) que determina a ação a ser realizada.
- **Exemplo no Código**:
  - O endpoint `/Compromisso` está configurado no controlador com a anotação `@RequestMapping("Compromisso")`.
  - A anotação `@GetMapping` indica que o endpoint responde a requisições HTTP do tipo GET.

---

codigo:
```java
      package br.fatec.agenda.Agenda.controllers;

      import java.util.List; // Importa a classe List para retornar listas de compromissos

      import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injeção de dependência
      import org.springframework.web.bind.annotation.GetMapping; // Importa a anotação para mapear requisições HTTP GET
      import org.springframework.web.bind.annotation.RequestMapping; // Importa a anotação para definir a rota base do controlador
      import org.springframework.web.bind.annotation.RestController; // Importa a anotação para definir a classe como um controlador REST

      import br.fatec.agenda.Agenda.entities.Compromisso; // Importa a entidade Compromisso
      import br.fatec.agenda.Agenda.services.AgendaServices; // Importa o serviço que fornece a lógica de negócios

      /**
       * Controlador responsável por gerenciar os endpoints relacionados aos compromissos.
      * Ele conecta a camada de apresentação (API) com a lógica de negócios (serviços).
      */
      @RestController // Define a classe como um controlador REST, gerenciado pelo Spring
      @RequestMapping("Compromisso") // Configura a rota base para os endpoints deste controlador
      public class AgendaController {

      
      @Autowired // Injeta automaticamente o serviço AgendaServices
         
         priv
      private AgendaServices service;

         /**
          * Endpoint para retornar todos os compromissos cadastrados.
          * 
          * @return List<Compromisso> - Lista de todos os compromissos disponíveis no banco de dados.
          */
         @GetMapping // Mapeia o método para responder a requisições HTTP GET na rota base "/Compromisso"
         public List<Compromisso> GetCompromissos() {
            // Chama o método do serviço para buscar todos os compromissos e retorna a lista
            return service.GetAllCompromissos();
         }
      }
```

***Explicação das Etapas***
Anotação @RestController:

Declara a classe como um controlador REST
Anotação @RequestMapping("Compromisso"):

Define a rota base /Compromisso para todos os métodos deste controlador.
Injeção de Depxendência com @Autowired:

Injeta automaticamente uma instância de AgendaServices no atributo service. Isso elimina a necessidade de criar manualmente uma instância do serviço.
Método GetCompromissos:

@GetMapping: Configura este método para responder a requisições HTTP GET.
Lógica:
O método chama o serviço GetAllCompromissos() para buscar todos os compromissos no banco de dados.
Retorna uma lista de objetos do tipo Compromisso.

***Exemplo de Resposta do Endpoint /Compromisso***

```json
[
  {
    "id": 1,
    "title": "Reunião de Projeto",
    "description": "Discussão sobre o andamento do projeto X",
    "compromissoDate": "2024-11-20",
    "startTime": "10:00:00",
    "endTime": "11:00:00",
    "local": "Sala de Reuniões 1",
    "priority": 2
  },
  {
    "id": 2,
    "title": "Consulta Médica",
    "description": "Consulta de rotina com o Dr. Silva",
    "compromissoDate": "2024-11-21",
    "startTime": "15:00:00",
    "endTime": "16:00:00",
    "local": "Clínica São José",
    "priority": 1
  }
]
```


### Explicação do Controlador `AgendaController`

1. **`@RestController`**:
   - Define a classe como um controlador REST. Isso significa que os métodos desta classe retornam diretamente dados no formato JSON ou XML, que são usados em APIs.

2. **`@RequestMapping("Compromisso")`**:
   - Configura a rota base para o controlador. Todas as rotas definidas nos métodos desta classe começam com `/Compromisso`.

3. **`@GetMapping`**:
   - Especifica que o método `GetCompromissos` responde a requisições HTTP do tipo GET na rota `/Compromisso`.
   - Quando acessado, o método retorna uma lista de compromissos.

4. **Endpoint Criado**:
   - **URL**: `/Compromisso`
   - **Método HTTP**: GET
   - **Descrição**: Retorna todos os compromissos cadastrados no banco de dados.

---
### 10. Implementando a Busca de Objeto por ID

#### Atualizações no Serviço

No arquivo `AgendaServices.java`, adicione o seguinte método para buscar um compromisso por ID:

```java
/**
 * Busca um compromisso específico pelo ID.
 * 
 * @param id - O ID do compromisso que deve ser buscado.
 * @return Compromisso - O compromisso correspondente ao ID fornecido.
 * @throws EntityNotFoundException - Se o ID não for encontrado, uma exceção será lançada.
 */
public Compromisso GetCompromissoById(long id) {
    // Utiliza o método findById() do JpaRepository para buscar o compromisso
    // Se não encontrado, lança uma EntityNotFoundException com a mensagem especificada
    return repository.findById(id).orElseThrow(
        () -> new EntityNotFoundException("Compromisso não encontrado")
    );
}
```

---

#### Explicação do Código no Serviço

1. **Método `GetCompromissoById`**:
   - O método recebe um parâmetro `id` do tipo `long`, que é o identificador único do compromisso a ser buscado.
   - Utiliza o método `findById()` do `JpaRepository`, que retorna um objeto `Optional<Compromisso>`.
   - O método `orElseThrow` verifica se o valor está presente no `Optional`. Caso contrário, ele lança uma exceção do tipo `EntityNotFoundException` com a mensagem **"Compromisso não encontrado"**.

2. **Programação Funcional**:
   - **Uso do Lambda**:
     - `() -> new EntityNotFoundException("Compromisso não encontrado")` é uma expressão lambda. 
     - Lambdas são funções anônimas usadas para criar lógica compacta e eficiente, comum em programação funcional.
   - **Vantagens da Programação Funcional**:
     - Código mais conciso e legível.
     - Melhor integração com APIs modernas do Java, como `Optional` e Streams.
   - No caso do método `GetCompromissoById`, o lambda encapsula a lógica de lançar uma exceção, mantendo o código mais limpo.

---

#### Atualizações no Controlador

No arquivo `AgendaController.java`, adicione o seguinte método para mapear o endpoint de busca por ID:

```java
import org.springframework.web.bind.annotation.PathVariable; // Import necessário para vincular variáveis de rota

/**
 * Endpoint para buscar um compromisso pelo ID.
 * 
 * @param id - O ID do compromisso a ser buscado (extraído da URL).
 * @return Compromisso - O compromisso correspondente ao ID fornecido.
 */
@GetMapping("{id}") // Mapeia o método para a rota "/Compromisso/{id}" e método HTTP GET
public Compromisso GetCompromisso(@PathVariable Long id) {
    // Chama o serviço para buscar o compromisso pelo ID e retorna o resultado
    return service.GetCompromissoById(id);
}
```

---

#### Explicação do Código no Controlador

1. **`@GetMapping("{id}")`**:
   - Define que este método responde a requisições HTTP GET para a rota `/Compromisso/{id}`, onde `{id}` é uma variável de rota.

2. **`@PathVariable`**:
   - A anotação `@PathVariable` vincula o valor da variável de rota `{id}` ao parâmetro `id` do método. Isso permite capturar o valor diretamente da URL.

3. **Corpo do Método**:
   - O método chama o serviço `GetCompromissoById()` para buscar o compromisso pelo ID e retorna o objeto encontrado.
   - Se o ID não existir no banco de dados, a exceção `EntityNotFoundException` será lançada e uma resposta de erro será enviada ao cliente.

---

### Novo Endpoint Criado

- **Rota**: `/Compromisso/{id}`
- **Método HTTP**: GET
- **Descrição**:
  - Busca um compromisso específico pelo seu ID.
  - Exemplo de requisição: `GET http://localhost:8080/Compromisso/1`
  - Resposta (se o ID existir):
    ```json
    {
      "id": 1,
      "title": "Reunião de Projeto",
      "description": "Discussão sobre o andamento do projeto X",
      "compromissoDate": "2024-11-20",
      "startTime": "10:00:00",
      "endTime": "11:00:00",
      "local": "Sala de Reuniões 1",
      "priority": 2
    }
    ```
  - Resposta (se o ID não existir):
    ```json
    {
      "timestamp": "2024-11-20T12:00:00.000+00:00",
      "status": 404,
      "error": "Not Found",
      "message": "Compromisso não encontrado",
      "path": "/Compromisso/99"
    }
    ```

---

### Benefícios da Implementação

- **Programação Funcional**:
  - O uso de lambdas e `Optional` simplifica o tratamento de valores nulos e evita verificações manuais repetitivas.
- **Separação de Responsabilidades**:
  - O controlador lida apenas com a entrada e saída da API, enquanto a lógica de negócios fica isolada no serviço.
- **Escalabilidade**:
  - Facilita a adição de novas operações sem impactar a estrutura existente.

---

### 11. Adicionando a Função de Deletar um Compromisso

#### Atualização no Serviço

No arquivo `AgendaServices.java`, adicione o método para deletar um compromisso pelo ID:

```java
/**
 * Deleta um compromisso pelo ID, se ele existir.
 * 
 * @param id - O ID do compromisso que será deletado.
 * @throws EntityNotFoundException - Se o compromisso com o ID fornecido não for encontrado.
 */
public void delete(long id) {
    // Verifica se o compromisso com o ID existe no banco de dados
    if (repository.existsById(id)) {
        // Deleta o compromisso pelo ID
        repository.deleteById(id);
    } else {
        // Lança uma exceção se o ID não for encontrado
        throw new EntityNotFoundException("Compromisso não encontrado");
    }
}
```

#### Explicação

1. **`existsById`**:
   - Método fornecido pelo `JpaRepository` para verificar se um registro com o ID fornecido existe no banco de dados.
2. **`deleteById`**:
   - Deleta o registro correspondente ao ID fornecido.
3. **Exceção `EntityNotFoundException`**:
   - Lançada se o compromisso com o ID fornecido não for encontrado. Isso garante que apenas compromissos existentes sejam deletados.

---

#### Atualização no Controlador

No arquivo `AgendaController.java`, adicione o método para mapear o endpoint de exclusão:

```java
import org.springframework.web.bind.annotation.DeleteMapping; // Import necessário para mapear requisições DELETE

/**
 * Endpoint para deletar um compromisso pelo ID.
 * 
 * @param id - O ID do compromisso a ser deletado.
 */
@DeleteMapping("{id}") // Mapeia o método para requisições HTTP DELETE na rota "/Compromisso/{id}"
public void DeleteCompromisso(@PathVariable long id) {
    // Chama o serviço para deletar o compromisso
    service.delete(id);
}
```

#### Novo Endpoint Criado

- **Rota**: `/Compromisso/{id}`
- **Método HTTP**: DELETE
- **Descrição**:
  - Exclui um compromisso pelo seu ID.
  - Exemplo de requisição: `DELETE http://localhost:8080/Compromisso/1`
  - Resposta:
    - Sem conteúdo no corpo (`204 No Content`) se o compromisso for deletado.
    - Erro `404 Not Found` se o compromisso com o ID fornecido não existir.

---

### 12. Subindo o Código para Nível de Maturidade 2

#### Atualização no Controlador

Atualize os métodos no controlador `AgendaController` para retornar **status codes HTTP adequados** usando `ResponseEntity`:

```java
import org.springframework.http.ResponseEntity; // Import necessário para construir respostas HTTP
import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * Endpoint para listar todos os compromissos.
 * 
 * @return ResponseEntity<List<Compromisso>> - Resposta HTTP com lista de compromissos e status 200 OK.
 */
@GetMapping
public ResponseEntity<List<Compromisso>> GetCompromissos() {
    // Retorna a lista de compromissos com o status 200 OK
    return ResponseEntity.ok(service.GetAllCompromissos());
}

/**
 * Endpoint para buscar um compromisso pelo ID.
 * 
 * @param id - O ID do compromisso a ser buscado.
 * @return ResponseEntity<Compromisso> - Resposta HTTP com o compromisso e status 200 OK.
 */
@GetMapping("{id}")
public ResponseEntity<Compromisso> GetCompromisso(@PathVariable Long id) {
    // Retorna o compromisso encontrado com o status 200 OK
    return ResponseEntity.ok(service.GetCompromissoById(id));
}

/**
 * Endpoint para deletar um compromisso pelo ID.
 * 
 * @param id - O ID do compromisso a ser deletado.
 * @return ResponseEntity<Void> - Resposta HTTP com status 204 No Content.
 */
@DeleteMapping("{id}")
public ResponseEntity<Void> DeleteCompromisso(@PathVariable long id) {
    // Deleta o compromisso e retorna o status 204 No Content
    service.delete(id);
    return ResponseEntity.noContent().build();
}
```

---

#### Alterações e Explicações

1. **Uso de `ResponseEntity`**:
   - Encapsula o corpo da resposta e o status HTTP em um único objeto.
   - Facilita o controle sobre o que será retornado ao cliente.

2. **Novos Status Codes HTTP**:
   - **`200 OK`**:
     - Retornado para requisições bem-sucedidas de busca (`GET`).
   - **`204 No Content`**:
     - Retornado para requisições de exclusão bem-sucedidas (`DELETE`).
   - **`404 Not Found`**:
     - Retornado automaticamente se o serviço lançar uma exceção `EntityNotFoundException`.

3. **Alterações nos Métodos**:
   - **`GetCompromissos`**:
     - Retorna uma lista de compromissos com o status `200 OK`.
   - **`GetCompromisso`**:
     - Retorna um compromisso específico pelo ID com o status `200 OK`.
   - **`DeleteCompromisso`**:
     - Deleta um compromisso e retorna o status `204 No Content`.


O nível de maturidade 2 faz parte do **Modelo de Maturidade REST de Richardson**, que é um modelo que mede o grau de adesão de uma API aos princípios do estilo arquitetural REST (**Representational State Transfer**). Esse modelo tem 4 níveis (0 a 3), e cada nível representa uma evolução no design de APIs RESTful.

### Resumo do Modelo de Maturidade REST de Richardson

1. **Nível 0: API Monolítica**
   - As APIs neste nível tratam todas as operações como uma única interface.
   - Exemplo: Todas as requisições são feitas para uma única URL (`/api`) e diferem apenas pelo corpo da mensagem.
   - Não utiliza métodos HTTP ou conceitos REST.

2. **Nível 1: Recursos**
   - Introduz o conceito de **recursos**.
   - Cada entidade ou operação da API é representada por uma URL única.
   - Exemplo:
     - `/compromissos`: Representa uma coleção de compromissos.
     - `/compromissos/{id}`: Representa um único compromisso.

3. **Nível 2: Verbs HTTP (Métodos HTTP)**
   - Usa métodos HTTP adequados para cada operação:
     - `GET`: Para buscar recursos.
     - `POST`: Para criar novos recursos.
     - `PUT` ou `PATCH`: Para atualizar recursos.
     - `DELETE`: Para excluir recursos.
   - Além disso, usa **códigos de status HTTP** para indicar o resultado das operações:
     - `200 OK`: Operação bem-sucedida.
     - `201 Created`: Recurso criado com sucesso.
     - `204 No Content`: Operação bem-sucedida sem retorno de corpo.
     - `404 Not Found`: Recurso não encontrado.
     - `500 Internal Server Error`: Erro inesperado no servidor.

4. **Nível 3: HATEOAS (Hypermedia As The Engine Of Application State)**
   - APIs neste nível retornam links no corpo da resposta que indicam como o cliente pode navegar entre os recursos.
   - Exemplo:
     ```json
     {
       "id": 1,
       "title": "Reunião de Projeto",
       "links": [
         { "rel": "self", "href": "/compromissos/1" },
         { "rel": "delete", "href": "/compromissos/1" },
         { "rel": "update", "href": "/compromissos/1" }
       ]
     }
     ```

---

### Foco no Nível 2

O nível de maturidade 2 é o mais comumente implementado e representa uma **API RESTful funcional e eficiente**. Ele inclui:

1. **Uso Adequado de Métodos HTTP**:
   - As operações são bem definidas com base no método HTTP usado:
     - `GET` para leitura.
     - `POST` para criação.
     - `PUT/PATCH` para atualização.
     - `DELETE` para remoção.

2. **Códigos de Status HTTP**:
   - A API deve retornar um **código de status HTTP apropriado** para cada operação. Isso ajuda os clientes (frontend, outras aplicações) a entenderem o resultado de uma requisição sem precisar analisar o corpo da resposta.

3. **Design Baseado em Recursos**:
   - Cada URL representa um recurso único ou uma coleção de recursos.
   - Exemplo:
     - `/compromissos`: Representa a coleção de compromissos.
     - `/compromissos/{id}`: Representa um único compromisso.

---

### Exemplo de API no Nível de Maturidade 2

#### Requisição: Buscar Todos os Compromissos
```http
GET /compromissos
```
- **Resposta**: 
  - Status: `200 OK`
  - Corpo:
    ```json
    [
      {
        "id": 1,
        "title": "Reunião de Projeto"
      },
      {
        "id": 2,
        "title": "Consulta Médica"
      }
    ]
    ```

#### Requisição: Criar um Novo Compromisso
```http
POST /compromissos
Content-Type: application/json

{
  "title": "Nova Reunião",
  "description": "Discussão de planejamento"
}
```
- **Resposta**:
  - Status: `201 Created`
  - Cabeçalho `Location`: `/compromissos/3`
  - Corpo:
    ```json
    {
      "id": 3,
      "title": "Nova Reunião"
    }
    ```

#### Requisição: Deletar um Compromisso
```http
DELETE /compromissos/3
```
- **Resposta**:
  - Status: `204 No Content`

---

### Por Que Implementar o Nível 2?

- **Melhor Integração**: Clientes podem entender e consumir a API facilmente, pois seguem padrões HTTP bem estabelecidos.
- **Feedback Claro**: Códigos de status HTTP eliminam ambiguidades sobre o sucesso ou falha de uma operação.
- **Base para Escalabilidade**: APIs no nível 2 podem ser facilmente integradas com sistemas modernos, incluindo arquiteturas frontend, sistemas distribuídos e ferramentas automatizadas.

---

### 13. Adicionando as Funções `Save`, `Update` e `Put`

Nesta etapa, vamos implementar as funcionalidades para salvar novos compromissos e atualizar compromissos existentes.

---

### Atualizações no Serviço

No arquivo `AgendaServices.java`, adicione os métodos `save` e `update`:

```java
/**
 * Salva um novo compromisso no banco de dados.
 * 
 * @param compromisso - Objeto do tipo Compromisso a ser salvo.
 * @return Compromisso - O compromisso recém-salvo.
 */
public Compromisso save(Compromisso compromisso) {
    // Utiliza o método save do JpaRepository para salvar o compromisso
    return repository.save(compromisso);
}

/**
 * Atualiza os dados de um compromisso existente.
 * 
 * @param compromisso - Objeto contendo os novos dados do compromisso.
 * @param id - O ID do compromisso a ser atualizado.
 */
public void update(Compromisso compromisso, long id) {
    // Busca o compromisso existente pelo ID sem carregá-lo totalmente
    Compromisso aux = repository.getReferenceById(id);

    // Atualiza os atributos do compromisso existente com os novos valores
    aux.setTitle(compromisso.getTitle());
    aux.setDescription(compromisso.getDescription());
    aux.setCompromissoDate(compromisso.getCompromissoDate());
    aux.setStartTime(compromisso.getStartTime());
    aux.setEndTime(compromisso.getEndTime());
    aux.setLocal(compromisso.getLocal());
    aux.setPriority(compromisso.getPriority());

    // Salva as mudanças no banco de dados
    repository.save(aux);
}
```

---

### Explicação do Código no Serviço

1. **Método `save`**:
   - Salva um novo compromisso no banco de dados usando o método `save` do `JpaRepository`.
   - Retorna o compromisso recém-criado.

2. **Método `update`**:
   - Busca o compromisso existente pelo ID usando `getReferenceById` (que cria um proxy sem carregar o objeto completamente).
   - Atualiza os atributos do compromisso existente com os valores do objeto recebido.
   - Salva as alterações no banco de dados com o método `save`.

---

### Atualizações no Controlador

No arquivo `AgendaController.java`, adicione os endpoints para criar e atualizar compromissos:

```java
import org.springframework.web.bind.annotation.PutMapping; // Import necessário para requisições PUT
import org.springframework.web.bind.annotation.PostMapping; // Import necessário para requisições POST
import org.springframework.web.bind.annotation.RequestBody; // Import necessário para mapear o corpo da requisição

/**
 * Endpoint para criar um novo compromisso.
 * 
 * @param compromisso - Objeto do tipo Compromisso enviado no corpo da requisição.
 * @return ResponseEntity<Compromisso> - Resposta com o compromisso criado e status 201 Created.
 */
@PostMapping // Mapeia o método para requisições HTTP POST na rota "/Compromisso"
public ResponseEntity<Compromisso> SaveCompromisso(@RequestBody Compromisso compromisso) {
    // Salva o novo compromisso e retorna a resposta com status 201 Created
    Compromisso newCompromisso = service.save(compromisso);
    return ResponseEntity.created(null).body(newCompromisso);
}

/**
 * Endpoint para atualizar um compromisso existente.
 * 
 * @param id - O ID do compromisso a ser atualizado.
 * @param compromisso - Objeto do tipo Compromisso enviado no corpo da requisição.
 * @return ResponseEntity<Void> - Resposta com status 200 OK.
 */
@PutMapping("{id}") // Mapeia o método para requisições HTTP PUT na rota "/Compromisso/{id}"
public ResponseEntity<Void> UpdateCompromisso(@PathVariable long id, @RequestBody Compromisso compromisso) {
    // Atualiza o compromisso existente
    service.update(compromisso, id);
    return ResponseEntity.ok().build();
}
```

---

### Explicação do Código no Controlador

1. **Método `SaveCompromisso`**:
   - Mapeado com `@PostMapping`, que lida com requisições HTTP POST.
   - Recebe o novo compromisso no corpo da requisição (`@RequestBody`).
   - Chama o serviço `save` para salvar o compromisso.
   - Retorna uma resposta com:
     - **Status `201 Created`**: Indica que o recurso foi criado com sucesso.
     - O compromisso recém-criado no corpo da resposta.

2. **Método `UpdateCompromisso`**:
   - Mapeado com `@PutMapping`, que lida com requisições HTTP PUT.
   - Recebe o ID do compromisso a ser atualizado na URL (`@PathVariable`) e os novos dados no corpo da requisição (`@RequestBody`).
   - Chama o serviço `update` para atualizar o compromisso.
   - Retorna uma resposta com:
     - **Status `200 OK`**: Indica que o recurso foi atualizado com sucesso.

---

### Novos Endpoints Criados

#### Endpoint para Criar um Novo Compromisso

- **Rota**: `/Compromisso`
- **Método HTTP**: POST
- **Descrição**:
  - Cria um novo compromisso no banco de dados.
  - Exemplo de requisição:
    ```http
    POST /Compromisso
    Content-Type: application/json

    {
      "title": "Reunião de Planejamento",
      "description": "Discussão sobre o projeto Y",
      "compromissoDate": "2024-11-22",
      "startTime": "14:00:00",
      "endTime": "15:30:00",
      "local": "Sala 3",
      "priority": 1
    }
    ```
  - Resposta:
    ```http
    HTTP/1.1 201 Created
    Content-Type: application/json

    {
      "id": 5,
      "title": "Reunião de Planejamento",
      "description": "Discussão sobre o projeto Y",
      "compromissoDate": "2024-11-22",
      "startTime": "14:00:00",
      "endTime": "15:30:00",
      "local": "Sala 3",
      "priority": 1
    }
    ```

---

#### Endpoint para Atualizar um Compromisso

- **Rota**: `/Compromisso/{id}`
- **Método HTTP**: PUT
- **Descrição**:
  - Atualiza os dados de um compromisso existente.
  - Exemplo de requisição:
    ```http
    PUT /Compromisso/5
    Content-Type: application/json

    {
      "title": "Reunião Atualizada",
      "description": "Discussão final do projeto Y",
      "compromissoDate": "2024-11-23",
      "startTime": "16:00:00",
      "endTime": "17:00:00",
      "local": "Sala 2",
      "priority": 2
    }
    ```
  - Resposta:
    ```http
    HTTP/1.1 200 OK
    ```

---
### 14. DTO e Validações


#### Dependência para Validações

No arquivo `pom.xml`, adicione a seguinte dependência dentro da seção `<dependencies>`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

- **Sobre a dependência**:
  - **`spring-boot-starter-validation`**: É uma biblioteca que permite realizar validações baseadas no padrão **Bean Validation**.
  - **Hibernate Validator**: É a implementação de referência para Bean Validation no Spring Boot. Ele fornece anotações como `@NotNull`, `@Size`, `@Email`, entre outras, para validar os atributos de um objeto.

---

#### O que é o Padrão DTO (Data Transfer Object)?

1. **Definição**:
   - Um **DTO** (Objeto de Transferência de Dados) é um padrão de projeto usado para transferir dados entre camadas da aplicação, especialmente entre a camada de serviço e a camada de apresentação (controladores).
   - Ele evita expor diretamente as entidades JPA, promovendo segurança e flexibilidade.

2. **Benefícios**:
   - **Segurança**: Esconde detalhes internos da entidade (como propriedades sensíveis ou relações complexas).
   - **Facilidade de Modificação**: Permite ajustar a resposta da API sem modificar as entidades ou a lógica de negócio.
   - **Validações e Formatações**: Permite aplicar validações específicas ou transformar os dados antes de enviá-los.

Para mais informações, acesse: [Refactoring Guru - DTO](https://refactoring.guru/design-patterns).

---

#### Implementando DTO na Aplicação

##### Estrutura do DTO `CompromissoResponse`

- Navegue para o diretório: `src/main/java/br/fatec/agenda/Agenda/`.
- Crie a pasta `dtos`e dentro dela o arquivo `CompromissoResponse.java` do tipo `record`:

```java
package br.fatec.agenda.Agenda.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO para representar os dados de um compromisso.
 * Este record encapsula os campos necessários para retornar informações ao cliente.
 */
public record CompromissoResponse(
    long id, 
    String title, 
    String description, 
    LocalDate compromissoDate, 
    LocalTime startTime, 
    LocalTime endTime, 
    String local, 
    long priority
) {}
```

---

##### Mapeando a Entidade para o DTO

- Navegue para o diretório: `src/main/java/br/fatec/agenda/Agenda/`.
- Crie a pasta `mappers` e dentro dela o arquivo `CompromissoMapper.java` do tipo classe:

```java
package br.fatec.agenda.Agenda.mappers;

import br.fatec.agenda.Agenda.dtos.CompromissoResponse;
import br.fatec.agenda.Agenda.entities.Compromisso;

/**
 * Classe responsável por converter uma entidade Compromisso em um DTO CompromissoResponse.
 */
public class CompromissoMapper {

    /**
     * Converte uma entidade Compromisso para o DTO CompromissoResponse.
     * 
     * @param compromisso - Entidade Compromisso a ser convertida.
     * @return CompromissoResponse - DTO contendo os dados do compromisso.
     */
    public static CompromissoResponse toDTO(Compromisso compromisso) {
        return new CompromissoResponse(
            compromisso.getId(),
            compromisso.getTitle(),
            compromisso.getDescription(),
            compromisso.getCompromissoDate(),
            compromisso.getStartTime(),
            compromisso.getEndTime(),
            compromisso.getLocal(),
            compromisso.getPriority()
        );
    }
}
```

---

##### Atualizando o Serviço para Retornar DTOs

No arquivo `AgendaServices.java`, modifique o método `GetAllCompromissos` para retornar uma lista de DTOs:

```java
import java.util.stream.Collectors;
import br.fatec.agenda.Agenda.mappers.CompromissoMapper;
import br.fatec.agenda.Agenda.dtos.CompromissoResponse;

/**
 * Retorna uma lista de compromissos no formato DTO.
 * 
 * @return List<CompromissoResponse> - Lista de DTOs contendo os dados dos compromissos.
 */
public List<CompromissoResponse> GetAllCompromissos() {
    // Converte a lista de entidades para uma lista de DTOs usando programação funcional
    return repository.findAll().stream()
        .map(CompromissoMapper::toDTO) // Converte cada Compromisso para CompromissoResponse
        .collect(Collectors.toList()); // Coleta os resultados em uma lista
}
```

---

##### Atualizando o Controlador

No arquivo `AgendaController.java`, modifique o endpoint `GetCompromissos` para usar o DTO:

```java
import br.fatec.agenda.Agenda.dtos.CompromissoResponse;

/**
 * Endpoint para listar todos os compromissos no formato DTO.
 * 
 * @return ResponseEntity<List<CompromissoResponse>> - Resposta com lista de DTOs e status 200 OK.
 */
@GetMapping
public ResponseEntity<List<CompromissoResponse>> GetCompromissos() {
    // Chama o serviço e retorna a lista de DTOs com status 200 OK
    return ResponseEntity.ok(service.GetAllCompromissos());
}
```

---

#### O Que é Programação Funcional?

1. **Definição**:
   - A **programação funcional** é um paradigma de programação que trata funções como cidadãos de primeira classe. Isso significa que as funções podem ser passadas como argumentos, retornadas como valores e usadas em expressões.

2. **Características no Código**:
   - Uso de **lambdas**: Expressões compactas para definir funções.
   - Uso de **Streams**: Uma API moderna do Java para processar coleções de forma declarativa.
   - Operadores como `map`, `filter` e `reduce` para transformar e manipular dados.

3. **Exemplo no Serviço**:
   - No método `GetAllCompromissos`, o código:
     ```java
     return repository.findAll().stream()
         .map(CompromissoMapper::toDTO)
         .collect(Collectors.toList());
     ```
     - **`stream()`**: Converte a lista em um fluxo para processamento funcional.
     - **`map(CompromissoMapper::toDTO)`**: Aplica a conversão de cada entidade para o DTO.
     - **`collect(Collectors.toList())`**: Coleta o resultado em uma lista.

4. **Vantagens da Programação Funcional**:
   - **Concisão**: Código mais curto e legível.
   - **Imutabilidade**: Dados originais não são alterados.
   - **Paralelismo**: Facilita o processamento em paralelo.

---

### Adicionando Validações e DTOs no Controle de Compromissos

#### 1. **Atualizando o Controlador**

No arquivo `AgendaController.java`, atualizamos os métodos para usar DTOs de entrada e saída e para incluir validações.

```java
@GetMapping("{id}")
public ResponseEntity<CompromissoResponse> GetCompromisso(@PathVariable Long id) {
    return ResponseEntity.ok(service.GetCompromissoById(id));
}

@DeleteMapping("{id}")
public ResponseEntity<Void> DeleteCompromisso(@PathVariable long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
}

@PutMapping("{id}")
public ResponseEntity<Void> UpdateCompromisso(@PathVariable long id, @Validated @RequestBody CompromissoRequest compromisso) {
    service.update(compromisso, id);
    return ResponseEntity.ok().build();
}

@PostMapping
public ResponseEntity<CompromissoResponse> SaveCompromisso(@Validated @RequestBody CompromissoRequest compromisso) {
    CompromissoResponse newCompromisso = service.save(compromisso);
    return ResponseEntity.created(null).body(newCompromisso);
}
```

**Explicação:**
- **Validações (@Validated)**: As anotações do pacote `jakarta.validation` são aplicadas automaticamente nos DTOs.
- **DTOs de Entrada e Saída**:
  - **`CompromissoRequest`**: DTO usado para receber dados do cliente.
  - **`CompromissoResponse`**: DTO usado para retornar dados ao cliente.
- **Resposta com Status**:
  - `ResponseEntity.ok()`: Retorna `200 OK` para operações bem-sucedidas.
  - `ResponseEntity.noContent().build()`: Retorna `204 No Content` após exclusões bem-sucedidas.
  - `ResponseEntity.created()`: Retorna `201 Created` após criar um novo recurso.

---

#### 2. **Criando o DTO `CompromissoRequest`**

Crie o arquivo `CompromissoRequest.java` na pasta `dtos`:

```java
package br.fatec.agenda.Agenda.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO para entrada de dados de compromissos.
 */
public record CompromissoRequest(
    @NotBlank(message = "Precisamos de um título")
    String title,

    String description,

    @FutureOrPresent(message = "Precisa ser no futuro ou no presente")
    LocalDate compromissoDate,

    @Future(message = "Precisa ser no futuro")
    LocalTime startTime,

    @Future(message = "Precisa ser no futuro")
    LocalTime endTime,

    @NotBlank(message = "Local é obrigatório")
    String local,

    @Size(min = 1, max = 10, message = "A prioridade deve estar entre 1 e 10")
    long priority
) {}
```

**Explicação:**
- **Validações no DTO**:
  - `@NotBlank`: Garante que o campo não esteja vazio.
  - `@FutureOrPresent`: Garante que a data não seja no passado.
  - `@Future`: Garante que o horário não seja no passado.
  - `@Size`: Garante que o valor esteja dentro de um intervalo definido.

---

#### 3. **Atualizando o Mapper**

No arquivo `CompromissoMapper.java`, adicionamos um método para converter o DTO de entrada (`CompromissoRequest`) em uma entidade:

```java
package br.fatec.agenda.Agenda.mappers;

import br.fatec.agenda.Agenda.dtos.CompromissoRequest;
import br.fatec.agenda.Agenda.dtos.CompromissoResponse;
import br.fatec.agenda.Agenda.entities.Compromisso;

/**
 * Mapeador para conversão entre entidades e DTOs.
 */
public class CompromissoMapper {

    public static CompromissoResponse toDTO(Compromisso compromisso) {
        return new CompromissoResponse(
            compromisso.getId(),
            compromisso.getTitle(),
            compromisso.getDescription(),
            compromisso.getCompromissoDate(),
            compromisso.getStartTime(),
            compromisso.getEndTime(),
            compromisso.getLocal(),
            compromisso.getPriority()
        );
    }

    public static Compromisso toEntity(CompromissoRequest compromissoRequest) {
        Compromisso compromisso = new Compromisso();
        compromisso.setTitle(compromissoRequest.title());
        compromisso.setDescription(compromissoRequest.description());
        compromisso.setCompromissoDate(compromissoRequest.compromissoDate());
        compromisso.setStartTime(compromissoRequest.startTime());
        compromisso.setEndTime(compromissoRequest.endTime());
        compromisso.setLocal(compromissoRequest.local());
        compromisso.setPriority(compromissoRequest.priority());
        return compromisso;
    }
}
```

**Explicação:**
- **`toDTO`**: Converte uma entidade `Compromisso` em um DTO `CompromissoResponse` para ser retornado ao cliente.
- **`toEntity`**: Converte um DTO `CompromissoRequest` em uma entidade `Compromisso` para ser salvo ou atualizado.

---

#### 4. **Atualizando o Serviço**

No arquivo `AgendaServices.java`, atualizamos os métodos para usar o novo DTO de entrada e saída:

```java
public List<CompromissoResponse> GetAllCompromissos() {
    return repository.findAll().stream()
        .map(CompromissoMapper::toDTO)
        .collect(Collectors.toList());
}

public CompromissoResponse GetCompromissoById(long id) {
    Compromisso compromisso = repository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Compromisso não encontrado"));
    return CompromissoMapper.toDTO(compromisso);
}

public void delete(long id) {
    if (!repository.existsById(id)) {
        throw new EntityNotFoundException("Compromisso não encontrado");
    }
    repository.deleteById(id);
}

public CompromissoResponse save(CompromissoRequest compromisso) {
    Compromisso newCompromisso = repository.save(CompromissoMapper.toEntity(compromisso));
    return CompromissoMapper.toDTO(newCompromisso);
}

public void update(CompromissoRequest compromisso, long id) {
    Compromisso aux = repository.getReferenceById(id);
    aux.setTitle(compromisso.title());
    aux.setDescription(compromisso.description());
    aux.setCompromissoDate(compromisso.compromissoDate());
    aux.setStartTime(compromisso.startTime());
    aux.setEndTime(compromisso.endTime());
    aux.setLocal(compromisso.local());
    aux.setPriority(compromisso.priority());
    repository.save(aux);
}
```

**Explicação:**
- **Validações Automáticas**:
  - O DTO `CompromissoRequest` já tem validações integradas.
- **Uso de DTOs**:
  - Os métodos de entrada usam `CompromissoRequest` para garantir a integridade dos dados.
  - Os métodos de saída retornam `CompromissoResponse` para proteger as entidades.

---

### Testando a API

#### Endpoints Criados

1. **Listar Compromissos**
   - Rota: `GET /Compromisso`
   - Resposta: Lista de compromissos no formato `CompromissoResponse`.

2. **Buscar Compromisso por ID**
   - Rota: `GET /Compromisso/{id}`
   - Resposta: Dados do compromisso no formato `CompromissoResponse`.

3. **Criar Novo Compromisso**
   - Rota: `POST /Compromisso`
   - Corpo da Requisição: `CompromissoRequest`.
   - Resposta: Compromisso criado no formato `CompromissoResponse`.

4. **Atualizar Compromisso**
   - Rota: `PUT /Compromisso/{id}`
   - Corpo da Requisição: `CompromissoRequest`.

5. **Excluir Compromisso**
   - Rota: `DELETE /Compromisso/{id}`
---
 # OBS:

 Para que seu projeto rode corretamente junto ao frontend é necessarios acrescentar a notação @CrossOrigin e seu import ao controler (no meu caso AgendaControler.java)

