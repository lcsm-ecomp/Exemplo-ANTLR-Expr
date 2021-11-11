export CLASSPATH=antlr.jar:.
java -jar antlr.jar -package expr -o expr Expr.g4
javac *.java expr/*.java
java Main 