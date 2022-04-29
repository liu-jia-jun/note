package algorithm.recursion;

/**
 * @author 刘佳俊
 * 八皇后问题
 */
public class EightQueens {
    int max = 8;
    int[] queens = new int[max];
    public void cheek(int n){
        if (n==max){
            return ;
        }
        for(int i=0;i<max;i++){
            queens[n]=i;
            if(judge(n)){
                cheek(n+1);
            }
        }
    }

    public boolean judge(int n){
        for(int i=0;i<n;i++){
            if(queens[i]==queens[n]||Math.abs(n-i)==Math.abs(queens[n]-queens[i])){
                return false;
            }
        }
        return true;
    }
}
