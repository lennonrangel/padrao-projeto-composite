# Padrão de Projeto Composite

Projeto desenvolvido para a disciplina de **Arquitetura e Projeto de Software**.

## Descrição

Este projeto demonstra a implementação do padrão estrutural **Composite**, que tem como objetivo compor objetos em estruturas de árvore para representar hierarquias parte-todo, permitindo que clientes tratem objetos individuais e composições de objetos de maneira uniforme.

O padrão foi aplicado para modelar o **cardápio de um restaurante**. Um cardápio pode conter categorias, e cada categoria pode conter pratos ou outras categorias, formando uma árvore de conteúdo tratada de forma uniforme via `getConteudo()`.

## Estrutura

| Classe | Papel |
|---|---|
| `ItemCardapio` | Componente abstrato — interface uniforme para folhas e compostos |
| `Prato` | Folha (Leaf) — item individual sem filhos |
| `Categoria` | Composto (Composite) — agrupa outros `ItemCardapio` |
| `Cardapio` | Cliente — usa o componente raiz para obter o menu |

## Funcionamento

Tanto `Prato` quanto `Categoria` implementam `getConteudo()`, permitindo que o `Cardapio` trate os dois da mesma forma. A `Categoria` percorre seus filhos recursivamente, acumulando o conteúdo de toda a árvore:

```
Cardapio do Restaurante (Categoria)
├── Entradas (Categoria)
│   └── Bruschetta - R$18.0 (Prato)
├── Pratos Principais (Categoria)
│   ├── Frango Grelhado - R$45.0 (Prato)
│   └── File Mignon - R$89.0 (Prato)
└── Sobremesas (Categoria)
    └── Pudim - R$15.0 (Prato)
```

Isso evita a necessidade de tratar folhas e compostos de forma diferente:
- `if (item instanceof Prato) exibirPrato()`
- `else if (item instanceof Categoria) percorrerCategoria()`

## Vantagens

- Trata objetos simples e compostos de forma uniforme
- Facilita a adição de novos tipos de componentes sem alterar o código existente
- Permite construir estruturas hierárquicas complexas de forma flexível
- A recursão em `getConteudo()` percorre toda a árvore automaticamente
- Segue o princípio Aberto/Fechado (Open/Closed Principle)

## Como executar

Abrir o projeto no IntelliJ como um projeto Maven e executar os testes localizados em:

- `CardapioTest`
