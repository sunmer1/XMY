package DoubleList;

import ListLink.Teacher;
/*
 * 循环双链表
 * 为了操作方便
 * 在链表中加入了头结点
 * 使得插入删除操作不需要再考虑插入删除数据是位于首节点位置以及链表是否为空的情况
 * 
 */
public class DoubleLinkList {

	public DoubleNode head;   //头结点
	public int len=1;        //实际节点个数
	public int tmp=0;        //节点位置
	
	public DoubleLinkList()
	{
		head=new DoubleNode(null);
		head.pre=head.next=head;
	}
	
	/*
	 * 头插法插入节点
	 * 头插法即插入的数据总是在头结点之后
	 * 即所在位置为head.next
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
	 * 尾插法插入节点
	 * 尾插法即插入的数据总是在最后
	 * 即所在位置为head.pre
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
	//在任何节点插入数据
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
	//从头结点删除
	public DoubleNode deleteNodeHead()
	{
		DoubleNode node=new DoubleNode(null);
		head.next.next.pre=head.next;
		head.next=head.next.next;		
		return node;
	}
	//从尾节点删除
	public DoubleNode deleteNodeTail()
	{
		DoubleNode node=new DoubleNode(null);
		head.pre.pre.next=head;
		head.pre=head.pre.pre;
		return node;
	}
	//删除节点
	public void deleteNode(int index)
	{
		int temp=index%len;     //这一步是为了防止将head删除，这会导致错误。
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
		Teacher teacher1=new Teacher("001","小明","男",22,"1222","wewew");
		dll.addNodeHead(teacher1);
		Teacher teacher2=new Teacher("002","小明","男",22,"1222","wewew");
		dll.addNodeHead(teacher2);
		Teacher teacher3=new Teacher("003","小明","男",22,"1222","wewew");
		dll.addNodeTail(teacher3);
		Teacher teacher4=new Teacher("004","小明","男",22,"1222","wewew");
		dll.addNodeTail(teacher4);
//		Teacher teacher5=new Teacher("005","小明","男",22,"1222","wewew");
//		dll.addNode(2,teacher5);
//		dll.deleteNode(5);
//		dll.deleteNodeHead();
//		dll.deleteNodeTail();
		dll.PrintAll();
	}
}
