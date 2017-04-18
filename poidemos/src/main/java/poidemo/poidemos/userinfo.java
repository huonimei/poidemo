package poidemo.poidemos;

public class userinfo {
	private int Id;
	private String Name;
	private String Pwd;
	private int age;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return  "id:"+this.getId()+"name:"+this.getName()+"password:"+this.getPwd()+"age:"+this.getAge();
	}
	
}
