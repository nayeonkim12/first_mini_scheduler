package namu;

import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner;

//멤버 vo에 이 나무에 대한 객체를 저장해놓아요. 

//일정을 완료했을 때 나무에게 경험치가 전달되어야 해용.200마다
//나무객체랑 일정서비스파일이랑 연결되어있어야 함. 
//일정서비스에서 일정완료시에 경험치를 20을 받으면 --> 나무객체한테로 전달 --> 멤버vo에 추가 
//일정서비스 ---> 나무 ---> 멤버 vo
//일정에대한 정보 --> 멤버 vo --->멤버서비스(로그아웃)--> 피카츄랑 일정에대한 정보가 txt파일에 정보가 저장
//로그인을 하면 해당 txt파일을 찾아서 일정만-->재할당을 해준다. -->txt파일을 비운다.
//저희 프로그램에서는 회원가입할 수 있는 회원수의 제한이 있어요 !! 5명 
//텍스트 파일이 회원 한명당 2~3개씩 배정. 
//피카츄를 모두 작성하고 나서 txt파일 읽고 재할당하는 거 하고 오류테스트!! 

//회원마다 이 나무에대한 객체를 배정받을텐데 밑에 이 아이로부터 상속받음.
public class growParent {
    // 나무의 진화상태에 대한 변수
    // 0으로 초기화/ 나무 진화 단계 설정 : 1.씨앗 2.새싹 3.나무
    // 나무의 레벨에 대한 변수

    protected int exp = 0;
    protected final int maxlevel = 40;
    protected String stage = "씨앗";
    protected int level = 1;

    File mySeed = new File("src/namu/seed.txt");
    File mySprout = new File("src/namu/sprout.txt");
    File myChildtree = new File("src/namu/childtree.txt");
    File myTree = new File("src/namu/tree.txt");

    public growParent() {
    	
    }
    
    
    public  void addExp(int a) {
    	exp = exp+a;
    	if(exp >200 && level <=maxlevel) {
    		exp =0;
    		level++;
    		System.out.print("레벨업했습니다!");
    	}
    	if(level >= maxlevel) {
    		System.out.println("이미 만렙이어서 레벨업을 할 수 없습니다.");
    	}
    	hasStage();
       }
    
    public void hasStage() {
    	
    	if(level <1) {
    		System.out.print("당신은 씨앗입니다.");
    	}
    	if(level >=1 && level <20) {
    		stage = "새싹";
    	 System.out.println("당신은 새싹입니다.");
    	}
    	if(level >=20 && level <30) {
    		stage = "어린나무";
    		System.out.println("당신은 어린나무입니다.");
    	}
    	if(level >=30 && level <40) {
    		stage = "나무";
    		System.out.println("당신은 나무입니다.");
    	}
    }
    public void printNamu() {
    	System.out.println("현재레벨:"+level+"\t현재경험치:"+exp);
    }

    
    // 출력메소드 작성

    public void ReadFile(File myObj) {
        try {
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("오류오유로율올율");
            e.printStackTrace();
        }
    }

    // 정보출력
    public String toString() {
        if (stage == "씨앗") {
            ReadFile(mySeed);
        } else if (stage == "새싹") {
            ReadFile(mySprout);
        } else if (stage == "어린나무") {
            ReadFile(myChildtree);
        } else if (stage == "나무") {
            ReadFile(myTree);
        }
        return "내사랑♥";
    }

}
