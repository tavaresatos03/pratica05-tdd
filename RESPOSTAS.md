# Respostas da Prática 05: TDD em Java

## 1. No Ciclo 1 usamos `return 70`. Por que isso é aceitável no TDD? O que obrigou a escrever a soma de verdade?

É aceitável porque no TDD o verde é só fazer o teste passar do jeito mais simples possível. Como só tinha um teste (20 + 20 + 30 = 70), devolver 70 direto já resolvia. Isso se chama "fake it", tipo fingir até conseguir.
O que me obrigou a fazer a soma de verdade foi o segundo teste do Ciclo 2, com outros números (10, 15 e 25, esperando 50). Aí o `return 70` quebrou e não teve outro jeito.

## 2. No Ciclo 3, por que testar com 69 e 70, e não com 50 e 90?

Por que 69 e 70 são valores que estão dividindo a aprovação e reprovação.

## 3. No Ciclo 4, o que mudou na refatoração? Como você teve certeza de que não quebrou nada?

Por que os 3 if's viraram uma maneira de validar a nota e os números 30 e 40 viraram constantes. E os resultados não mudaram por que fiz o teste

## 4. No Ciclo 8, por que alteramos os testes antes de mudar o código?

Por que mudando a regra primeiro, os testes falham e provamos que o codigo ainda não está pronto.

## 5. Qual ciclo foi o mais difícil para você, e por quê?

O Ciclo 6, pela lógica com `&&` e `||`