package DoubleList;


import List.LinkList;
import List.Node;


public class MyQueue {

	public LinkList lls;
	int len=0;
	public MyQueue()
	{
		lls=new LinkList();
	}
	//入队
	public void EnQueue(String data)
	{
		lls.add(len, data);
		len++;
	}
	//出队
	public Node DeQueue()
	{
		Node node=lls.deleteFirstNode();
		return node;
	}
}
