int max3(int x, int y, int z, int w){
    if(x>y) y = x;
    if(y>z) z = x; // z = y
    if(z>w) w = z;
    return z;
}
