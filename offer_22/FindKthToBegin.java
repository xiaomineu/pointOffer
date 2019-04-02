package offer_22;

import java.util.Stack;

/**
 * 倒数第K个节点
 * 可使用堆栈:
 */
class ListNode
{
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}

public class FindKthToBegin {
    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        node.next.next.next.next.next=new ListNode(6);
        ListNode fin=valueOfKth(node,0);
        System.out.println(fin);
    }
    public static ListNode valueOfKth(ListNode head,int K)
    {
        if(head==null)
        {
            return null;
        }
        Stack<ListNode> stack=new Stack<>();
        ListNode listNode=head;
        while(listNode!=null)
        {
            stack.push(listNode);
            listNode=listNode.next;
        }
        if(stack.size()<K||K==0)
        {
            return null;
        }
        while(K>1)
        {
            stack.pop();
            K--;
        }
        ListNode fin=stack.peek();
        return fin;
    }
}
