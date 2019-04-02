//package exp;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Num4 {
//    public static void main(String[] args)
//    {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int [] a=new int[n];
//        int [][] b=new int[n][2];
//        int []flag=new int[n];
//        int left=0;
//        int right=n-1;
//        for(int i=0;i<n;i++)
//        {
//            a[i]=in.nextInt();
//            b[i][0]=a[i];
//            b[i][1]=i;
//            flag[i]=0;
//        }
//        int ans=0;
//        if(a[0]==1&&n>1)
//        {
//            ans+=a[1];
//            flag[0]=1;
//            left=1;
//        }
//        if(a[n-1]==1&&n>1)
//        {
//            ans+=a[n-2];
//            flag[n-1]=1;
//            right=n-2;
//        }
//        slowsort(b,n);
//        for(int i=0;i<=n;i++)
//        {
//            int index=b[i][1];
//            if(flag[index]==1)
//            {
//                continue;
//            }
//            int leftindex=findleft(left,index,flag);
//            int rightindex=findright(index,flag,right);
//
//        }
//
//    }
//
//    private static void slowsort(int[][] b,int n)
//    {
//        for(int i=0;i<n;i++)
//        {
//            for(int j=i-1;j>-1;j--)
//            {
//                if(b[i][0]<b[j][0])
//                {
//                    int x=b[i][0];
//                    b[i][0]=b[j][0];
//                    b[j][0]=x;
//                    int y=b[i][1];
//                    b[i][1]=b[j][1];
//                }
//            }
//        }
//    }
//}
