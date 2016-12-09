#! /bin/bash
class_name=$1
method_name=$2
line_num=$3
var_name=$4
./make_jar.sh $class_name
./get_text_slice.sh $class_name $method_name $line_num $var_name
./cleanup.sh $class_name
