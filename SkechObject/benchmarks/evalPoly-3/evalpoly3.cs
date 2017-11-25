int evalPoly(int[] p, int x){
    int num = 0;
    int i = 1; // i = 0
    while (i < p.Length - 1){
        num += p[i]*Math.pow(x,i) 
        i = i + 1
    }
    return num
}
