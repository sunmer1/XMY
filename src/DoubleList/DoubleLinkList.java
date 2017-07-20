package DoubleList;

import ListLink.Teacher;

public class DoubleLinkList {

	public DoubleNode head;   //头结点
	public DoubleNode tail;   //尾节点
	public int len=0;        //实际节点个数
	public int tmp=0;  
	
	public DoubleLinkList()
	{
		this.head=null;
		this.tail=null;
	    head.pre=tail;
		tail.next=head;
	}
	//头插法插入节点
	public void addNodeHead(Teacher teacher)
	{
		DoubleNode node=new DoubleNode(teacher);
		if(head==null&&tail==null)
		{
			node.next=head;
			head=node;
			tail=node;
		}
		else
		{
		
		}
	}
	//尾插法插入节点
	public void addNodeTail(Teacher teacher)
	{
		DoubleNode node=new DoubleNode(teacher);
		if(head==null||tail==null)
		{
			
		}
		else
		{
			
		}
		
													
	}
}
