#! /bin/bash
class_name=$1
>&2 echo $PATH
export JAVA_HOME=`/usr/libexec/java_home -v 1.7`
javac -g "$class_name".java
mkdir -p META-INF
echo "Main-Class: $class_name" > META-INF/"$class_name".MF
jar cmvf META-INF/"$class_name".MF "$class_name".jar "$class_name".class
