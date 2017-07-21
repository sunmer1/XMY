package ListLink;

/*
 * ѭ��������ļ򵥲���
 */
public class CircleLinkList {
	/*
	 * firstΪͷ��㣬��������ݣ������������ݣ�ָ�����������������ݣ���ָ���׽ڵ�
	 * �����ͷ�����ǰ�����µ�ͷ��㲻һ����֮ǰ��ͷ��㼴Ϊ�׽ڵ㣬����ͷ����������ϵĵ�һ���ڵ㣬
	 * ָ���׽ڵ㣬ͷ��������ݿ���Ϊ�գ�Ҳ���Դ洢�����ȵ�����
	 * �׽ڵ�ָ�����߼��ϴ�����ݵĵ�һ���ڵ�
	 * ��ע������
	 * ����Ϊʲô���׽ڵ�֮ǰʹ��ͷ��㣬���ǲ�ʹ��ͷ����ʱ��ִ�в��롢ɾ��������ʱ��
	 * ����Ҫ�������ǲ���/ɾ����λ���ǲ���λ���׽ڵ�λ�ã��Լ�ԭ�����Ƿ�Ϊ�յ�����
	 * ����ͷ��㣬����Ҫ������Щ����
	 * 
	 */
	public Node first=null;   
	int len=1;   //����ڵ���
	int tmp=0;   //��ǰ�ڵ�λ��
	
	public CircleLinkList()
	{
		first=new Node(null);
		first.next=first;
	}
	//��β����������
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
	//��ͷ����������
	public void addNodeFirst(Teacher teacher)
	{
		Node node=new Node(teacher);
		node.next=first.next;
	    first.next=node;
	    len++;
	}	
	/*
	 * �����û��������ݲ���������
	 * �˴���index��ò�Ҫ��ֵΪ0������ֵΪ0����ͷ��㸲�ǣ���ʱֻ��һ���ڵ㣬��ͷ��㣬
	 * ����ֵΪ0 �������ӽڵ㣬�������ӣ��ڴ˲���֮ǰ�����еĽڵ������򲻴�����
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
	//��β��ɾ������
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
	//ɾ��ͷ������
	public void deleteNodeFirst()
	{
		Node node=first.next;
		first.next=node.next;
		len--;
	}
	/*
	 * ɾ������λ�õ�����
	 * �˴���дɾ��0�ڵ�����������õ�
	 * ���⣬���˴�ʵ�ֵ���ɾ��0�ڵ㣬�������Ȳ���
	 * ������Ҫɾ��0�ڵ�
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
	//��ѯĳλ�õĽڵ���Ϣ����ӡ����
	public void getNodeIndex(int index)
	{
		Node node=first;
		while(tmp!=index)
		{	
		    node=node.next;
		    tmp++;
		}
		tmp=0;
		System.out.println("��ѯ�Ľ̹���Ϣ�ǣ�");
        node.display();
		System.out.println("��ѯ����");        
	}
	//��ѯ����ĳ��������Ϣ����ӡ����
	public void getNodeData(Teacher teacher)
	{
		int temp=0;
		Node node=first;
		for(int i=0;i<len-1;i++)
		{
			node=node.next;
			if(node.teacher.getSno()==teacher.getSno())
			{
				System.out.println("��ѯ�Ľ̹���Ϣ�ǣ�");
		        node.display();
		        temp++;
		        System.out.println("��ѯ����1");  
			}
		}
		if(temp==0)
		{
			System.out.println("δ��ѯ���̹���Ϣ");
	        System.out.println("��ѯ����"); 
		}		
	}
	//�����е����ݴ�ӡ����
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
		Teacher teacher=new Teacher("001","С��","��",22,"1222","wewew");
		cll.addNodeEnd(teacher);
		Teacher teacher1=new Teacher("001","С��","��",23,"1222","wewew");
		cll.addNodeEnd(teacher1);
		Teacher teacher2=new Teacher("002","С��","��",22,"1222","wewew");
		cll.addNodeEnd(teacher2);
		Teacher teacher3=new Teacher("003","С��","��",22,"1222","wewew");
		cll.addNodeFirst(teacher3);
		Teacher teacher4=new Teacher("004","С��","��",22,"1222","wewew");
		cll.addNode(2,teacher4); 
//		cll.deleteNodeEnd();
//		cll.deleteNodeFirst();
		cll.deleteNode(6);
//		cll.getNodeIndex(2);
        cll.PrintAll();
//        Teacher teacher5=new Teacher("001","С��","��",22,"1222","wewew");
//		cll.getNodeData(teacher5);
	}
}
