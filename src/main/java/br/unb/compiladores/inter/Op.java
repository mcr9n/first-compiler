package br.unb.compiladores.inter;
// Arquivo Op.java
import br.unb.compiladores.lexer.*;
import br.unb.compiladores.symbols.*;
public class Op extends Expr {

    public Op(Token tok, Type p)  { super(tok, p); }

    public Expr reduce() {
        Expr x = gen();
        Temp t = new Temp(type);
        emit( t.toString() + "=" + x.toString() );
        return t;
    }
  }

  // A classe Arith implementa operadores binários como * e +. O construtor Arith começa chamando
// super(tok, null) (linha 6), onde tok é um token representando o operador e null é um marcador
// de lugar para o tipo. O tipo é determinado na linha 7 usando Type.max, que verifica se os dois
// operandos podem ser convertidos para um tipo numérico comum. Se eles puderem ser convertidos
// type é definido como o tipo resultado.; caso contrário, um erro de tipo é informado (linha 8)
// Esse compilador simples verifica tipos mas não insere conversões de tipo.

