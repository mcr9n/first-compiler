package br.unb.compiladores.inter; // Arquivo Or.java

import br.unb.compiladores.lexer.*;

public class Or extends Logical {
  public Or(Token tok, Expr x1, Expr x2) {
    super(tok, x1, x2);
  }

  public void jumping(int t, int f) {
    int label = t != 0 ? t : newlabel();
    expr1.jumping(label, 0);
    expr2.jumping(t, f);
    if (t == 0) emitlabel(label);
  }
}
// Na classe Or, o método Jumping() gera código de desvio para uma expressão
// booleana B = B1 || B2. Por um momento, suponha que nem a saída verdadeira
// t nem a saída falsa f de B seja rótulo especial 0. COmo B é verdadeiro se B1
// é verdadeiro, a verdadeira saída de B1 deve ser t, e a saída falsa corresponde
// à primeira instrução de B2. As saídas verdadeira e falsa de B2 são as mesmas de
// B.