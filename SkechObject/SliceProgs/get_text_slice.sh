#! /bin/bash
class_name=$1
method_name=$2
line_num=$3
var_name=$4
>&2 echo $PATH
slicer_asm_path="javaslicer/assembly"
export JAVA_HOME=`/usr/libexec/java_home -v 1.7`
java -javaagent:"$slicer_asm_path"/tracer.jar=tracefile:"$class_name".trace -jar "$class_name".jar
java -Xmx2g -jar "$slicer_asm_path"/slicer.jar "$class_name".trace "$class_name"\."$method_name":"$line_num":"{$var_name}" > "$class_name".slice
./SliceProgs/line_nums.awk -v class_name="$class_name" "$class_name".slice | sort -g > "$class_name".nums