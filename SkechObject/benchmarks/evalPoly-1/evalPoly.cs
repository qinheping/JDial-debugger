int evalPoly(int[] p, int x){
    int num = p[0];
    int i = p.length-1;
    while (i >= 1){ // i >= 0
        num += p[i]*Math.pow(x,i) 
        i = i - 1
    }
    return num
}
