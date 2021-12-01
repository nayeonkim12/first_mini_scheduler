package schedule;

import java.util.Scanner;

public class ScheduleService {

  //
  /*
   * 2.일정관리
   * 
   * 2-1. 일정 추가.
   * 2-2. 일정 수정
   * 2-3. 일정 삭제.
   * 2-4. 일정 목록
   * 완료 일정 목록
   * 미완료 일정 목록
   * 2-5. 일정 검색
   * 키워드로 검색
   * 날짜로 검색
   */
  public ScheduleDao dao = new ScheduleDao();
  Scanner sc = new Scanner(System.in);

  // public ScheduleService(Scanner sc) {
  // 일정추가

  public void addScheduleService(Scanner sc) {
    String a;
    String b;
    boolean c = true;
    System.out.println("추가할 할 일을 입력해주세요.");
    a = sc.next();
    System.out.println("할일 입력이 완료되었습니다.");
    while (c) {
      System.out.println("중요도를 입력하세요. 1~3중에 입력 1:매우중요,2:중요,3:보통");
      b = sc.next();
      if (b.equals("1")|| b.equals("2")|| b.equals("3")) {
        dao.addSchedule(b, a);
        System.out.println("일정이 성공적으로 추가되었습니다.");
        c = false; 
      }
    }

  }

  // 일정 수정
  public void changeScheduleService(Scanner sc) {
	  // 일정 수정
	        String a = "";
	        boolean x = false;
	        System.out.println("수정할 일정을 입력하세요"); // 이걸 삭제시키기
	        a = sc.next();
	        x = dao.deleteSchedule(a);
	        if (x) {
	            System.out.println("뭐로 바꿀까요");
	         addScheduleService(sc);
	        }
	        
    // 일정추가 부분 상속받아서 하는 방법이 있을까요?.?
  }

  // 모든 일정출력
  public void printAllService() {
    System.out.println("모든 일정을 출력합니다.");
    dao.printAllByDate();
  }

  // 특정일정출력
  public void printService(Scanner sc) { // 스캐너 없어도 되나요?
    String a;
    System.out.println("원하는날짜를 입력하세요 날짜형식 yyyyMMdd");
    a = sc.next();
    dao.selectByDate(a);
  }

  // 일정 삭제?
  public void deleteScheduleService(Scanner sc) {
    String a;
    System.out.println("삭제할 할 일을 입력해주세요");
    a = sc.next();
    dao.deleteSchedule(a);
    System.out.println("일정이 삭제되었습니다.");
  }

  // 일정 완료?
  public int finishScheduleService(Scanner sc) {
    String a;
    int b;
    System.out.println("완료할 일정을 입력해주세요");
    a = sc.next();
    b = dao.finishSchedule(a); // b-> 피카츄경험치
    // 여기에서 피카츄에게 경험치전달
    if (b == 0) {
      System.out.println("해당 일정이 존재하지 않습니다.");
    } else if (b >= 20 && b <= 50) {
      System.out.println("일정을 완료, 경험치 증가");

    }
    return b;
  }
}