package br.unb.compiladores.inter;

import br.unb.compiladores.lexer.*;


public class Node {
    // O pacote inter contém a hierarquia de classe Node
    // Node possui duas subclasses: Expr para nós de expressão e Stmt para nós de comando
    // Os nós na árvore sintática são implementados como objetos da classe Node. para os
    // relatos de erros, o campo lexline (linha 4 do arquivo Node.java) guarda o número
    // da linha fonte da construção desse nó
    // As linhas 7-10 são usadas para emitir código de três endereços
    int lexline = 0;
    Node(){ lexline = Lexer.line; }
    void error(String s){
        throw new Error("near line " + lexline + ": " +s);
    }
    static int labels = 0;
    public int newlabel(){
        return ++labels;
    }
    public void emitlabel(int i ){
        System.out.println("L" + i + ":");
    }
    public void emit(String s){
        System.out.println("\t" + s);
    }
    // Construções de expressão são implementadas pelas subclasses de expr. A classe Expr possui campos
    // op e type (linhas 4-5) representando o operador e tipo, respectivamente em um nó.




}
