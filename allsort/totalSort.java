package allsort;


//回溯法实现全排列
public class totalSort {

    public void total(char [] c,int k)
    {
        //使用循环方法，每次保持一位不变，交换其他位字符;
        for(int i=k;i<c.length;i++)
        {
            char tem=c[i];
            c[i]=c[k];
            c[k]=tem;


            total(c,k+1);//k+1满足递归基

            //交换之后，重新交换，保持原来的顺序
            tem=c[i];
            c[i]=c[k];
            c[k]=tem;
        }
        if(k==c.length)
        {
            for(char a:c)
            {
                System.out.print(a);
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        String str="abcd";
        char [] c=str.toCharArray();
        totalSort list=new totalSort();
        list.total(c,0);
    }
}
