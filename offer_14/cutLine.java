package offer_14;

public class cutLine {
    public int maxCuttingNumber(int length)
    {
        //判断边界条件
        if(length<2)
        {
            return 0;
        }
        if(length==2)
        {
            return 1;
        }
        if(length==3)
        {
            return 2;
        }

        //辅助数组，记录长度为i时所对应的最大乘积;
        int [] maxNumber=new int[length+1];
        maxNumber[0]=0;
        maxNumber[1]=1;
        maxNumber[2]=2;
        maxNumber[3]=3;
        int max=0;

        //i递增，自下向上计算至length
        for(int i=4;i<=length;i++)
        {
            max=0;
            //当长度为i时，计算最大乘积;
            for(int j=1;j<=i/2;j++)
            {
                int value=maxNumber[j]*maxNumber[i-j];
                if(value>max)
                {
                    max=value;
                }
            }
            maxNumber[i]=max;
        }
        max=maxNumber[length];
        return max;
    }

    public static void main(String[] args) {
        cutLine exp=new cutLine();
        System.out.println(exp.maxCuttingNumber(100));
    }

}
