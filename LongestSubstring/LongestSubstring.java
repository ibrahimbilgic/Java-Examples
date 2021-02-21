class LongestSubstring {
    public static void main(String[] args) {
        String str1 = "abcdefghjhj";
        String str2 = "abcdefghh";
        int result = getLongestCommonSubstring(str1,str2);
        System.out.print(result);
    }
    public static int getLongestCommonSubstring(String str1,String str2){
        int arr[][] = new int[str2.length()+1][str1.length()+1];
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=str2.length();i++){
            for(int j=1;j<=str1.length();j++){
                if(str1.charAt(j-1) == str2.charAt(i-1)){
                    arr[i][j] = arr[i-1][j-1]+1;
                    if(arr[i][j]>max){
                        max=arr[i][j];
                    }
                }
                else{
                    arr[i][j]=0;
                }
            }
            
        }
        return max;
    }

    
}
