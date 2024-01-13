
/**
 * This Rotate class represents . . .
 *
 * @Caleb Wang  (your name)
 * @8/23/23 (todays date)
 */
public class Rotate
{
    public static int[][] rotateArray(int [][] given) {
        int [][] answer = new int [given.length][given[0].length];
        int r = 0;
        int c = 0;
        for (int col = 0; col < given[0].length; col++) {
            for (int row = given.length - 1; row >= 0; row--){
                answer[r][c] = given[row][col];
                c++;
                if (c >= given.length) {
                    c = 0;
                    r++;
                }
            }
        }
        return answer; 
    }
}
