package offer_13;

public class RobotRangeActive {
    public int movingCount(int K,int row,int col)
    {
        if(K<0||row<=0||col<=0)
        {
            return 0;
        }
        boolean [][]assist=new boolean[row][col];
        return MovingCountCore(K,row,col,0,0,assist);
    }

    //递归访问该节点周围节点;
    public  int MovingCountCore(int K,int row,int col,int r,int c,boolean[][]assist)
    {
        int count=0;
        if(check(K,row,col,r,c,assist))
        {
            assist[r][c]=true;//标记为已访问;
            count=1+MovingCountCore(K,row,col,r+1,c,assist)+MovingCountCore(K,row,col,r-1,c,assist)+MovingCountCore(K,row,col,r,c+1,assist)+MovingCountCore(K,row,col,r,c-1,assist);
        }
        return count;
    }

    //判断该节点能否被访问
    public boolean check(int K,int row,int col,int r,int c,boolean[][]assist)
    {
            return r>=0 && c>=0 && r<row && c<col && (GetDigitSum(r)+GetDigitSum(c))<=K &&!assist[r][c];
    }

    public int GetDigitSum(int number)
    {
        int sum=0;
        while(number>0)
        {
            sum+=number%10;
            number/=10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotRangeActive robot=new RobotRangeActive();
        System.out.println(robot.movingCount(0,3,4));
        System.out.println(robot.movingCount(10,3,4));
    }
}
