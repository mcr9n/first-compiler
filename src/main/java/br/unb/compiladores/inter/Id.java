package br.unb.compiladores.inter;

import br.unb.compiladores.lexer.*;
import br.unb.compiladores.symbols.*;

// A classe Id herda as implementações default de gen e reduce na classe Expr, porque um
// identificador é um endereço.

public class Id extends Expr {

  public int offset; // endereço relativo

  public Id(Word id, Type p, int b) {
    super(id, p);
    offset = b;
  }
}

// O nó para um identificador da classe Id é uma folha
// O campo offset contém o endereço relativo a esse identificador
// A classe Op oferece uma implementação de reduce que é herdada pelas subclasses Arith
// para operadores aritméticos
// Unary para operadores unários e Access para acessos a arranjo. Em cada caso reduce() chama gen() para
// gerar um novo termo, emite uma instrução para atribuir o termo a um novo nome temporário, e retorna o temporário
// Em cada caso reduce() chama gen para gerar um termo, emite uma instrução para atribuir o termo a um novo nome
// temporário, e retorna o temporário.


