package br.unb.compiladores.inter;

// Arquivo Break.java
public class Break extends Stmt {

  Stmt stmt;

  public Break() {
    if (Stmt.Enclosing == null) error("unenclosed break");
    stmt = Stmt.Enclosing;
  }

  public void gen(int b, int a) {
    emit("goto L" + stmt.after);
  }
}
