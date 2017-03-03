int largestGap(int[] a){
  int max = a[0];
  int min = 100;
  for(int i=1; i < a.Length; i++){
    if(max < a[i]) max = a[i];
    if(min > a[i]) min = a[i];
  }
  return max-min;
}
