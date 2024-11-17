package br.unb.compiladores.inter;

// Arquivo Rel.java
import br.unb.compiladores.lexer.*;
import br.unb.compiladores.symbols.*;

public class Rel extends Logical {

  public Rel(Token tok, Expr x1, Expr x2) {
    super(tok, x1, x2);
  }

  public Type check(Type p1, Type p2) {
    if (p1 instanceof Array || p2 instanceof Array) return null;
    else if (p1 == p2) return Type.Bool;
    else return null;
  }

  public void jumping(int t, int f) {
    Expr a = expr1.reduce();
    Expr b = expr2.reduce();
    String test = a.toString() + " " + op.toString() + " " + b.toString();
    emitjumps(test, t, f);
  }
}

// A classe Rel implementa os operadores <, <=, ==, !=, >= e >. A função check (linhas 5-9) verifica
// se os dois operandos têm o mesmo tipo e se não são arranjos. Para simplificar, as coerções não são permitidas.
