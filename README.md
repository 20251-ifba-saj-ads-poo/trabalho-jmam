# Relatório de Avaliação - trabalho-jmam

Gestão de Feira de Ciências Escolar

Desenvolva um sistema para organizar uma feira de ciências. A feira possui projetos, alunos participantes e professores orientadores. Cada projeto pode ter vários alunos e um ou mais professores. Implemente funcionalidades para listar projetos por aluno, professores por projeto e alunos por projeto
## Resumo da Pontuação

| Critério | Pontuação Máxima | Pontuação Obtida | Comentários |
| --- | --- | --- | --- |
| **Interface Gráfica (JavaFX)** | **20** | **15** | A interface é complexa e funcional, mas o tratamento de erros não segue o padrão de exceções customizadas. |
| **Camada de Negócio** | **30** | **7** | Camada de serviço anêmica. A lógica de negócio e validação foram movidas para os controllers. |
| **Camada de Dados** | **20** | **17** | A camada de dados está bem implementada, mas com uma falha de design na inicialização do repositório. |
| **Separação em Camadas** | **20** | **10** | A separação foi severamente violada ao mover a lógica de negócio para a camada de apresentação. |
| **Boas Práticas** | **10** | **5** | O código tem boas ideias (extensão da `AbstractEntity`), mas falha em seguir a arquitetura de 3 camadas. |
| **Total** | **100** | **54** | |

---

## Pontos de Atenção

- **Falha Crítica - Lógica de Negócio no Controller**: A maior parte da lógica de validação (ex: checagem de CPF/email duplicado) e regras de negócio está na camada de Controle (Controller), e não na camada de Serviço. Isso viola o princípio da separação de responsabilidades e a arquitetura definida no modelo.
- **Camada de Serviço Anêmica**: O projeto não possui classes de serviço específicas para as entidades de negócio (ex: `EstudanteService`, `ProjetoService`). Em vez disso, o `Service<T>` genérico é instanciado diretamente no controller, fazendo com que a camada de serviço não contenha lógica de negócio, tornando-a um mero repassador de chamadas.
- **Falta de Exceções Customizadas**: O projeto não utiliza exceções customizadas para erros de validação, tratando `Exception` genérica diretamente no controller, o que vai contra o modelo proposto.
- **Violação de Boas Práticas (Repository)**: O `Repository` executa uma verificação de usuário 'admin' em seu construtor, o que é ineficiente e deve ser feito em um bloco `static`.
