int largestGap(int[] a){
  int max = 0;
  int min = 100;
  int[][] b;
  for(int i=0; i < a.Length; i++){
    if(max < a[i]) max = a[i];
  }
  return max-min;
}
