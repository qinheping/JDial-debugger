#! /bin/bash
class_name=$1
if [ -z $class_name ]
then
    echo "Error: Empty class name"
    exit
fi
rm -f META-INF/"$class_name".mf
rm "$class_name".class "$class_name".jar "$class_name".trace "$class_name".slice

