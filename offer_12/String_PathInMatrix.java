package offer_12;

public class String_PathInMatrix {

    public static boolean hasPath(char [][] matrix,String str)
    {
        //判断边界
        if(matrix.length==0||matrix==null||str==null||str.length()==0)
        {
            return false;
        }
        int rowlen=matrix.length;
        int collen=matrix[0].length;
        boolean [][]symbol=new boolean[rowlen][collen];
        for(int i=0;i<rowlen;i++)
        {
            for(int j=0;j<collen;j++)
            {
                if(hasPathCore(matrix,i,j,symbol,str,0))
                {
                    return true;
                }
            }
        }
        return false;
    }

    //
    public static boolean hasPathCore(char [][] matrix,int rowIndex,int colIndex,boolean [][]symbol,String str,int StrIndex)
    {
        //递归基
        if(StrIndex>=str.length())
        {
            return true;
        }
        if(rowIndex<0||colIndex<0||rowIndex>=matrix.length||colIndex>=matrix[0].length)
        {
            return false;
        }
        //递归
        if(!symbol[rowIndex][colIndex]&&matrix[rowIndex][colIndex]==str.charAt(StrIndex))
        {
            //如果该节点未被访问，并且节点字符匹配，上下左右分别求解
            symbol[rowIndex][colIndex]=true;
            boolean result=
                    hasPathCore(matrix,rowIndex+1,colIndex,symbol,str,StrIndex+1)||
                    hasPathCore(matrix,rowIndex,colIndex+1,symbol,str,StrIndex+1)||
                            hasPathCore(matrix,rowIndex-1,colIndex,symbol,str,StrIndex+1)||
                            hasPathCore(matrix,rowIndex,colIndex-1,symbol,str,StrIndex+1);

            if(result)
            {
                return true;
            }
            //当前递归路线求解失败，将这条路线标记清除
            else
            {
                symbol[rowIndex][colIndex]=false;
                return false;
            }
        }
        else
            return false;
    }

    public static void main(String[] args) {
        char[][]maxtri={
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        System.out.println(hasPath(maxtri,"bfce"));
        System.out.println(hasPath(maxtri,"abfb"));
    }


}
