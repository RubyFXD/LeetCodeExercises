/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 ="aabcc",
 * s2 ="dbbca",
 *
 * When s3 ="aadbbcbcac", return true.
 * When s3 ="aadbbbaccc", return false.
 *
 *
 * 注意：
 * s1,s2按字母排列顺序interleave, e.g. s1="ab", s2="bc" "acbb"false
 */
public class IsInterleave {
    /**
     * 二维数组存储当前正太的匹配结果，动态更新
     * 二维数组右下角
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()){
            return false;
        }

        char[] chars1=s1.toCharArray();
        char[] chars2=s2.toCharArray();
        char[] chars3=s3.toCharArray();

        boolean [][]result=new boolean[s1.length()+1][s2.length()+1];
        result[0][0]=true;

        for(int i=1;i<s1.length()+1;i++){
            result[i][0]=result[i-1][0] && chars1[i-1]==chars3[i-1];
        }
        for(int j=1;j<s2.length()+1;j++){
            result[0][j]=result[0][j-1] && chars2[j-1]==chars3[j-1];
        }
        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                result[i][j]= result[i-1][j] && chars1[i-1] == chars3[i+j-1]
                        || result[i][j-1] && chars2[j-1] == chars3[i+j-1];
            }
        }
        return result[s1.length()][s2.length()];

    }

    public static void main(String[] args) {
        IsInterleave isInterleave=new IsInterleave();
        System.out.println(isInterleave.isInterleave("ab","bc","acbb"));
        System.out.println(isInterleave.isInterleave("aabcc","dbbca","aadbbbaccc"));
        System.out.println(isInterleave.isInterleave("ab","bc","abbc"));
    }
}