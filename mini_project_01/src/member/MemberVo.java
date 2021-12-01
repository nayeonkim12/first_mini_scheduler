package member;

import namu.growParent;

public class MemberVo {

	private String id;
	private String pwd;
	private String name;

	public growParent namu = new growParent();

	public MemberVo() {
	}

	public MemberVo(String id, String pwd, String name) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {

		return "Member [id :" + id + ", name : " + name + ", pwd : " + pwd + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}

// 나무부모로부터 상속받는 나무클래스를 여기에 작성
class Tree extends growParent {
	
	
     }
	// 자식이 가지고 있는 고유한 정보

