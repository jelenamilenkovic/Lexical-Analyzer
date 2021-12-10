// import sekcija

%%

// sekcija opcija i deklaracija
%class MPLexer
%function next_token
%line
%column
%debug
%type Yytoken

%eofval{
return new Yytoken( sym.EOF, null, yyline, yycolumn);
%eofval}

%{
//dodatni clanovi generisane klase
KWTable kwTable = new KWTable();
Yytoken getKW()
{
	return new Yytoken( kwTable.find( yytext() ),
	yytext(), yyline, yycolumn );
}
%}

//stanja
%xstate KOMENTAR

//makroi
slovo = [a-zA-Z]
cifra = [0-9]
niz_cifara_10=(0|[1-9]{cifra}*) 
niz_cifara_8=(0|[1-7][0-7]*) 
niz_cifara_16=(0|[1-9A-F][0-9A-F]*) 
niz_cifara_2=([0-1]*) 

%%

// pravila
\/\*\* { yybegin( KOMENTAR ); }
<KOMENTAR>~"*/" { yybegin( YYINITIAL ); }

[\t\n\r ] { ; }
\(   { return new Yytoken( sym.LEFTPAR, yytext(), yyline, yycolumn ); }
\) { return new Yytoken( sym.RIGHTPAR, yytext(), yyline, yycolumn ); }
\{  {return new Yytoken( sym.LEFTCURLY, yytext(), yyline, yycolumn ); }
\}  {return new Yytoken( sym.RIGHTCURLY, yytext(), yyline, yycolumn ); }

//operatori
\+ { return new Yytoken( sym.PLUS,yytext(), yyline, yycolumn ); }
\* { return new Yytoken( sym.MUL,yytext(), yyline, yycolumn ); }

//separatori
; { return new Yytoken( sym.SEMICOLON, yytext(), yyline, yycolumn ); }
: { return new Yytoken( sym.COLON, yytext(), yyline, yycolumn ); }
, { return new Yytoken( sym.COMMA, yytext(), yyline, yycolumn ); }
\. { return new Yytoken( sym.DOT, yytext(), yyline, yycolumn ); }
:= { return new Yytoken( sym.ASSIGN, yytext(), yyline, yycolumn ); }
//rel op
> { return new Yytoken( sym.GREATER,yytext(), yyline, yycolumn ); }
\< { return new Yytoken( sym.LESS,yytext(), yyline, yycolumn ); }
== { return new Yytoken( sym.EQUAL,yytext(), yyline, yycolumn ); }
>= { return new Yytoken( sym.GREATEREQ,yytext(), yyline, yycolumn ); }
\<= { return new Yytoken( sym.LESSEQ,yytext(), yyline, yycolumn ); }
\<> { return new Yytoken ( sym.NOTEQ, yytext(), yyline, yycolumn); }
//boolean
(true|false) { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }

//kljucne reci
{slovo}+ { return getKW(); }

//identifikatori
{slovo}({slovo}|{cifra})* { return new Yytoken(sym.ID, yytext(),yyline, yycolumn ); }

//konstante
//int-osnova 2
2['#']{niz_cifara_2} { return new Yytoken(sym.CONST, yytext(),yyline, yycolumn ); }
//int-osnova 8
8['#']{niz_cifara_8} { return new Yytoken(sym.CONST, yytext(),yyline, yycolumn ); }
//int-osnova 10
{cifra}+ { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
10['#']{niz_cifara_10} { return new Yytoken(sym.CONST, yytext(),yyline, yycolumn ); }
//int-osnova 16
16['#']{niz_cifara_16} { return new Yytoken(sym.CONST, yytext(),yyline, yycolumn ); }
['#']{niz_cifara_16}  { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }
//real
{niz_cifara_10}\.{niz_cifara_10}(E[+-]?{niz_cifara_10})? { return new Yytoken( sym.CONST, yytext(), yyline, yycolumn ); }


//obrada gresaka
. { if (yytext() != null && yytext().length() > 0) System.out.println( "ERROR: " + yytext() ); }
