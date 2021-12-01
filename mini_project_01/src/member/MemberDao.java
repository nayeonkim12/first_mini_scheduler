
package member;

import java.util.ArrayList;

public class MemberDao {
	// 1.회원가입 2.로그인 3.내정보확인 4.내정보수정 5.로그아웃 6.회원탈퇴

	private ArrayList<MemberVo> datas;

	public MemberDao() {
		datas = new ArrayList<>();
	}

	// 중복체크
	public int doubleCheck(String a) {
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getId().equals(a)) {
				return i;
			}
		}
		return -1;
	}

	// 회원가입 : 배열에 추가할 객체를 파라미터로 받아서 배열에 추가
	public void insert(String id, String psw, String name) { // 파라미터는 리스트 타입과 동일
		MemberVo mbV = new MemberVo();
		mbV.setId(id);
		mbV.setPwd(psw);
		mbV.setName(name);
		datas.add(mbV);
	}

	// ID로 검색
	// 입력받은 ID에 대한 객체의 인덱스번호 반환
	public int selectById(String id) {
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

	// pw로 검색
	public int selectByPwd(String pw) {
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getPwd().equals(pw)) {
				return i;
			}
		}
		return -1;
	}

	// 파라메터로 받아온 방번호로 그 위치의 멤버 객체를 반환.
	public ArrayList<MemberVo> selectByName(String name) {
		ArrayList<MemberVo> sameName = new ArrayList<>();
		for (MemberVo m : datas) {
			if (name.equals(m.getName())) {
				sameName.add(m);
			}
		}
		return sameName;
	}

	// 삭제
	public boolean deleteByid(String id) {
		for (int i = 0; i < datas.size(); i++) {
			MemberVo m = datas.get(i);
			if (m.getId().equals(id)) {
				datas.remove(i);
				return true;
			}
		}

		return false;

	}

	// 나무 정보 출력

	void printNamu(String id) {
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getId().equals(id)) {
				datas.get(i).namu.toString();
				datas.get(i).namu.printNamu();
			}
		}
	}

	
	// 전체정보출력
	void printAll(String id) {
		for (int i = 0; i < datas.size(); i++) {			
			System.out.println(datas.get(i).toString());			
		}
	}
	
	void printOne(String id) {
		for (int i = 0; i < datas.size(); i++) {
			if (datas.get(i).getId().equals(id)) {
				System.out.println(datas.get(i).toString());
			}
		}
	}
	


	public void Namu_plus(int exp, String login_id) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<datas.size();i++) {
			if(datas.get(i).getId().equals(login_id)) {
				datas.get(i).namu.addExp(exp);
			}
		}
	}

}