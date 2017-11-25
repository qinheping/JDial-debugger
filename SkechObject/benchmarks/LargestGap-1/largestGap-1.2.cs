int largestGap(int[] a){
  int max = a[0];
  int min = 100; // min = a[0]
  for(int i=0; i < a.Length; i++){
    if(max < a[i]) max = a[i]; 
    if(min > a[i]) min = a[i];
  }
  return max-min;
}
