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
	//创建一颗树
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
	//判断是否是空树
	public boolean isEmpty()
	{
		return root==null;
	}
	//计算树的高度
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
	//计算节点个数
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
	//返回父母节点
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
	//删除子树,需确定删除的子树是其父节点的左子树还是右子树
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
	 * 删除节点
	 * 
	 * 
	 * 关于删除节点，这里有一点要特别说明，删除操作一般是应用于二叉查找树，涉及到排序的问题，所以在删除的时候要考虑到排序不能乱，
	 * 所以关于二叉树 的删除较为复杂一些。即我们删除后的二叉树依旧是二叉排序树。
	 * 这里我们不多做考虑，主要是为了阐述删除节点的算法，如果觉得这里写的不清楚，可以查看我后面写的关于二叉查找树的博客，二叉查找树也叫二叉排序树
	 * 
	 * 
	 * 删除节点依据要删除节点位置分为三种情况来讨论
	 * 1.删除节点为叶子节点，则直接删除
	 * 2.删除节点不是叶子节点，且该节点仅有一个孩子节点，则将该节点删除，该节点的孩子节点直接放置于删除节点位置
	 * 3.删除节点不是叶子节点，且该节点有两个孩子节点，此时按照中序排列取该节点的前驱或者后驱置于该节点位置并删除前驱或者后驱节点
	 *  我们选择的前驱或者后驱节点必然是没有左孩子或者右孩子的节点，或者是叶子节点
	 */
	public void deleteNode(TreeNode trnode)
	{
		if(root==null)
		{
			root=null;
			return;
		}
		TreeNode tnee=parentNode(root,trnode);
		//要删除的节点为叶子结点，先确定该节点是其父母节点的左节点还是右节点
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
			if(root==trnode)  //根节点的删除要单独处理
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
			//我们这里采用该节点处中根遍历的后驱节点
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
	//先根遍历
	public void PreOrder(TreeNode trnode)
	{
		if(trnode!=null)
		{
			visit(trnode);
			PreOrder(trnode.lchild);
			PreOrder(trnode.rchild);
		}
	}
	//中根遍历
	public void InOrder(TreeNode trnode)
	{
		if(trnode!=null)
		{
			InOrder(trnode.lchild);
			visit(trnode);
			InOrder(trnode.rchild);
		}
	}
	//后根遍历
	public void PostOrder(TreeNode trnode)
	{
		if(trnode!=null)
		{
			PostOrder(trnode.lchild);
			PostOrder(trnode.rchild);
			visit(trnode);
		}
	}
	//层次遍历,层次遍历这里使用了队列.队列使用的类型是带头结点的单循环链表
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
	//测试
	public static void main(String[] args)
	{
		BinaryTree btr=new BinaryTree();
		btr.CreateTree();
		btr.isEmpty();
		int height=btr.TreeHeight();
		System.out.println("该树高度为： "+height);
		int index=btr.TreeNodeIndex();
		System.out.println("该树节点数为： "+index);
		TreeNode tn=btr.parentNode(btr.root,btr.node_d);
		System.out.println("该节点的父节点是: "+tn.data);
	//	btr.deleteNodeTree(btr.node_g);              //删除子树
	//	btr.deleteNode(btr.root);                  //删除节点
		System.out.print("先根遍历的结果：");
		btr.PreOrder(btr.root);
		System.out.println();
		System.out.print("中根遍历的结果：");
		btr.InOrder(btr.root);
		System.out.println();
		System.out.print("后根遍历的结果：");
		btr.PostOrder(btr.root);
		System.out.println();
		System.out.print("层次遍历的结果： ");
		btr.LevelOrder(btr.root);	
		System.out.println();
	}
}