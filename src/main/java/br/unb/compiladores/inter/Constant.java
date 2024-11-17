package br.unb.compiladores.inter;

// Arquivo Constant.java
import br.unb.compiladores.lexer.*;
import br.unb.compiladores.symbols.*;

public class Constant extends Expr {

  public Constant(Token tok, Type p) {
    super(tok, p);
  }

  public Constant(int i) {
    super(new Num(i), Type.Int);
  }

  public static final Constant True = new Constant(Word.True, Type.Bool),
      False = new Constant(Word.False, Type.Bool);

  public void jumping(int t, int f) {
    if (this == True && t != 0) emit("goto L" + t);
    else if (this == False && f != 0) emit("goto L" + f);
  }
}

// O método jumping (arquivo Constant.java) utiliza dois parâmetros rotulados como t ou f.
// Se essa constante for um objeto estático
// Se essa constant for o objeto estático True e t não for o rótulo especial 0, então um desvio para
// t é gerado. Caso contrário se esse for o objeto False e f for diferente de zero, então um desvio para
// f é gerado.
// A classe Logical oferece alguma funcionalidade comum para as classes Or, And e Not. Os campos x e y da linha
// 4 correspondem aos operandos de um operador lógico . Embora a classe Not implemente um operador unário,
// por conveniênci, ela é uma subclasse de Logical. O construtor Logical(tok, a ,b) constrói um nó de sintaxe
// com operador tok e operandos a e b. Ao fazer isso, ele usa a função check para garantir que tanto a e b sejam
// booleanos. O método gen() será discutido no fim dessa seção.
