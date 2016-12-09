#!/bin/bash
CLASS_NAME=${1}
awk -v inp="`cat $CLASS_NAME.nums | tr '\n' ' ' `"  'BEGIN{split(inp,arr," "); for(k in arr){p_lines[arr[k] + 0] = arr[k];}} {{if(NR in p_lines){print $0;}}}' "$CLASS_NAME".java 
