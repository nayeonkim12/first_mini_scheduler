package schedule;

public class ScheduleVo {
    // 변수

    private String toDo;
    private String date;
    private String importance;

    // 생성자
    ScheduleVo() {

        this.toDo = null;
        this.date = null;
        this.importance = null;
    }
    // 변수제어

    String getTodo() {
        return toDo;
    }

    String getImportance() {
        return importance;

    }

    String getDate() {
        return date;
    }

    void setTodo(String todo) {
        this.toDo = todo;
    }

    void setDate(String date) {
        this.date = date;
    }

    void setImportance(String importance) {
        this.importance = importance;

    }

    // 일정출력

    void printSchedule() {
        System.out.println("날짜:" + date);
    }

}