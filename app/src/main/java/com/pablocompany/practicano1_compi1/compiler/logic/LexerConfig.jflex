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
%state STRING


/********************** estados *********************************/

%init{
    /****************** codigo dentro del constructor ******************/


%init}

/********************** macros ***********************************/
/*=======Apartado de macros======*/
LineTerminator = \r|\n|\r\n
WhiteSpace = [ \t\f]
Numero = [0-9]+
Decimal = {Numero}"."{Numero}
Id = {jletter}{jletterdigit}*
HexColor = "H"[0-9A-Fa-f]{6}

%{
    /****************** codigo de usuario (codigo java) ***********************/

    //string bulder para cadenas de texto
    private StringBuilder string;


 /*---------------------------------------------
        Codigo para el manejo de errores
    -----------------------------------------------*/

    private List<String> errorList;

    public List<String> getLexicalErrors(){
        return this.errorList;
    }

    /*-------------------------- Codigo para el parser --------------------------------*/

     /*-----------------------------------------------
              Codigo para el parser
        -------------------------------------------------*/

    private Symbol symbol(int type, Object object){
        return new Symbol(type, yyline+1, yycolumn+1, object);
    }

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

{WhiteSpace} { /* ignorar */ }

{LineTerminator} { return symbol(sym.SALTO); }

"#".*      {/*Ignorado*/}

{HexColor} { return sym.COLOR_HEX; }

"|"     {return symbol(sym.PLECA);}

"=="    {return symbol(sym.IGUAL);}

"!=" {return symbol(sym.DIFF);}

">"    {return symbol(sym.MAYOR);}

"<"    {return symbol(sym.MENOR);}

">="    {return symbol(sym.MAYORIGUAL);}

"<="    {return symbol(sym.MENORIGUAL);}

"&&"    {return symbol(sym.AND);}

"||"    {return symbol(sym.OR);}

"!"    {return symbol(sym.NOT);}

"+" {return symbol(sym.SUMA);}

"-" {return symbol(sym.RESTA);}

"*" {return symbol(sym.MULTIPLICACION);}

"/" {return symbol(sym.DIVISION);}

/*============CARACTERES ESPECIALES====================*/

"%%%"           {return symbol(sym.SEPARADOR);}

"<"             {return symbol(sym.PARENT_ANGULAR_APERTURA);}

">"             {return symbol(sym.PARENT_ANGULAR_CIERRE);}

","             {return symbol(sym.COMA);}

/*============CARACTERES ESPECIALES====================*/

/*============PALABRAS RESERVADAS====================*/

"%DEFAULT"     {return symbol(sym.DEFAULT);}

/*=============APARTADO DE INSTRUCCIONES DE SI===============*/

"%COLOR_TEXTO_SI"       {return symbol(sym.COLOR_TEXTO_SI);}

"%COLOR_SI"       {return symbol(sym.COLOR_SI);}

"%FIGURA_SI"       {return symbol(sym.FIGURA_SI);}

"%LETRA_SI"       {return symbol(sym.LETRA_SI);}

"%LETRA_SIZE_SI"       {return symbol(sym.LERTA_SIZE_SI);}

/*=============APARTADO DE INSTRUCCIONES DE SI===============*/

/*=============APARTADO DE INSTRUCCIONES DE MIENTRAS===============*/

"%COLOR_TEXTO_MIENTRAS"       {return symbol(sym.COLOR_TEXTO_MIENTRAS);}

"%COLOR_MIENTRAS"                {return symbol(sym.COLOR_MIENTRAS);}

"%FIGURA_MIENTRAS"         {return symbol(sym.FIGURA_MIENTRAS);}

"%LETRA_MIENTRAS"       {return symbol(sym.LETRA_MIENTRAS);}

"%LETRA_SIZE_MIENTRAS"       {return symbol(sym.LERTA_SIZE_MIENTRAS);}

/*=============APARTADO DE INSTRUCCIONES DE SI===============*/

/*=============APARTADO DE INSTRUCCIONES DE MIENTRAS===============*/

"%COLOR_TEXTO_BLOQUE"       {return symbol(sym.COLOR_TEXTO_BLOQUE);}

"%COLOR_BLOQUE"                {return symbol(sym.COLOR_BLOQUE);}

"%FIGURA_BLOQUE"         {return symbol(sym.FIGURA_BLOQUE);}

"%LETRA_BLOQUE"       {return symbol(sym.LETRA_BLOQUE);}

"%LETRA_SIZE_BLOQUE"       {return symbol(sym.LERTA_SIZE_BLOQUE);}

/*=============APARTADO DE INSTRUCCIONES DE SI===============*/

"INICIO"    {return symbol(sym.INICIO);}

"FIN"      {return symbol(sym.FIN);}

"VAR" {return symbol(sym.VAR);}

"SI" {return symbol(sym.SI);}

"ENTONCES" {return symbol(sym.ENTONCES);}

"MIENTRAS" {return symbol(sym.MIENTRAS);}

"MOSTRAR" {return symbol(sym.MOSTRAR);}

"LEER"      {return symbol(sym.LEER);}

"FIN MIENTRAS"       {return symbol(sym.FIN_MIENTRAS);}

"HACER"      {return symbol(sym.HACER);}

"FIN SI"       {return symbol(sym.FIN_SI);}

"("       {return symbol(sym.PARENT_APERTURA);}

")"       {return symbol(sym.PARENT_CIERRE);}

/*============PALABRAS RESERVADAS====================*/

/*============CONFIGURACIONES====================*/

ELIPSE|CIRCULO|PARALELOGRAMO|RECTANGULO|ROMBO|RECTANGULO_REDONDEADO     {symbol(return sym.FIGURA);}

ARIAL|TIMES_NEW_ROMAN|COMIC_SANS|VERDANA       {return symbol(sym.FUENTE);}

/*============CONFIGURACIONES====================*/

/*==========ER CON CONTEXTO EN EL LENGUAJE============*/
{Decimal}  {return symbol(sym.DECIMAL);}

{Numero} {return symbol(sym.ENTERO);}

{Id} { return symbol(sym.ID); }

{WhiteSpace} { /* ignorar */ }

\"      { string = new StringBuilder(); yybegin(STRING); }

}

<STRING> {

    \" {
        yybegin(YYINITIAL);
        return symbol(sym.STRING, string.toString());
    }

    [^\n\r\"\\]+ {
        string.append(yytext());
    }

    \\\" {
        string.append("\"");
    }

    \\n {
        string.append("\n");
    }

    \\t {
        string.append("\t");
    }

    \\ {
        string.append("\\");
    }
}



.          {  error("lexema: <" + yytext() + ">"); }

<<EOF>>    {
                return symbol(sym.EOF);
           }






