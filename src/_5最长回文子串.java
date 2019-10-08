public class _5最长回文子串 {
    public String longestPalindrome(String s) {
        int longestPalindrome = 0;
        if(s.length() < 1)
            return s;
        String longestPalindromeStr = s.substring(0,1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < s.length(); l++) {
                if(s.charAt(l) == s.charAt(r) && (r-l<=2 || dp[l+1][r-1])) {
                    dp[l][r] = true;
                    if(r-l+1>longestPalindrome){
                        longestPalindrome = r-l+1;
                        longestPalindromeStr = s.substring(l, r+1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

    public static void main(String[] args) {
        String str = "babad";
        _5最长回文子串 solution = new _5最长回文子串();
        System.out.println(solution.longestPalindrome(str));
    }
}
