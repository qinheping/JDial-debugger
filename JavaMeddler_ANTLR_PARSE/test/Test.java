int largestGap(int[] a){
  int max = 0;
  a[1] = 10;
  c = max++;
  int min = 100;
  int[] b = {1, 2, 3};
  for(int i=0; i < a.Length; i++){
    if(max < a[i]) max = a[i];
  }
  return max-min;
}
