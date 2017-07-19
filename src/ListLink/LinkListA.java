package ListLink;

public class LinkListA {
	public Node first;
	public int tmp;
	public int len=0;
	
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
			System.out.println("É¾³ýÊ§°Ü£¬¸ÃÁ´±íÎª¿Õ");
		}
		else
		{
			node=first;
			first=node.next;
		}
		return node;
	}
	
	public void addNode(int index,Teacher teacher)
	{
		
	}

}
