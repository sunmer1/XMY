package erchashu;

public class BinaryTree {
	public TreeNode root;
	
	public BinaryTree()
	{
		root=new TreeNode("A");	
	}
	//创建一颗树
	public void CreateTree()
	{
		TreeNode node_b=new TreeNode("B");
		TreeNode node_c=new TreeNode("C");
		TreeNode node_d=new TreeNode("D");
		TreeNode node_e=new TreeNode("E");
		TreeNode node_f=new TreeNode("F");
		TreeNode node_g=new TreeNode("G");
		TreeNode node_h=new TreeNode("H");
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
		int len=0;
		if(root==null)
			return 0;
		else
		{
			len++;
			size(root.lchild);
			size(root.rchild);
			return len;
		}
	}
	//返回父母节点
	public TreeNode parentNode(TreeNode trnode)
	{
		TreeNode node=new TreeNode(null);
        if(root!=null&&root!=trnode)
        {
        	if(root.lchild==trnode||root.rchild==trnode)
        		node=root;
        	else
        	{
        		parentNode(root.lchild);
        		parentNode(root.rchild);
        	}       		
        }
		return node;
	}
	//删除节点
	public void deleteNode(TreeNode trnode)
	{
		if(trnode.lchild!=null||trnode.rchild!=null)
		{
			deleteNode(trnode.lchild);
			deleteNode(trnode.rchild);
		}
		trnode=null;
	}
	//先根遍历
	public void PreOrder(TreeNode trnode)
	{
		System.out.print("先根遍历的结果：");
		while(trnode!=null)
		{
			visit(trnode);
			PreOrder(trnode.lchild);
			PreOrder(trnode.rchild);
		}
		System.out.println();
	}
	//中跟遍历
	public void InOrder(TreeNode trnode)
	{
		System.out.print("中根遍历的结果：");
		while(trnode!=null)
		{
			PreOrder(trnode.lchild);
			visit(trnode);
			PreOrder(trnode.rchild);
		}
		System.out.println();
	}
	//后跟遍历
	public void PostOrder(TreeNode trnode)
	{
		System.out.print("后根遍历的结果：");
		while(trnode!=null)
		{
			PreOrder(trnode.lchild);
			PreOrder(trnode.rchild);
			visit(trnode);
		}
		System.out.println();
	}
	//层次遍历
	public void Order()
	{
		
	}
	public void visit(TreeNode trnode)
	{
		System.out.print(trnode.data+"  ");
	}
	public static void main(String[] args)
	{
		BinaryTree btr=new BinaryTree();
		btr.CreateTree();
	}
}
