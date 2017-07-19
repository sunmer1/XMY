package List;

public class LinkList {

	public Node first;   //����һ��ͷ���
	public int temp=0;    //ͷ����λ��
	int len=0;
	 
	//���캯����ͷ����ʼ״̬�ĵ�ָ����ָ���
	public LinkList()
	{
		this.first=null;
	}
	
	//����һ��ͷ���
	public void addFirstNode(int data)
	{
		Node node=new Node(data);
		node.next=first;   //�½��Ľڵ��ָ�����ָ��ԭͷ���
		first=node;        //ͷ����Ϊnode
		len++;
	}
	
	//ɾ��һ��ͷ��㣬������ͷ���
	public Node deleteFirstNode()
	{
		Node temp=null;
		if(first==null)
			System.out.println("ɾ��ʧ�ܣ�������Ϊ�գ�����ִ��ɾ������");
		else
		{
		temp=first;
		first=temp.next;
		len--;
		}
		return temp;
	}
	
	//������λ�ò���ڵ㣬��λ���ɴ���index����,�����ڵ�Ϊindexλ��
	public void add(int index,int data)
	{
		Node node=new Node(data);
		Node previous=first;
		Node current=first;
		if(index>len)
		{
			System.out.println("����ʧ�ܣ���������λ�ó�����������");
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
	
	
	//ɾ������λ�õĽڵ㣬�����ظýڵ�
	public Node delete(int index)
	{
		Node current=first;
		Node previous=first;
		if(index>len)
		{
			System.out.println("ɾ��ʧ�ܣ��ýڵ�λ�ò����������У���������");
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
	
	//����dataɾ���ýڵ�,�����ظýڵ�
	public Node deleteByData(int data)
	{
		Node current=first;
		Node previous=first;
		while(current.data!=data)
		{
			if(current.next==null)
			{
				System.out.println("ɾ��ʧ�ܣ������ݲ��������������");
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
	
	//��ʾ���еĽڵ���Ϣ
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
