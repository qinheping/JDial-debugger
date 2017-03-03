int iterPower(int base, int exp){
    int result = base;
    while(exp>0){
	result += base;
	exp -= 1;
    }
    return result;
}
