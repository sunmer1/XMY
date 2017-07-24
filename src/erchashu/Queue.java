package erchashu;

public class Queue {

	public TreeNode first;
	public String data;
	public Queue()
	{
		first=new TreeNode(null);
		first.next=first;
	}
	//���
	public void EnQueue(TreeNode node)
	{
		TreeNode temp=first;
		while(temp.next!=first)
			temp=temp.next;
		temp.next=node;
		node.next=first;
	}
	//����
	public TreeNode DeQueue()
	{
		TreeNode tr=first.next;
		first.next=tr.next;
		return tr;
	}
}
