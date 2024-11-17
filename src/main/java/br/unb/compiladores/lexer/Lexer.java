package br.unb.compiladores.lexer;
import br.unb.compiladores.symbols.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;

public class Lexer {
    // O método principal na classe Lexer, função scan, reconhece números, identificadores e palavras reservadas
    // As linhas 9-13 na classe Lexer reservam palavras-chave selecionadas
    // As linhas 14-16 reservam lexemas para objetos definidos em outras partes
    // Os objetos Word.True e Word.False são definidos na classe Word. Os objetos para os tipos básicos
    // int, char, bool e float são definidos na classe Type, uma subclasse de Word. A classe Type faz parte do pacote symbols
    public static int line = 1;
    char peek = ' ';
    Hashtable<String, Word> words = new Hashtable<>();
    void reserve(Word w){ words.put(w.lexeme, w); }
    public Lexer() throws IOException {

        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));
        reserve( Word.True );
        reserve( Word.False );
        reserve( Type.Int  );
        reserve( Type.Char  );
        reserve( Type.Bool );
        reserve( Type.Float );
    }

        // A função readch() (linha 18) é usada para ler o próximo caractere de entrada na variável peek.
        // o nome readch é reutilizado e sobrecarregado ( linhas 19-24 ) para auxiliar a reconhecer tokens
        // compostos. Por exemplo, quando a entrada < é vista, chamada readch('=') lê o próximo caractere em
        // peek e verifica se é =.

    void readch() throws IOException { peek = (char)System.in.read(); }
    boolean readch(char c) throws IOException{
        readch();
        if(peek != c) return false;
        peek = ' ';
        return true;
    }

    // A função scan() começa ignorando espaços em branco (linhas 26 - 30). Ela reconhece tokens compostos
        // como <= (linhas 31 - 34) e números como 365 e 3.14 (linhas 45 - 58), antes de reconhecer palavras
        // (linhas 59-70)
        public Token scan() throws IOException{
            for( ;  ; readch()) {
                if (peek == ' ' || peek == '\t') continue;
                else if (peek == '\n') line = line + 1;
                else break;
            }

            switch (peek){
                case '&':
                    if(readch('&')) return Word.and; else return new Token('&');
                case '|':
                    if( readch('|') ) return Word.or;   else return new Token('|');
                case '=':
                    if( readch('=') ) return Word.eq;   else return new Token('=');
                case '!':
                    if( readch('=') ) return Word.ne;   else return new Token('!');
                case '<':
                    if( readch('=') ) return Word.le;   else return new Token('<');
                case '>':
                    if( readch('=') ) return Word.ge;   else return new Token('>');
            }

            if ( Character.isDigit(peek) ){
                int v = 0;
                do{
                    v = 10*v + Character.digit(peek, 10); readch();
                }while( Character.isDigit(peek));

                if ( peek != '.') return new Num(v);
                float x = v; float d = 10;
                for(;;){
                    readch();
                    if(!Character.isDigit(peek)) break;
                    x = x + Character.digit(peek, 10) / d; d = d * 10;
                }

                return new Real(x);


            }

            if ( Character.isLetter(peek)){
                StringBuffer b = new StringBuffer();
                do{
                    b.append(peek); readch();
                }while( Character.isLetterOrDigit(peek));
                String s = b.toString();
                Word w = words.get(s);
                if ( w != null ) return w;
                w = new Word(s, Tag.ID);
                words.put(s, w);
                return w;

            }

            Token tok = new Token(peek); peek = ' ';
            return tok;

        }


}