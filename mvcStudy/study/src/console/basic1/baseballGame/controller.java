package basic1.baseballGame;

import java.util.Scanner;

public class controller {
    // 입력을 받고
    //서비스에서 계산하기
//    그리고 출력하기
    // 여기에서 뷰랑 섞어야하지

    private Scanner sc = new Scanner(System.in);

    public void playBall(){
        System.out.println("\n=====숫자 야구 시작=====");
        model model = new model();
        int[] data = model.getArr();
        System.out.println("data = " + model.getArr());
        // get이 이상한데
//        어떻게 진행하지?

        System.out.println("숫자 4개를 입력하세요.");
        // 컨트롤러와 서비스의 차이
        service service = new service();

        int input = sc.nextInt();
        service.check(input);

    }

    //입력받은 숫자 4개 위치확인하고 결과알려주기

    // 이런 로직은 서비스로 가야하고
    // 컨트롤러에서 입력을 받아야할것같은데
    //count알려주기

}
