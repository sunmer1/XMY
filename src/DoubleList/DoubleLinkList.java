package DoubleList;

import ListLink.Teacher;

public class DoubleLinkList {

	public DoubleNode head;   //ͷ���
	public DoubleNode tail;   //β�ڵ�
	public int len=0;        //ʵ�ʽڵ����
	public int tmp=0;  
	
	public DoubleLinkList()
	{
		this.head=null;
		this.tail=null;
	    head.pre=tail;
		tail.next=head;
	}
	//ͷ�巨����ڵ�
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
	//β�巨����ڵ�
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
