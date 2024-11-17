package br.unb.compiladores.inter;
import br.unb.compiladores.symbols.*;
import br.unb.compiladores.lexer.*;

public class Expr extends Node{
    public Token op;
    public Type type;
    Expr(Token tok, Type p){
        op = tok;
        type = p;
    }

    // O método Gen (linha 7) retorna o "termo" que pode caber no lado direito de um comando de 3 endereços
    // Dada a expressão E = E1 + E2, o método gen retorna um termo x1 + x2, onde x1 e x2 são endereços para
    // os valores de E1 e E2, respectivamente.
    // O valor de retorno this é apropriado se esse objeto for um endereço; As subclasses de Expr tipicamente
    // reimplementam gen
    // O método reduce (linha 8) calcula ou "reduz" uma expressão a um único endereço, ou seja, retorna uma
    // constante, um identificador ou um nome temporário
    // Dada uma expressão E o método reduce retorna um teporário t contendo o valor de E
    // Novamente this é um valor de retorno apropriado se esse objeto for um endereço
    public Expr gen() { return this; }
    public Expr reduce() { return this; }
    public void jumping(int t, int f) { emitjumps(toString(), t, f); }
    public void emitjumps(String test, int t, int f) {
        if( t != 0 && f != 0 ) {
            emit("if " + test + " goto L" + t);
            emit("goto L" + f);
        }
        else if( t != 0 ) emit("if " + test + " goto L" + t);
        else if( f != 0 ) emit("iffalse " + test + " goto L" + f);
        else ; // nada, porque ambos t e f fall through
    }
    public String toString() { return op.toString(); }

}
