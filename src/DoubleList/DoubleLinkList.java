package DoubleList;

import ListLink.Teacher;
/*
 * ѭ��˫����
 * Ϊ�˲�������
 * �������м�����ͷ���
 * ʹ�ò���ɾ����������Ҫ�ٿ��ǲ���ɾ��������λ���׽ڵ�λ���Լ������Ƿ�Ϊ�յ����
 * 
 */
public class DoubleLinkList {

	public DoubleNode head;   //ͷ���
	public int len=1;        //ʵ�ʽڵ����
	public int tmp=0;        //�ڵ�λ��
	
	public DoubleLinkList()
	{
		head=new DoubleNode(null);
		head.pre=head.next=head;
	}
	
	/*
	 * ͷ�巨����ڵ�
	 * ͷ�巨�����������������ͷ���֮��
	 * ������λ��Ϊhead.next
	 */
	public void addNodeHead(Teacher teacher)
	{
		DoubleNode node=new DoubleNode(teacher);
		node.next=head.next;
        head.next.pre=node;
		head.next=node;
		node.pre=head;
		len++;
	}
	/*
	 * β�巨����ڵ�
	 * β�巨��������������������
	 * ������λ��Ϊhead.pre
	 */
	public void addNodeTail(Teacher teacher)
	{
		DoubleNode node=new DoubleNode(teacher);
		node.next=head;
		node.pre=head.pre;
		head.pre.next=node;	
		head.pre=node;
		len++;
	}
	//���κνڵ��������
	public void addNode(int index,Teacher teacher)
	{
		DoubleNode node=new DoubleNode(teacher);
		DoubleNode previous=head;
		DoubleNode current=head;
		while(tmp!=index)
		{
			previous=current;
			current=current.next;
			tmp++;
		}
		node.next=current;
		current.pre=node;
		previous.next=node;
		node.pre=previous;
		tmp=0;	
		len++;
	}
	//��ͷ���ɾ��
	public DoubleNode deleteNodeHead()
	{
		DoubleNode node=new DoubleNode(null);
		head.next.next.pre=head.next;
		head.next=head.next.next;		
		return node;
	}
	//��β�ڵ�ɾ��
	public DoubleNode deleteNodeTail()
	{
		DoubleNode node=new DoubleNode(null);
		head.pre.pre.next=head;
		head.pre=head.pre.pre;
		return node;
	}
	//ɾ���ڵ�
	public void deleteNode(int index)
	{
		int temp=index%len;     //��һ����Ϊ�˷�ֹ��headɾ������ᵼ�´���
		DoubleNode previous=head;
		DoubleNode current=head;
		while(tmp!=temp)
		{
			previous=current;
			current=current.next;
			tmp++;
		}
		current.next.pre=previous;
		previous.next=current.next;
		tmp=0;
		len--;
	}
	public void PrintAll()
	{
		DoubleNode node=head.next;
		while(node!=head)
		{
			node.display();
			node=node.next;			
		}	
	}
	public static void main(String[] args)
	{
		DoubleLinkList dll=new DoubleLinkList();
		Teacher teacher1=new Teacher("001","С��","��",22,"1222","wewew");
		dll.addNodeHead(teacher1);
		Teacher teacher2=new Teacher("002","С��","��",22,"1222","wewew");
		dll.addNodeHead(teacher2);
		Teacher teacher3=new Teacher("003","С��","��",22,"1222","wewew");
		dll.addNodeTail(teacher3);
		Teacher teacher4=new Teacher("004","С��","��",22,"1222","wewew");
		dll.addNodeTail(teacher4);
//		Teacher teacher5=new Teacher("005","С��","��",22,"1222","wewew");
//		dll.addNode(2,teacher5);
//		dll.deleteNode(5);
//		dll.deleteNodeHead();
//		dll.deleteNodeTail();
		dll.PrintAll();
	}
}
