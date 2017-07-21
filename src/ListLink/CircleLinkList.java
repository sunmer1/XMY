package ListLink;

/*
 * 循环单链表的简单操作
 */
public class CircleLinkList {
	/*
	 * first为头结点，不存放内容，若后面无内容，指向自身，若后面有内容，则指向首节点
	 * 这里的头结点与前面两章的头结点不一样，之前的头结点即为首节点，这里头结点是物理上的第一个节点，
	 * 指向首节点，头结点中内容可以为空，也可以存储链表长度等数据
	 * 首节点指的是逻辑上存放数据的第一个节点
	 * 请注意区分
	 * 至于为什么在首节点之前使用头结点，我们不使用头结点的时候，执行插入、删除操作的时候，
	 * 往往要考虑我们插入/删除的位置是不是位于首节点位置，以及原链表是否为空的问题
	 * 引入头结点，则不需要考虑这些问题
	 * 
	 */
	public Node first=null;   
	int len=1;   //链表节点数
	int tmp=0;   //当前节点位置
	
	public CircleLinkList()
	{
		first=new Node(null);
		first.next=first;
	}
	//在尾部插入数据
	public void addNodeEnd(Teacher teacher)
	{
		Node node=new Node(teacher);
		Node temp=first;
		while(temp.next!=first)
			temp=temp.next;
		temp.next=node;
		node.next=first;
		len++;
	}
	//在头部插入数据
	public void addNodeFirst(Teacher teacher)
	{
		Node node=new Node(teacher);
		node.next=first.next;
	    first.next=node;
	    len++;
	}	
	/*
	 * 根据用户需求将数据插入链表中
	 * 此处的index最好不要传值为0，若传值为0，则将头结点覆盖，此时只有一个节点，即头结点，
	 * 若传值为0 后继续添加节点，则继续添加，在此步骤之前链表中的节点数据则不存在了
	 */
	public void addNode(int index,Teacher teacher)
	{
		Node node=new Node(teacher);
		Node previous=first;
		Node current=first;
		while(tmp!=index)
		{
			previous=current;
			current=current.next;
			tmp++;
		}
		node.next=current;
		previous.next=node;
		len++;	
		tmp=0;
	}
	//在尾部删除数据
	public void deleteNodeEnd()
	{
		Node previous=first;
		Node current=first;
		while(current.next!=first)
		{
			previous=current;
			current=current.next;
		}
		previous.next=first;
		len--;
	}
	//删除头部数据
	public void deleteNodeFirst()
	{
		Node node=first.next;
		first.next=node.next;
		len--;
	}
	/*
	 * 删除任意位置的数据
	 * 此处若写删除0节点的数据是无用的
	 * 另外，若此处实现的是删除0节点，该链表长度不变
	 * 尽量不要删除0节点
	 * 
	 */
	public void deleteNode(int index)
	{
		int temp=index%len;
		Node previous=first;
		Node current=first;
		while(tmp!=temp)
		{
			previous=current;
			current=current.next;
			tmp++;
		}
		previous.next=current.next;
		len--;
		tmp=0;
	}
	//查询某位置的节点信息并打印出来
	public void getNodeIndex(int index)
	{
		Node node=first;
		while(tmp!=index)
		{	
		    node=node.next;
		    tmp++;
		}
		tmp=0;
		System.out.println("查询的教工信息是：");
        node.display();
		System.out.println("查询结束");        
	}
	//查询满足某条件的信息并打印出来
	public void getNodeData(Teacher teacher)
	{
		int temp=0;
		Node node=first;
		for(int i=0;i<len-1;i++)
		{
			node=node.next;
			if(node.teacher.getSno()==teacher.getSno())
			{
				System.out.println("查询的教工信息是：");
		        node.display();
		        temp++;
		        System.out.println("查询结束1");  
			}
		}
		if(temp==0)
		{
			System.out.println("未查询到教工信息");
	        System.out.println("查询结束"); 
		}		
	}
	//将所有的数据打印出来
	public void PrintAll()
	{
		Node node=first.next;
		while(node!=first)
		{
			node.display();
			node=node.next;			
		}	
	}
	public static void main(String[] args)
	{
		CircleLinkList cll=new CircleLinkList();
		//cll.PrintAll();
		Teacher teacher=new Teacher("001","小明","男",22,"1222","wewew");
		cll.addNodeEnd(teacher);
		Teacher teacher1=new Teacher("001","小明","男",23,"1222","wewew");
		cll.addNodeEnd(teacher1);
		Teacher teacher2=new Teacher("002","小明","男",22,"1222","wewew");
		cll.addNodeEnd(teacher2);
		Teacher teacher3=new Teacher("003","小明","男",22,"1222","wewew");
		cll.addNodeFirst(teacher3);
		Teacher teacher4=new Teacher("004","小明","男",22,"1222","wewew");
		cll.addNode(2,teacher4); 
//		cll.deleteNodeEnd();
//		cll.deleteNodeFirst();
		cll.deleteNode(6);
//		cll.getNodeIndex(2);
        cll.PrintAll();
//        Teacher teacher5=new Teacher("001","小红","男",22,"1222","wewew");
//		cll.getNodeData(teacher5);
	}
}
