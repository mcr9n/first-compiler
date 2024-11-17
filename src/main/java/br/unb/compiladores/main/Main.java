package br.unb.compiladores.main;

import java.io.*;

import br.unb.compiladores.lexer.*;
import br.unb.compiladores.parser.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Lexer lex = new Lexer();
        Parser parse = new Parser(lex);
        parse.program();
        System.out.write('\n');
    }
}
