#!/bin/bash

JFLEX_JAR="/home/pablo03/compilator_java_resources/jflex-full-1.9.1.jar"
CUP_JAR="/home/pablo03/compilator_java_resources/java-cup-11b.jar"

echo "Generando Lexer..."
java -jar "$JFLEX_JAR" LexerConfig.jflex

echo "Generando Parser..."
java -jar "$CUP_JAR" -parser Parser ParserConfig.cup

echo "Listo."