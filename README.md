 Aplicativo de Finanças Coletivas para Repúblicas

Esse projeto consiste no desenvolvimento do núcleo de domínio de uma aplicação voltada para a divisão justa de despesas comuns em grupos ou repúblicas. O sistema permite o registro de despesas individuais, o cálculo das cotas por membro e a definição de saldos de acerto.

 Tema Escolhido
 Tema 10: Aplicativo de Finanças Coletivas para Repúblicas ou Grupos de Viagem

Tecnologias Utilizadas
 Linguagem: Java 17
 Gerenciador de Dependências: Maven
 Framework de Testes: JUnit 5

 Diretrizes do Projeto
O projeto foi estruturado seguindo rigorosamente as práticas exigidas:
 Domain-Driven Design (DDD): Isolamento completo das regras de negócio em entidades e Value Objects dentro de `src/domain/`.
 Test-Driven Development (TDD): Desenvolvimento guiado por testes unitários mapeados na pasta `tests/domain/`, cobrindo cenários de sucesso e falha.
 Automação (CI/CD): Integração contínua configurada via GitHub Actions para build e execução automática de testes a cada push.

