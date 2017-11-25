int largestGap(int[] a){
  int max = -100; // max = a[0]
  int min = a[0]; 
  for(int i=1; i < a.Length; i++){
    if(max < a[i]) max = a[i];
    if(min > a[i]) min = a[i];
  }
  return max-min;
}
