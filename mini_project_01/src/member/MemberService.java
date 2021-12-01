package member;

import java.util.Scanner;

// MemberDao의 기능을 끌어다 사용하기 위해서 멤버변수로 MemberDao 객체가 필요
public class MemberService {

    Scanner sc = new Scanner(System.in);

    private MemberDao mdao;
    public static String login_id = null;

    public MemberService() { // 생성자
        mdao = new MemberDao();
    }

    // 회원가입
    public void addMember(Scanner sc) {

        // ID 중복체크
        String id = "";
        int idx =-1; // 중복되지 않은 상태
        boolean l = true;
        while(l) {
        	
            System.out.println("ID를 입력하세요.\nID : ");
            id = sc.next();
            idx = mdao.doubleCheck(id);
            if (idx >= 0) {
                System.out.print("중복된 ID입니다. 다른 ");
            }
            else if (idx == -1) {
            	System.out.println("Password를 입력하세요.\nPassword : ");

                String pwd = sc.next();

                System.out.println("이름을 입력하세요.\n이름 : ");
                String name = sc.next();
                mdao.insert(id, pwd,name);
                l =false;           
            }         
        }

    }

    // 로그인
    public int login(Scanner sc) {
        int idx = -1;
        int pwx = -1;
        if (login_id != null) {
            System.out.println("로그인 되어 있습니다.");
            return -1; // 매서드 종료
        }

	        System.out.println("===로그인===");
	        System.out.println("ID : ");
	        String id = sc.next();
	
	        System.out.println("PW : ");
	        String pw = sc.next();
	
	        idx = mdao.selectById(id);
	        pwx = mdao.selectByPwd(pw);
        if (idx == -1) {
            System.out.println("없는 아이디입니다. 로그인 실패");
            return -1;
        } else if (idx >= 0 && pwx >= 0) {
            login_id = id;
            return 1;
        }
        return -1;
    }

    // 내정보 확인
    public void printMyInfo(Scanner m) {
        // 로그인 안되어있을 경우
        if (login_id == null) {
            System.out.println("로그인이 필요합니다.");
        } else if (login_id != null) { // 로그인 되어있을 경우
            mdao.printAll(login_id);
        }

    }

   
    // 로그아웃
    public void logout(Scanner sc) {
        // 로그인 되어있을 경우
        if (login_id != null) {
            login_id = null;
        } else {
            System.out.println("로그아웃 상태");
        }
    }

    // 회원수정
    public void rewrite(Scanner sc) { 
    	String id="";
    	String pw;
    	String name;
        mdao.deleteByid(login_id);   
        System.out.print("수정할 id를 입력하세요");
        id = sc.next();
        System.out.print("수정할 pw를 입력하세요");
        pw = sc.next();
        System.out.print("수정할 이름를 입력하세요");
        name = sc.next();
        login_id = id;
        mdao.insert(id, pw, name);
        
    }

    // 탈퇴
    public void out() {
        if (login_id == null) {
            System.out.println("로그인이 필요합니다.");
        } else if (login_id != null) {
            mdao.deleteByid(login_id);
            login_id = null;
            System.out.println("탈퇴되었습니다.");
        } else {
            System.out.println("등록되지 않은 사용자입니다.");
        }
    }
    //멤버서비스 부분 
    public void plusExpNamu(int exp) {
    	mdao.Namu_plus(exp, login_id);
    }
    // 나무 정보 출력
    public void print_Namu_service() {
        mdao.printNamu(login_id);
    }
    
	
}