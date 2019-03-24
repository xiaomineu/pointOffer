package offer_18;

/**
 * 在O(1)时间复杂度，实现节点删除操作；
 * 待删除节点内容被后继节点覆写
 * 删除后继节点
 */
public class DeleteNode {
    class Node
    {
        int data;
        Node next;
    }

    public void delete(Node Head,Node BeDeleteNode)
    {
        if(Head==null||BeDeleteNode==null)
        {
            return;
        }
        //删除节点不是尾节点;
        if(BeDeleteNode.next!=null)
        {
            Node tem=BeDeleteNode.next;
            BeDeleteNode.data=tem.data;
            BeDeleteNode.next=tem.next;
        }
        //删除链表中只有一个节点;
        else if(Head==BeDeleteNode)
        {
            BeDeleteNode=null;
        }
        //删除节点为尾节点
        else
        {
            Node tem=Head;
            while(tem.next!=BeDeleteNode)
            {
                tem=tem.next;
            }
            tem.next=null;
        }
    }

    public static void main(String[] args) {

    }
}
