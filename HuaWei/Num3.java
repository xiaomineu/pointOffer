package HuaWei;


import java.util.Scanner;

/**
 *
 * 1.使用小根堆排列咖啡机使用完成时间
 * 2.每个人选择当前使用时间最小的咖啡机使用
 * 3.将使用时间加上上次完成时间，维护小根堆
 */

public class Num3 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int circle=in.nextInt();
        while(circle>0)
        {
            drinkCoffe();
            circle--;
        }
    }

    private static void drinkCoffe()
    {
        Scanner input=new Scanner(System.in);
        int person=input.nextInt();
        int machineNum=input.nextInt();
        int washCup=input.nextInt();
        int Naturetime=input.nextInt();
        int [][] currentTime=new int[machineNum+1][2];
        for(int i=1;i<=machineNum;i++)
        {
            currentTime[i][1]=input.nextInt();
            currentTime[i][0]=currentTime[i][1];
        }

        //创建小根堆
        InitHeap(currentTime);

        int coffeTime=0;
        int washTime=0;
        int Total=0;

        for(int i=0;i<person;i++)
        {
            coffeTime=currentTime[1][0];
            currentTime[1][0]+=currentTime[1][1];
            mainTainHeap(currentTime);

            Total=coffeTime+Naturetime;
            //杯子是否被占用
            if(coffeTime>washTime)
            {
                if(washCup<Naturetime)
                {
                    washTime=coffeTime+washCup;
                    Total=washTime+washCup;
                }
            }
            else
            {
                //从生产完咖啡到烘干时间与杯子可用时间+洗杯时间之和比较
                if((coffeTime+Naturetime)>(washTime+washCup))
                {
                    Total=washTime+washCup;
                    washTime=washCup+washTime;//更新杯子可用时间点;
                }
            }
        }
        System.out.println(Total);


    }
    private static void InitHeap(int [][] array)
    {
        //自底向下调整
        for(int i=2;i<=array.length-1;i++)
        {
            int j=i;
            while(j/2>0)
            {
                if(array[j][0]<array[j/2][0])
                {
                    swap(array,j,j/2);
                }
                j=j/2;
            }
        }
    }

    private static void mainTainHeap(int [][] array)
    {
        int i=2;
        while(i<=array.length-1)
        {
            if((i+1)<array.length&&array[i][0]>array[i+1][0])
            {
                i++;
            }
            if(array[i][0]<array[i/2][0])
            {
                swap(array,i,i/2);
            }
            i=i*2;
        }
    }

    private static void swap(int [][]array,int i,int j)
    {
        int temp1=array[i][0];
        array[i][0]=array[j][0];
        array[j][0]=temp1;

        int temp2=array[i][1];
        array[i][1]=array[j][1];
        array[j][1]=temp2;
    }
}
