package List;

public class LinkList {

	public Node first;   //定义一个头结点
	public int temp=0;    //头结点的位置
	int len=0;
	 
	//构造函数，头结点初始状态的的指针域指向空
	public LinkList()
	{
		this.first=null;
	}
	
	//插入一个头结点
	public void addFirstNode(int data)
	{
		Node node=new Node(data);
		node.next=first;   //新建的节点的指针域点指向原头结点
		first=node;        //头结点变为node
		len++;
	}
	
	//删除一个头结点，并返回头结点
	public Node deleteFirstNode()
	{
		Node temp=null;
		if(first==null)
			System.out.println("删除失败，该链表为空，不可执行删除操作");
		else
		{
		temp=first;
		first=temp.next;
		len--;
		}
		return temp;
	}
	
	//在任意位置插入节点，该位置由传参index决定,新增节点为index位置
	public void add(int index,int data)
	{
		Node node=new Node(data);
		Node previous=first;
		Node current=first;
		if(index>len)
		{
			System.out.println("插入失败，插入数据位置超出该链表长度");
			return;
		}
		while(temp!=index)
		{
			previous=current;
			current=current.next;
			temp++;
		}
		if(index==0)
		{
			node.next=first;
			first=node;
		}
		else
		{
		node.next=current;
		previous.next=node;
		}
	    temp=0;
	    len++;
	}
	
	
	//删除任意位置的节点，并返回该节点
	public Node delete(int index)
	{
		Node current=first;
		Node previous=first;
		if(index>len)
		{
			System.out.println("删除失败，该节点位置不存在链表中，超出链表");
			return null;
		}
		while(temp!=index)
		{
			previous=current;
			current=current.next;
			temp++;
		}
		if(current==first)
			first=first.next;
		else
			previous.next=current.next;
		temp=0;
		len--;
		return current;
	}
	
	//根据data删除该节点,并返回该节点
	public Node deleteByData(int data)
	{
		Node current=first;
		Node previous=first;
		while(current.data!=data)
		{
			if(current.next==null)
			{
				System.out.println("删除失败，该数据不存在与该链表中");
				return null;
			}
			previous=current;
			current=current.next;
			
		}
		if(current==first)
		{
			first=current.next;
		}
		else
			previous.next=current.next;	
		len--;
		return current;	
		}
	
	//显示所有的节点信息
	public void displayALL()
	{
		Node current=first;
		while(current!=null)
		{
			current.display();
			current=current.next;
		}
		
	}
	
	public static void main(String[] args)
	{
		LinkList list=new LinkList();
		list.displayALL();
		list.addFirstNode(1);
		list.addFirstNode(10);
		list.add(2,2);
		list.add(2,3);
		list.add(3,4);
//		list.add(5,13);
//		list.deleteFirstNode();
//		list.delete(8);
//		list.deleteByData(3);
		list.displayALL();
	}

}
