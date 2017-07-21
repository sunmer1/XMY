package DoubleList;

import ListLink.Teacher;
/*
 * ջ�ļ�ʹ�þ���
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
	//��ջ��Ҳ����ѹջ
	//�������У���ͷ�巨��������
	public void Push(Teacher teacher)
	{
		dll.addNodeHead(teacher);
		len++;
	}
	//��ջ��Ҳ������ջ
	//�������У�����ͷ���֮���Ƴ�����
	public void Pop()
	{
		dll.deleteNodeHead();
		len--;
	}
	//�п�
	public void StackEmpty()
	{
		if(len==0)
			System.out.println("��ջΪ��");
		else
			System.out.println("��ջ����Ϊ: "+len);
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
		Teacher teacher1=new Teacher("001","С��","��",22,"1222","wewew");
		ms.Push(teacher1);
		Teacher teacher2=new Teacher("002","С��","��",22,"1222","wewew");
		ms.Push(teacher2);
		ms.Pop();
		ms.PrintAll();
	}
	
}
