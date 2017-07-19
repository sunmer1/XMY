package ListLink;

public class Teacher {
	private String sno;
	private String sname;
	private String sex;
	private int age;
	private String tel;
	private String email;
	
	public Teacher(String sno,String sname,String sex,int age,String tel,String email)
	{
		this.sno=sno;
		this.sname=sname;
		this.sex=sex;
		this.age=age;
		this.tel=tel;
		this.email=email;
	}
	public String getSno() {
		return sno;
	}
	public String getSname() {
		return sname;
	}
	public String getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public String getTel() {
		return tel;
	}
	public String getEmail() {
		return email;
	}
	
}
