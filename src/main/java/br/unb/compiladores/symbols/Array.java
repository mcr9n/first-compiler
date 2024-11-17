package br.unb.compiladores.symbols;
import br.unb.compiladores.lexer.*;
public class Array extends Type {

    public Type of;
    public int size = 1;             // número de elementos
    public Array(int sz, Type p) {
        super("[]", Tag.INDEX, sz*p.width); size = sz;  of = p;
    }
    public String toString() { return "[" + size + "] " + of.toString();}
    // arranjo *of* type

    // O pacote Inter contém a hierarquia de classe Node. Node possui duas subclasses: Expr
    // para nós de expressão e Stmt para nós de comando
    // Esta seção apresenta Expr e suas subclasses. Alguns dos métodos em Expr tratam booleanos
    // e código de desvio

}