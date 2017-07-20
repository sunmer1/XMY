package ListLink;

public class LinkListA {
	public Node first;
	public int tmp=0;     //节点位置
	public int len=0;     //链表长度
	
	public LinkListA()
	{
		this.first=null;
	}
	
	public void addFirstNode(Teacher teacher)
	{
		Node node=new Node(teacher);
		node.next=first;
		first=node;
		len++;
	}
	
	public Node deleteFirstNode()
	{
		Node node=null;
		if(first==null)
		{
			System.out.println("删除失败，该链表为空");
		}
		else
		{
			node=first;
			first=node.next;
			len--;
		}
		return node;
	}
	
	public void addNode(int index,Teacher teacher)
	{
		Node node=new Node(teacher);
		Node previous=first;
		Node current=first;
		if(index>len||index<0)
		{
			System.out.println("插入失败，超过链表长度");
			return;
		}
		while(tmp!=index)
		{
			previous=current;
			current=current.next;
			tmp++;
		}
		if(index==0)
		{
			node.next=first;
			first=node;
			len++;			
		}
		else
		{
			node.next=current;
			previous.next=node;
			len++;
		}
		tmp=0;
	}

	public Node deleteNodeByIndex(int index)
	{
		Node node=null;
		if(index>=len||index<0)
		{
			System.out.println("删除失败，超出链表长度");
			return node;
		}
		Node previous=first;
		Node current=first;
        while(tmp!=index)
        {
        	previous=current;
        	current=current.next;
        	tmp++;
        }
        if(index==0)
        {
        	node=first;
        	first=node.next;
        	len--;
        }
        else
        {
        	node=current;
        	previous.next=current.next;
        	len--;
        }
		return node;		
	}
	
	
	public void PrintAll()
	{
		Node node=first;
		while(node!=null)
		{
			node.display();
			node=node.next;			
		}
		
	}
	
	public static void main(String[] args)
	{
		LinkListA lla=new LinkListA();
		Teacher teacher=new Teacher("0001","张三","男",45,"12111111","1111@11.com");
		lla.addFirstNode(teacher);
//		Teacher teacher1=new Teacher("0001","李四","男",42,"12111111","1111@11.com");
//		lla.addNode(1, teacher1);
		lla.PrintAll();
	}
	
}
