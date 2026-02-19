/********************** paquetes y otros ***********************/
package com.pablocompany.practicano1_compi1.compiler.logic;

import java_cup.runtime.*;
import java.util.*;

%% //separador de area

/********************* declaraciones de jflex ******************/
%public
%unicode
%class AnalizadorLexico
%cup
%line
%column
%ignorecase


/********************** estados *********************************/

%init{
    /****************** codigo dentro del constructor ******************/


%init}

/********************** macros ***********************************/

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

Numeros = [0-9]

%{
    /****************** codigo de usuario (codigo java) ***********************/




    /*-------------------------- Codigo para el parser --------------------------------*/

    private Symbol symbol(int type){
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private void error(String message){
         errorList.add("Error en la linea: " + (yyline+1) + ", columna: " + (yycolumn+1) + " : " + message);
    }


%}


%% //separador de area

/********************** reglas lexicas **************************/

<YYINITIAL>{


"=="    {return symbol(sym.IGUAL);}

"!=" {return symbol(sym.DIFF);}

">"    {return symbol(sym.MAYOR);}

"<"    {return symbol(sym.MENOR);}

">="    {return symbol(sym.MAYORIGUAL);}

"<="    {return symbol(sym.MENORIGUAL);}

"&&"    {return symbol(sym.AND);}

"||"    {return symbol(sym.OR);}

"!"    {return symbol(sym.NOT);}

"+" {/*Suma*/}

"-" {/*Resta*/}

"" {/*Multiplicacion*/}

"/" {/division/}

}

.          {  error("lexema: <" + yytext() + ">"); }

<<EOF>>    {
                return symbol(sym.EOF);
           }






