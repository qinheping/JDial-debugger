bool FindC(string s, char c, int k){
  for(int i=0; i < k; i++){
    if(s[i]==c)
      return 1;
  }
  return 0;
}
