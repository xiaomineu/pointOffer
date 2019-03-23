package offer_17;

//为大数时，无法用int,long类型表示最大数时;
public class bigNumber {
    public void printToMax(int n)
    {
        if(n<=0)
        {
            return;
        }
        //使用字符串数组模拟加法
        char [] list=new char[n+1];
        list[n]='\0';
        for(int i=0;i<10;i++)
        {
            list[0]=(char)(i+'0');
            printCircle(list,n,0);
        }
    }

    //递归打印全排列
    public void printCircle(char[] list,int len,int index)
    {
        if(index==len-1)
        {
            printFinal(list);
            return;
        }
        for(int i=0;i<10;i++)
        {
            list[index+1]=(char)(i+'0');
            printCircle(list,len,index+1);
        }
    }

    public void printFinal(char [] list)
    {
        boolean symbol=true;
        int len=list.length;
        for(int i=0;i<len;i++)
        {
            if(symbol&&list[i]!='0')
            {
                symbol=false;
            }
            if(!symbol)
            {
                System.out.print(list[i]);
            }
        }
    }

    public static void main(String[] args) {
        bigNumber fresh=new bigNumber();
        fresh.printToMax(10);
    }
}
