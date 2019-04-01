package offer_19;

public class CharMatch {
    public static boolean match(String test,String template)
    {
        if((test==null)||(template==null))
        {
            return false;
        }
//        char [] tes=test.toCharArray();
//        char [] pattern=template.toCharArray();
        return matchCore(test,0,template,0);
    }

    public static boolean matchCore(String tes,int texIndex,String tem,int temIndex) {
        //两个字符串都到边界
        if (texIndex == tes.length() && temIndex == tem.length()) {
            return true;
        }
        //字符串未到边界，模式串到边界
        if (texIndex != tes.length() && temIndex == tem.length()) {
            return false;
        }
        //模式串未到边界，字符串到边界
        if (texIndex == tes.length() && temIndex != tem.length()) {
            if (temIndex + 1 < tem.length() && tem.charAt(temIndex + 1) == '*') {
                return matchCore(tes, texIndex, tem, temIndex + 2);
            } else
                return false;
        }

        //模式串第二个字符不是*或只剩下一个字符
        if (temIndex == tem.length() - 1 || tem.charAt(temIndex + 1) != '*') {
            if (tem.charAt(temIndex) == '.' || tem.charAt(temIndex) == tes.charAt(texIndex)) {
                return matchCore(tes, texIndex + 1, tem, temIndex + 1);
            } else
                return false;
        }

        //如果模式串第二个字符为*时，并且不止为一个字符;
        else {
            if (tem.charAt(temIndex) == '.' || tem.charAt(temIndex) == tes.charAt(texIndex)) {
                return matchCore(tes, texIndex + 1, tem, temIndex)
                        || matchCore(tes, texIndex + 1, tem, temIndex + 2)
                        || matchCore(tes, texIndex, tem, temIndex + 2);//重复0次的情况

            } else {
                return matchCore(tes, texIndex, tem, temIndex+2);//当前位置不相等，重复0次的情况;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(match("aaa","a.a"));
        System.out.println(match("aaa","ab*ac*a"));
        System.out.println(match("aaa","aa.a"));
    }
}
