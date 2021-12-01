package schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

// import java.util.HashMap;

/*
2.일정관리

2-1. 일정 추가
2-2. 일정 수정
2-3. 일정 삭제
2-4. 일정 목록
    완료 일정 목록
    미완료 일정 목록
2-5. 일정 검색
    키워드로 검색
    날짜로 검색
*/

public class ScheduleDao {
    // 요런식으로 저장!! 2021-11-26/할일어쩌구
    // 할일넘버카운트
    // 일정 배열 생성
    ArrayList<ScheduleVo> datas = new ArrayList<>();
    // @@HashMap<Integer,String> datas_todo =new HashMap<>();

    // 생성자
    ScheduleDao() {
        datas = new ArrayList<>();
    }

    // 일정추가
    void addSchedule(String imp, String todo) {
        // date 오브젝트를 불러와서 날짜를 저장한다.
    	ScheduleVo sdV = new ScheduleVo();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyyMMdd");

        LocalDateTime myDateObj = LocalDateTime.now(); // 오브젝트
        // LocalDateTime.of(int year, int month, int dayOfMonth, int hour, int minute,
        // int second) : LocalDateTime
        String dt = myDateObj.format(myFormatObj);
        sdV.setDate(dt);
        sdV.setTodo(todo);
        sdV.setImportance(imp);
        // 저장한 객채를 배열에 추가한다.
        datas.add(sdV);

    }

    // 일정삭제
    boolean deleteSchedule(String todo) {
        // 할일을 입력받아 그것과 일치하는 할일배열내의 같은 리스트를 찾아서 해당 객체를 삭제한다.
        for (int i = 0; i < datas.size(); i++) {

            String b = datas.get(i).getTodo(); // datas클래스의 i번째 객체의 Todo정보를 리턴한 값을 b에 담음
            if (todo.equals(b)) {
                datas.remove(i);

                return true;
            }
        }
        return false;
    }

    // 없다면 "일치하는 일정이 없습니다"를 출력하세요
    // 펄스를 리턴하시오. // 완료!

    // 특정일정출력
    Boolean selectByDate(String date) {
        if (datas.get(0) == null) { // @@
            System.out.println("일정이 없습니다.");
            return false;
        }
        com();
        for (int i = 0; i < datas.size(); i++) {
            String b = datas.get(i).getDate();// 배열의 날짜 불러오기
            if (date.equals(b)) {
                System.out.println("날짜:\t" + b + "\t할일:\t" + datas.get(i).getTodo());
            }
        }
        return true;
    }

    // 모든 일정출력
    boolean printAllByDate() {
        if (datas.size() < 0) { // @@
            System.out.println("일정이 없습니다.");
            return false;
        }
        com();
        for (int i = 0; i < datas.size(); i++) { // @@
            String b = datas.get(i).getDate();// 배열의 날짜 불러오기
            System.out.println("날짜:" + b + "\t"+"할일:" + datas.get(i).getTodo()+"\t"+"중요도:"+datas.get(i).getImportance());
            
        }
        return true;
    }

    // 일정완료
    int finishSchedule(String todo) {
        String b = "";
        boolean a = false;
        for (int i = 0; i < datas.size(); i++) {
            if (todo.equals(datas.get(i).getTodo())) {
                b = datas.get(i).getImportance(); // 중요도 가져오는 작업.
            }
        }
        if (b.equals("1")|| b.equals("2" )|| b.equals("3")) { // 존재하면
            a = deleteSchedule(todo);
        }
        if (a == true && b.equals("1")) {
            return 50;
        } else if (a == true && b.equals("2")) {
            return 30;
        } else if (a == true && b.equals("3")) {
            return 20;
        }
        return 0;
    }

   
    
    
    void com() {
        int sd;
        int sa;
        for (int i = 0; i < datas.size(); i++) {
        	for(int j=0;j<datas.size()-1;j++) {
        	
            sd = Integer.parseInt(datas.get(j).getImportance());//전  3
            sa = Integer.parseInt(datas.get(j + 1).getImportance());//후 1 
            if (sd > sa) {
                ScheduleVo a = datas.get(j+1);
                datas.set(j+1, datas.get(j));
                datas.set(j , a);
            }      
        }
        }
    }
}
