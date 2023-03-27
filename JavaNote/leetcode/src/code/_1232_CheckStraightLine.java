package code;

/**
 * @author 刘佳俊
 *
 * 1232 点缀成线
 *
 * 思路:
 *
 * // TODO
 * 
 *
 */
public class _1232_CheckStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        boolean flag = true;
        for(int i=0;i<coordinates.length-1;i++){
            if(coordinates[i][0]!=coordinates[i+1][0]){
                flag=false;
                break;
            }
        }
        if(flag){
            return true;
        }
        flag=true;
        for(int i=0;i<coordinates.length-1;i++){
            if(coordinates[i][1]!=coordinates[i+1][1]){
                flag=false;
                break;
            }
        }
        if(flag){
            return true;
        }

        double sin = (double)(coordinates[1][0]-coordinates[0][0]) / (double)(coordinates[1][1]-coordinates[0][1]);
        double temp =0;
        for(int i=1;i<coordinates.length-1;i++){
            temp =  ((double)(coordinates[i+1][0]-coordinates[i][0]) / (double)(coordinates[i+1][1]-coordinates[i][1]));

            if( temp!=sin){
                return false;
            }
        }
        return true;
    }
}
