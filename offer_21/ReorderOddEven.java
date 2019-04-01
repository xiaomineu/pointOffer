package offer_21;

import java.util.Arrays;

public class ReorderOddEven {
    public void reOrder(int [] num)
    {
        if(num.length==0)
        {
            return;
        }
        int left=0;
        int right=num.length-1;
        while(left<right)
        {
            while(num[left]%2!=0&&left<right)
            {
                left++;
            }
            while(num[right]%2==0&&left<right)
            {
                right--;
            }
            int temp=num[right];
            num[right]=num[left];
            num[left]=temp;
        }
    }

    public static void main(String[] args) {
        ReorderOddEven list=new ReorderOddEven();
        int [] num={1,3,4,5,6,7,8,9,10};
        list.reOrder(num);
        System.out.println(Arrays.toString(num));
    }
}
