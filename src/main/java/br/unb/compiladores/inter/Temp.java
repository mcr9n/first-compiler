package br.unb.compiladores.inter;


import br.unb.compiladores.symbols.Type;
import br.unb.compiladores.lexer.*;

public class Temp extends Expr {

  static int count = 0;
  int number = 0;

  public Temp(Type p) {
    super(Word.temp, p);
    number = ++count;
  }

  public String toString() {
    return "t" + number;
  }
}
