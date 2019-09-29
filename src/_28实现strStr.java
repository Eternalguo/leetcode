public class _28实现strStr {
    public int indexOf(String txt, String pat){
        int i = 0, j = 0;
        int[] next = getNext(pat);
        while(i < txt.length() && j < pat.length()){
            //j == -1表示，模式串已经退回到开始位置，重新开始匹配
            if(j == -1 || txt.charAt(i) == pat.charAt(j)){
                i ++;
                j ++;
            }else{
                // 即j != -1 && txt.charAt(i) != pat.charAt(j)，当前失配，则模式串回退到最长前缀和后缀相等的位置
                // 减少对模式串的匹配次数
                j = next[j];
            }
        }
        if(j == pat.length())
            return i - j;
        else
            return -1;
    }
    private int[] getNext(String pat){
        int[] next = new int[pat.length()];
        int j = 0;
        next[0] = -1;
        int k = -1;
        while(j < pat.length()){
            //if(k == -1 )
        }
        return next;
    }
}
