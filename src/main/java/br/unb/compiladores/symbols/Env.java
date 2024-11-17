package br.unb.compiladores.symbols;
import br.unb.compiladores.lexer.*;
import br.unb.compiladores.inter.*;

import java.util.Hashtable;


public class Env {
    // O pacote symbols implementa as tabelas de símbolos e tipos
    // A classe Env é basicamente inalterada da figura 2.37. Enquanto a classe Lexer mapeia cadeis em palavras, a classe
    // Env mapeia tokens de palavra a objetos da classe Id (que é definida no pacote Inter com as classes para as expressões
    // e comandos
    private Hashtable table;
    protected Env prev;
    public Env(Env n) { table = new Hashtable(); prev = n; }
    public void put(Token w, Id i) { table.put(w, i); }

    public Id get(Token w){
        for (Env e = this; e != null; e = e.prev) {
            Id found = (Id) (e.table.get(w));
            if(found != null ) return found;
        }
        return null;
    }
    // Definimos a classe Type como sendo uma subclasse de Word, porque os nomes de tipo básicos como int são
    // simplesmente palavras reservadas, a serem mapeadas de lexemas para objetos apropriados pelo analisador léxico
    // Os objetos para os tipos básicos são Type.Int, Type.Float, Type.Char e Type.Bool (linhas 7 - 10). Todos eles
    // tem o campo herdado tag definido como tag.BASIC, de modo que o analisador sintático os trata da mesma forma.

}
