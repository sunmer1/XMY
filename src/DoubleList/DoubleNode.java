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
		System.out.println(" �̹����: "+teacher.getSno()+" �̹�����: "+teacher.getSname()+" �Ա�: "+teacher.getSex()+" ����: "+teacher.getAge()+" �绰: "+teacher.getTel()+" ����:"+teacher.getEmail());
	}

}
