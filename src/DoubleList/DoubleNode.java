package DoubleList;

import ListLink.Teacher;

public class DoubleNode {
	protected DoubleNode next;
	protected DoubleNode pre;
	protected Teacher teacher;

	public DoubleNode(Teacher teacher)
	{
		this.teacher=teacher;		
	}
	
	public void display()
	{
		System.out.println(" 教工编号: "+teacher.getSno()+" 教工姓名: "+teacher.getSname()+" 性别: "+teacher.getSex()+" 年龄: "+teacher.getAge()+" 电话: "+teacher.getTel()+" 邮箱:"+teacher.getEmail());
	}

}
