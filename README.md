# Serviço Auditor DLQ

## 🏗️ Arquitetura Escolhida: **Layered Architecture (Arquitetura em Camadas)**

### **Por que escolhi esta arquitetura?**

Decidi utilizar a **Arquitetura em Camadas (Layered Architecture)** ao invés de padrões mais complexos como Hexagonal ou Clean Architecture pelos seguintes motivos:

#### **1. Adequação ao Propósito do Serviço**

Este é um **serviço de apoio** com responsabilidade única e bem definida:

- Consumir mensagens da DLQ
- Aplicar regra de negócio simples (cálculo de severidade)
- Persistir no banco de dados

Não há necessidade de:

- Múltiplas integrações externas que justifiquem portas/adaptadores
- Troca frequente de infraestrutura (o SQS e o banco H2/JPA são estáveis)
- Lógica de domínio complexa que exija isolamento total
- Múltiplos casos de uso ou pontos de entrada

A simplicidade do serviço favorece uma arquitetura **direta e de fácil manutenção**.

---

## 📝 Autor

**Gustavo Miranda dos Santos**  
Estudante de Engenharia de Software - FAG (Faculdade Assis Gurgacz)  
5º Semestre - Previsão de formatura: Janeiro 2028

---

## 📚 Referências

- [Tutorial AWS SQS Consumer](https://master.d368vvufhi872i.amplifyapp.com/tutoriais/consumer-sqs)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Cloud AWS](https://docs.awspring.io/)
- Aulas de Arquitetura de Software - T04 (2026)
