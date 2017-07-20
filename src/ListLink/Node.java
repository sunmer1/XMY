package ListLink;

public class Node {

	protected Node next=null;
	protected Teacher teacher=null;
	
	public Node(Teacher teacher)
	{
		this.teacher=teacher;
	}
	
	public void display()
	{
		System.out.println(" 教工编号: "+teacher.getSno()+" 教工姓名: "+teacher.getSname()+" 性别: "+teacher.getSex()+" 年龄: "+teacher.getAge()+" 电话: "+teacher.getTel()+" 邮箱:"+teacher.getEmail());
	}
}
