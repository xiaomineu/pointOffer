package midNum;

public class midNum {
    public int searchMid(int [] a)
    {
        if(a.length<=0)
        {
            return 0;
        }
        int [] rightMin=new int[a.length];
        int min=a[a.length-1];
        //辅助数组记录数组中从又向左最小值
        for(int i=a.length-1;i>-1;i--)
        {
            if(min>a[i])
            {
                min=a[i];
            }
            rightMin[i]=min;
        }

        //从左向右遍历，找比前值大而且小于辅助数组中最小值，记录当前最大值
        int leftMax=a[0];
        for(int i=0;i<a.length-1;++i)
        {
            if(leftMax<a[i])
            {
                leftMax=a[i];
                if(leftMax<rightMin[i+1])
                {
                    break;
                }
            }
        }
        return leftMax;
    }

    public static void main(String[] args) {
        midNum exp=new midNum();
        int []a={1,6,4,5,8,12,9,10};
        System.out.println(exp.searchMid(a));
    }
}
