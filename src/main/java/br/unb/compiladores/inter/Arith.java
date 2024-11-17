package br.unb.compiladores.inter;

// Arquivo Arith.java
import br.unb.compiladores.lexer.*;
import br.unb.compiladores.symbols.*;

public class Arith extends Op {

  public Expr expr1, expr2;

  public Arith(Token tok, Expr x1, Expr x2) {
    super(tok, null);
    expr1 = x1;
    expr2 = x2;
    type = Type.max(expr1.type, expr2.type);
    if (type == null) error("type error");
  }

  public Expr gen() {
    return new Arith(op, expr1.reduce(), expr2.reduce());
  }

  public String toString() {
    return expr1.toString() + " " + op.toString() + " " + expr2.toString();
  }
}

// O método gen() constrói o lado direito de uma instrução de 3 endereços
// reduzindo as subexpressões para endereços e aplicando o operador aos endereços
// Por exemplo, suponha que gen seja chamada na raiz para a+b*c. As chamadas a reduce
// retornam a como endereço para a subexpressão a e um temporário t como endereço para
// b*. Enquanto isso, reduce emite a instrução t=b*c. O método gen retorna um novo nó
// Arith, com o operador * e endereços a e t como operandos.
// Vale a pena observar que os nomes temporários tem tipos como todas as outras expressões
// O construtor Temp portanto é chamado com um tipo como parâmetro
