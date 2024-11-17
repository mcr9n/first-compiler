package br.unb.compiladores.inter;

// A classe Unary é o correspondente de um operando da classe Arith
import br.unb.compiladores.lexer.*;
import br.unb.compiladores.symbols.*;

public class Unary extends Op {

  public Expr expr;

  public Unary(Token tok, Expr x) { // trata operador menos, para !, ver Not
    super(tok, null);
    expr = x;
    type = Type.max(Type.Int, expr.type);
    if (type == null) error("type error");
  }

  public Expr gen() {
    return new Unary(op, expr.reduce());
  }

  public String toString() {
    return op.toString() + " " + expr.toString();
  }
}

// Código de desvio para expressões booleanas
// O código de desvio para uma expressão booleana B é gerado pelo método Jumping().
// que recebe dois rótulos t e f como parâmetros, chamados respectivamente de saídas
// verdadeira e falsa de B. O código contém um desvio para t se B for avaliado como
// verdadeiro, e um desvio para f se B for avaliado como falso. Pro convenção
// o rótulo especial 0 significa que o controle passa por B em direção à próxima
// instrução após o código de B.
// Começamos com a classe Constant. O construtor Constant na linha 4 recebe um token tok e um tipo
// p como parâmetros. Ele constrói uma folha na árvore de sintaxe com o rótulo tok e o tipo p
// Por conveniência o construtor Constant é sobrecarregado (linha 5) para criar um objeto constante
// a partir de um inteiro
