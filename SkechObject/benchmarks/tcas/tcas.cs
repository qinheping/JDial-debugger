bool tcas(bool inhibit, int up_sep, int down_sep){
     int bias;
     if(inhibit){
       bias = down_sep; // bias = down_sep + 100;
     }
     else{
       bias = up_sep;
     }
     
     if(bias > down_sep) return 1;
     else return 0;
}
