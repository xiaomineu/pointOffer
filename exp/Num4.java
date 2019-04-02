package exp;

import java.util.Scanner;

public class Num4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[][] b = new int[n][2];
        int[] flag = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i][0] = a[i];
            b[i][1] = i;//记录当前元素位置;
        }
        slowsort(b,n);
        int ans=0;
        int count=1;
        while(a[left]==1&&n>1&&left<n-1)
        {
            while(a[left]==a[left+1])
            {
                flag[left]=1;
                left++;
                count++;
            }
            ans+=a[left+1]*count;
            flag[left]=1;
            left++;
        }
        count=1;
        while(a[right]==1&&n>1&&right>-1)
        {
            while(a[right]==a[right-1])
            {
                flag[right]=1;
                right--;
                count++;
            }
            ans+=a[n-2]*count;
            flag[right]=1;
            right--;
        }

        for(int i=0;i<n;i++)
        {
            int index=b[i][1];
            if(flag[index]==1||index==left||index==right)
            {
                continue;
            }
            int leftIndex=Leftposition(left,index,flag);
            int rightIndex=Rightposition(right,index,flag);
            int add=b[i][0];
            if(leftIndex>=left)
            {
                add*=a[leftIndex];
            }
            if(rightIndex<=right)
            {
                add*=a[rightIndex];
            }
            flag[index]=1;
            ans+=add;
        }
        ans+=a[left]*a[right];
        if(a[left]>a[right])
        {
            ans+=a[left];
        }
        else
            ans+=a[right];


        System.out.println(ans);
    }

    private static int Leftposition(int left,int position,int []flag)
    {
        int x=position-1;
        while(x>left&&flag[x]==1)
        {
            x--;
        }
        return x;
    }


    private static int Rightposition(int right,int position,int []flag)
    {
        int x=position+1;
        while(x<right&&flag[x]==1)
        {
            x++;
        }
        return x;
    }



    private static void slowsort(int[][] b,int n)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=i;j<n-1;j++)
            {
                if(b[j][0]>b[j+1][0])
                {
                    int x=b[j][0];
                    b[j][0]=b[j+1][0];
                    b[j+1][0]=x;
                    int y=b[j][1];
                    b[j][1]=b[j+1][1];
                    b[j+1][1]=y;
                }
            }
        }
    }
}
