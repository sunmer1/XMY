package DoubleList;

import ListLink.Teacher;
/*
 * 栈的简单使用举例
 */
public class MyStack {

	protected DoubleLinkList dll;;
	protected int top;
	int len=0;
	
	public MyStack()
	{
		dll=new DoubleLinkList();
		top=-1;
	}
	//进栈、也叫做压栈
	//在链表中，即头插法插入数据
	public void Push(Teacher teacher)
	{
		dll.addNodeHead(teacher);
		len++;
	}
	//出栈，也叫做退栈
	//在链表中，即从头结点之后移除数据
	public void Pop()
	{
		dll.deleteNodeHead();
		len--;
	}
	//判空
	public void StackEmpty()
	{
		if(len==0)
			System.out.println("此栈为空");
		else
			System.out.println("此栈长度为: "+len);
	}
	public void PrintAll()
	{
		DoubleNode node=dll.head.next;
		while(node!=dll.head)
		{
			node.display();
			node=node.next;			
		}	
	}
	public static void main(String args[])
	{
		MyStack ms=new MyStack();
		Teacher teacher1=new Teacher("001","小明","男",22,"1222","wewew");
		ms.Push(teacher1);
		Teacher teacher2=new Teacher("002","小明","男",22,"1222","wewew");
		ms.Push(teacher2);
		ms.Pop();
		ms.PrintAll();
	}
	
}
