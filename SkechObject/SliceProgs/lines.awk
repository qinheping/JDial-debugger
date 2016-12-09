#! /usr/bin/awk -f
{
	if($0 ~ "^" class_name "\."){		
		#split($1,fst,":");
		#l_num = fst[2];
		#line_nums[l_num] = true;
		print $0
	}
}

#END{
#	for (l_num in line_nums){
#		print l_num;
#	}
#}
