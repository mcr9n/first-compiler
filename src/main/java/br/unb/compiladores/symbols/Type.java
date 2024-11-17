package br.unb.compiladores.symbols;

import br.unb.compiladores.lexer.*;

public class Type extends Word {
  public int width = 0; // Usado para alocação de memória

  public Type(String s, int tag, int w) {
    super(s, tag);
    width = w;
  }

  public static final Type Int = new Type("int", Tag.BASIC, 4),
      Float = new Type("float", Tag.BASIC, 8),
      Char = new Type("char", Tag.BASIC, 1),
      Bool = new Type("bool", Tag.BASIC, 1);

  // As funções numeric (linhas 11 - 14) e max (linhas 15-20) são úteis para as conversões de tipo

  public static boolean numeric(Type p) {
    if (p == Type.Char || p == Type.Int || p == Type.Float) return true;
    else return false;
  }

  public static Type max(Type p1, Type p2 ) {
        if ( ! numeric(p1) || ! numeric(p2) ) return null;
        else if ( p1 == Type.Float || p2 == Type.Float ) return Type.Float;
        else if ( p1 == Type.Int   || p2 == Type.Int   ) return Type.Int;
        else return Type.Char;

  }

    // As conversões são permitidas entre os tipos numéricos Type.Char, Type.int e Type.Float. Quando um operador
    // aritmético é aplicado a dois tipos numéricos, o resultado é o max() dos dois tipos
    // Os arranjos são o único tipo construído na linguagem fonte. A chamada para super na linha 7 define o campo
    // Width, que é essencial para cálculos de endereço. Ela também define lexeme e tok para valores default que
    // não são usados
}
