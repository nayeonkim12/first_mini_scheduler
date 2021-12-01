import java.util.Scanner;
import member.MemberService;
import schedule.ScheduleService;

public class Menu {
    public ScheduleService schedule_service;
    public MemberService member_service;

    public Menu() {
        schedule_service = new ScheduleService();
        member_service = new MemberService();
    }

    /*
     * 
     * 1. 회원가입 2.로그인
     * ------------로그인 완료 시--------------
     * 1. Mypage 2.일정관리
     * ------------1번 선택시--------------
     * Mypage
     * 1-1. 내정보 확인(+레벨정보)
     * 1-2. 내정보 수정
     * 1-3. 로그아웃
     * 1-4. 탈퇴
     * ------------2번 선택시--------------
     * 2.일정관리
     * 2-1. 일정 추가
     * 2-2. 일정 수정
     * 2-3. 일정 삭제
     * 2-4. 일정 목록
     * 완료 일정 목록
     * 미완료 일정 목록
     * 2-5. 일정 검색
     * 키워드로 검색
     * 날짜로 검색
     */

    public void run(Scanner sc) {
        String str = "1.회원가입 2.로그인 3.종료";
        String menu;
        boolean flag = true;
        int haslogin = -1;
        while (flag) {
            if (MemberService.login_id != null) {
                System.out.println(MemberService.login_id + "님이 로그인 중입니다");
            }
            System.out.println(str);
            menu = sc.next();
            switch (menu) {
                case "1":
                	System.out.println("===회원가입===");
                    member_service.addMember(sc);
                    break;
                case "2":
                    haslogin = member_service.login(sc);
                    if (haslogin > 0) {
                        selectMenu(sc);
                    }
                    // 종료도 따로 추가해야하는지? > case3에서 false,break로 종료되는것 같습니다_수현
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                	System.out.print("유효한 메뉴가 아닙니다.");
                	break;
            }
        }
    }

    public void selectMenu(Scanner sc) {

        int menu;
        boolean flag = true;

        while (flag) {
            System.out.println("1. 회원관리 \t 2.일정관리 \t3.나무정보 \t4.로그아웃\t5.탈퇴");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    run_member_menu(sc);
                    break;

                case 2:
                    run_service_menu(sc);
                    break;
                case 3:
                    member_service.print_Namu_service();
                    break;
                case 4:
                    member_service.logout(sc);
                    flag = false;
                    break;
                case 5:
                	 member_service.out();
                	 flag= false;
                	break;
                default:
                	System.out.print("유효한 메뉴가 아닙니다.");
                	break;

            }
        }

    }

    public void run_member_menu(Scanner sc) {
        boolean flag = true;
        int m ;
        while (flag) {
            System.out.println("1.내정보확인\t2.내정보수정\t3.나가기");
            m = sc.nextInt();
            switch (m) {
                case 1:
                    member_service.printMyInfo(sc);

                    break;
                case 2:
                    member_service.rewrite(sc);
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                	System.out.print("유효한 메뉴가 아닙니다.");
                	break;
            }
        }
    }

    public void run_service_menu(Scanner sc) {
        boolean flag = true;
        int m = 0;
        int e = -1;
        while (flag) {
            System.out.println("1.일정추가\t2.일정수정\t3.일정삭제\t4.일정완료\t5.일정목록\t6.일정검색\t7.나가기");
            m = sc.nextInt();
            switch (m) {
                case 1:
                    schedule_service.addScheduleService(sc);
                    break;
                case 2:
                    schedule_service.changeScheduleService(sc);
                    break;
                case 3:
                    schedule_service.deleteScheduleService(sc);
                    break;
                case 4:
                    e = schedule_service.finishScheduleService(sc);
                    // 멤버 서비스-> 멤버 dao -> 멤버 vo -> 나무클래스 -> 경험치전달
                    member_service.plusExpNamu(e);
                    break;
                case 5:
                    schedule_service.printAllService();
                    break;
                case 6:
                    schedule_service.printService(sc);
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                	System.out.print("유효한 메뉴가 아닙니다.");
                	break;
            }
        }
    }

    // 생성자

    // 메인메뉴에 대한 옵션
    // 회원가입 로그인...?

    // 멤버메뉴에 대한 옵션
    // MemberService

    // 일정메뉴에 대한 옵션
    // ScheduleService

}