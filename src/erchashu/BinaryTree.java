package erchashu;



public class BinaryTree {
	public TreeNode root;
	public TreeNode node_b;
	public TreeNode node_c;
	public TreeNode node_d;
	public TreeNode node_e;
	public TreeNode node_f;
	public TreeNode node_g;
	public TreeNode node_h;
	
	public BinaryTree()
	{
		root=new TreeNode("A");	
	}
	//����һ����
	public void CreateTree()
	{
		node_b=new TreeNode("B");
		node_c=new TreeNode("C");
		node_d=new TreeNode("D");
		node_e=new TreeNode("E");
		node_f=new TreeNode("F");
		node_g=new TreeNode("G");
		node_h=new TreeNode("H");
		root.lchild=node_b;
		root.rchild=node_c;
		node_b.lchild=node_d;
		node_d.lchild=node_g;
		node_c.lchild=node_e;
		node_c.rchild=node_f;
		node_f.rchild=node_h;
	}
	//�ж��Ƿ��ǿ���
	public boolean isEmpty()
	{
		return root==null;
	}
	//�������ĸ߶�
	public int TreeHeight()
	{
		int length=height(root);
		return length;
	}
	public int height(TreeNode root)
	{
		if(root==null)
			return 0;
		else
		{
			int i=height(root.lchild);
			int j=height(root.rchild);
			return (i>j)?(i+1):(j+1);
		}
	}
	//����ڵ����
	public int TreeNodeIndex()
	{
		return size(root);
	}
	public int size(TreeNode root)
	{
		if(root==null)
			return 0;
		else
		{
			return 1+size(root.lchild)+size(root.rchild);
		}
	}
	//���ظ�ĸ�ڵ�
	public TreeNode parentNode(TreeNode root,TreeNode trnode)
	{
		TreeNode node=null;
        if(root!=null&&root!=trnode)
        {
        	if(root.lchild==trnode||root.rchild==trnode)
        		return root;
        	else
        	{
        		TreeNode s1=parentNode(root.lchild,trnode);
        		TreeNode s2=parentNode(root.rchild,trnode);
        		if(s1!=null)
        			node=s1;
        		else
        			if(s2!=null)
        				node=s2;
        	}  
        }
        return node;
	}
	//ɾ������,��ȷ��ɾ�����������丸�ڵ������������������
	public void deleteNodeTree(TreeNode trnode)
	{
		if(root==null||root==trnode)
		{
			root=null;
			return;
		}
		TreeNode temp=parentNode(root,trnode);
		if(temp.lchild==trnode)
			temp.lchild=null;
		if(temp.rchild==trnode)
			temp.rchild=null;
		if(trnode!=null)
		{	
			deleteNode(trnode.lchild);
			deleteNode(trnode.rchild);
		}
	}
	/*
	 * ɾ���ڵ�
	 * 
	 * 
	 * ����ɾ���ڵ㣬������һ��Ҫ�ر�˵����ɾ������һ����Ӧ���ڶ�����������漰����������⣬������ɾ����ʱ��Ҫ���ǵ��������ң�
	 * ���Թ��ڶ����� ��ɾ����Ϊ����һЩ��������ɾ����Ķ����������Ƕ�����������
	 * �������ǲ��������ǣ���Ҫ��Ϊ�˲���ɾ���ڵ���㷨�������������д�Ĳ���������Բ鿴�Һ���д�Ĺ��ڶ���������Ĳ��ͣ����������Ҳ�ж���������
	 * 
	 * 
	 * ɾ���ڵ�����Ҫɾ���ڵ�λ�÷�Ϊ�������������
	 * 1.ɾ���ڵ�ΪҶ�ӽڵ㣬��ֱ��ɾ��
	 * 2.ɾ���ڵ㲻��Ҷ�ӽڵ㣬�Ҹýڵ����һ�����ӽڵ㣬�򽫸ýڵ�ɾ�����ýڵ�ĺ��ӽڵ�ֱ�ӷ�����ɾ���ڵ�λ��
	 * 3.ɾ���ڵ㲻��Ҷ�ӽڵ㣬�Ҹýڵ����������ӽڵ㣬��ʱ������������ȡ�ýڵ��ǰ�����ߺ������ڸýڵ�λ�ò�ɾ��ǰ�����ߺ����ڵ�
	 *  ����ѡ���ǰ�����ߺ����ڵ��Ȼ��û�����ӻ����Һ��ӵĽڵ㣬������Ҷ�ӽڵ�
	 */
	public void deleteNode(TreeNode trnode)
	{
		if(root==null)
		{
			root=null;
			return;
		}
		TreeNode tnee=parentNode(root,trnode);
		//Ҫɾ���Ľڵ�ΪҶ�ӽ�㣬��ȷ���ýڵ����丸ĸ�ڵ����ڵ㻹���ҽڵ�
		if(trnode.lchild==null&&trnode.rchild==null)
		{
			if(trnode==root)
			{
				root=null;
				return;
			}
			if(tnee.lchild==trnode)
				tnee.lchild=null;
			if(tnee.rchild==trnode)
				tnee.rchild=null;
			return;
		}
		if(trnode.lchild!=null&&trnode.rchild==null)
		{
			if(root==trnode)
			{
			    root=trnode.lchild;
				return;
			}
			if(tnee.lchild==trnode)
				tnee.lchild=trnode.lchild;
			if(tnee.rchild==trnode)
				tnee.rchild=trnode.lchild;
			return;	
		}
		if(trnode.lchild==null&&trnode.rchild!=null)
		{
			if(root==trnode)
			{
			    root=trnode.rchild;
				return;
			}
			if(tnee.lchild==trnode)
				tnee.lchild=trnode.rchild;
			if(tnee.rchild==trnode)
				tnee.rchild=trnode.rchild;
			return;
		}
		if(trnode.lchild!=null&&trnode.rchild!=null)
		{
			if(root==trnode)  //���ڵ��ɾ��Ҫ��������
			{
				TreeNode tmp=trnode.rchild;
				while(tmp.lchild!=null)
					tmp=tmp.lchild;
				deleteNode(tmp);
				root=tmp;
				tmp.rchild=trnode.rchild;
				tmp.lchild=trnode.lchild;
				return;
			}
			//����������øýڵ㴦�и������ĺ����ڵ�
			TreeNode temp=trnode.rchild;
			while(temp.lchild!=null)
				temp=temp.lchild;
			if(tnee.lchild==trnode)
			{
				deleteNode(temp);
				tnee.lchild=temp;
				temp.rchild=trnode.rchild;
				temp.lchild=trnode.lchild;
			}
			if(tnee.rchild==trnode)
			{
				deleteNode(temp);
				tnee.rchild=temp;
				temp.rchild=trnode.rchild;
				temp.lchild=trnode.lchild;	
			}
			return;
		}		
	}
	//�ȸ�����
	public void PreOrder(TreeNode trnode)
	{
		if(trnode!=null)
		{
			visit(trnode);
			PreOrder(trnode.lchild);
			PreOrder(trnode.rchild);
		}
	}
	//�и�����
	public void InOrder(TreeNode trnode)
	{
		if(trnode!=null)
		{
			InOrder(trnode.lchild);
			visit(trnode);
			InOrder(trnode.rchild);
		}
	}
	//�������
	public void PostOrder(TreeNode trnode)
	{
		if(trnode!=null)
		{
			PostOrder(trnode.lchild);
			PostOrder(trnode.rchild);
			visit(trnode);
		}
	}
	//��α���,��α�������ʹ���˶���.����ʹ�õ������Ǵ�ͷ���ĵ�ѭ������
	public void LevelOrder(TreeNode trnode)
	{
		Queue mqq=new Queue();
        if(trnode==null)
        	return;
       mqq.EnQueue(trnode);
       while(mqq.first.next!=mqq.first)
       {
    	   TreeNode node=mqq.DeQueue();
    	   System.out.print(node.data+"  ");
    	   if(node.lchild!=null)
    		   mqq.EnQueue(node.lchild);
    	   if(node.rchild!=null)
    		   mqq.EnQueue(node.rchild);  
       }
	}
	public void visit(TreeNode trnode)
	{
		System.out.print(trnode.data+"  ");
	}
	//����
	public static void main(String[] args)
	{
		BinaryTree btr=new BinaryTree();
		btr.CreateTree();
		btr.isEmpty();
		int height=btr.TreeHeight();
		System.out.println("�����߶�Ϊ�� "+height);
		int index=btr.TreeNodeIndex();
		System.out.println("�����ڵ���Ϊ�� "+index);
		TreeNode tn=btr.parentNode(btr.root,btr.node_d);
		System.out.println("�ýڵ�ĸ��ڵ���: "+tn.data);
	//	btr.deleteNodeTree(btr.node_g);              //ɾ������
	//	btr.deleteNode(btr.root);                  //ɾ���ڵ�
		System.out.print("�ȸ������Ľ����");
		btr.PreOrder(btr.root);
		System.out.println();
		System.out.print("�и������Ľ����");
		btr.InOrder(btr.root);
		System.out.println();
		System.out.print("��������Ľ����");
		btr.PostOrder(btr.root);
		System.out.println();
		System.out.print("��α����Ľ���� ");
		btr.LevelOrder(btr.root);	
		System.out.println();
	}
}