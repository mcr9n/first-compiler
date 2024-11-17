package br.unb.compiladores.inter; // Arquivo Do.java

import br.unb.compiladores.symbols.*;

public class Do extends Stmt {
  Expr expr;
  Stmt stmt;

  public Do() {
    expr = null;
    stmt = null;
  }

  public void init(Stmt s, Expr x) {
    expr = x;
    stmt = s;
    if (expr.type != Type.Bool) expr.error("boolean required in do");
  }

  public void gen(int b, int a) {
    after = a;
    int label = newlabel(); // rótulo para expr
    stmt.gen(b, label);
    emitlabel(label);
    expr.jumping(b, 0);
  }
}
