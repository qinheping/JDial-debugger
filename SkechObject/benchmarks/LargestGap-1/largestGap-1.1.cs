int largestGap(int[] a){
  int max = 0; // max = a[0]
  int min = 100; 
  for(int i=0; i < a.Length; i++){
    if(max < a[i]) max = a[i]; 
    if(min > a[i]) min = a[i];
  }
  return max-min;
}
