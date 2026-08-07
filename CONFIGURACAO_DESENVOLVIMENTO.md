# ValidES - Aplicativo Acadêmico para Testes de Software e OOP

## Especificação técnica do projeto ValidES.

## Ações por classes

Como se trata de uma aplicação MDI, o *ScreenManager.java* fica responsável por:

Controlar a área de trabalho MDI.
Abrir telas filhas.
Fechar telas filhas.
Impedir duplicidade de telas.
Centralizar carregamento de FXML.

# CAPITULOS

## 1. Objetivo do Projeto

O ValidES é um software desktop desenvolvido em Java, utilizando JavaFX, Maven e arquitetura MVC.

Seu objetivo é servir como estudo de caso para as disciplinas:
- Teste de Software
- Programação Orientada a Objetos

O sistema contém módulos funcionais com **defeitos lógicos propositais** para que os alunos utilizem técnicas de teste e o framework JUnit para localizar e corrigir os problemas.

## 2. Requisitos de Software
2.1. O usuário (aluno) utiliza normalmente o software.
2.2. Caso o resultado seja diferente do esperado, ele não corrige pela interface.
2.3. Ele abre o projeto no Eclipse.
2.4. Analisa o código-fonte.
2.5. Escreve ou executa os testes JUnit.
2.6. Localiza a falha lógica.
2.7. Corrige a implementação.
2.8. Executa novamente a aplicação para validar a correção.

2.9. filosofia do projeto.

O código-fonte distribuído aos alunos não deve ser alterado durante as atividades de teste. As evidências de defeitos devem ser obtidas por meio da criação e execução de testes automatizados com JUnit.

## 3. Arquitetura do Software
3.1 Arquitetura MVC
3.2 Padrão MDI

Padrão de interface: MDI (uma única tela filha aberta por vez).

3.3 Fluxo de navegação entre telas

Tela principal: MainView.fxml.

3.4 ScreenManager

O MainController ficará responsável apenas por responder aos eventos do menu e atualizar a barra de status, enquanto todo o gerenciamento de telas ficará centralizado no ScreenManager

## 4. Estrutura de Diretórios

4.1 MVC

4.2 MDI

4.3 Service Layer

4.4 Repository Pattern

4.5 ScreenManager

ScreenManager controla o ambiente MDI, e se necessário mudanças futuras de MDI deve ser alterado apenas em ScreenManager, e sendo assim:

--- 

- nenhum controller manipulará diretamente o desktopPane;
- toda a lógica de abertura e fechamento ficará centralizada em um único lugar;
- se um dia o comportamento do MDI mudar, apenas o ScreenManager precisará ser alterado.

--- 

## 5. Configuração do Eclipse

IDE: Eclipse.

## 6. Configuração do Java 25

## 7. Configuração do Maven

## 8. Configuração do JavaFX

## 9. Configuração do module-info.java

Todo pacote que contém Controllers JavaFX deve ser declarado com opens ... to javafx.fxml;. A criação de novos subpacotes (controller.trigonometria, controller.conversoes, etc.) exige a atualização correspondente do module-info.java.

Sempre que um novo pacote de controllers for criado (controller.trigonometria, controller.validadores, etc.), deve ser adicionada a instrução opens ... to javafx.fxml; correspondente.

## 10. Configuração do pom.xml

## 11. Template Oficial de Telas do ValidES

Template oficial: ModuleTemplate.fxml.
O ModuleTemplate.fxml não terá:
- fx:controller
- fx:id
- onAction
- lógica de negócio
- referências a ScreenManager

Ele será um documento de referência visual.

11.1 Estrutura visual

BorderPane
│
├── Top
│     VBox
│       ├── Título
│       ├── Descrição
│       └── Separator
│
├── Center
│     VBox
│       ├── TitledPane
│       │      GridPane (Dados de Entrada)
│       │
│       └── TitledPane
│              TextArea (Resultado)
│
└── Bottom
      HBox
          Executar
          Limpar
          (espaço)
          Fechar

11.2 Cabeçalho

11.3 Painel de Entrada

11.4 Painel de Resultado

11.5 Barra de Ações

11.6 Botões obrigatórios

11.7 Controllers

11.8 Convenções para os arquivos FXML

11.9 Convenções para CSS


## 12. Argumentos da JVM

## 13. Execução do Projeto

## 14. Depuração (Debug)

## 15. Resolução de Problemas Conhecidos

Ao decorrer do projeto algumas inconformidades foram tratadas.

Problema: Module ValidES not found

Solução: Executar: Project -> Clean e Maven -> Update Project

Problema: WARNING: Restricted methods will be blocked in a future release
Solução: Adicionar --enable-native-access=javafx.graphics na configuração VM Arguments da execução Java Application.

Em Main.java, mais precisamente na declaração public void start(Stage stage) throws Exception
Para esta expressão recebo a seguinte mensagem: Multiple markers at this line:  The type Stage from module javafx.graphics may not be accessible to clients due to missing 'requires transitive', implements javafx.application.Application.start
[Esta foi aceita como um falso positivo do Eclipse...]

## 16. Convenções de Desenvolvimento

### 16.01. - Nomes dos Arquivos

* Views: NomeView.fxml
* Controllers: NomeController.java
* Services: NomeService.java
* Testes: NomeServiceTest.java

### 16.02. - Divisão por Blocos para Service

======================================================<br>
MÉTODOS PÚBLICOS<br>
======================================================

======================================================<br>
VALIDAÇÕES<br>
======================================================

======================================================<br>
REGRAS DE NEGÓCIO<br>
======================================================

======================================================<br>
GERAÇÃO DO RELATÓRIO<br>
======================================================

### 16.03. - Divisão por Blocos para Controller

======================================================<br>
COMPONENTES FXML<br>
======================================================

======================================================<br>
SERVIÇOS<br>
======================================================

======================================================<br>
INICIALIZAÇÃO<br>
======================================================

======================================================<br>
EVENTOS DA INTERFACE<br>
======================================================

======================================================<br>
MÉTODOS AUXILIARES<br>
======================================================

### 16.04. - Divisão para as classes de modelo

/**
 * Descrição da classe.
 */
public class NomeModel {

    /*======================================================
     * ATRIBUTOS
     *======================================================*/

    ...

    /*======================================================
     * CONSTRUTORES
     *======================================================*/

    ...

    /*======================================================
     * GETTERS E SETTERS
     *======================================================*/

    ...

}



## 17. Histórico de Alterações

Versão 0.0.1

- Estrutura Maven criada
- JavaFX configurado
- Tela Principal criada
- Primeira tela filha criada

## 18. Catálogo de Casos de Estudo

Problema do Triângulo

objetivo;
regra de negócio;
defeito lógico inserido;
conceitos de teste abordados;
exercícios propostos aos alunos.

Calculadora de INSS
Validador de CPF
Validador de CNPJ
Conversão de Datas
Carrinho de Compras

## 19. Roadmap de Desenvolvimento

19.1 Infraestrutura

19.2 Trigonometria

19.3 Conversões

19.4 Cálculos

19.5 Validadores

19.6 Melhorias Futuras

Módulo   | Situação
------- | ------
| Tela Principal  | Concluído
| ScreenManager | Concluído
| Template Oficial de Telas | Em desenvolvimento
| Problema do Triângulo | Em desenvolvimento
| Lei dos Senos | Planejado
| Lei dos Cossenos | Planejado
| Classificação de Triângulos | Planejado
| Conversão de Datas | Planejado
| Calculadora de Desconto  | Planejado
| Calculadora de INSS | Planejado
| Validador de CPF | Planejado
| Validador de CNPJ | Planejado 


## 20. Convenções para Casos de Estudo

### 20.01 - Nome do módulo:
Problema do Triângulo

#### 20.01.01 - Descrição:
O usuário informa os três lados de um possível triângulo, e o sistema deverá:

* validar os dados informados;
* verificar se os lados formam um triângulo;
* classificar o triângulo;
* apresentar o resultado na área de saída.


### 20.02 - Nome do módulo:
Validar um CPF.

### 20.02.01 - Entrada:
CPF informado pelo usuário.

### 20.02.02 - Saída esperada:
CPF válido ou inválido.

### 20.02.03 - Defeito lógico proposital:
Erro no cálculo do segundo dígito verificador.

### 20.02.04 - Conceitos de Teste de Software envolvidos:
Teste de Unidade, Particionamento em Classes, Valores Limites

### 20.02.05 - Classe de Teste correspondente:
CpfServiceTest.java

### 20.02.06 - Sugestões ao professor: 


### 20.03 - Nome do módulo:
Calculadora de Desconto

### 20.03.01 - Objetivo:
Objetivo didático é permitir que o professor introduza erros lógicos na regra de cálculo; O aluno deverá escrever testes JUnit para identificar a inconsistência e corrigir a implementação.

### 20.03.02 - Entrada:
Valor da compra
Percentual de desconto

### 20.03.03 - Saída esperada:
Valor do desconto
Valor final
Relatório textual

### 20.04 - Nome do módulo:
Valida CPF

### 20.03.01 - Objetivo:
Objetivo didático 

### 20.03.02 - Entrada:
CPF

### 20.03.03 - Saída esperada:
CPF informado
CPF normalizado
Situação
CPF válido ou CPF inválido


## 21. Versionamento e Backup

21.1 Política de Backup

21.2 Convenção para Nome das Versões

21.3 Recuperação de Versões

21.4 Versionamento com Git (futuro)